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

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;
import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

public class AddSubTreeAction {

	private static StatHelper STAT = StatHelper.getInstance();

	@Execute
	public void execute(ISession session) {
		Tree parentTree = (Tree) session.getCurrentSelection().get(0);
		session.modifyModel(f -> {
			List<TreeType> childrenTypes = new ArrayList<>(parentTree.getType().getChildrenProbs().keySet());
			if (!childrenTypes.isEmpty()) {
				Tree tree = ForestFactory.eINSTANCE.createTree();
				int randomInt = STAT.getRandomInt(0, childrenTypes.size());
				TreeType type = childrenTypes.get(randomInt);
				tree.setType(type);
				tree.setLocation(SemanticHelper.getNextChildLocation(parentTree, type));
				tree.setHeading(SemanticHelper.getNextRandomOrientation());
				parentTree.getChildren().add(tree);
			}
		});
	}

	@CanExecute
	public boolean canExecute(ISession session) {
		return !session.getCurrentSelection().isEmpty() && session.getCurrentSelection().get(0) instanceof Tree;
	}

}