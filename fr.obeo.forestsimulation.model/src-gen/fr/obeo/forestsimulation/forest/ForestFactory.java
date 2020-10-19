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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.forestsimulation.forest.ForestPackage
 * @generated
 */
public interface ForestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ForestFactory eINSTANCE = fr.obeo.forestsimulation.forest.impl.ForestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Forest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forest</em>'.
	 * @generated
	 */
	Forest createForest();

	/**
	 * Returns a new object of class '<em>Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree</em>'.
	 * @generated
	 */
	Tree createTree();

	/**
	 * Returns a new object of class '<em>Tree Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Type</em>'.
	 * @generated
	 */
	TreeType createTreeType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ForestPackage getForestPackage();

} //ForestFactory
