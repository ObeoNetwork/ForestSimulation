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

import java.util.Random;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import fr.obeo.forestsimulation.forest.Tree;

import fr.obeo.forestsimulation.rcp.ISession;

/**
 * Runnable in charge of giving desease or healing tree
 * 
 * @author Arthur Daussy
 *
 */
public class DeseaseRunner implements Runnable {

	private Random random = new Random(System.currentTimeMillis());

	private ISession session;

	public DeseaseRunner(ISession session) {
		this.session = session;
	}

	@Override
	public void run() {
		session.modifyModel(f -> {
			TreeIterator<EObject> contentIte = f.eAllContents();
			while (contentIte.hasNext()) {
				EObject eObject = (EObject) contentIte.next();
				if (eObject instanceof Tree) {
					Tree tree = (Tree) eObject;
					if (!tree.isIsSick()) {
						if (random.nextFloat() < tree.getDeseaseProb()) {
							tree.setIsSick(true);
						}
					}

					if (tree.isIsSick()) {
						if (random.nextFloat() < tree.getHealProb()) {
							tree.setIsSick(false);
						}
					}
				}
			}
		});
		
		session.getEditingDomain().getCommandStack().flush();

	}

}
