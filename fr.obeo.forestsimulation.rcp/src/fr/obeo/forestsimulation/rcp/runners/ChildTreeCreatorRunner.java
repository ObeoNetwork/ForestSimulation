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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.InternalEList;

import com.jme3.math.Vector3f;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;
import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

/**
 * 
 * Runnable in charge of creating sub trees
 * 
 * @author Arthur Daussy
 *
 */
public class ChildTreeCreatorRunner implements Runnable {

	private static final StatHelper STAT = StatHelper.getInstance();

	private final ISession session;

	public ChildTreeCreatorRunner(ISession session) {
		super();
		this.session = session;

	}

	@Override
	public void run() {

		// Build a map to the child to create
		session.modifyModel(f -> {
			int cmp = SemanticHelper.countTree(f);
			TreeIterator<EObject> contentIte = f.eAllContents();
			int possibleCreation = f.getMaxNumberOfTree() - cmp;

			while (contentIte.hasNext() && possibleCreation > 0) {
				EObject eObject = (EObject) contentIte.next();
				if (eObject instanceof Tree) {
					Tree tree = (Tree) eObject;
					TreeType type = tree.getType().getChildType(STAT.getNextFloat());
					if (type != null) { // Null no creation
						Vector3f newLocation = SemanticHelper.getNextChildLocation(tree, type);
						Tree createTree = createTree(tree, newLocation, f, type);
						if (session.getBoundHelper().canPlant(createTree)) {
							possibleCreation--;
							((InternalEList<Tree>) tree.getChildren()).addUnique(createTree);
						}
					}
				}
			}
		});

	}

	private Tree createTree(Tree parentTree, Vector3f location, Forest forest, TreeType type) {
		Tree tree = SemanticHelper.initTreeWithProb(forest, type);
		tree.setLocation(location);
		tree.setHeading(SemanticHelper.getNextRandomOrientation());
		return tree;
	}

}
