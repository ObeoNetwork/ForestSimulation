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

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.eclipse.emf.ecore.util.InternalEList;

import com.jme3.math.Vector3f;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;
import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

/**
 * Runner in charge of cerating pioner trees
 * 
 * @author Arthur Daussy
 *
 */
public class PionerTreeCreatorRunner implements Runnable {

	private StatHelper stat = StatHelper.getInstance();
	private final ISession session;

	private int nbTry;

	private float lowCoordinateRange;

	private float hightCoordinateRange;

	public PionerTreeCreatorRunner(ISession session) {
		super();
		this.session = session;

		session.readModel(f -> {
			float size = f.getSize();
			lowCoordinateRange = -size / 2;
			hightCoordinateRange = size / 2;
			nbTry = (int) (size / 2);
		});
	}

	@Override
	public void run() {
		session.modifyModel(f -> {
			Integer cmp = SemanticHelper.countTree(f);
			int possibleCreation = f.getMaxNumberOfTree() - cmp;
			float probNewTree = f.getPionerTreeProb();
			int lNbTry = Math.min(possibleCreation, nbTry);
			for (int t = 0; t < lNbTry; t++) {
				if (stat.draw(probNewTree)) {

					final List<TreeType> types = f.getTypes().stream().filter(TreeType::isIsPioner).collect(toList());
					final TreeType type;
					if (types.size() > 1) {
						int randomInt = stat.getRandomInt(0, types.size());
						type = types.get(randomInt);
					} else if (types.size() == 1) {
						type = types.get(0);
					} else {
						type = null;
					}
					if (type != null) {
						Tree createTree = createTree(f, type);
						if(session.getBoundHelper().canPlant(createTree)) {
							((InternalEList<Tree>)f.getTrees()).addUnique(createTree);
						}
					}
				}
			}
		});

	}

	public Tree createTree(Forest forest, TreeType type) {
		Tree tree = SemanticHelper.initTreeWithProb(forest, type);
		tree.setLocation(new Vector3f(getNextRandomCoordinate(), getNextRandomCoordinate(), 0));
		tree.setHeading(getNextRandomOrientaion());
		return tree;
	}

	private float getNextRandomCoordinate() {
		return stat.getRandomFloat(lowCoordinateRange, hightCoordinateRange);
	}

	private float getNextRandomOrientaion() {
		return stat.getRandomFloat(0, 180);
	}

}
