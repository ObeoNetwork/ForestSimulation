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
package fr.obeo.forestsimulation.rcp.states;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

/**
 * Custom state in charge of the the LoD of each tree
 * 
 * @author Arthur Daussy
 *
 */
public class LodState extends AbstractAppState {

	private float SLO = 4f * 4f;
	private float SL1 = 6f * 6f;
	private float SL2 = 9f * 9f;

	private Camera cam;
	private Node rootNode;

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		super.initialize(stateManager, app);
		cam = app.getCamera();
		rootNode = ((SimpleApplication) app).getRootNode();
	}

	@Override
	public void update(float tpf) {
		Vector3f camLoc = cam.getLocation();

		rootNode.depthFirstTraversal(s -> {
			if (s instanceof Geometry) {
				Vector3f spatialLocation = s.getWorldTranslation();
				Geometry geo = (Geometry) s;
				if (geo.getMesh().getNumLodLevels() > 0) {
					float distanceSquared = camLoc.distanceSquared(spatialLocation);
					if (distanceSquared < SLO) {
						if (geo.getLodLevel() != 0) {
							geo.setLodLevel(0);
						}
					} else if (distanceSquared < SL1) {
						if (geo.getLodLevel() != 1) {
							geo.setLodLevel(1);
						}
					}
					if (distanceSquared < SL2) {
						if (geo.getLodLevel() != 2) {
							geo.setLodLevel(2);
						}
					} else {
						if (geo.getLodLevel() != 3) {
							geo.setLodLevel(3);
						}
					}
				}

			}
		});
		super.update(tpf);
	}

}
