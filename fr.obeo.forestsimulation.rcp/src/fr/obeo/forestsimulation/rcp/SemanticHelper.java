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
package fr.obeo.forestsimulation.rcp;


import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Transform;
import com.jme3.math.Vector3f;

import fr.obeo.forestsimulation.rcp.helpers.StatHelper;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

public class SemanticHelper {
	private static final StatHelper stat = StatHelper.getInstance();

	public static int countTree(Forest f) {
		int cmpt = 0;
		TreeIterator<EObject> contentIte = f.eAllContents();
		while (contentIte.hasNext()) {
			EObject eObject = (EObject) contentIte.next();
			if (eObject instanceof Tree) {
				cmpt++;
			}
		}
		return cmpt;
	}

	public static Tree initTreeWithProb(Forest forest, TreeType type) {
		Tree tree = ForestFactory.eINSTANCE.createTree();
		tree.setType(type);

		tree.setMaxAge(stat.getRandomInt(type.getDefaultTreeMinAge(), type.getDefaultTreeMaxAge()));
		tree.setHealProb(type.getDefaultHealProb());
		tree.setSize(type.getStartingScale());
		float defaultMaxSize = type.getDefaultMaxSize();
		tree.setMaxSize(stat.getRandomFloat(defaultMaxSize * 0.7f, defaultMaxSize * 1.3f));
		return tree;
	}

	public static <T extends EObject> Stream<T> allContainedObjectOfType(EObject self, Class<T> type) {
		return eAllContentSteamWithSelf((EObject) self).filter(e -> type.isInstance(e)).map(e -> type.cast(e));

	}

	public static Stream<EObject> eAllContentSteamWithSelf(EObject o) {
		if (o == null) {
			return Stream.empty();
		}
		return Stream.concat(Stream.of(o), StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(o.eAllContents(), Spliterator.NONNULL), false));
	}

	public static void deleteSingleTree(Tree t) {
		EObject container = t.eContainer();
		if (container instanceof Forest) {
			Forest forest = (Forest) container;
			forest.getTrees().addAll(t.getChildren());
			forest.getTrees().remove(t);
		} else if (container instanceof Tree) {
			Tree parentTree = (Tree) container;
			parentTree.getChildren().addAll(t.getChildren());
			parentTree.getChildren().remove(t);
		}
	}
	
	public static Vector3f getNextChildLocation(Tree parentTree, TreeType type) {
		float generateHeading = getNextRandomOrientation();
		float hExtent = (parentTree.getType().getHSpace() + type.getHSpace())/2f ;
		float minSpacing = parentTree.getSize() * hExtent * 2;
		float distance = stat.getRandomFloat(minSpacing, minSpacing * 1.3f);
		Vector3f newLocation = new Transform(new Quaternion().fromAngles(0, 0, generateHeading))
				.transformVector(Vector3f.UNIT_X.mult(distance), null);
		return parentTree.getLocation().add(newLocation);
	}
	
	public static float getNextRandomOrientation() {
		return stat.getRandomFloat(0f, 360f) * FastMath.RAD_TO_DEG;
	}
}
