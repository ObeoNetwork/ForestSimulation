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
package fr.obeo.forestsimulation.rcp.parts;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.jme3.app.state.AbstractAppState;
import com.jme3.swt.SWTContext;

import fr.obeo.forestsimulation.rcp.Activator;
import fr.obeo.forestsimulation.rcp.CustomApp;
import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.states.CustomFlyCamAppState;
import fr.obeo.forestsimulation.rcp.states.CustomStatState;
import fr.obeo.forestsimulation.rcp.states.LodState;
import fr.obeo.forestsimulation.rcp.states.TreeRenderer;

public class Part3D {
//	private LwjglCanvas canvas;
	private Composite jme3Window;
	private Frame jme3awtFrame;
	private CustomApp app;

	@Inject
	public Part3D() {

	}

	@PostConstruct
	public void postConstruct(Composite parent, ISession session) {

		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());

		List<AbstractAppState> states = new ArrayList<AbstractAppState>();
		if (Activator.isPluginDebugging()) {
			states.add(new CustomStatState());
		}
		states.add(new CustomFlyCamAppState(session));
		states.add(new TreeRenderer(session, r -> {
			app.enqueue(r);
		}));
		states.add(new LodState());

		app = new CustomApp(CustomApp.createAppSettings(top), session, states.toArray(new AbstractAppState[states.size()]));

		SWTContext context = app.startOnCanvas();
	}

	@PreDestroy
	public void preDestroy() {

	}

	@Focus
	public void onFocus() {

	}

}