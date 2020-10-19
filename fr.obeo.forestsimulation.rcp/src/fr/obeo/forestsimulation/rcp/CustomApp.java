/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Arthur Daussy - initial API and implementation
 *******************************************************************************/
package fr.obeo.forestsimulation.rcp;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.jme3.system.JmeSystem;
import com.jme3.system.lwjgl.LwjglCanvas;

import fr.obeo.forestsimulation.rcp.cam.CustomFlyCam;
import fr.obeo.forestsimulation.rcp.helpers.MaterialBuilder;
import fr.obeo.forestsimulation.rcp.helpers.ShapeBuilder;
import fr.obeo.forestsimulation.rcp.states.CustomFlyCamAppState;

public class CustomApp extends SimpleApplication {

	private static final ColorRGBA SOIL_COLOR = new ColorRGBA(72 / 255f, 133 / 255f, 48 / 255f, 1f);

	public static final float AMBIENT_LIGHT_COEFF = 1.3f;

	private static final int MIN_RES_HEIGHT = 480;

	private static final int MIN_RES_WIDTH = 640;

	private static final int DEFAULT_FRAMERATE = 15;

	private ISession session;

	public CustomApp(ISession session, AbstractAppState... states) {
		super(states);
		this.session = session;
	}

	public static AppSettings createAppSettings() {
		AppSettings newSetting = new AppSettings(true);
		newSetting.setFrameRate(DEFAULT_FRAMERATE); // In APogy can be changed via property
		newSetting.setAudioRenderer(null); // We don't need audio in this application.
		newSetting.setSamples(4); // Use anti aliasing set to 0 if not

		newSetting.setMinResolution(MIN_RES_WIDTH, MIN_RES_HEIGHT);
		return newSetting;
	}

	@Override
	public void initialize() {
		assetManager = JmeSystem.newAssetManager(JmeSystem.getPlatformAssetConfigURL());
		assetManager.addClassLoader(this.getClass().getClassLoader());
		super.initialize();
	}

	@Override
	public void simpleInitApp() {
		if (assetManager.getClassLoaders().contains(this.getClass().getClassLoader())) {
			assetManager.addClassLoader(this.getClass().getClassLoader());
		}
		assetManager.addClassLoader(SimpleApplication.class.getClassLoader());
		assetManager.addClassLoader(this.getClass().getClassLoader());
		flyCam = new CustomFlyCam(cam);
		CustomFlyCamAppState flyCamState = stateManager.getState(CustomFlyCamAppState.class);
		if(flyCamState != null) {
			flyCamState.setCamera((CustomFlyCam) flyCam);
		}

		setUpLight();

		if (Activator.isPluginDebugging()) {
			rootNode.attachChild(ShapeBuilder.createAxis(assetManager, 10));
		}
		buildSoil();
		setUpCam();

	}

	private void setUpCam() {
		cam.setLocation(new Vector3f(-10, -10, 10));
		flyCam.setDragToRotate(true);
		flyCam.setMoveSpeed(10f);
		flyCam.setUpVector(Vector3f.UNIT_Z);
		cam.lookAt(new Vector3f(1, 1, 0), Vector3f.UNIT_Z);
	}

	private void buildSoil() {
		float fieldSize = session.readModelAndReturn(f -> f.getSize());
		Quad soil = new Quad(fieldSize, fieldSize);
		Geometry soilGeo = new Geometry("", soil);
		soilGeo.setMaterial(MaterialBuilder.buildUnshaded(assetManager, SOIL_COLOR));
		soilGeo.setLocalTranslation(-fieldSize / 2, -fieldSize / 2, 0);
		rootNode.attachChild(soilGeo);
		soilGeo.setShadowMode(ShadowMode.Receive);
	}

	private void setUpLight() {
		DirectionalLight sun2 = new DirectionalLight();
		sun2.setColor(ColorRGBA.White.mult(2f));
		sun2.setDirection(new Vector3f(.5f, .5f, -.5f).normalizeLocal());
		rootNode.addLight(sun2);

		DirectionalLightShadowRenderer shadowRenderer = new DirectionalLightShadowRenderer(getAssetManager(), 1024, 1);
		shadowRenderer.setLight(sun2);
		getViewPort().addProcessor(shadowRenderer);

		AmbientLight al = new AmbientLight();
		al.setColor(ColorRGBA.White);
		rootNode.addLight(al);
	}

	public LwjglCanvas startOnCanvas() {

		start(JmeContext.Type.Canvas);

		setPauseOnLostFocus(false);

		LwjglCanvas canvas = (LwjglCanvas) getContext();

		startCanvas(true);

		canvas.getCanvas().setFocusable(true);
		setDisplayFps(true);
		setDisplayStatView(true);

		return canvas;
	}

}
