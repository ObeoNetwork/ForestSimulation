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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.forestsimulation.forest.ForestFactory
 * @model kind="package"
 * @generated
 */
public interface ForestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "forest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/forest";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "forest";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "fr.obeo.forestsimulation.model.forest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ForestPackage eINSTANCE = fr.obeo.forestsimulation.forest.impl.ForestPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.forestsimulation.forest.impl.ForestImpl <em>Forest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.forestsimulation.forest.impl.ForestImpl
	 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getForest()
	 * @generated
	 */
	int FOREST = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Trees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__TREES = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__SIZE = 2;

	/**
	 * The feature id for the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__DEBUG = 3;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__AGE = 4;

	/**
	 * The feature id for the '<em><b>Pioner Tree Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__PIONER_TREE_PROB = 5;

	/**
	 * The feature id for the '<em><b>Max Number Of Tree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__MAX_NUMBER_OF_TREE = 6;

	/**
	 * The feature id for the '<em><b>Year Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST__YEAR_PERIOD = 7;

	/**
	 * The number of structural features of the '<em>Forest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Forest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.forestsimulation.forest.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.forestsimulation.forest.impl.TreeImpl
	 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getTree()
	 * @generated
	 */
	int TREE = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__SIZE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Is Sick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__IS_SICK = 2;

	/**
	 * The feature id for the '<em><b>Max Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__MAX_AGE = 3;

	/**
	 * The feature id for the '<em><b>Current Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CURRENT_AGE = 4;

	/**
	 * The feature id for the '<em><b>Desease Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__DESEASE_PROB = 5;

	/**
	 * The feature id for the '<em><b>Heal Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__HEAL_PROB = 6;

	/**
	 * The feature id for the '<em><b>Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__MAX_SIZE = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__LOCATION = 9;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__HEADING = 10;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl <em>Tree Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.forestsimulation.forest.impl.TreeTypeImpl
	 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getTreeType()
	 * @generated
	 */
	int TREE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Asset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__ASSET = 0;

	/**
	 * The feature id for the '<em><b>Default Tree Max Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__DEFAULT_TREE_MAX_AGE = 1;

	/**
	 * The feature id for the '<em><b>Default Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__DEFAULT_MAX_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Default Heal Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__DEFAULT_HEAL_PROB = 3;

	/**
	 * The feature id for the '<em><b>Default Tree Min Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__DEFAULT_TREE_MIN_AGE = 4;

	/**
	 * The feature id for the '<em><b>Is Pioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__IS_PIONER = 5;

	/**
	 * The feature id for the '<em><b>Default Desease Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__DEFAULT_DESEASE_PROB = 6;

	/**
	 * The feature id for the '<em><b>Starting Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__STARTING_SCALE = 7;

	/**
	 * The feature id for the '<em><b>Children Probs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__CHILDREN_PROBS = 8;

	/**
	 * The feature id for the '<em><b>HSpace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__HSPACE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE__NAME = 10;

	/**
	 * The number of structural features of the '<em>Tree Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE_FEATURE_COUNT = 11;

	/**
	 * The operation id for the '<em>Get Child Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE___GET_CHILD_TYPE__FLOAT = 0;

	/**
	 * The number of operations of the '<em>Tree Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_TYPE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '<em>Vector3f</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.jme3.math.Vector3f
	 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getVector3f()
	 * @generated
	 */
	int VECTOR3F = 3;

	/**
	 * The meta object id for the '<em>Float</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Float
	 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getFloat()
	 * @generated
	 */
	int FLOAT = 4;

	/**
	 * Returns the meta object for class '{@link fr.obeo.forestsimulation.forest.Forest <em>Forest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forest</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest
	 * @generated
	 */
	EClass getForest();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.forestsimulation.forest.Forest#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getTypes()
	 * @see #getForest()
	 * @generated
	 */
	EReference getForest_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.forestsimulation.forest.Forest#getTrees <em>Trees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trees</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getTrees()
	 * @see #getForest()
	 * @generated
	 */
	EReference getForest_Trees();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getSize()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_Size();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#isDebug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#isDebug()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_Debug();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getAge()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_Age();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#getPionerTreeProb <em>Pioner Tree Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pioner Tree Prob</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getPionerTreeProb()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_PionerTreeProb();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#getMaxNumberOfTree <em>Max Number Of Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Number Of Tree</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getMaxNumberOfTree()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_MaxNumberOfTree();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Forest#getYearPeriod <em>Year Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year Period</em>'.
	 * @see fr.obeo.forestsimulation.forest.Forest#getYearPeriod()
	 * @see #getForest()
	 * @generated
	 */
	EAttribute getForest_YearPeriod();

	/**
	 * Returns the meta object for class '{@link fr.obeo.forestsimulation.forest.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getSize()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Size();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.forestsimulation.forest.Tree#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getChildren()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Children();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#isIsSick <em>Is Sick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sick</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#isIsSick()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_IsSick();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getMaxAge <em>Max Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Age</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getMaxAge()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_MaxAge();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getCurrentAge <em>Current Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Age</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getCurrentAge()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_CurrentAge();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getDeseaseProb <em>Desease Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desease Prob</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getDeseaseProb()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_DeseaseProb();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getHealProb <em>Heal Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heal Prob</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getHealProb()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_HealProb();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getMaxSize <em>Max Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Size</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getMaxSize()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_MaxSize();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.forestsimulation.forest.Tree#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getType()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Type();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getLocation()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Location();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.Tree#getHeading <em>Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heading</em>'.
	 * @see fr.obeo.forestsimulation.forest.Tree#getHeading()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Heading();

	/**
	 * Returns the meta object for class '{@link fr.obeo.forestsimulation.forest.TreeType <em>Tree Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Type</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType
	 * @generated
	 */
	EClass getTreeType();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getAsset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asset</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getAsset()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_Asset();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMaxAge <em>Default Tree Max Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Tree Max Age</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMaxAge()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_DefaultTreeMaxAge();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultMaxSize <em>Default Max Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Max Size</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getDefaultMaxSize()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_DefaultMaxSize();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultHealProb <em>Default Heal Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Heal Prob</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getDefaultHealProb()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_DefaultHealProb();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMinAge <em>Default Tree Min Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Tree Min Age</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getDefaultTreeMinAge()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_DefaultTreeMinAge();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#isIsPioner <em>Is Pioner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pioner</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#isIsPioner()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_IsPioner();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getDefaultDeseaseProb <em>Default Desease Prob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Desease Prob</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getDefaultDeseaseProb()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_DefaultDeseaseProb();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getStartingScale <em>Starting Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Starting Scale</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getStartingScale()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_StartingScale();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getChildrenProbs <em>Children Probs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Children Probs</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getChildrenProbs()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_ChildrenProbs();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getHSpace <em>HSpace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>HSpace</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getHSpace()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_HSpace();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.forestsimulation.forest.TreeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getName()
	 * @see #getTreeType()
	 * @generated
	 */
	EAttribute getTreeType_Name();

	/**
	 * Returns the meta object for the '{@link fr.obeo.forestsimulation.forest.TreeType#getChildType(float) <em>Get Child Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Child Type</em>' operation.
	 * @see fr.obeo.forestsimulation.forest.TreeType#getChildType(float)
	 * @generated
	 */
	EOperation getTreeType__GetChildType__float();

	/**
	 * Returns the meta object for data type '{@link com.jme3.math.Vector3f <em>Vector3f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vector3f</em>'.
	 * @see com.jme3.math.Vector3f
	 * @model instanceClass="com.jme3.math.Vector3f"
	 * @generated
	 */
	EDataType getVector3f();

	/**
	 * Returns the meta object for data type '{@link java.lang.Float <em>Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float</em>'.
	 * @see java.lang.Float
	 * @model instanceClass="java.lang.Float"
	 * @generated
	 */
	EDataType getFloat();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ForestFactory getForestFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.forestsimulation.forest.impl.ForestImpl <em>Forest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.forestsimulation.forest.impl.ForestImpl
		 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getForest()
		 * @generated
		 */
		EClass FOREST = eINSTANCE.getForest();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREST__TYPES = eINSTANCE.getForest_Types();

		/**
		 * The meta object literal for the '<em><b>Trees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREST__TREES = eINSTANCE.getForest_Trees();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__SIZE = eINSTANCE.getForest_Size();

		/**
		 * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__DEBUG = eINSTANCE.getForest_Debug();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__AGE = eINSTANCE.getForest_Age();

		/**
		 * The meta object literal for the '<em><b>Pioner Tree Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__PIONER_TREE_PROB = eINSTANCE.getForest_PionerTreeProb();

		/**
		 * The meta object literal for the '<em><b>Max Number Of Tree</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__MAX_NUMBER_OF_TREE = eINSTANCE.getForest_MaxNumberOfTree();

		/**
		 * The meta object literal for the '<em><b>Year Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREST__YEAR_PERIOD = eINSTANCE.getForest_YearPeriod();

		/**
		 * The meta object literal for the '{@link fr.obeo.forestsimulation.forest.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.forestsimulation.forest.impl.TreeImpl
		 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__SIZE = eINSTANCE.getTree_Size();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__CHILDREN = eINSTANCE.getTree_Children();

		/**
		 * The meta object literal for the '<em><b>Is Sick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__IS_SICK = eINSTANCE.getTree_IsSick();

		/**
		 * The meta object literal for the '<em><b>Max Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__MAX_AGE = eINSTANCE.getTree_MaxAge();

		/**
		 * The meta object literal for the '<em><b>Current Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__CURRENT_AGE = eINSTANCE.getTree_CurrentAge();

		/**
		 * The meta object literal for the '<em><b>Desease Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__DESEASE_PROB = eINSTANCE.getTree_DeseaseProb();

		/**
		 * The meta object literal for the '<em><b>Heal Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__HEAL_PROB = eINSTANCE.getTree_HealProb();

		/**
		 * The meta object literal for the '<em><b>Max Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__MAX_SIZE = eINSTANCE.getTree_MaxSize();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__TYPE = eINSTANCE.getTree_Type();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__LOCATION = eINSTANCE.getTree_Location();

		/**
		 * The meta object literal for the '<em><b>Heading</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__HEADING = eINSTANCE.getTree_Heading();

		/**
		 * The meta object literal for the '{@link fr.obeo.forestsimulation.forest.impl.TreeTypeImpl <em>Tree Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.forestsimulation.forest.impl.TreeTypeImpl
		 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getTreeType()
		 * @generated
		 */
		EClass TREE_TYPE = eINSTANCE.getTreeType();

		/**
		 * The meta object literal for the '<em><b>Asset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__ASSET = eINSTANCE.getTreeType_Asset();

		/**
		 * The meta object literal for the '<em><b>Default Tree Max Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__DEFAULT_TREE_MAX_AGE = eINSTANCE.getTreeType_DefaultTreeMaxAge();

		/**
		 * The meta object literal for the '<em><b>Default Max Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__DEFAULT_MAX_SIZE = eINSTANCE.getTreeType_DefaultMaxSize();

		/**
		 * The meta object literal for the '<em><b>Default Heal Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__DEFAULT_HEAL_PROB = eINSTANCE.getTreeType_DefaultHealProb();

		/**
		 * The meta object literal for the '<em><b>Default Tree Min Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__DEFAULT_TREE_MIN_AGE = eINSTANCE.getTreeType_DefaultTreeMinAge();

		/**
		 * The meta object literal for the '<em><b>Is Pioner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__IS_PIONER = eINSTANCE.getTreeType_IsPioner();

		/**
		 * The meta object literal for the '<em><b>Default Desease Prob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__DEFAULT_DESEASE_PROB = eINSTANCE.getTreeType_DefaultDeseaseProb();

		/**
		 * The meta object literal for the '<em><b>Starting Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__STARTING_SCALE = eINSTANCE.getTreeType_StartingScale();

		/**
		 * The meta object literal for the '<em><b>Children Probs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__CHILDREN_PROBS = eINSTANCE.getTreeType_ChildrenProbs();

		/**
		 * The meta object literal for the '<em><b>HSpace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__HSPACE = eINSTANCE.getTreeType_HSpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_TYPE__NAME = eINSTANCE.getTreeType_Name();

		/**
		 * The meta object literal for the '<em><b>Get Child Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TREE_TYPE___GET_CHILD_TYPE__FLOAT = eINSTANCE.getTreeType__GetChildType__float();

		/**
		 * The meta object literal for the '<em>Vector3f</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.jme3.math.Vector3f
		 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getVector3f()
		 * @generated
		 */
		EDataType VECTOR3F = eINSTANCE.getVector3f();

		/**
		 * The meta object literal for the '<em>Float</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Float
		 * @see fr.obeo.forestsimulation.forest.impl.ForestPackageImpl#getFloat()
		 * @generated
		 */
		EDataType FLOAT = eINSTANCE.getFloat();

	}

} //ForestPackage
