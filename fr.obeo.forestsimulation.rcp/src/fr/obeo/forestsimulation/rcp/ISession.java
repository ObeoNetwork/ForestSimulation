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
package fr.obeo.forestsimulation.rcp;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.inject.Singleton;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import fr.obeo.forestsimulation.forest.Forest;

import fr.obeo.forestsimulation.rcp.helpers.BoundHelper;

@Singleton
public interface ISession {

	void readModel(Consumer<Forest> reader);

	<T> T readModelAndReturn(Function<Forest, T> func);

	<T> T modifyModelAndReturn(Function<Forest, T> runnable);

	void modifyModel(Runnable runnable);

	void modifyModel(Consumer<Forest> consumer);

	BoundHelper getBoundHelper();

	void setSelection(List<EObject> collection);

	List<EObject> getCurrentSelection();

	void addSelectionListener(BiConsumer<List<EObject>, List<EObject>> listener);

	TransactionalEditingDomainImpl getEditingDomain();

}