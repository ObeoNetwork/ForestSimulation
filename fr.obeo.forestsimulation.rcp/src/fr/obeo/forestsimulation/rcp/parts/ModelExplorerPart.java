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
package fr.obeo.forestsimulation.rcp.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import fr.obeo.forestsimulation.forest.provider.ForestItemProviderAdapterFactory;
import fr.obeo.forestsimulation.rcp.ISession;

public class ModelExplorerPart {

	private ISession session;
	private ForestItemProviderAdapterFactory adapterFactory;
	@Inject
	ESelectionService selectionService;

	@Inject
	public ModelExplorerPart(ISession session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite cc = new Composite(parent, SWT.NONE);
		cc.setLayout(new FillLayout());

		TreeViewer treeViewer = new TreeViewer(cc);

		treeViewer.addSelectionChangedListener(event -> {
			session.setSelection(event.getStructuredSelection().toList());
		});

		adapterFactory = new ForestItemProviderAdapterFactory();
		TransactionalEditingDomain editingDomain = session.getEditingDomain();
		TransactionalAdapterFactoryContentProvider contentProvider = new TransactionalAdapterFactoryContentProvider(
				editingDomain, adapterFactory);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(editingDomain, adapterFactory));

		session.readModel(project -> {
			treeViewer.setInput(session.readModelAndReturn(f -> f));
		});

	}

}