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

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getTrees <em>Trees</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getSize <em>Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#isDebug <em>Debug</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getAge <em>Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getPionerTreeProb <em>Pioner Tree Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getMaxNumberOfTree <em>Max Number Of Tree</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.ForestImpl#getYearPeriod <em>Year Period</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForestImpl extends MinimalEObjectImpl.Container implements Forest {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeType> types;

	/**
	 * The cached value of the '{@link #getTrees() <em>Trees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrees()
	 * @generated
	 * @ordered
	 */
	protected EList<Tree> trees;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final float SIZE_EDEFAULT = 120.0F;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected float size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEBUG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected boolean debug = DEBUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPionerTreeProb() <em>Pioner Tree Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPionerTreeProb()
	 * @generated
	 * @ordered
	 */
	protected static final float PIONER_TREE_PROB_EDEFAULT = 0.05F;

	/**
	 * The cached value of the '{@link #getPionerTreeProb() <em>Pioner Tree Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPionerTreeProb()
	 * @generated
	 * @ordered
	 */
	protected float pionerTreeProb = PIONER_TREE_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxNumberOfTree() <em>Max Number Of Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumberOfTree()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NUMBER_OF_TREE_EDEFAULT = 1500;

	/**
	 * The cached value of the '{@link #getMaxNumberOfTree() <em>Max Number Of Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumberOfTree()
	 * @generated
	 * @ordered
	 */
	protected int maxNumberOfTree = MAX_NUMBER_OF_TREE_EDEFAULT;

	/**
	 * The default value of the '{@link #getYearPeriod() <em>Year Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYearPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final int YEAR_PERIOD_EDEFAULT = 400;

	/**
	 * The cached value of the '{@link #getYearPeriod() <em>Year Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYearPeriod()
	 * @generated
	 * @ordered
	 */
	protected int yearPeriod = YEAR_PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ForestPackage.Literals.FOREST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeType> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<TreeType>(TreeType.class, this, ForestPackage.FOREST__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tree> getTrees() {
		if (trees == null) {
			trees = new EObjectContainmentEList<Tree>(Tree.class, this, ForestPackage.FOREST__TREES);
		}
		return trees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(float newSize) {
		float oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebug(boolean newDebug) {
		boolean oldDebug = debug;
		debug = newDebug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__DEBUG, oldDebug, debug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPionerTreeProb() {
		return pionerTreeProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPionerTreeProb(float newPionerTreeProb) {
		float oldPionerTreeProb = pionerTreeProb;
		pionerTreeProb = newPionerTreeProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__PIONER_TREE_PROB,
					oldPionerTreeProb, pionerTreeProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxNumberOfTree() {
		return maxNumberOfTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxNumberOfTree(int newMaxNumberOfTree) {
		int oldMaxNumberOfTree = maxNumberOfTree;
		maxNumberOfTree = newMaxNumberOfTree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__MAX_NUMBER_OF_TREE,
					oldMaxNumberOfTree, maxNumberOfTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYearPeriod() {
		return yearPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYearPeriod(int newYearPeriod) {
		int oldYearPeriod = yearPeriod;
		yearPeriod = newYearPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.FOREST__YEAR_PERIOD, oldYearPeriod,
					yearPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ForestPackage.FOREST__TYPES:
			return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
		case ForestPackage.FOREST__TREES:
			return ((InternalEList<?>) getTrees()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ForestPackage.FOREST__TYPES:
			return getTypes();
		case ForestPackage.FOREST__TREES:
			return getTrees();
		case ForestPackage.FOREST__SIZE:
			return getSize();
		case ForestPackage.FOREST__DEBUG:
			return isDebug();
		case ForestPackage.FOREST__AGE:
			return getAge();
		case ForestPackage.FOREST__PIONER_TREE_PROB:
			return getPionerTreeProb();
		case ForestPackage.FOREST__MAX_NUMBER_OF_TREE:
			return getMaxNumberOfTree();
		case ForestPackage.FOREST__YEAR_PERIOD:
			return getYearPeriod();
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
		case ForestPackage.FOREST__TYPES:
			getTypes().clear();
			getTypes().addAll((Collection<? extends TreeType>) newValue);
			return;
		case ForestPackage.FOREST__TREES:
			getTrees().clear();
			getTrees().addAll((Collection<? extends Tree>) newValue);
			return;
		case ForestPackage.FOREST__SIZE:
			setSize((Float) newValue);
			return;
		case ForestPackage.FOREST__DEBUG:
			setDebug((Boolean) newValue);
			return;
		case ForestPackage.FOREST__AGE:
			setAge((Integer) newValue);
			return;
		case ForestPackage.FOREST__PIONER_TREE_PROB:
			setPionerTreeProb((Float) newValue);
			return;
		case ForestPackage.FOREST__MAX_NUMBER_OF_TREE:
			setMaxNumberOfTree((Integer) newValue);
			return;
		case ForestPackage.FOREST__YEAR_PERIOD:
			setYearPeriod((Integer) newValue);
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
		case ForestPackage.FOREST__TYPES:
			getTypes().clear();
			return;
		case ForestPackage.FOREST__TREES:
			getTrees().clear();
			return;
		case ForestPackage.FOREST__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case ForestPackage.FOREST__DEBUG:
			setDebug(DEBUG_EDEFAULT);
			return;
		case ForestPackage.FOREST__AGE:
			setAge(AGE_EDEFAULT);
			return;
		case ForestPackage.FOREST__PIONER_TREE_PROB:
			setPionerTreeProb(PIONER_TREE_PROB_EDEFAULT);
			return;
		case ForestPackage.FOREST__MAX_NUMBER_OF_TREE:
			setMaxNumberOfTree(MAX_NUMBER_OF_TREE_EDEFAULT);
			return;
		case ForestPackage.FOREST__YEAR_PERIOD:
			setYearPeriod(YEAR_PERIOD_EDEFAULT);
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
		case ForestPackage.FOREST__TYPES:
			return types != null && !types.isEmpty();
		case ForestPackage.FOREST__TREES:
			return trees != null && !trees.isEmpty();
		case ForestPackage.FOREST__SIZE:
			return size != SIZE_EDEFAULT;
		case ForestPackage.FOREST__DEBUG:
			return debug != DEBUG_EDEFAULT;
		case ForestPackage.FOREST__AGE:
			return age != AGE_EDEFAULT;
		case ForestPackage.FOREST__PIONER_TREE_PROB:
			return pionerTreeProb != PIONER_TREE_PROB_EDEFAULT;
		case ForestPackage.FOREST__MAX_NUMBER_OF_TREE:
			return maxNumberOfTree != MAX_NUMBER_OF_TREE_EDEFAULT;
		case ForestPackage.FOREST__YEAR_PERIOD:
			return yearPeriod != YEAR_PERIOD_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (size: ");
		result.append(size);
		result.append(", debug: ");
		result.append(debug);
		result.append(", age: ");
		result.append(age);
		result.append(", pionerTreeProb: ");
		result.append(pionerTreeProb);
		result.append(", maxNumberOfTree: ");
		result.append(maxNumberOfTree);
		result.append(", yearPeriod: ");
		result.append(yearPeriod);
		result.append(')');
		return result.toString();
	}

} //ForestImpl
