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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import fr.obeo.forestsimulation.forest.Forest;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.SemanticHelper;

public class BottomToolBar {

	private static final String FOREST_AGE = "Forest age ";
	private Integer yearPeriod;
	private Shell shell;
	private ISession session;
	private Label forestAge;
	private Label nbTree;

	@Inject
	public BottomToolBar() {

	}

	@PostConstruct
	public void createGui(ISession session, org.eclipse.swt.widgets.Shell shell, Composite parent) {

		this.session = session;
		this.shell = shell;

		Composite cc = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(2, true);
		cc.setLayout(layout);

		forestAge = new Label(cc, SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_VERTICAL);
		layoutData.widthHint = 150;
		forestAge.setLayoutData(layoutData);

		nbTree = new Label(cc, SWT.BORDER);
		nbTree.setLayoutData(layoutData);

		yearPeriod = session.readModelAndReturn(Forest::getYearPeriod);
		forestAge.setText(FOREST_AGE + session.readModelAndReturn(Forest::getAge));

		updateUI();
	}

	private void updateUI() {
		int[] maxNumberOfTree = new int[1];
		int[] numberOfTree = new int[1];
		int[] age = new int[1];

		session.readModel(f -> {
			age[0] = f.getAge();
			maxNumberOfTree[0] = f.getMaxNumberOfTree();
			numberOfTree[0] = SemanticHelper.countTree(f);
		});

		if (!forestAge.isDisposed()) {
			forestAge.setText(FOREST_AGE + age[0]);
		}

		if (!nbTree.isDisposed()) {
			nbTree.setText("Nb tree " + numberOfTree[0] + "/" + maxNumberOfTree[0]);
		}

		if (!shell.isDisposed()) {
			shell.getDisplay().timerExec(yearPeriod, this::updateUI);
		}
	}
}