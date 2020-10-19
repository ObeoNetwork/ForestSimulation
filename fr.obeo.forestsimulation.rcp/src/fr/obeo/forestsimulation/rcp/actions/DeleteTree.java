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

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import fr.obeo.forestsimulation.forest.Tree;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;

public class DeleteTree {

	@Execute
	public void execute(Shell shell, ISession session) {
		List<Tree> toDelete = session.getCurrentSelection().stream().filter(t -> t instanceof Tree).map(t -> (Tree) t)
				.collect(toList());

		session.modifyModel(() -> {
			for (Tree tree : toDelete) {
				SemanticHelper.deleteSingleTree(tree);
			}
		});
	}

	@CanExecute
	public boolean canExecute(ISession session) {
		return !session.getCurrentSelection().isEmpty();
	}

}