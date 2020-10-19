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
package fr.obeo.forestsimulation.model;

import java.text.DecimalFormat;
import java.text.ParseException;

import com.jme3.math.Vector3f;

public class DataTypeBuilder {

	private static final DecimalFormat FORMATTER = new DecimalFormat("#.##");

	public static String vectorToString(Vector3f v) {
		return "{" + FORMATTER.format(v.getX()) + ";" + FORMATTER.format(v.getY()) + ";" + FORMATTER.format(v.getZ())
				+ "}";
	}

	public static Vector3f stringToVector(String v) {
		try {
			return stringToVectorRaw(v);
		} catch (ParseException e) {
			e.printStackTrace();
			return Vector3f.ZERO;
		}
	}

	public static Vector3f stringToVectorRaw(String v) throws ParseException {
		String[] coordinates = v.replace("{", "").replace("}", "").split(";");
		if (coordinates.length == 3) {
			return new Vector3f(FORMATTER.parse(coordinates[0]).floatValue(), //
					FORMATTER.parse(coordinates[1]).floatValue(), FORMATTER.parse(coordinates[2]).floatValue());
		} else {
			return Vector3f.ZERO;
		}
	}

}
