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

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

import com.jme3.math.Vector3f;

import fr.obeo.forestsimulation.rcp.ISession;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

public class PropsPart {


	private void refreshUI() {
		display.asyncExec(() -> {
			widgets.forEach(Refreshable::refresh);
		});
		
		if(currentSelection != null && shell != null && !shell.isDisposed()) {
				shell.getDisplay().timerExec(250, this::refreshUI);
		}
	}

	@Inject
	ESelectionService selectionService;
	private EObject currentSelection;
	private Composite cc;
	private float forestSize;

	private List<Refreshable> widgets = new ArrayList<Refreshable>();
	private ISession session;
	private Display display;
	private Shell shell;

	@Inject
	public PropsPart() {

	}

	@PostConstruct
	public void postConstruct(Composite parent, ISession session) {
		this.session = session;
		this.shell = parent.getShell();
		this.display = shell.getDisplay();
		forestSize = session.readModelAndReturn(Forest::getSize);

		cc = new Composite(parent, SWT.None);
		cc.setLayout(new GridLayout(2, false));

		session.addSelectionListener(this::activeSelection);

	}

	public void activeSelection(List<EObject> oldSelection, List<EObject> newSelection) {
		if (newSelection.contains(currentSelection)) {
			return;
		}
		if (!cc.isDisposed()) {
			for (Control c : cc.getChildren()) {
				c.dispose();
			}
		}
		widgets.clear();

		if (newSelection.isEmpty()) {
			currentSelection = null;
		} else {
			this.currentSelection = newSelection.get(0);
		}

		if (currentSelection instanceof Tree) {
			Tree tree = (Tree) currentSelection;
			float forestHalfSize = (forestSize * 100 / 2);
			createXWidget(tree, -forestHalfSize, forestHalfSize);
			createYWidget(tree, -forestHalfSize, forestHalfSize);

			createFloatWidget("Heading", tree::getHeading, tree::setHeading, 0, 180, 5f);
			createFloatWidget("Size", tree::getSize, tree::setSize, 0, 20, 0.1f);
			createFloatWidget("Desease prob", tree::getDeseaseProb, tree::setDeseaseProb, 0, 1, 0.1f);
			createFloatWidget("Heal prob", tree::getHealProb, tree::setHealProb, 0, 1, 0.1f);
			createFloatWidget("Max size", tree::getMaxSize, tree::setMaxSize, 0, 30, 0.2f);
			createIntWidget("Max Age", tree::getMaxAge, tree::setMaxAge, 0, 2000, 10);
			createIntWidget("Age", tree::getCurrentAge, tree::setCurrentAge, 0, 2000, 1);
		} else if (currentSelection instanceof TreeType) {
			TreeType treeType = (TreeType) currentSelection;

			createFloatWidget("H Spacing", treeType::getHSpace, treeType::setHSpace, 0f, 20f, 0.05f);
			for (Entry<TreeType, Float> entry : treeType.getChildrenProbs().entrySet()) {
				TreeType childType = entry.getKey();
				createFloatWidget("Prob of " + childType.getName(), () -> treeType.getChildrenProbs().get(childType),
						v -> treeType.getChildrenProbs().put(treeType, v), 0f, 1f, 0.5f);
			}

			createIntWidget("Default max age", treeType::getDefaultTreeMaxAge, treeType::setDefaultTreeMaxAge, 0,
					10000, 10);
			createIntWidget("Default min age", treeType::getDefaultTreeMinAge, treeType::setDefaultTreeMinAge, 0,
					10000, 10);

			createFloatWidget("Default desease prob", treeType::getDefaultDeseaseProb, treeType::setDefaultDeseaseProb,
					0, 1, 0.1f);
			createFloatWidget("Default health prob", treeType::getDefaultHealProb, treeType::setDefaultHealProb, 0, 1,
					0.1f);
			createFloatWidget("Default max size", treeType::getDefaultMaxSize, treeType::setDefaultMaxSize, 0, 50,
					0.1f);
		} else if (currentSelection instanceof Forest) {
			Forest forest = (Forest) currentSelection;
			createIntWidget("Year period", forest::getYearPeriod, forest::setYearPeriod, 100, 10000, 100);
			createIntWidget("Max number of tree", forest::getMaxNumberOfTree, forest::setMaxNumberOfTree, 100, 10000,
					100);
			createFloatWidget("Pioner tree prob", forest::getPionerTreeProb, forest::setPionerTreeProb, 0, 1, 0.1f);

		}
		if (cc != null && !cc.isDisposed()) {
			cc.layout();
		}
		
		if(currentSelection != null) {
			refreshUI();
		}
	}

	private void createXWidget(Tree tree, float min, float max) {
		WrappedFloatSpinner spinner = createFloatSpinner("X", //
				() -> {
					return session.readModelAndReturn(f -> tree.getLocation().getX());
				}, //
				v -> {
					session.modifyModel(f -> {
						Vector3f location = tree.getLocation();
						tree.setLocation(new Vector3f(v, location.getY(), location.getZ()));
					});
				}, min, max, 0.2f);
		widgets.add(spinner);
	}

	private void createYWidget(Tree tree, float min, float max) {
		WrappedFloatSpinner spinner = createFloatSpinner("Y", //
				() -> {
					return session.readModelAndReturn(f -> tree.getLocation().getY());
				}, //
				v -> {
					session.modifyModel(f -> {
						Vector3f location = tree.getLocation();
						tree.setLocation(new Vector3f(location.getX(), v, location.getZ()));
					});
				}, min, max, 0.2f);
		widgets.add(spinner);
	}

	private void createFloatWidget(String label, Supplier<Float> valueSup, Consumer<Float> valueConsumer, float min,
			float max, float inc) {
		WrappedFloatSpinner spinner = createFloatSpinner(label, //
				() -> {
					return session.readModelAndReturn(f -> (float) valueSup.get());
				}, //
				v -> {
					session.modifyModel(f -> {
						valueConsumer.accept(v);
					});
				}, min, max, inc);
		widgets.add(spinner);
	}

	private void createIntWidget(String label, IntSupplier valueSup, IntConsumer valueConsumer, int min, int max,
			int inc) {
		WrappedIntSpinner spinner = createIntSpinner(label, //
				() -> {
					return session.readModelAndReturn(f -> valueSup.getAsInt());
				}, //
				v -> {
					session.modifyModel(f -> {
						valueConsumer.accept(v);
					});
				}, min, max, inc);
		widgets.add(spinner);
	}

	private WrappedFloatSpinner createFloatSpinner(String label, Supplier<Float> valueProvider,
			Consumer<Float> valueConsumer, float min, float max, float inc) {
		return new WrappedFloatSpinner(cc, label, valueProvider, valueConsumer, min, max, inc);
	}

	private WrappedIntSpinner createIntSpinner(String label, IntSupplier valueProvider, IntConsumer valueConsumer,
			int min, int max, int inc) {
		return new WrappedIntSpinner(cc, label, valueProvider, valueConsumer, min, max, inc);
	}

	@PreDestroy
	public void preDestroy() {

	}

	private interface Refreshable {
		public void refresh();
	}

	private class WrappedFloatSpinner implements Refreshable {
		private static final int DIGITS = 2;
		Supplier<Float> valueProvider;
		Spinner spinner;

		public WrappedFloatSpinner(Composite parent, String label, Supplier<Float> valueProvider,
				Consumer<Float> valueConsumer, float min, float max, float inc) {
			this.valueProvider = valueProvider;
			Label labelWidget = new Label(cc, SWT.None);
			labelWidget.setLayoutData(new GridData(GridData.BEGINNING));
			labelWidget.setText(label);

			spinner = new Spinner(cc, SWT.READ_ONLY);
			spinner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			spinner.setDigits(DIGITS);

			// set the minimum value to 0.001
			spinner.setMinimum((int) min * 100);
			// set the maximum value to 20
			spinner.setMaximum((int) max * 100);
			// set the increment value to 0.010
			spinner.setIncrement((int) (Math.pow(10, DIGITS) * inc));
			spinner.setSelection((int) (valueProvider.get() * 100));
			spinner.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					int selection = spinner.getSelection();
					int digits = spinner.getDigits();
					double newValue = selection / Math.pow(10, digits);
					valueConsumer.accept((float) newValue);
				}
			});
		}

		public void refresh() {
			if (!spinner.isDisposed()) {
				spinner.setSelection((int) (valueProvider.get() * 100));
			}
		}
	}

	private class WrappedIntSpinner implements Refreshable {
		IntSupplier valueProvider;
		Spinner spinner;

		public WrappedIntSpinner(Composite parent, String label, IntSupplier valueProvider, IntConsumer valueConsumer,
				int min, int max, int inc) {
			this.valueProvider = valueProvider;
			Label labelWidget = new Label(cc, SWT.READ_ONLY);
			labelWidget.setLayoutData(new GridData(GridData.BEGINNING));
			labelWidget.setText(label);

			spinner = new Spinner(cc, SWT.READ_ONLY);
			spinner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			// set the minimum value to 0.001
			spinner.setMinimum(-max);
			// set the maximum value to 20
			spinner.setMaximum(max);
			// set the increment value to 0.010
			spinner.setIncrement(inc);
			spinner.setSelection(valueProvider.getAsInt());
			spinner.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					valueConsumer.accept(spinner.getSelection());
				}
			});
		}

		public void refresh() {
			if (!spinner.isDisposed()) {
				spinner.setSelection(valueProvider.getAsInt());
			}
		}
	}

}