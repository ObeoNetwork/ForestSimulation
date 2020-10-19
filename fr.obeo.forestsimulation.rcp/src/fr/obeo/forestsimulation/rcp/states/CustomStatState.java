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
import com.jme3.app.StatsAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;

/**
 * Custom state to properly display stats (currently not working without it)
 * @author Arthur Daussy
 *
 */
public class CustomStatState extends StatsAppState{
	
	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		super.initialize(stateManager, app);
		Vector3f t = fpsText.getLocalTranslation();
		fpsText.setLocalTranslation(t.getX(),t.getY()+200, 100);
		Vector3f t2 = statsView.getLocalTranslation();
		statsView.setLocalTranslation(t2.getX(),t2.getY()+200, 100);
	}
	

}
