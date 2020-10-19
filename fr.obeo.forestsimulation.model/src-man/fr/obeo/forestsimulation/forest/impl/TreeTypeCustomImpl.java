/**
 *   Copyright (c) 2020 Obeo.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *   https://www.eclipse.org/legal/epl-2.0/
 *  
 *   Contributors:
 *     Arthur Daussy - initial API and implementation
 * 
 */
package fr.obeo.forestsimulation.forest.impl;

import java.util.Map;
import java.util.Map.Entry;

import fr.obeo.forestsimulation.forest.TreeType;

public class TreeTypeCustomImpl extends TreeTypeImpl {
	
	
	private float[] probs ;
	
	private TreeType[] types;
	
	@Override
	public TreeType getChildType(float draw) {
		float[] proba = getProbs();
		for(int i =  0; i < proba.length  ; i++) {
			if(draw  < proba[i]) {
				return types[i];
			}
		}
		return null;
	}
	
	private float[] getProbs() {
		if(probs == null) {
			Map<TreeType, Float> cProbs = getChildrenProbs();
			probs = new float[cProbs.size()];
			types = new TreeType[cProbs.size()];
			float start = 0;
			int i = 0;
			for(Entry<TreeType, Float> entry : getChildrenProbs().entrySet()) {
				probs[i]=entry.getValue()+start;
				types[i]=entry.getKey();
				start += entry.getValue();
				i++;
			}
		}
		return probs;
	}

}
