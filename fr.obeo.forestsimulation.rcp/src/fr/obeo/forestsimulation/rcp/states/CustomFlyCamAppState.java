/*
 * Copyright (c) 2009-2012 jMonkeyEngine
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
package fr.obeo.forestsimulation.rcp.states;

import java.util.List;
import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EObject;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.FlyByCamera;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.cam.CustomFlyCam;

import fr.obeo.forestsimulation.forest.Tree;

/**
 * Custom impl of flycam using {@link CustomFlyCam}
 * 
 * @author Arthur Daussy
 *
 */
public class CustomFlyCamAppState extends AbstractAppState implements BiConsumer<List<EObject>, List<EObject>> {

	private Application app;
	private CustomFlyCam flyCam;
	private Camera camera;

	public CustomFlyCamAppState(ISession session) {
		session.addSelectionListener(this);
	}

	/**
	 * This is called by SimpleApplication during initialize().
	 */
	public void setCamera(CustomFlyCam cam) {
		this.flyCam = cam;
	}

	public FlyByCamera getCamera() {
		return flyCam;
	}

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		super.initialize(stateManager, app);

		this.app = app;

		this.camera = app.getCamera();
		if (app.getInputManager() != null) {

			if (flyCam == null) {
				flyCam = new CustomFlyCam(camera);
			}

			flyCam.registerWithInput(app.getInputManager());
		}

	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);

		flyCam.setEnabled(enabled);
	}

	@Override
	public void cleanup() {
		super.cleanup();

		if (app.getInputManager() != null) {
			flyCam.unregisterInput();
		}
	}

	@Override
	public void accept(List<EObject> oldSelection, List<EObject> newSelection) {
		newSelection.stream().filter(e -> e instanceof Tree)
				.forEach(t -> camera.lookAt(((Tree) t).getLocation(), Vector3f.UNIT_Z));

	}

}
