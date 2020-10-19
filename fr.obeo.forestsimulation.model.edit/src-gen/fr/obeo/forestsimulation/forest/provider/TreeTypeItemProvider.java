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
package fr.obeo.forestsimulation.forest.provider;

import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.TreeType;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.forestsimulation.forest.TreeType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeTypeItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAssetPropertyDescriptor(object);
			addDefaultTreeMaxAgePropertyDescriptor(object);
			addDefaultMaxSizePropertyDescriptor(object);
			addDefaultHealProbPropertyDescriptor(object);
			addDefaultTreeMinAgePropertyDescriptor(object);
			addIsPionerPropertyDescriptor(object);
			addDefaultDeseaseProbPropertyDescriptor(object);
			addStartingScalePropertyDescriptor(object);
			addChildrenProbsPropertyDescriptor(object);
			addHSpacePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Asset feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssetPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_asset_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_asset_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__ASSET, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Tree Max Age feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultTreeMaxAgePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_defaultTreeMaxAge_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_defaultTreeMaxAge_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__DEFAULT_TREE_MAX_AGE, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Max Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultMaxSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_defaultMaxSize_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_defaultMaxSize_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__DEFAULT_MAX_SIZE, true, false, false,
						ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Heal Prob feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultHealProbPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_defaultHealProb_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_defaultHealProb_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__DEFAULT_HEAL_PROB, true, false, false,
						ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Tree Min Age feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultTreeMinAgePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_defaultTreeMinAge_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_defaultTreeMinAge_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__DEFAULT_TREE_MIN_AGE, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Is Pioner feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsPionerPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_isPioner_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_isPioner_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__IS_PIONER, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Desease Prob feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultDeseaseProbPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_defaultDeseaseProb_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_defaultDeseaseProb_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__DEFAULT_DESEASE_PROB, true, false, false,
						ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Starting Scale feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartingScalePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_startingScale_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_startingScale_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__STARTING_SCALE, true, false, false,
						ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Children Probs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChildrenProbsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_childrenProbs_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_childrenProbs_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__CHILDREN_PROBS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the HSpace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHSpacePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_hSpace_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_hSpace_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__HSPACE, true, false, false,
						ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_TreeType_name_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TreeType_name_feature",
								"_UI_TreeType_type"),
						ForestPackage.Literals.TREE_TYPE__NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns TreeType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TreeType"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TreeType) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_TreeType_type")
				: getString("_UI_TreeType_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TreeType.class)) {
		case ForestPackage.TREE_TYPE__ASSET:
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE:
		case ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE:
		case ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB:
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE:
		case ForestPackage.TREE_TYPE__IS_PIONER:
		case ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB:
		case ForestPackage.TREE_TYPE__STARTING_SCALE:
		case ForestPackage.TREE_TYPE__CHILDREN_PROBS:
		case ForestPackage.TREE_TYPE__HSPACE:
		case ForestPackage.TREE_TYPE__NAME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ForestEditPlugin.INSTANCE;
	}

}
