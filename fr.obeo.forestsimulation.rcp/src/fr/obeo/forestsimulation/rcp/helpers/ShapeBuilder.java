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

import com.jme3.asset.AssetManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

public final class ShapeBuilder {

	public static Geometry buildLine(AssetManager assetManager, Vector3f start, Vector3f end, ColorRGBA color) {
		com.jme3.scene.shape.Line l = new com.jme3.scene.shape.Line(start, end);
		Geometry lineGeo = new Geometry("", l);
		lineGeo.setMaterial(MaterialBuilder.buildUnshaded(assetManager, color));
		return lineGeo;
	}

	public static Node createAxis(AssetManager assetManager, int size) {
		Node axisNode = new Node();
		axisNode.attachChild(
				ShapeBuilder.buildLine(assetManager, Vector3f.ZERO, new Vector3f(0, 0, size), ColorRGBA.Red));
		for (int i = 1; i <= size; i++) {
			Geometry s1 = buildSphere(assetManager, 0.1f, ColorRGBA.Red);
			s1.setLocalTranslation(0, 0, i);
			axisNode.attachChild(s1);

			Geometry s2 = buildSphere(assetManager, 0.1f, ColorRGBA.Blue);
			s2.setLocalTranslation(i, 0, 0);
			axisNode.attachChild(s2);

			Geometry s3 = buildSphere(assetManager, 0.1f, ColorRGBA.Green);
			s3.setLocalTranslation(0, i, 0);
			axisNode.attachChild(s3);
		}
		axisNode.attachChild(
				ShapeBuilder.buildLine(assetManager, Vector3f.ZERO, new Vector3f(size, 0, 0), ColorRGBA.Blue));
		axisNode.attachChild(
				ShapeBuilder.buildLine(assetManager, Vector3f.ZERO, new Vector3f(0, size, 0), ColorRGBA.Green));
		return axisNode;
	}

	private static Geometry buildSphere(AssetManager assetManager, float radius, ColorRGBA color) {
		Sphere s = new Sphere(5, 5, radius);
		Geometry geo = new Geometry("", s);
		geo.setMaterial(MaterialBuilder.buildUnshaded(assetManager, color));
		return geo;
	}

}
