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
package fr.obeo.forestsimulation.rcp.helpers;

import static java.util.stream.Collectors.toList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.index.kdtree.KdTree;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.util.IntMap;

import fr.obeo.forestsimulation.rcp.SemanticHelper;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.Tree;

/**
 * Bounds helper used to keeps track of the space occupied by trees
 * 
 * @author Arthur Daussy
 *
 */
public class BoundHelper extends ResourceSetListenerImpl {

	private Forest forest;

	KdTree kdTree = new KdTree();

	public static class Circle {

		private Vector2f location;

		private float size;

		public Circle(Vector2f location, float size) {
			super();
			this.location = location;
			this.size = size;
		}

		public boolean insesect(Circle c) {
			float distance = c.location.distance(location);
			float tSize = c.size + size;
			return distance < tSize;
		}

		public Vector2f getLocation() {
			return location;
		}

		public float getSize() {
			return size;
		}
	}

	public void init(Forest f) {
		this.forest = f;
		List<Tree> trees = SemanticHelper.allContainedObjectOfType(forest, Tree.class).collect(toList());

		for (Tree t : trees) {
			Vector3f location = t.getLocation();
			kdTree.insert(new Coordinate(location.getX(), location.getY()), t);
		}
	}

	public boolean canPlant(Tree tree) {
		Vector3f location = tree.getLocation();

		float halfSize = forest.getSize() / 2f;

		if (location.getX() > -halfSize && location.getX() < halfSize//
				&& location.getY() > -halfSize && location.getY() < halfSize) {
			Circle c = toCircle(tree);

			float radius = tree.getSize() * tree.getType().getHSpace() * 2;

			List<org.locationtech.jts.index.kdtree.KdNode> list = kdTree.query(new Envelope(location.getX() - radius,
					location.getX() + radius, location.getY() - radius, location.getY() + radius));

			for (org.locationtech.jts.index.kdtree.KdNode node : list) {
				Tree t = (Tree) node.getData();
				Circle circle = toCircle(t);
				if (circle.insesect(c)) {
					return false;
				}
			}
			return true;
		}
		return false;

	}

	public boolean isPostcommitOnly() {
		return true;
	};

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		boolean shouldCompute = false;
		for (Notification notif : event.getNotifications()) {
			if (notif.getFeature() == ForestPackage.eINSTANCE.getForest_Trees()
					|| notif.getFeature() == ForestPackage.eINSTANCE.getTree_Children()) {
				shouldCompute = true;
			} else if (notif.getFeature() == ForestPackage.eINSTANCE.getTree_Location()
					&& notif.getNotifier() instanceof Tree) {
				shouldCompute = true;
			}

		}
		if (shouldCompute) {
			kdTree = new KdTree();
			List<Tree> trees = SemanticHelper.allContainedObjectOfType(forest, Tree.class).collect(toList());

			for (Tree t : trees) {
				Vector3f location = t.getLocation();
				kdTree.insert(new Coordinate(location.getX(), location.getY()), t);
			}
		}
	}

	public Circle toCircle(Tree newValue) {
		Vector3f loc = newValue.getLocation();
		Circle circle = new Circle(new Vector2f(loc.getX(), loc.getY()),
				newValue.getSize() * newValue.getType().getHSpace());
		return circle;
	}
}
