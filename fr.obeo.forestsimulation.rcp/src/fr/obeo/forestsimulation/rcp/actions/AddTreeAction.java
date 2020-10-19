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

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;
import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

public class AddTreeAction {
	private static final StatHelper STAT_HELPER = StatHelper.getInstance();

	@Execute
	public void execute(ISession session) {
		session.modifyModel(f -> {
			List<TreeType> types = f.getTypes().stream().filter(t -> t.isIsPioner()).collect(toList());
			if (!types.isEmpty()) {
				Tree tree = ForestFactory.eINSTANCE.createTree();
				TreeType value = types.get(STAT_HELPER.getRandomInt(0, types.size()));
				SemanticHelper.initTreeWithProb(f, value);
				tree.setType(value);
				f.getTrees().add(tree);
			}
		});
	}

}