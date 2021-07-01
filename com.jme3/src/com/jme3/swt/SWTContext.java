/*
 * Copyright (c) 2009-2021 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.swt;

import static com.jme3.util.LWJGLBufferAllocator.PROPERTY_CONCURRENT_BUFFER_ALLOCATOR;
import static java.util.stream.Collectors.toSet;
import static org.lwjgl.opencl.CL10.CL_CONTEXT_PLATFORM;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL.setCapabilities;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Version;
import org.lwjgl.opencl.APPLEGLSharing;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.KHRGLSharing;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.swt.GLCanvas;
import org.lwjgl.opengl.swt.GLData;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.Platform;

import com.jme3.input.JoyInput;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.TouchInput;
import com.jme3.lwjgl3.utils.APIUtil;
import com.jme3.opencl.Context;
import com.jme3.opencl.DefaultPlatformChooser;
import com.jme3.opencl.Device;
import com.jme3.opencl.PlatformChooser;
import com.jme3.opencl.lwjgl.LwjglDevice;
import com.jme3.opencl.lwjgl.LwjglPlatform;
import com.jme3.opencl.lwjgl.Utils;
import com.jme3.renderer.Renderer;
import com.jme3.renderer.RendererException;
import com.jme3.renderer.lwjgl.LwjglGL;
import com.jme3.renderer.lwjgl.LwjglGLExt;
import com.jme3.renderer.lwjgl.LwjglGLFboEXT;
import com.jme3.renderer.lwjgl.LwjglGLFboGL3;
import com.jme3.renderer.opengl.GL;
import com.jme3.renderer.opengl.GL2;
import com.jme3.renderer.opengl.GL3;
import com.jme3.renderer.opengl.GL4;
import com.jme3.renderer.opengl.GLDebug;
import com.jme3.renderer.opengl.GLExt;
import com.jme3.renderer.opengl.GLFbo;
import com.jme3.renderer.opengl.GLRenderer;
import com.jme3.renderer.opengl.GLTiming;
import com.jme3.renderer.opengl.GLTimingState;
import com.jme3.renderer.opengl.GLTracer;
import com.jme3.swt.inputs.SWTKeyInput;
import com.jme3.swt.inputs.SWTMouseInput;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.jme3.system.NanoTimer;
import com.jme3.system.SystemListener;
import com.jme3.system.Timer;
import com.jme3.system.lwjgl.LwjglContext;
import com.jme3.util.BufferAllocatorFactory;
import com.jme3.util.LWJGLBufferAllocator;
import com.jme3.util.LWJGLBufferAllocator.ConcurrentLWJGLBufferAllocator;

/**
 * {@link JmeContext} that use of {@link GLCanvas} to render the 3D scene in SWT context. This renderer use a
 * fix version of OpenGL 3.2 (may be improved later). It was deeply inspired from
 * {@link com.jme3.system.lwjgl.LwjglContext}
 * 
 * @author Arthur Daussy
 */
public class SWTContext implements JmeContext, Runnable {

	public static final String PARENT_COMPOSITE = "SWTContext.PARENT_COMPOSITE";

	public static final boolean CL_GL_SHARING_POSSIBLE = true;

	protected final Object createdLock = new Object();

	protected final AtomicBoolean created = new AtomicBoolean(false);

	protected final AtomicBoolean renderable = new AtomicBoolean(false);

	protected final AppSettings settings = new AppSettings(true);

	private SWTKeyInput keyInput;

	private SWTMouseInput mouseInput;

	private static final Logger logger = Logger.getLogger(LwjglContext.class.getName());

	static {

		final String implementation = BufferAllocatorFactory.PROPERTY_BUFFER_ALLOCATOR_IMPLEMENTATION;

		if (System.getProperty(implementation) == null) {
			if (Boolean.parseBoolean(System.getProperty(PROPERTY_CONCURRENT_BUFFER_ALLOCATOR, "true"))) {
				System.setProperty(implementation, ConcurrentLWJGLBufferAllocator.class.getName());
			} else {
				System.setProperty(implementation, LWJGLBufferAllocator.class.getName());
			}
		}
	}

	protected Timer timer = new NanoTimer();

	protected Renderer renderer;

	protected SystemListener listener;

	protected com.jme3.opencl.lwjgl.LwjglContext clContext;

	private GLCanvas canvas;

	private GLCapabilities swtCapabilities;

	private int frameRate;

	private Composite parent;

	private int width;

	private int height;

	@Override
	public void setSystemListener(final SystemListener listener) {
		this.listener = listener;
	}

	protected void printContextInitInfo() {
		logger.log(Level.INFO, "SWT LWJGL {0} context running on thread {1}\n * Graphics Adapter: SWT {2}",
				APIUtil.toArray(Version.getVersion(), Thread.currentThread().getName(), SWT.getVersion()));
	}


	protected void initContextFirstTime() {

		final String renderer = settings.getRenderer();
		this.swtCapabilities = createCapabilities(!renderer.equals(AppSettings.LWJGL_OPENGL32));

		if (!swtCapabilities.OpenGL32) {
			throw new RendererException("OpenGL 3.2 or higher is required for jMonkeyEngine");
		}
		
		GL gl = new LwjglGL();
		GLExt glext = new LwjglGLExt();
		GLFbo glfbo;

		if (swtCapabilities.OpenGL30) {
			glfbo = new LwjglGLFboGL3();
		} else {
			glfbo = new LwjglGLFboEXT();
		}

		if (settings.getBoolean("GraphicsDebug")) {
			gl = (GL)GLDebug.createProxy(gl, gl, GL.class, GL2.class, GL3.class, GL4.class);
			glext = (GLExt)GLDebug.createProxy(gl, glext, GLExt.class);
			glfbo = (GLFbo)GLDebug.createProxy(gl, glfbo, GLFbo.class);
		}

		if (settings.getBoolean("GraphicsTiming")) {
			GLTimingState timingState = new GLTimingState();
			gl = (GL)GLTiming.createGLTiming(gl, timingState, GL.class, GL2.class, GL3.class, GL4.class);
			glext = (GLExt)GLTiming.createGLTiming(glext, timingState, GLExt.class);
			glfbo = (GLFbo)GLTiming.createGLTiming(glfbo, timingState, GLFbo.class);
		}

		if (settings.getBoolean("GraphicsTrace")) {
			gl = (GL)GLTracer.createDesktopGlTracer(gl, GL.class, GL2.class, GL3.class, GL4.class);
			glext = (GLExt)GLTracer.createDesktopGlTracer(glext, GLExt.class);
			glfbo = (GLFbo)GLTracer.createDesktopGlTracer(glfbo, GLFbo.class);
		}

		this.renderer = new GLRenderer(gl, glext, glfbo);
		this.renderer.initialize();

		this.renderer.setMainFrameBufferSrgb(settings.isGammaCorrection());
		this.renderer.setLinearizeSrgbImages(settings.isGammaCorrection());

		// Init input
		if (keyInput != null) {
			keyInput.initialize();
		}

		if (mouseInput != null) {
			mouseInput.initialize();
		}

		// if (joyInput != null) {
		// joyInput.initialize();
		// }

		// GLFW.glfwSetJoystickCallback(new GLFWJoystickCallback() {
		// @Override
		// public void invoke(int jid, int event) {
		//
		// // Invoke the disconnected event before we reload the joysticks or we lose the reference to it.
		// // Invoke the connected event after we reload the joysticks to obtain the reference to it.
		//
		// if ( event == GLFW.GLFW_CONNECTED ) {
		// joyInput.reloadJoysticks();
		// joyInput.fireJoystickConnectedEvent(jid);
		// }
		// else {
		// joyInput.fireJoystickDisconnectedEvent(jid);
		// joyInput.reloadJoysticks();
		// }
		// }
		// });

		 renderable.set(true);
	}

	/**
	 * Returns a list of the available platforms, filtered by the specified filter.
	 * <p>
	 * Copied from the old release
	 *
	 * @return the available platforms
	 */
	private static long[] getPlatforms() {
		try (MemoryStack stack = MemoryStack.stackPush()) {

			final IntBuffer countBuffer = stack.callocInt(1);
			int errcode = CL10.clGetPlatformIDs(null, countBuffer);
			Utils.checkError(errcode, "clGetDeviceIDs");

			final int count = countBuffer.get();
			final PointerBuffer pointer = stack.callocPointer(count);

			errcode = CL10.clGetPlatformIDs(pointer, (IntBuffer)null);
			Utils.checkError(errcode, "clGetDeviceIDs");

			final long[] platformIDs = new long[count];
			for (int i = 0; i < count; i++) {
				platformIDs[i] = pointer.get();
			}

			return platformIDs;
		}
	}

	protected void initOpenCL(final long window) {
		logger.info("Initialize OpenCL with LWJGL3");

		// try {
		// CL.create();
		// } catch (Exception ex) {
		// logger.log(Level.SEVERE, "Unable to initialize OpenCL", ex);
		// return;
		// }

		// load platforms and devices
		StringBuilder platformInfos = new StringBuilder();
		List<LwjglPlatform> platforms = new ArrayList<>();
		for (long platformId : getPlatforms()) {
			platforms.add(new LwjglPlatform(platformId));
		}

		platformInfos.append("Available OpenCL platforms:");

		for (int i = 0; i < platforms.size(); ++i) {
			LwjglPlatform platform = platforms.get(i);
			platformInfos.append("\n * Platform ").append(i + 1);
			platformInfos.append("\n *   Name: ").append(platform.getName());
			platformInfos.append("\n *   Vendor: ").append(platform.getVendor());
			platformInfos.append("\n *   Version: ").append(platform.getVersion());
			platformInfos.append("\n *   Profile: ").append(platform.getProfile());
			platformInfos.append("\n *   Supports interop: ").append(platform.hasOpenGLInterop());
			List<LwjglDevice> devices = platform.getDevices();
			platformInfos.append("\n *   Available devices:");
			for (int j = 0; j < devices.size(); ++j) {
				LwjglDevice device = devices.get(j);
				platformInfos.append("\n *    * Device ").append(j + 1);
				platformInfos.append("\n *    *   Name: ").append(device.getName());
				platformInfos.append("\n *    *   Vendor: ").append(device.getVendor());
				platformInfos.append("\n *    *   Version: ").append(device.getVersion());
				platformInfos.append("\n *    *   Profile: ").append(device.getProfile());
				platformInfos.append("\n *    *   Compiler version: ").append(device.getCompilerVersion());
				platformInfos.append("\n *    *   Device type: ").append(device.getDeviceType());
				platformInfos.append("\n *    *   Compute units: ").append(device.getComputeUnits());
				platformInfos.append("\n *    *   Work group size: ")
						.append(device.getMaxiumWorkItemsPerGroup());
				platformInfos.append("\n *    *   Global memory: ").append(device.getGlobalMemorySize())
						.append("B");
				platformInfos.append("\n *    *   Local memory: ").append(device.getLocalMemorySize())
						.append("B");
				platformInfos.append("\n *    *   Constant memory: ")
						.append(device.getMaximumConstantBufferSize()).append("B");
				platformInfos.append("\n *    *   Supports double: ").append(device.hasDouble());
				platformInfos.append("\n *    *   Supports half floats: ").append(device.hasHalfFloat());
				platformInfos.append("\n *    *   Supports writable 3d images: ")
						.append(device.hasWritableImage3D());
				platformInfos.append("\n *    *   Supports interop: ").append(device.hasOpenGLInterop());
			}
		}

		logger.info(platformInfos.toString());

		// choose devices
		PlatformChooser chooser = null;
		if (settings.getOpenCLPlatformChooser() != null) {
			try {
				chooser = (PlatformChooser)Class.forName(settings.getOpenCLPlatformChooser()).newInstance();
			} catch (Exception ex) {
				logger.log(Level.WARNING, "Unable to instantiate custom PlatformChooser", ex);
			}
		}

		if (chooser == null) {
			chooser = new DefaultPlatformChooser();
		}

		final List<? extends Device> choosenDevices = chooser.chooseDevices(platforms);
		final Optional<? extends Device> unsupportedDevice = choosenDevices.stream()
				.filter(dev -> !(dev instanceof LwjglDevice)).findAny();

		if (unsupportedDevice.isPresent()) {
			logger.log(Level.SEVERE,
					"attempt to return a custom Device implementation " + "from PlatformChooser: {0}",
					unsupportedDevice.get());
			return;
		}

		final Set<LwjglPlatform> lwjglPlatforms = choosenDevices.stream().map(LwjglDevice.class::cast)
				.map(LwjglDevice::getPlatform).collect(toSet());

		if (lwjglPlatforms.size() != 1) {
			logger.severe("attempt to use devices from different platforms");
			return;
		}

		final long[] deviceIds = choosenDevices.stream().map(LwjglDevice.class::cast)
				.mapToLong(LwjglDevice::getDevice).toArray();

		if (deviceIds.length < 1) {
			logger.warning("no devices specified, no OpenCL context created");
			return;
		}

		final LwjglPlatform platform = lwjglPlatforms.stream().findFirst()
				.orElseThrow(() -> new RuntimeException("not found a platform"));

		logger.log(Level.INFO, "chosen platform: {0}", platform.getName());
		logger.log(Level.INFO, "chosen devices: {0}", choosenDevices);

		// create context
		try {
			long context = createContext(platform.getPlatform(), deviceIds, window);
			clContext = new com.jme3.opencl.lwjgl.LwjglContext(context, (List<LwjglDevice>)choosenDevices);
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, "Unable to create OpenCL context", ex);
			return;
		}

		logger.info("OpenCL context created");
	}
/*
 * Copied from com.jme3.system.lwjgl.LwjglContext.createContext
 */
	private long createContext(final long platform, final long[] devices, long window) {
		try (MemoryStack stack = MemoryStack.stackPush()) {

			final int propertyCount = 2 + 4 + 1;
			final PointerBuffer properties = stack.callocPointer(propertyCount + devices.length);

			// set sharing properties
			// https://github.com/glfw/glfw/issues/104
			// https://github.com/LWJGL/lwjgl3/blob/master/modules/core/src/test/java/org/lwjgl/demo/opencl/Mandelbrot.java
			// TODO: test on Linux and MacOSX
			switch (Platform.get()) {
				case WINDOWS:
					properties.put(KHRGLSharing.CL_GL_CONTEXT_KHR)
							.put(org.lwjgl.glfw.GLFWNativeWGL.glfwGetWGLContext(window))
							.put(KHRGLSharing.CL_WGL_HDC_KHR).put(org.lwjgl.opengl.WGL.wglGetCurrentDC());
					break;
				case LINUX:
					properties.put(KHRGLSharing.CL_GL_CONTEXT_KHR)
							.put(org.lwjgl.glfw.GLFWNativeGLX.glfwGetGLXContext(window))
							.put(KHRGLSharing.CL_GLX_DISPLAY_KHR)
							.put(org.lwjgl.glfw.GLFWNativeX11.glfwGetX11Display());
					break;
				case MACOSX:
					properties.put(APPLEGLSharing.CL_CONTEXT_PROPERTY_USE_CGL_SHAREGROUP_APPLE)
							.put(org.lwjgl.opengl.CGL
									.CGLGetShareGroup(org.lwjgl.opengl.CGL.CGLGetCurrentContext()));
			}

			properties.put(CL_CONTEXT_PLATFORM).put(platform);
			properties.put(0);
			properties.flip();

			final IntBuffer error = stack.callocInt(1);
			final PointerBuffer deviceBuffer = stack.callocPointer(devices.length);
			for (final long deviceId : devices) {
				deviceBuffer.put(deviceId);
			}

			deviceBuffer.flip();

			long context = CL10.clCreateContext(properties, deviceBuffer, null, 0, error);
			Utils.checkError(error, "clCreateContext");

			return context;
		}
	}


	public void create() {
		create(false);
	}

	public void destroy() {
		destroy(false);
	}


	@Override
	public boolean isCreated() {
		return created.get();
	}

	@Override
	public boolean isRenderable() {
		return renderable.get();
	}

	@Override
	public void setSettings(AppSettings settings) {
		this.settings.copyFrom(settings);
		frameRate = settings.getFrameRate();
		parent = (Composite)settings.get(PARENT_COMPOSITE);
		if (parent == null) {
			throw new IllegalStateException("Missing parent composite");
		}
		keyInput = new SWTKeyInput(this);

		mouseInput = new SWTMouseInput(this);

	}

	@Override
	public AppSettings getSettings() {
		return settings;
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public Timer getTimer() {
		return timer;
	}

	@Override
	public Context getOpenCLContext() {
		return clContext;
	}

	@Override
	public void create(boolean arg0) {
		if (!created.get()) {

			GLData data = new org.lwjgl.opengl.swt.GLData();

			data.profile = GLData.Profile.CORE;
			data.majorVersion = 3;
			data.minorVersion = 2;

			if (settings.getSamples() > 0) {
				data.samples = settings.getSamples();
			}

			data.swapInterval = 1; // for enabling v-sync (swapbuffers sync'ed to monitor refresh)

			canvas = new GLCanvas(parent, SWT.NONE, data);
			canvas.setCurrent();
			mouseInput.setCanvas(canvas);
			keyInput.setCanvas(canvas);
			initContextFirstTime();

			// DO not delete. Uncomment to get debug message from OpenGL
			// Callback swtDebugProc = GLUtil.setupDebugMessageCallback();

			parent.addListener(SWT.Resize, new Listener() {

				@Override
				public void handleEvent(Event event) {
					if (renderable.get() && !parent.isDisposed()) {
						Point size = parent.getSize();
						int newWidth = Math.max(size.x, 1);
						int newHeight = Math.max(size.y, 1);
						if (width != newWidth || height != newHeight) {
							width = newWidth;
							height = newHeight;
							if (listener != null) {
								listener.reshape(width, height);
							}
						}
					}

				}
			});
			canvas.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					/*
					 * When the application lose focus we will no longer be notified is a key is released. So
					 * by default release all key that are being pressed
					 */
					keyInput.releaseAllPressedKeys(timer.getTime());
					listener.loseFocus();
				}

				@Override
				public void focusGained(FocusEvent e) {
					listener.gainFocus();

				}
			});
			setCapabilities(swtCapabilities);
			canvas.setCurrent();
			listener.initialize();
			run();

			created.set(true);
		}

	}

	@Override
	public void destroy(boolean arg0) {
		canvas.dispose();
	}

	@Override
	public JoyInput getJoyInput() {
		return null;
	}

	@Override
	public KeyInput getKeyInput() {
		return keyInput;
	}

	@Override
	public MouseInput getMouseInput() {
		return mouseInput;
	}

	@Override
	public TouchInput getTouchInput() {
		return null;
	}

	@Override
	public Type getType() {
		return Type.Canvas;
	}

	@Override
	public void restart() {
	}

	@Override
	public void setAutoFlushFrames(boolean arg0) {
	}

	@Override
	public void setTitle(String arg0) {
	}

	
	@Override
	public void run() {
		runOneUpdate();
		if (parent != null && !parent.isDisposed()) {
			parent.getDisplay().timerExec(frameRate, this::run);
		}
	}

	public void runOneUpdate() {
		if (parent != null && !parent.isDisposed()) {
			// Render to SWT window
			if (!canvas.isDisposed()) {
				canvas.swapBuffers();
			}

			if (renderer != null) {
				renderer.postFrame();
			}
			listener.update();
		}
	}

}
