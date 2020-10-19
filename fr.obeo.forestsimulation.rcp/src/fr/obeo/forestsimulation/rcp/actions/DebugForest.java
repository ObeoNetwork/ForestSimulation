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

import org.eclipse.e4.core.di.annotations.Execute;

import fr.obeo.forestsimulation.rcp.ISession;

public class DebugForest {
	@Execute
	public void execute(ISession session) {
		session.modifyModel(f -> f.setDebug(!f.isDebug()));
	}

}