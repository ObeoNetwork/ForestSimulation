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
package fr.obeo.forestsimulation.rcp.actions;

import java.util.Collections;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import fr.obeo.forestsimulation.rcp.ISession;

public class EditForestHandler {

	@Execute
	public void execute(Shell shell, ISession session) {
		session.setSelection(Collections.singletonList(session.readModelAndReturn(f -> f)));
	}

}