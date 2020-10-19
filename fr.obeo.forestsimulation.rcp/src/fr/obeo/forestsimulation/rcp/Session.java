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
package fr.obeo.forestsimulation.rcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.inject.Singleton;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.TreeType;
import fr.obeo.forestsimulation.forest.util.ForestAdapterFactory;
import fr.obeo.forestsimulation.forest.util.ForestResourceFactoryImpl;

import fr.obeo.forestsimulation.rcp.helpers.BoundHelper;
import fr.obeo.forestsimulation.rcp.helpers.TreeTypeBuilder;

@Singleton
public class Session implements ISession {

	private TransactionalEditingDomainImpl editingDomain;
	private Resource mainResource;
	private Forest root;
	private BoundHelper boundHelper;

	private List<EObject> currentSelection = Collections.emptyList();

	private List<BiConsumer<List<EObject>, List<EObject>>> listeners = new ArrayList<>();

	public Session() {
		ResourceSet rs = new ResourceSetImpl();

		rs.getPackageRegistry().put(ForestPackage.eINSTANCE.getNsURI(), ForestPackage.eINSTANCE);
		ForestResourceFactoryImpl forestResourceFactoryImpl = new ForestResourceFactoryImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(ForestPackage.eNS_PREFIX.toLowerCase(),
				forestResourceFactoryImpl);

		editingDomain = new TransactionalEditingDomainImpl(new ForestAdapterFactory(), rs);

		editingDomain
				.setDefaultTransactionOptions(Collections.singletonMap(Transaction.OPTION_NO_VALIDATION, Boolean.TRUE));
		mainResource = rs.createResource(URI.createURI("fakeURI:/aFakePath.forest"));
		root = ForestFactory.eINSTANCE.createForest();
		this.boundHelper = new BoundHelper();
		modifyModel(() -> {
			mainResource.getContents().add(root);
			boundHelper.init(root);
			buildTreeTypes();

		});
		editingDomain.addResourceSetListener(boundHelper);
	}

	private void buildTreeTypes() {

		TreeType oak = new TreeTypeBuilder("Oak")//
				.withAssetName("models/treeB/TreeB.j3o")//
				.withDeseaseProb(0.055f)//
				.withMinAge(50)//
				.withMaxAge(300)//
				.withPioner(false)//
				.withStartingSize(0.15f)//
				.withHSpace(1.1f)//
				.withMaxSize(0.8f)//
				.withSelfChild(0.1f)//
				.build();

		root.getTypes().add(oak);

		TreeType treeType1 = new TreeTypeBuilder("Ash Tree")//
				.withAssetName("models/treeA/tree1.j3o")//
				.withDeseaseProb(0.05f)//
				.withMinAge(30)//
				.withMaxAge(100)//
				.withPioner(true)//
				.withStartingSize(0.3f)//
				.withHSpace(0.99f)//
				.withMaxSize(1f)//
				.withSelfChild(0.3f).addChildProb(0.2f, oak)//
				.build();

		root.getTypes().add(treeType1);

		oak.getChildrenProbs().put(treeType1, 0.1f);

		TreeType pin1 = new TreeTypeBuilder("Pine 1")//
				.withDeseaseProb(0.01f)//
				.withMinAge(50)//
				.withMaxAge(150)//
				.withPioner(true)//
				.withSelfChild(0.3f)//
				.withStartingSize(0.3f)//
				.withMaxSize(1f)//
				.withAssetName("models/pin1/pin1.j3o")//
				.withHSpace(0.483f).build();
		root.getTypes().add(pin1);

		TreeType pin2 = new TreeTypeBuilder("Pine 2")//
				.withDeseaseProb(0.01f)//
				.withMinAge(50)//
				.withMaxAge(250)//
				.withPioner(false)//
				.withSelfChild(0.2f)//
				.withStartingSize(0.3f)//
				.withMaxSize(1.2f)//
				.withAssetName("models/pin2/pin2.j3o")//
				.withHSpace(0.857f).addChildProb(0.1f, pin1).build();
		root.getTypes().add(pin2);
		pin1.getChildrenProbs().put(pin2, 0.2f);

		TreeType pin3 = new TreeTypeBuilder("Pine 3")//
				.withDeseaseProb(0.01f)//
				.withMinAge(50)//
				.withMaxAge(300)//
				.withPioner(false)//
				.withSelfChild(0.2f)//
				.withStartingSize(0.3f)//
				.withMaxSize(1.3f)//
				.withAssetName("models/pin3/pin3.j3o")//
				.withHSpace(0.656f).addChildProb(0.1f, pin2).addChildProb(0.1f, pin1).build();
		root.getTypes().add(pin3);
		pin1.getChildrenProbs().put(pin3, 0.2f);

	}

	@Override
	public BoundHelper getBoundHelper() {
		return boundHelper;
	}

	@Override
	public TransactionalEditingDomainImpl getEditingDomain() {
		return editingDomain;
	}

	@Override
	public void readModel(Consumer<Forest> reader) {
		try {
			editingDomain.runExclusive(() -> {
				reader.accept(root);
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T readModelAndReturn(Function<Forest, T> func) {
		Object[] result = new Object[1];
		try {
			editingDomain.runExclusive(() -> {
				result[0] = func.apply(root);
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return (T) result[0];
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T modifyModelAndReturn(Function<Forest, T> runnable) {
		Object[] result = new Object[1];
		RecordingCommand cmd = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				result[0] = runnable.apply(root);
			}
		};
		editingDomain.getCommandStack().execute(cmd);
		return (T) result[0];
	}

	@Override
	public void modifyModel(Runnable runnable) {
		RecordingCommand cmd = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				runnable.run();
			}
		};
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void modifyModel(Consumer<Forest> consumer) {
		RecordingCommand cmd = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				consumer.accept(root);
			}
		};
		editingDomain.getCommandStack().execute(cmd);
	}

	@Override
	public void setSelection(List<EObject> collection) {
		List<EObject> old = currentSelection;
		this.currentSelection = collection;
		for (BiConsumer<List<EObject>, List<EObject>> listener : listeners) {
			listener.accept(old, currentSelection);
		}
	}

	@Override
	public List<EObject> getCurrentSelection() {
		return currentSelection;
	}

	@Override
	public void addSelectionListener(BiConsumer<List<EObject>, List<EObject>> listener) {
		listeners.add(listener);
	}

}
