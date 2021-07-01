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
package com.jme3.swt.inputs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.lwjgl.opengl.swt.GLCanvas;

import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.input.MouseInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.swt.SWTContext;

/**
 * {@link MouseInput} to interact with {@link SWT}
 * 
 * <p>Inspired from {@link com.jme3.input.AWTMouseInput}</p>
 * 
 * @author Joshua Slack
 * @author MHenze (cylab)
 * @author Arthur Daussy
 */
public class SWTMouseInput implements MouseInput, MouseListener, MouseMoveListener, MouseWheelListener {

	private static final int SCROLL_FACTOR = 100;

	private static final Map<Integer, Integer> MOUSE_BUTTON_TO_JME = new HashMap<>();

	static {
		MOUSE_BUTTON_TO_JME.put(1, BUTTON_LEFT);
		MOUSE_BUTTON_TO_JME.put(2, BUTTON_MIDDLE);
		MOUSE_BUTTON_TO_JME.put(3, BUTTON_RIGHT);
	}

	private RawInputListener listener;

	private final SWTContext context;

	private int mouseX;

	private int mouseY;

	private int mouseWheel;

	private final LinkedList<MouseMotionEvent> mouseMotionEvents = new LinkedList<>();

	private final LinkedList<MouseButtonEvent> mouseButtonEvents = new LinkedList<>();

	private GLCanvas canvas;

	public SWTMouseInput(SWTContext context) {
		this.context = context;
	}

	public void setCanvas(GLCanvas newCanvas) {
		if (this.canvas != newCanvas) {
			if (this.canvas != null) {
				canvas.removeMouseListener(this);
				canvas.removeMouseListener(this);
				canvas.removeMouseWheelListener(this);
			}
			newCanvas.addMouseListener(this);
			newCanvas.addMouseMoveListener(this);
			newCanvas.addMouseWheelListener(this);
		}
		this.canvas = newCanvas;
	}

	@Override
	public void initialize() {

	}

	@Override
	public void update() {
		if (!context.isRenderable())
			return;

		while (!mouseMotionEvents.isEmpty()) {
			listener.onMouseMotionEvent(mouseMotionEvents.poll());
		}
		while (!mouseButtonEvents.isEmpty()) {
			listener.onMouseButtonEvent(mouseButtonEvents.poll());
		}

	}

	@Override
	public void destroy() {
		if (this.canvas != null && !canvas.isDisposed()) {
			canvas.removeMouseListener(this);
			canvas.addMouseMoveListener(this);
			canvas.addMouseWheelListener(this);
		}
	}

	@Override
	public boolean isInitialized() {
		return true;
	}

	@Override
	public void setInputListener(RawInputListener listener) {
		this.listener = listener;

	}

	@Override
	public long getInputTimeNanos() {
		return System.nanoTime();
	}

	@Override
	public void setCursorVisible(boolean visible) {
	}

	@Override
	public int getButtonCount() {
		return 3;
	}

	@Override
	public void setNativeCursor(JmeCursor cursor) {
	}

	@Override
	public void mouseScrolled(MouseEvent e) {
		onWheelScroll(e.count * SCROLL_FACTOR, toLongTime(e.time));

	}

	private long toLongTime(int time) {
		return time & 0xFFFFFFFFL;
	}

	private void onWheelScroll(int scroll, long time) {

		mouseWheel += scroll;

		final MouseMotionEvent mouseMotionEvent = new MouseMotionEvent(mouseX, mouseY, 0, 0, mouseWheel,
				scroll);
		mouseMotionEvent.setTime(time);

		mouseMotionEvents.add(mouseMotionEvent);
	}

	@Override
	public void mouseMove(MouseEvent e) {
		onCursorPos(e.x, e.y, toLongTime(e.time));

	}

	private void onCursorPos(int xpos, int ypos, long time) {

		int xDelta;
		int yDelta;
		int x = xpos;
		int y = canvas.getSize().y - (int)Math.round(ypos);

		if (mouseX == 0)
			mouseX = x;
		if (mouseY == 0)
			mouseY = y;

		xDelta = x - mouseX;
		yDelta = y - mouseY;

		mouseX = x;
		mouseY = y;

		if (xDelta == 0 && yDelta == 0)
			return;

		final MouseMotionEvent mouseMotionEvent = new MouseMotionEvent(x, y, xDelta, yDelta, mouseWheel, 0);
		mouseMotionEvent.setTime(time);

		mouseMotionEvents.add(mouseMotionEvent);

	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		onMouseButton(e, true, toLongTime(e.time));

	}

	@Override
	public void mouseUp(MouseEvent e) {
		onMouseButton(e, false, toLongTime(e.time));
	}

	private void onMouseButton(MouseEvent event, final boolean pressed, long time) {
		final MouseButtonEvent mouseButtonEvent = new MouseButtonEvent(convertButton(event.button), pressed,
				mouseX, mouseY);
		mouseButtonEvent.setTime(time);

		mouseButtonEvents.add(mouseButtonEvent);
	}

	private int convertButton(int i) {
		final Integer result = MOUSE_BUTTON_TO_JME.get(i);
		return result == null ? 0 : result;
	}

}
