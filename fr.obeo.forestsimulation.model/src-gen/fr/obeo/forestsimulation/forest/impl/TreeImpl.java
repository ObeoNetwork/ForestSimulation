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

import com.jme3.math.Vector3f;

import fr.obeo.forestsimulation.forest.ForestFactory;
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
 * An implementation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#isIsSick <em>Is Sick</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getMaxAge <em>Max Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getCurrentAge <em>Current Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getDeseaseProb <em>Desease Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getHealProb <em>Heal Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getMaxSize <em>Max Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getType <em>Type</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.impl.TreeImpl#getHeading <em>Heading</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TreeImpl extends MinimalEObjectImpl.Container implements Tree {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final float SIZE_EDEFAULT = 0.3F;

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
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Tree> children;

	/**
	 * The default value of the '{@link #isIsSick() <em>Is Sick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSick()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SICK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSick() <em>Is Sick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSick()
	 * @generated
	 * @ordered
	 */
	protected boolean isSick = IS_SICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAge() <em>Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAge()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_AGE_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getMaxAge() <em>Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAge()
	 * @generated
	 * @ordered
	 */
	protected int maxAge = MAX_AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentAge() <em>Current Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAge()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentAge() <em>Current Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAge()
	 * @generated
	 * @ordered
	 */
	protected int currentAge = CURRENT_AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeseaseProb() <em>Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeseaseProb()
	 * @generated
	 * @ordered
	 */
	protected static final float DESEASE_PROB_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getDeseaseProb() <em>Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeseaseProb()
	 * @generated
	 * @ordered
	 */
	protected float deseaseProb = DESEASE_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getHealProb() <em>Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHealProb()
	 * @generated
	 * @ordered
	 */
	protected static final float HEAL_PROB_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getHealProb() <em>Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHealProb()
	 * @generated
	 * @ordered
	 */
	protected float healProb = HEAL_PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSize() <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSize()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_SIZE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaxSize() <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSize()
	 * @generated
	 * @ordered
	 */
	protected float maxSize = MAX_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TreeType type;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3f LOCATION_EDEFAULT = (Vector3f) ForestFactory.eINSTANCE
			.createFromString(ForestPackage.eINSTANCE.getVector3f(), "{0;0;0}");

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Vector3f location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeading() <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeading()
	 * @generated
	 * @ordered
	 */
	protected static final float HEADING_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getHeading() <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeading()
	 * @generated
	 * @ordered
	 */
	protected float heading = HEADING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ForestPackage.Literals.TREE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tree> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Tree>(Tree.class, this, ForestPackage.TREE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSick() {
		return isSick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSick(boolean newIsSick) {
		boolean oldIsSick = isSick;
		isSick = newIsSick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__IS_SICK, oldIsSick, isSick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxAge() {
		return maxAge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAge(int newMaxAge) {
		int oldMaxAge = maxAge;
		maxAge = newMaxAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__MAX_AGE, oldMaxAge, maxAge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentAge() {
		return currentAge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentAge(int newCurrentAge) {
		int oldCurrentAge = currentAge;
		currentAge = newCurrentAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__CURRENT_AGE, oldCurrentAge,
					currentAge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDeseaseProb() {
		return deseaseProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeseaseProb(float newDeseaseProb) {
		float oldDeseaseProb = deseaseProb;
		deseaseProb = newDeseaseProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__DESEASE_PROB, oldDeseaseProb,
					deseaseProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHealProb() {
		return healProb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHealProb(float newHealProb) {
		float oldHealProb = healProb;
		healProb = newHealProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__HEAL_PROB, oldHealProb,
					healProb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxSize() {
		return maxSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSize(float newMaxSize) {
		float oldMaxSize = maxSize;
		maxSize = newMaxSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__MAX_SIZE, oldMaxSize, maxSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (TreeType) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ForestPackage.TREE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TreeType newType) {
		TreeType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3f getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Vector3f newLocation) {
		Vector3f oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeading() {
		return heading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeading(float newHeading) {
		float oldHeading = heading;
		heading = newHeading;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForestPackage.TREE__HEADING, oldHeading, heading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ForestPackage.TREE__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
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
		case ForestPackage.TREE__SIZE:
			return getSize();
		case ForestPackage.TREE__CHILDREN:
			return getChildren();
		case ForestPackage.TREE__IS_SICK:
			return isIsSick();
		case ForestPackage.TREE__MAX_AGE:
			return getMaxAge();
		case ForestPackage.TREE__CURRENT_AGE:
			return getCurrentAge();
		case ForestPackage.TREE__DESEASE_PROB:
			return getDeseaseProb();
		case ForestPackage.TREE__HEAL_PROB:
			return getHealProb();
		case ForestPackage.TREE__MAX_SIZE:
			return getMaxSize();
		case ForestPackage.TREE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case ForestPackage.TREE__LOCATION:
			return getLocation();
		case ForestPackage.TREE__HEADING:
			return getHeading();
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
		case ForestPackage.TREE__SIZE:
			setSize((Float) newValue);
			return;
		case ForestPackage.TREE__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends Tree>) newValue);
			return;
		case ForestPackage.TREE__IS_SICK:
			setIsSick((Boolean) newValue);
			return;
		case ForestPackage.TREE__MAX_AGE:
			setMaxAge((Integer) newValue);
			return;
		case ForestPackage.TREE__CURRENT_AGE:
			setCurrentAge((Integer) newValue);
			return;
		case ForestPackage.TREE__DESEASE_PROB:
			setDeseaseProb((Float) newValue);
			return;
		case ForestPackage.TREE__HEAL_PROB:
			setHealProb((Float) newValue);
			return;
		case ForestPackage.TREE__MAX_SIZE:
			setMaxSize((Float) newValue);
			return;
		case ForestPackage.TREE__TYPE:
			setType((TreeType) newValue);
			return;
		case ForestPackage.TREE__LOCATION:
			setLocation((Vector3f) newValue);
			return;
		case ForestPackage.TREE__HEADING:
			setHeading((Float) newValue);
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
		case ForestPackage.TREE__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case ForestPackage.TREE__CHILDREN:
			getChildren().clear();
			return;
		case ForestPackage.TREE__IS_SICK:
			setIsSick(IS_SICK_EDEFAULT);
			return;
		case ForestPackage.TREE__MAX_AGE:
			setMaxAge(MAX_AGE_EDEFAULT);
			return;
		case ForestPackage.TREE__CURRENT_AGE:
			setCurrentAge(CURRENT_AGE_EDEFAULT);
			return;
		case ForestPackage.TREE__DESEASE_PROB:
			setDeseaseProb(DESEASE_PROB_EDEFAULT);
			return;
		case ForestPackage.TREE__HEAL_PROB:
			setHealProb(HEAL_PROB_EDEFAULT);
			return;
		case ForestPackage.TREE__MAX_SIZE:
			setMaxSize(MAX_SIZE_EDEFAULT);
			return;
		case ForestPackage.TREE__TYPE:
			setType((TreeType) null);
			return;
		case ForestPackage.TREE__LOCATION:
			setLocation(LOCATION_EDEFAULT);
			return;
		case ForestPackage.TREE__HEADING:
			setHeading(HEADING_EDEFAULT);
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
		case ForestPackage.TREE__SIZE:
			return size != SIZE_EDEFAULT;
		case ForestPackage.TREE__CHILDREN:
			return children != null && !children.isEmpty();
		case ForestPackage.TREE__IS_SICK:
			return isSick != IS_SICK_EDEFAULT;
		case ForestPackage.TREE__MAX_AGE:
			return maxAge != MAX_AGE_EDEFAULT;
		case ForestPackage.TREE__CURRENT_AGE:
			return currentAge != CURRENT_AGE_EDEFAULT;
		case ForestPackage.TREE__DESEASE_PROB:
			return deseaseProb != DESEASE_PROB_EDEFAULT;
		case ForestPackage.TREE__HEAL_PROB:
			return healProb != HEAL_PROB_EDEFAULT;
		case ForestPackage.TREE__MAX_SIZE:
			return maxSize != MAX_SIZE_EDEFAULT;
		case ForestPackage.TREE__TYPE:
			return type != null;
		case ForestPackage.TREE__LOCATION:
			return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
		case ForestPackage.TREE__HEADING:
			return heading != HEADING_EDEFAULT;
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
		result.append(", isSick: ");
		result.append(isSick);
		result.append(", maxAge: ");
		result.append(maxAge);
		result.append(", currentAge: ");
		result.append(currentAge);
		result.append(", deseaseProb: ");
		result.append(deseaseProb);
		result.append(", healProb: ");
		result.append(healProb);
		result.append(", maxSize: ");
		result.append(maxSize);
		result.append(", location: ");
		result.append(location);
		result.append(", heading: ");
		result.append(heading);
		result.append(')');
		return result.toString();
	}

} //TreeImpl
