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
package fr.obeo.forestsimulation.rcp.runners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import fr.obeo.forestsimulation.forest.Tree;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;
import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

/**
 * Runner in charge of growing each the forest. It:
 * <p>
 * <ul>
 * <li>It makes all tree grows</li>
 * <li>It increment the age of each tree and the forest</li>
 * <li>It decreases the lifetime of a sick trees</li>
 * <li>It deletes tree that reach their maximum age</li>
 * 
 * </ul>
 * </p>
 * 
 * age it also deletes it
 * 
 * @author Arthur Daussy
 *
 */
public class GrowingTreeRunner implements Runnable {

	private StatHelper stat = StatHelper.getInstance();
	private final ISession session;

	public GrowingTreeRunner(ISession session) {
		this.session = session;
	}

	@Override
	public void run() {

		session.modifyModel(f -> {
			List<Tree> treeToRemove = new ArrayList<>();
			TreeIterator<EObject> contentIte = f.eAllContents();
			while (contentIte.hasNext()) {
				EObject eObject = (EObject) contentIte.next();
				if (eObject instanceof Tree) {
					Tree tree = (Tree) eObject;

					if (!tree.isIsSick() && tree.getCurrentAge() < tree.getMaxAge()
							&& tree.getSize() < tree.getMaxSize()) {
						float nextGrowSize = getNextGrowSize();

						float oldSize = tree.getSize();
						Float newSize = oldSize + nextGrowSize;
						tree.setSize(newSize);
					}

					if (tree.isIsSick()) {
						tree.setMaxAge(tree.getMaxAge() - 5);
					}

					if (tree.getCurrentAge() <= tree.getMaxAge()) {
						tree.setCurrentAge(tree.getCurrentAge() + 1);
					} else {
						treeToRemove.add(tree);
					}

				}
			}

			treeToRemove.forEach(SemanticHelper::deleteSingleTree);

			f.setAge(f.getAge() + 1);
		});

	}

	private float getNextGrowSize() {
		return stat.getRandomFloat(0f, 0.05f);
	}

}
