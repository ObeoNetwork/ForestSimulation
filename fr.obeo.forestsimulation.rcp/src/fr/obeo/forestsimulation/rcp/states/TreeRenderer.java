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
package fr.obeo.forestsimulation.rcp.states;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import fr.obeo.forestsimulation.rcp.ISession;
import fr.obeo.forestsimulation.rcp.helpers.MaterialBuilder;
import fr.obeo.forestsimulation.rcp.helpers.BoundHelper.Circle;

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

/**
 * Render in charge of displaying trees
 */
public class TreeRenderer extends AbstractAppState {

	private final ISession session;
	private AssetManager assetManager;
	private Node rootNode;

	Map<Tree, Node> existingTrees = new HashMap<>();

	private Map<Tree, Geometry> debugElements = new HashMap<>();
	private Map<TreeType, Node> templates = new HashMap<TreeType, Node>();

	private ResourceSetListenerImpl listener = new ModelInterpreter();
	private final Consumer<Runnable> sceneModifier;

	public TreeRenderer(ISession session, Consumer<Runnable> sceneModifier) {
		super();
		this.session = session;
		this.sceneModifier = sceneModifier;
		session.getEditingDomain().addResourceSetListener(listener);
	}

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		assetManager = app.getAssetManager();
		rootNode = ((SimpleApplication) app).getRootNode();
		buildExisting();
		super.initialize(stateManager, app);
	}

	private void buildExisting() {
		session.readModel(forest -> {
			TreeIterator<EObject> contentIte = forest.eAllContents();
			while (contentIte.hasNext()) {
				EObject eObject = (EObject) contentIte.next();
				if (eObject instanceof Tree) {
					Tree sTree = (Tree) eObject;
					rootNode.attachChild(buildTreeRepresentation(sTree));

					if (forest.isDebug()) {
						Geometry boundingVolume = buildWireframeBox(sTree);
						debugElements.put(sTree, boundingVolume);
						rootNode.attachChild(boundingVolume);
					}
				}
			}
		});
	}

	private Node getTreeTemplate(TreeType type) {
		Node treeTemplate = templates.get(type);
		if (treeTemplate == null) {
			treeTemplate = (Node) assetManager.loadModel(type.getAsset());
			templates.put(type, treeTemplate);
		}
		return treeTemplate;
	}

	private Node buildTreeRepresentation(Tree sTree) {
		final Node tree;
		TreeType type = sTree.getType();
		tree = getTreeTemplate(type).clone(true);
		tree.setShadowMode(com.jme3.renderer.queue.RenderQueue.ShadowMode.CastAndReceive);
		tree.setLocalScale(sTree.getSize());
		tree.setLocalRotation(buildQuaternion(sTree.getHeading()));

		Vector3f location = sTree.getLocation();
		tree.setLocalTranslation(location);

		addRepresentation(sTree, tree);
		return tree;
	}

	private void addRepresentation(Tree sTree, Node spatial) {
		existingTrees.put(sTree, spatial);
	}

	private Node removeRepresentation(Object sTree) {
		return existingTrees.remove(sTree);
	}

	private Node getRepresentation(Object object) {
		return existingTrees.get(object);
	}

	private Geometry buildWireframeBox(Tree sTree) {
		Circle circle = session.getBoundHelper().toCircle(sTree);
		Vector2f location = circle.getLocation();
		fr.obeo.forestsimulation.rcp.helpers.Circle circleMesh = new fr.obeo.forestsimulation.rcp.helpers.Circle(Vector3f.ZERO,
				circle.getSize(), 10);
		Geometry boundingVolume = new Geometry("", circleMesh);
		boundingVolume.setLocalTranslation(new Vector3f(location.getX(), location.getY(), 0));
		Material mat = MaterialBuilder.buildUnshaded(assetManager, ColorRGBA.White);
		boundingVolume.setMaterial(mat);
		boundingVolume.setLocalRotation(new Quaternion().fromAngles(FastMath.PI / 2, 0, 0));
		return boundingVolume;
	}

	private Quaternion buildQuaternion(float heading) {
		return new Quaternion().fromAngles(0, 0, FastMath.RAD_TO_DEG * heading);
	}

	private final class ModelInterpreter extends ResourceSetListenerImpl {
		public boolean isPostcommitOnly() {
			return true;
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			for (Notification notif : event.getNotifications()) {
				if (notif.getFeature() == ForestPackage.eINSTANCE.getForest_Trees()
						|| notif.getFeature() == ForestPackage.eINSTANCE.getTree_Children()) {
					handleAddRemoveTree(notif);
				} else if (notif.getFeature() == ForestPackage.eINSTANCE.getTree_Location()
						&& notif.getNotifier() instanceof Tree) {
					handleMove(notif);
				} else if (notif.getFeature() == ForestPackage.eINSTANCE.getTree_Heading()
						&& notif.getNotifier() instanceof Tree) {
					handleHeading(notif);
				} else if (notif.getFeature() == ForestPackage.eINSTANCE.getTree_Size()
						&& notif.getNotifier() instanceof Tree) {
					handleScale(notif);
				} else if (notif.getFeature() == ForestPackage.eINSTANCE.getForest_Debug()) {
					handleForectDebug((Forest) notif.getNotifier(), notif.getNewBooleanValue());
				}

			}
		}

		private void handleForectDebug(Forest forest, boolean debug) {

			List<Geometry> toRemove = new ArrayList<Geometry>(debugElements.values());

			sceneModifier.accept(() -> {
				toRemove.forEach(t -> rootNode.detachChild(t));
			});

			debugElements.clear();

			List<Spatial> reps = new ArrayList<>();
			int nbTrees = 0;
			TreeIterator<EObject> contentIte = forest.eAllContents();
			if (debug) {
				while (contentIte.hasNext()) {
					EObject eObject = (EObject) contentIte.next();
					if (eObject instanceof Tree) {
						Tree sTree = (Tree) eObject;
						nbTrees++;
						Spatial rep = getRepresentation(sTree);
						if (rep != null) {
							reps.add(rep);
						} else {
							System.err.println("Missing rep");
						}
						Geometry boundingVolume = buildWireframeBox(sTree);
						debugElements.put(sTree, boundingVolume);
					}
				}
			}

			System.out.println("Nb semantic tress " + nbTrees);
			System.out.println("Nb representation tress " + reps.size());
			System.out.println("Nb of children of root node tress " + rootNode.getChildren().size());

			List<Geometry> toAdd = new ArrayList<Geometry>(debugElements.values());
			sceneModifier.accept(() -> {
				toAdd.forEach(t -> {
					rootNode.attachChild(t);
				});
			});

		}

		private void handleScale(Notification notif) {
			Spatial node = getRepresentation(notif.getNotifier());
			float size = notif.getNewFloatValue();
			sceneModifier.accept(() -> node.setLocalScale(size));
		}

		private void handleHeading(Notification notif) {
			Spatial node = getRepresentation(notif.getNotifier());
			float heading = notif.getNewFloatValue();
			sceneModifier.accept(() -> node.setLocalRotation(buildQuaternion(heading)));
		}

		private void handleMove(Notification notif) {
			Spatial node = getRepresentation(notif.getNotifier());
			Vector3f location = (Vector3f) notif.getNewValue();
			sceneModifier.accept(() -> node.setLocalTranslation(location));
		}

		private void handleAddRemoveTree(Notification notif) {
			if (notif.getEventType() == Notification.ADD) {
				Tree newValue = (Tree) notif.getNewValue();
				Node existingRep = getRepresentation(newValue);
				if (existingRep == null) {
					Node treeRep = buildTreeRepresentation(newValue);
					sceneModifier.accept(() -> rootNode.attachChild(treeRep));
				}
			} else if (notif.getEventType() == Notification.REMOVE) {
				EObject oldValue = (EObject) notif.getOldValue();
				Spatial treeRep = removeRepresentation(oldValue);
				if (treeRep != null) {
					sceneModifier.accept(() -> rootNode.detachChild(treeRep));
				}
			} else if (notif.getEventType() == Notification.ADD_MANY) {
				@SuppressWarnings("unchecked")
				List<Tree> newTrees = (List<Tree>) notif.getNewValue();
				List<Node> treeReps = newTrees.stream().map(sT -> buildTreeRepresentation(sT)).collect(toList());
				sceneModifier.accept(() -> {
					treeReps.forEach(rootNode::attachChild);
				});
			} else if (notif.getEventType() == Notification.REMOVE_MANY) {
				@SuppressWarnings("unchecked")
				List<Tree> oldValues = (List<Tree>) notif.getOldValue();
				List<Node> toRemove = oldValues.stream().map(r -> getRepresentation(r)).filter(r -> r != null)
						.collect(toList());
				sceneModifier.accept(() -> {
					toRemove.forEach(rootNode::detachChild);
				});
			}
		}
	}

}
