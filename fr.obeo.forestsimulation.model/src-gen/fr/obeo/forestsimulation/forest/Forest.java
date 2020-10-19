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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getTypes <em>Types</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getTrees <em>Trees</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getSize <em>Size</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#isDebug <em>Debug</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getAge <em>Age</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getPionerTreeProb <em>Pioner Tree Prob</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getMaxNumberOfTree <em>Max Number Of Tree</em>}</li>
 *   <li>{@link fr.obeo.forestsimulation.forest.Forest#getYearPeriod <em>Year Period</em>}</li>
 * </ul>
 *
 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest()
 * @model
 * @generated
 */
public interface Forest extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.forestsimulation.forest.TreeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<TreeType> getTypes();

	/**
	 * Returns the value of the '<em><b>Trees</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.forestsimulation.forest.Tree}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trees</em>' containment reference list.
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_Trees()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tree> getTrees();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"120f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_Size()
	 * @model default="120f"
	 * @generated
	 */
	float getSize();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(float value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(boolean)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_Debug()
	 * @model default="false"
	 * @generated
	 */
	boolean isDebug();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#isDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #isDebug()
	 * @generated
	 */
	void setDebug(boolean value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Pioner Tree Prob</b></em>' attribute.
	 * The default value is <code>"0.05f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Probability of a pioner tree to be created
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pioner Tree Prob</em>' attribute.
	 * @see #setPionerTreeProb(float)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_PionerTreeProb()
	 * @model default="0.05f"
	 * @generated
	 */
	float getPionerTreeProb();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#getPionerTreeProb <em>Pioner Tree Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pioner Tree Prob</em>' attribute.
	 * @see #getPionerTreeProb()
	 * @generated
	 */
	void setPionerTreeProb(float value);

	/**
	 * Returns the value of the '<em><b>Max Number Of Tree</b></em>' attribute.
	 * The default value is <code>"1500"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Max number of tree in the forest
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Number Of Tree</em>' attribute.
	 * @see #setMaxNumberOfTree(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_MaxNumberOfTree()
	 * @model default="1500"
	 * @generated
	 */
	int getMaxNumberOfTree();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#getMaxNumberOfTree <em>Max Number Of Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Number Of Tree</em>' attribute.
	 * @see #getMaxNumberOfTree()
	 * @generated
	 */
	void setMaxNumberOfTree(int value);

	/**
	 * Returns the value of the '<em><b>Year Period</b></em>' attribute.
	 * The default value is <code>"400"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Time in millisec for a year
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Year Period</em>' attribute.
	 * @see #setYearPeriod(int)
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#getForest_YearPeriod()
	 * @model default="400"
	 * @generated
	 */
	int getYearPeriod();

	/**
	 * Sets the value of the '{@link fr.obeo.forestsimulation.forest.Forest#getYearPeriod <em>Year Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year Period</em>' attribute.
	 * @see #getYearPeriod()
	 * @generated
	 */
	void setYearPeriod(int value);

} // Forest
