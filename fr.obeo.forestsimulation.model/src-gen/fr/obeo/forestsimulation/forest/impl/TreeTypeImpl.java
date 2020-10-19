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
package fr.obeo.forestsimulation.forest.impl;

import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.TreeType;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getAsset <em>Asset</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getDefaultTreeMaxAge <em>Default Tree Max Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getDefaultMaxSize <em>Default Max Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getDefaultHealProb <em>Default Heal Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getDefaultTreeMinAge <em>Default Tree Min Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#isIsPioner <em>Is Pioner</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getDefaultDeseaseProb <em>Default Desease Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getStartingScale <em>Starting Scale</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getChildrenProbs <em>Children Probs</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getHSpace <em>HSpace</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TreeTypeImpl extends MinimalEObjectImpl.Container implements TreeType {
	/**
	 * The default value of the '{@link #getAsset() <em>Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsset()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAsset() <em>Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsset()
	 * @generated
	 * @ordered
	 */
	protected String asset = ASSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTreeMaxAge() <em>Default Tree Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTreeMaxAge()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_TREE_MAX_AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultTreeMaxAge() <em>Default Tree Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTreeMaxAge()
	 * @generated
	 * @ordered
	 */
	protected int defaultTreeMaxAge = DEFAULT_TREE_MAX_AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultMaxSize() <em>Default Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMaxSize()
	 * @generated
	 * @ordered
	 */
	protected static final float DEFAULT_MAX_SIZE_EDEFAULT = 2.0F;

	/**
	 * The cached value of the '{@link #getDefaultMaxSize() <em>Default Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMaxSize()
	 * @generated
	 * @ordered
	 */
	protected float defaultMaxSize = DEFAULT_MAX_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultHealProb() <em>Default Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHealProb()
	 * @generated
	 * @ordered
	 */
	protected static final float DEFAULT_HEAL_PROB_EDEFAULT = 0.05F;

	/**
	 * The cached value of the '{@link #getDefaultHealProb() <em>Default Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHealProb()
	 * @generated
	 * @ordered
	 */
	protected float defaultHealProb = DEFAULT_HEAL_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTreeMinAge() <em>Default Tree Min Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTreeMinAge()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_TREE_MIN_AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultTreeMinAge() <em>Default Tree Min Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTreeMinAge()
	 * @generated
	 * @ordered
	 */
	protected int defaultTreeMinAge = DEFAULT_TREE_MIN_AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPioner() <em>Is Pioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPioner()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PIONER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPioner() <em>Is Pioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPioner()
	 * @generated
	 * @ordered
	 */
	protected boolean isPioner = IS_PIONER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultDeseaseProb() <em>Default Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDeseaseProb()
	 * @generated
	 * @ordered
	 */
	protected static final float DEFAULT_DESEASE_PROB_EDEFAULT = 0.05F;

	/**
	 * The cached value of the '{@link #getDefaultDeseaseProb() <em>Default Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDeseaseProb()
	 * @generated
	 * @ordered
	 */
	protected float defaultDeseaseProb = DEFAULT_DESEASE_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartingScale() <em>Starting Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingScale()
	 * @generated
	 * @ordered
	 */
	protected static final float STARTING_SCALE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getStartingScale() <em>Starting Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingScale()
	 * @generated
	 * @ordered
	 */
	protected float startingScale = STARTING_SCALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildrenProbs() <em>Children Probs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenProbs()
	 * @generated
	 * @ordered
	 */
	protected Map<TreeType, Float> childrenProbs;

	/**
	 * The default value of the '{@link #getHSpace() <em>HSpace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHSpace()
	 * @generated
	 * @ordered
	 */
	protected static final float HSPACE_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getHSpace() <em>HSpace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHSpace()
	 * @generated
	 * @ordered
	 */
	protected float hSpace = HSPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ForestPackage.Literals.TREE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsset(String newAsset) {
		String oldAsset = asset;
		asset = newAsset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__ASSET, oldAsset, asset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultTreeMaxAge() {
		return defaultTreeMaxAge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTreeMaxAge(int newDefaultTreeMaxAge) {
		int oldDefaultTreeMaxAge = defaultTreeMaxAge;
		defaultTreeMaxAge = newDefaultTreeMaxAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE,
					oldDefaultTreeMaxAge, defaultTreeMaxAge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDefaultMaxSize() {
		return defaultMaxSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultMaxSize(float newDefaultMaxSize) {
		float oldDefaultMaxSize = defaultMaxSize;
		defaultMaxSize = newDefaultMaxSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE,
					oldDefaultMaxSize, defaultMaxSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDefaultHealProb() {
		return defaultHealProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultHealProb(float newDefaultHealProb) {
		float oldDefaultHealProb = defaultHealProb;
		defaultHealProb = newDefaultHealProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB,
					oldDefaultHealProb, defaultHealProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultTreeMinAge() {
		return defaultTreeMinAge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTreeMinAge(int newDefaultTreeMinAge) {
		int oldDefaultTreeMinAge = defaultTreeMinAge;
		defaultTreeMinAge = newDefaultTreeMinAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE,
					oldDefaultTreeMinAge, defaultTreeMinAge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPioner() {
		return isPioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPioner(boolean newIsPioner) {
		boolean oldIsPioner = isPioner;
		isPioner = newIsPioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__IS_PIONER, oldIsPioner,
					isPioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDefaultDeseaseProb() {
		return defaultDeseaseProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDeseaseProb(float newDefaultDeseaseProb) {
		float oldDefaultDeseaseProb = defaultDeseaseProb;
		defaultDeseaseProb = newDefaultDeseaseProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB,
					oldDefaultDeseaseProb, defaultDeseaseProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStartingScale() {
		return startingScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingScale(float newStartingScale) {
		float oldStartingScale = startingScale;
		startingScale = newStartingScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__STARTING_SCALE,
					oldStartingScale, startingScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<TreeType, Float> getChildrenProbs() {
		return childrenProbs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrenProbs(Map<TreeType, Float> newChildrenProbs) {
		Map<TreeType, Float> oldChildrenProbs = childrenProbs;
		childrenProbs = newChildrenProbs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__CHILDREN_PROBS,
					oldChildrenProbs, childrenProbs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHSpace() {
		return hSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHSpace(float newHSpace) {
		float oldHSpace = hSpace;
		hSpace = newHSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__HSPACE, oldHSpace, hSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeType getChildType(float draw) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ForestPackage.TREE_TYPE__ASSET:
			return getAsset();
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE:
			return getDefaultTreeMaxAge();
		case ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE:
			return getDefaultMaxSize();
		case ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB:
			return getDefaultHealProb();
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE:
			return getDefaultTreeMinAge();
		case ForestPackage.TREE_TYPE__IS_PIONER:
			return isIsPioner();
		case ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB:
			return getDefaultDeseaseProb();
		case ForestPackage.TREE_TYPE__STARTING_SCALE:
			return getStartingScale();
		case ForestPackage.TREE_TYPE__CHILDREN_PROBS:
			return getChildrenProbs();
		case ForestPackage.TREE_TYPE__HSPACE:
			return getHSpace();
		case ForestPackage.TREE_TYPE__NAME:
			return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ForestPackage.TREE_TYPE__ASSET:
			setAsset((String) newValue);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE:
			setDefaultTreeMaxAge((Integer) newValue);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE:
			setDefaultMaxSize((Float) newValue);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB:
			setDefaultHealProb((Float) newValue);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE:
			setDefaultTreeMinAge((Integer) newValue);
			return;
		case ForestPackage.TREE_TYPE__IS_PIONER:
			setIsPioner((Boolean) newValue);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB:
			setDefaultDeseaseProb((Float) newValue);
			return;
		case ForestPackage.TREE_TYPE__STARTING_SCALE:
			setStartingScale((Float) newValue);
			return;
		case ForestPackage.TREE_TYPE__CHILDREN_PROBS:
			setChildrenProbs((Map<TreeType, Float>) newValue);
			return;
		case ForestPackage.TREE_TYPE__HSPACE:
			setHSpace((Float) newValue);
			return;
		case ForestPackage.TREE_TYPE__NAME:
			setName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ForestPackage.TREE_TYPE__ASSET:
			setAsset(ASSET_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE:
			setDefaultTreeMaxAge(DEFAULT_TREE_MAX_AGE_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE:
			setDefaultMaxSize(DEFAULT_MAX_SIZE_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB:
			setDefaultHealProb(DEFAULT_HEAL_PROB_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE:
			setDefaultTreeMinAge(DEFAULT_TREE_MIN_AGE_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__IS_PIONER:
			setIsPioner(IS_PIONER_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB:
			setDefaultDeseaseProb(DEFAULT_DESEASE_PROB_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__STARTING_SCALE:
			setStartingScale(STARTING_SCALE_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__CHILDREN_PROBS:
			setChildrenProbs((Map<TreeType, Float>) null);
			return;
		case ForestPackage.TREE_TYPE__HSPACE:
			setHSpace(HSPACE_EDEFAULT);
			return;
		case ForestPackage.TREE_TYPE__NAME:
			setName(NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ForestPackage.TREE_TYPE__ASSET:
			return ASSET_EDEFAULT == null ? asset != null : !ASSET_EDEFAULT.equals(asset);
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MAX_AGE:
			return defaultTreeMaxAge != DEFAULT_TREE_MAX_AGE_EDEFAULT;
		case ForestPackage.TREE_TYPE__DEFAULT_MAX_SIZE:
			return defaultMaxSize != DEFAULT_MAX_SIZE_EDEFAULT;
		case ForestPackage.TREE_TYPE__DEFAULT_HEAL_PROB:
			return defaultHealProb != DEFAULT_HEAL_PROB_EDEFAULT;
		case ForestPackage.TREE_TYPE__DEFAULT_TREE_MIN_AGE:
			return defaultTreeMinAge != DEFAULT_TREE_MIN_AGE_EDEFAULT;
		case ForestPackage.TREE_TYPE__IS_PIONER:
			return isPioner != IS_PIONER_EDEFAULT;
		case ForestPackage.TREE_TYPE__DEFAULT_DESEASE_PROB:
			return defaultDeseaseProb != DEFAULT_DESEASE_PROB_EDEFAULT;
		case ForestPackage.TREE_TYPE__STARTING_SCALE:
			return startingScale != STARTING_SCALE_EDEFAULT;
		case ForestPackage.TREE_TYPE__CHILDREN_PROBS:
			return childrenProbs != null;
		case ForestPackage.TREE_TYPE__HSPACE:
			return hSpace != HSPACE_EDEFAULT;
		case ForestPackage.TREE_TYPE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ForestPackage.TREE_TYPE___GET_CHILD_TYPE__FLOAT:
			return getChildType((Float) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (asset: ");
		result.append(asset);
		result.append(", defaultTreeMaxAge: ");
		result.append(defaultTreeMaxAge);
		result.append(", defaultMaxSize: ");
		result.append(defaultMaxSize);
		result.append(", defaultHealProb: ");
		result.append(defaultHealProb);
		result.append(", defaultTreeMinAge: ");
		result.append(defaultTreeMinAge);
		result.append(", isPioner: ");
		result.append(isPioner);
		result.append(", defaultDeseaseProb: ");
		result.append(defaultDeseaseProb);
		result.append(", startingScale: ");
		result.append(startingScale);
		result.append(", childrenProbs: ");
		result.append(childrenProbs);
		result.append(", hSpace: ");
		result.append(hSpace);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TreeTypeImpl
