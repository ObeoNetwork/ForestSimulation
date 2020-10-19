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
package fr.obeo.forestsimulation.forest;

import com.jme3.math.Vector3f;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getSize <em>Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getChildren <em>Children</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#isIsSick <em>Is Sick</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getMaxAge <em>Max Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getCurrentAge <em>Current Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getDeseaseProb <em>Desease Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getHealProb <em>Heal Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getMaxSize <em>Max Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getType <em>Type</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getLocation <em>Location</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Tree#getHeading <em>Heading</em>}</li>
 * </ul>
 *
 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"0.3f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_Size()
	 * @model default="0.3f"
	 * @generated
	 */
	float getSize();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(float value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.forestsimulation.forest.Tree}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tree> getChildren();

	/**
	 * Returns the value of the '<em><b>Is Sick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sick</em>' attribute.
	 * @see #setIsSick(boolean)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_IsSick()
	 * @model
	 * @generated
	 */
	boolean isIsSick();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#isIsSick <em>Is Sick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sick</em>' attribute.
	 * @see #isIsSick()
	 * @generated
	 */
	void setIsSick(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Age</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum age of this tree
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Age</em>' attribute.
	 * @see #setMaxAge(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_MaxAge()
	 * @model default="100"
	 * @generated
	 */
	int getMaxAge();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getMaxAge <em>Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Age</em>' attribute.
	 * @see #getMaxAge()
	 * @generated
	 */
	void setMaxAge(int value);

	/**
	 * Returns the value of the '<em><b>Current Age</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Age</em>' attribute.
	 * @see #setCurrentAge(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_CurrentAge()
	 * @model default="0"
	 * @generated
	 */
	int getCurrentAge();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getCurrentAge <em>Current Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Age</em>' attribute.
	 * @see #getCurrentAge()
	 * @generated
	 */
	void setCurrentAge(int value);

	/**
	 * Returns the value of the '<em><b>Desease Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Probability to get a desease
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Desease Prob</em>' attribute.
	 * @see #setDeseaseProb(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_DeseaseProb()
	 * @model
	 * @generated
	 */
	float getDeseaseProb();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getDeseaseProb <em>Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desease Prob</em>' attribute.
	 * @see #getDeseaseProb()
	 * @generated
	 */
	void setDeseaseProb(float value);

	/**
	 * Returns the value of the '<em><b>Heal Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Probability to recover from a desease
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Heal Prob</em>' attribute.
	 * @see #setHealProb(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_HealProb()
	 * @model
	 * @generated
	 */
	float getHealProb();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getHealProb <em>Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heal Prob</em>' attribute.
	 * @see #getHealProb()
	 * @generated
	 */
	void setHealProb(float value);

	/**
	 * Returns the value of the '<em><b>Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maximum size that can be reached by this tree
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Size</em>' attribute.
	 * @see #setMaxSize(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_MaxSize()
	 * @model
	 * @generated
	 */
	float getMaxSize();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getMaxSize <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Size</em>' attribute.
	 * @see #getMaxSize()
	 * @generated
	 */
	void setMaxSize(float value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TreeType)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_Type()
	 * @model required="true"
	 * @generated
	 */
	TreeType getType();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TreeType value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The default value is <code>"{0;0;0}"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Vector3f)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_Location()
	 * @model default="{0;0;0}" dataType="fr.obeo.forestsimulation.forest.Vector3f" required="true"
	 * @generated
	 */
	Vector3f getLocation();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Vector3f value);

	/**
	 * Returns the value of the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heading</em>' attribute.
	 * @see #setHeading(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTree_Heading()
	 * @model
	 * @generated
	 */
	float getHeading();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Tree#getHeading <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heading</em>' attribute.
	 * @see #getHeading()
	 * @generated
	 */
	void setHeading(float value);

} // Tree
