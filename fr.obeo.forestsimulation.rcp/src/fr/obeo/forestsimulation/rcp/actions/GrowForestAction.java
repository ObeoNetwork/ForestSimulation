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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.runners.ChildTreeCreatorRunner;
import fr.obeo.forestsimulation.rcp.runners.DeseaseRunner;
import fr.obeo.forestsimulation.rcp.runners.GrowOrchestrator;
import fr.obeo.forestsimulation.rcp.runners.GrowingTreeRunner;
import fr.obeo.forestsimulation.rcp.runners.PionerTreeCreatorRunner;

public class GrowForestAction {

	@Execute
	public void execute(ISession session, GrowOrchestrator orchestrator) {

		int year = session.readModelAndReturn(f -> f.getYearPeriod());
		int desease = (int) (year * 1.5);
		int pionerTree = (int) (year * 1.2);
		int childTree = year;
		List<Pair<? extends Runnable, Integer>> runnables = new ArrayList<>();
		runnables.add(Tuples.pair(new ChildTreeCreatorRunner(session), childTree));
		runnables.add(Tuples.pair(new DeseaseRunner(session), desease));
		runnables.add(Tuples.pair(new GrowingTreeRunner(session), year));
		runnables.add(Tuples.pair(new PionerTreeCreatorRunner(session), pionerTree));
		orchestrator.start(runnables);
	}

	@CanExecute
	public boolean canExecute(GrowOrchestrator orchestrator) {
		return !orchestrator.isStarted();
	}

}