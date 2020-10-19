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

import java.util.HashMap;
import java.util.Map;

import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.TreeType;

public class TreeTypeBuilder {

	private String assetName;
	private int minAge;
	private int maxAge;
	private float startingSize;
	private float maxSize;
	private boolean pioner;
	private float hSpace;
	private float deseaseProb;
	private final String name;
	private Map<TreeType, Float> childProbs = new HashMap<>();
	private float selfChildProb = Float.NaN;

	public TreeTypeBuilder(String name) {
		this.name = name;
	}

	public TreeTypeBuilder withAssetName(String assetName) {
		this.assetName = assetName;
		return this;
	}

	public TreeTypeBuilder withMinAge(int minAge) {
		this.minAge = minAge;
		return this;
	}

	public TreeTypeBuilder withMaxAge(int maxAge) {
		this.maxAge = maxAge;
		return this;
	}

	public TreeTypeBuilder withStartingSize(float startingSize) {
		this.startingSize = startingSize;
		return this;
	}

	public TreeTypeBuilder withMaxSize(float maxSize) {
		this.maxSize = maxSize;
		return this;
	}

	public TreeTypeBuilder withPioner(boolean pioner) {
		this.pioner = pioner;
		return this;
	}

	public TreeTypeBuilder withHSpace(float hSpace) {
		this.hSpace = hSpace;
		return this;
	}

	public TreeTypeBuilder withDeseaseProb(float deseaseProb) {
		this.deseaseProb = deseaseProb;
		return this;
	}

	public TreeTypeBuilder addChildProb(float pb, TreeType type) {
		childProbs.put(type, pb);
		return this;
	}

	public TreeTypeBuilder withSelfChild(float selfChildProb) {
		this.selfChildProb = selfChildProb;
		return this;
	}

	public TreeType build() {
		TreeType type = ForestFactory.eINSTANCE.createTreeType();
		type.setAsset(assetName);
		type.setDefaultTreeMaxAge(maxAge);
		type.setDefaultTreeMinAge(minAge);
		type.setIsPioner(pioner);
		type.setStartingScale(startingSize);
		type.setDefaultDeseaseProb(deseaseProb);
		type.setDefaultMaxSize(maxSize);
		type.setHSpace(hSpace);
		type.setName(name);
		if (!Float.isNaN(selfChildProb)) {
			childProbs.put(type, selfChildProb);
		}

		type.setChildrenProbs(childProbs);

		return type;
	}
}
