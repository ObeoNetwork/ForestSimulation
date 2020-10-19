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
package fr.obeo.forestsimulation.rcp.cam;

import com.jme3.input.CameraInput;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.Joystick;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;

/**
 * Custom Fly camm used to remap moving key to azerty keyboard
 * @author Arthur Daussy
 *
 */
public class CustomFlyCam extends FlyByCamera {
	private static String[] mappings = new String[] { CameraInput.FLYCAM_LEFT, CameraInput.FLYCAM_RIGHT,
			CameraInput.FLYCAM_UP, CameraInput.FLYCAM_DOWN,

			CameraInput.FLYCAM_STRAFELEFT, CameraInput.FLYCAM_STRAFERIGHT, CameraInput.FLYCAM_FORWARD,
			CameraInput.FLYCAM_BACKWARD,

			CameraInput.FLYCAM_ZOOMIN, CameraInput.FLYCAM_ZOOMOUT, CameraInput.FLYCAM_ROTATEDRAG,

			CameraInput.FLYCAM_RISE, CameraInput.FLYCAM_LOWER,

			CameraInput.FLYCAM_INVERTY };

	public CustomFlyCam(Camera cam) {
		super(cam);
	}

	public void registerWithInput(InputManager inputManager) {
		this.inputManager = inputManager;

		// both mouse and button - rotation of cam
		inputManager.addMapping(CameraInput.FLYCAM_LEFT, new MouseAxisTrigger(MouseInput.AXIS_X, true),
				new KeyTrigger(KeyInput.KEY_LEFT));

		inputManager.addMapping(CameraInput.FLYCAM_RIGHT, new MouseAxisTrigger(MouseInput.AXIS_X, false),
				new KeyTrigger(KeyInput.KEY_RIGHT));

		inputManager.addMapping(CameraInput.FLYCAM_UP, new MouseAxisTrigger(MouseInput.AXIS_Y, false),
				new KeyTrigger(KeyInput.KEY_UP));

		inputManager.addMapping(CameraInput.FLYCAM_DOWN, new MouseAxisTrigger(MouseInput.AXIS_Y, true),
				new KeyTrigger(KeyInput.KEY_DOWN));

		// mouse only - zoom in/out with wheel, and rotate drag
		inputManager.addMapping(CameraInput.FLYCAM_ZOOMIN, new MouseAxisTrigger(MouseInput.AXIS_WHEEL, false));
		inputManager.addMapping(CameraInput.FLYCAM_ZOOMOUT, new MouseAxisTrigger(MouseInput.AXIS_WHEEL, true));
		inputManager.addMapping(CameraInput.FLYCAM_ROTATEDRAG, new MouseButtonTrigger(MouseInput.BUTTON_LEFT));

		// keyboard only WASD for movement and WZ for rise/lower height
		inputManager.addMapping(CameraInput.FLYCAM_STRAFELEFT, new KeyTrigger(KeyInput.KEY_Q));
		inputManager.addMapping(CameraInput.FLYCAM_STRAFERIGHT, new KeyTrigger(KeyInput.KEY_D));
		inputManager.addMapping(CameraInput.FLYCAM_FORWARD, new KeyTrigger(KeyInput.KEY_Z));
		inputManager.addMapping(CameraInput.FLYCAM_BACKWARD, new KeyTrigger(KeyInput.KEY_S));
		inputManager.addMapping(CameraInput.FLYCAM_RISE, new KeyTrigger(KeyInput.KEY_A));
		inputManager.addMapping(CameraInput.FLYCAM_LOWER, new KeyTrigger(KeyInput.KEY_E));

		inputManager.addListener(this, mappings);
		inputManager.setCursorVisible(dragToRotate || !isEnabled());

		Joystick[] joysticks = inputManager.getJoysticks();
		if (joysticks != null && joysticks.length > 0) {
			for (Joystick j : joysticks) {
				mapJoystick(j);
			}
		}
	}

	protected void riseCamera(float value) {
		Vector3f vel = new Vector3f(0, 0, value * moveSpeed);
		Vector3f pos = cam.getLocation().clone();

		if (motionAllowed != null)
			motionAllowed.checkMotionAllowed(pos, vel);
		else
			pos.addLocal(vel);

		cam.setLocation(pos);
	}
	
}
