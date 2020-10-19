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
package fr.obeo.forestsimulation.forest.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import fr.obeo.forestsimulation.forest.Tree;

public class TreeItemProviderCustomImpl extends TreeItemProvider {

	public TreeItemProviderCustomImpl(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("custom/tree.png"));

	}

	@Override
	public String getText(Object object) {
		Tree tree = (Tree) object;
		String desease = tree.isIsSick() ? "[Sick]" : "";
		return tree.getType().getName() + " " + tree.getCurrentAge() + "/" + tree.getMaxAge() + " " + tree.getSize()
				+ " " + desease;
	}

}
