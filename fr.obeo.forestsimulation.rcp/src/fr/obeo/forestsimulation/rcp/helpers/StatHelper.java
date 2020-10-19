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

import java.util.Random;

public class StatHelper {
	
	private static final StatHelper INSTANCE = new StatHelper();
	
	public static StatHelper getInstance() {
		return INSTANCE;
	}
	

	private Random random = new Random(System.currentTimeMillis());
	
	private StatHelper() {
	}

	public float getRandomFloat(float min, float max) {
		return random.nextFloat() * (max - min) + min;
	}

	public int getRandomInt(int min, int max) {
		return (int) (random.nextDouble() * (max - min) + min);
	}

	public float getNextFloat() {
		return random.nextFloat();
	}
	
	public boolean draw(float percentage) {
		return random.nextFloat() < percentage;
	}
}
