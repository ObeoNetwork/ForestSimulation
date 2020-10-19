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
package fr.obeo.forestsimulation.rcp.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.jme3.app.state.AbstractAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.JmeContext;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.rcp.CustomApp;
import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.Session;

public class TreeRendererTest {

	private TreeRenderer renderer;
	private CustomApp cApp;

	CountDownLatch queuLatch = new CountDownLatch(1);
	private ISession session;

	@Before
	public void setUp() throws InterruptedException {
		session = new Session();
		CountDownLatch latch = new CountDownLatch(1);
		Consumer<Runnable> updater = new Consumer<Runnable>() {

			@Override
			public void accept(Runnable t) {
				queuLatch = new CountDownLatch(1);
				cApp.enqueue(new Callable<Object>() {

					@Override
					public Object call() throws Exception {
						t.run();
						queuLatch.countDown();
						return new Object();
					}
				});

			}
		};

		renderer = new TreeRenderer(session, updater) {

			public void initialize(com.jme3.app.state.AppStateManager stateManager, com.jme3.app.Application app) {
				super.initialize(stateManager, app);
				latch.countDown();
			};
		};
		cApp = new CustomApp(session, new AbstractAppState[] { renderer }) {
			
			protected void runQueuedTasks() {
				super.runQueuedTasks();
				queuLatch.countDown();
			};
			
		};
		cApp.start(JmeContext.Type.Headless);

		latch.await(20, TimeUnit.SECONDS);
	}

	@Test
	public void testRenderer() throws InterruptedException {

		assertTrue(renderer.isInitialized());
		assertTrue(renderer.existingTrees.isEmpty());

		Tree tree = ForestFactory.eINSTANCE.createTree();
		Vector3f expectedLocation = new Vector3f(1, 2, 3);
		runAndWait(f -> {
			tree.setType(f.getTypes().get(0));
			tree.setLocation(expectedLocation);
			f.getTrees().add(tree);
		});

		assertFalse(renderer.existingTrees.isEmpty());
		Node rep = renderer.existingTrees.get(tree);
		assertNotNull(rep);
		assertEquals(expectedLocation, rep.getLocalTranslation());
		assertIsInScene(rep);
	}

	private void assertIsInScene(Node n) {
		Node parent = n.getParent();
		Node root = cApp.getRootNode();
		while (parent != null) {
			if (parent == root) {
				return;
			}
			parent = parent.getParent();
		}
		fail("Not in the scene");
	}

	private void runAndWait(Consumer<Forest> toRun) throws InterruptedException {
		session.modifyModel(toRun);
		queuLatch.await(10, TimeUnit.SECONDS);

	}

}
