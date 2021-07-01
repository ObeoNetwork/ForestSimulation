/*******************************************************************************
 * Copyright (c) 2021 Mesuris
* This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Mesuris - initial API and implementation
 *******************************************************************************/
package com.jme3.swt.inputs;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.lwjgl.opengl.swt.GLCanvas;

import com.jme3.input.KeyInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.swt.SWTContext;

/**
 * {@link KeyInput} that maps SWT inputs to JME3 event
 * 
 * @author Arthur Daussy
 */
public class SWTKeyInput implements KeyInput, KeyListener {

	private final ConcurrentLinkedQueue<KeyInputEvent> eventQueue = new ConcurrentLinkedQueue<KeyInputEvent>();

	private RawInputListener listener;

	private final SWTContext context;

	private GLCanvas canvas;

	private Set<KeyInputEvent> pressedKeys = new LinkedHashSet<KeyInputEvent>();

	public SWTKeyInput(SWTContext context) {
		this.context = context;
	}

	public void setCanvas(GLCanvas newCanvas) {
		if (this.canvas != newCanvas) {
			if (this.canvas != null) {
				canvas.removeKeyListener(this);
			}
			newCanvas.addKeyListener(this);
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
		while (!eventQueue.isEmpty()) {
			listener.onKeyEvent(eventQueue.poll());
		}

	}

	@Override
	public void destroy() {
		if (canvas != null && !canvas.isDisposed()) {
			canvas.addKeyListener(this);
		}
	}

	@Override
	public boolean isInitialized() {
		return canvas != null;
	}

	@Override
	public void setInputListener(RawInputListener listener) {
		this.listener = listener;
	}

	@Override
	public long getInputTimeNanos() {
		return System.nanoTime();
	}

	private void handleEvent(char character, int keyCode, long time, boolean pressed) {
		int jme3Code = SWTKeyMap.toJME3(keyCode);

		if (jme3Code != SWTKeyMap.INVALID_CODE) {
			char keyChar = character;
			final KeyInputEvent jme3Event = new KeyInputEvent(jme3Code, keyChar, pressed, false);
			jme3Event.setTime(time);

			if (pressed) {
				pressedKeys.add(jme3Event);
			} else {
				pressedKeys.remove(jme3Event);
			}
			eventQueue.add(jme3Event);
		}
	}

	/**
	 * Release all the keys that are being pressed
	 * 
	 * @param time
	 *            the current time
	 */
	public void releaseAllPressedKeys(long time) {
		Iterator<KeyInputEvent> pressKeyIte = pressedKeys.iterator();
		while (pressKeyIte.hasNext()) {
			KeyInputEvent next = pressKeyIte.next();
			pressKeyIte.remove();
			
			eventQueue.add(new KeyInputEvent(next.getKeyCode(), next.getKeyChar(), false, false));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		handleEvent(e.character, e.keyCode, e.time, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		handleEvent(e.character, e.keyCode, e.time, false);
	}

}
