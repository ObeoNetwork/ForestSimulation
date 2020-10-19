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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getAsset <em>Asset</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMaxAge <em>Default Tree Max Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultMaxSize <em>Default Max Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultHealProb <em>Default Heal Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMinAge <em>Default Tree Min Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#isIsPioner <em>Is Pioner</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultDeseaseProb <em>Default Desease Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getStartingScale <em>Starting Scale</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getChildrenProbs <em>Children Probs</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getHSpace <em>HSpace</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.TreeType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType()
 * @model
 * @generated
 */
public interface TreeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Asset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the 3D asset
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Asset</em>' attribute.
	 * @see #setAsset(String)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_Asset()
	 * @model
	 * @generated
	 */
	String getAsset();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getAsset <em>Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset</em>' attribute.
	 * @see #getAsset()
	 * @generated
	 */
	void setAsset(String value);

	/**
	 * Returns the value of the '<em><b>Default Tree Max Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default maximum age for this kind of tree
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Tree Max Age</em>' attribute.
	 * @see #setDefaultTreeMaxAge(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_DefaultTreeMaxAge()
	 * @model
	 * @generated
	 */
	int getDefaultTreeMaxAge();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMaxAge <em>Default Tree Max Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Tree Max Age</em>' attribute.
	 * @see #getDefaultTreeMaxAge()
	 * @generated
	 */
	void setDefaultTreeMaxAge(int value);

	/**
	 * Returns the value of the '<em><b>Default Max Size</b></em>' attribute.
	 * The default value is <code>"2.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default maximum size for this kind of tree
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Max Size</em>' attribute.
	 * @see #setDefaultMaxSize(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_DefaultMaxSize()
	 * @model default="2.0"
	 * @generated
	 */
	float getDefaultMaxSize();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultMaxSize <em>Default Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Max Size</em>' attribute.
	 * @see #getDefaultMaxSize()
	 * @generated
	 */
	void setDefaultMaxSize(float value);

	/**
	 * Returns the value of the '<em><b>Default Heal Prob</b></em>' attribute.
	 * The default value is <code>"0.05f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default probability for this kind of tree to recover from a desease
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Heal Prob</em>' attribute.
	 * @see #setDefaultHealProb(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_DefaultHealProb()
	 * @model default="0.05f"
	 * @generated
	 */
	float getDefaultHealProb();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultHealProb <em>Default Heal Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Heal Prob</em>' attribute.
	 * @see #getDefaultHealProb()
	 * @generated
	 */
	void setDefaultHealProb(float value);

	/**
	 * Returns the value of the '<em><b>Default Tree Min Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default minimum age for this kind of tree
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Tree Min Age</em>' attribute.
	 * @see #setDefaultTreeMinAge(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_DefaultTreeMinAge()
	 * @model
	 * @generated
	 */
	int getDefaultTreeMinAge();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMinAge <em>Default Tree Min Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Tree Min Age</em>' attribute.
	 * @see #getDefaultTreeMinAge()
	 * @generated
	 */
	void setDefaultTreeMinAge(int value);

	/**
	 * Returns the value of the '<em><b>Is Pioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set to true if this typep of tree is a pioner
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Pioner</em>' attribute.
	 * @see #setIsPioner(boolean)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_IsPioner()
	 * @model
	 * @generated
	 */
	boolean isIsPioner();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#isIsPioner <em>Is Pioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pioner</em>' attribute.
	 * @see #isIsPioner()
	 * @generated
	 */
	void setIsPioner(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Desease Prob</b></em>' attribute.
	 * The default value is <code>"0.05f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default propability for this kind of tree to get a desease in a year
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Desease Prob</em>' attribute.
	 * @see #setDefaultDeseaseProb(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_DefaultDeseaseProb()
	 * @model default="0.05f"
	 * @generated
	 */
	float getDefaultDeseaseProb();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultDeseaseProb <em>Default Desease Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Desease Prob</em>' attribute.
	 * @see #getDefaultDeseaseProb()
	 * @generated
	 */
	void setDefaultDeseaseProb(float value);

	/**
	 * Returns the value of the '<em><b>Starting Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Size of this tree at age 0
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Starting Scale</em>' attribute.
	 * @see #setStartingScale(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_StartingScale()
	 * @model
	 * @generated
	 */
	float getStartingScale();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getStartingScale <em>Starting Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Scale</em>' attribute.
	 * @see #getStartingScale()
	 * @generated
	 */
	void setStartingScale(float value);

	/**
	 * Returns the value of the '<em><b>Children Probs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maps the propability for this tree to create sub tree <TreeType,Percentage of propability>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children Probs</em>' attribute.
	 * @see #setChildrenProbs(Map)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_ChildrenProbs()
	 * @model transient="true"
	 * @generated
	 */
	Map<TreeType, Float> getChildrenProbs();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getChildrenProbs <em>Children Probs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children Probs</em>' attribute.
	 * @see #getChildrenProbs()
	 * @generated
	 */
	void setChildrenProbs(Map<TreeType, Float> value);

	/**
	 * Returns the value of the '<em><b>HSpace</b></em>' attribute.
	 * The default value is <code>"1f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Horiration space taken by this tree. (Circle radius). It needs to be multiplied by the size of the tree.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>HSpace</em>' attribute.
	 * @see #setHSpace(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_HSpace()
	 * @model default="1f"
	 * @generated
	 */
	float getHSpace();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getHSpace <em>HSpace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HSpace</em>' attribute.
	 * @see #getHSpace()
	 * @generated
	 */
	void setHSpace(float value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getTreeType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.TreeType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a TreeType (or null) for a given probability draw
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	TreeType getChildType(float draw);

} // TreeType
