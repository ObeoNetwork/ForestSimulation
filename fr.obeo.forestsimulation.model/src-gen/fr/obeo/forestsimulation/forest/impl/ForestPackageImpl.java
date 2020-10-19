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

import fr.obeo.forestsimulation.forest.Forest;
import fr.obeo.forestsimulation.forest.ForestFactory;
import fr.obeo.forestsimulation.forest.ForestPackage;
import fr.obeo.forestsimulation.forest.Tree;
import fr.obeo.forestsimulation.forest.TreeType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForestPackageImpl extends EPackageImpl implements ForestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vector3fEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType floatEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.obeo.forestsimulation.forest.ForestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ForestPackageImpl() {
		super(eNS_URI, ForestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ForestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ForestPackage init() {
		if (isInited)
			return (ForestPackage) EPackage.Registry.INSTANCE.getEPackage(ForestPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredForestPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ForestPackageImpl theForestPackage = registeredForestPackage instanceof ForestPackageImpl
				? (ForestPackageImpl) registeredForestPackage
				: new ForestPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theForestPackage.createPackageContents();

		// Initialize created meta-data
		theForestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theForestPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ForestPackage.eNS_URI, theForestPackage);
		return theForestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForest() {
		return forestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForest_Types() {
		return (EReference) forestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForest_Trees() {
		return (EReference) forestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_Size() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_Debug() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_Age() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_PionerTreeProb() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_MaxNumberOfTree() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForest_YearPeriod() {
		return (EAttribute) forestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTree() {
		return treeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_Size() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTree_Children() {
		return (EReference) treeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_IsSick() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_MaxAge() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_CurrentAge() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_DeseaseProb() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_HealProb() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_MaxSize() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTree_Type() {
		return (EReference) treeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_Location() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_Heading() {
		return (EAttribute) treeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeType() {
		return treeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_Asset() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_DefaultTreeMaxAge() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_DefaultMaxSize() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_DefaultHealProb() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_DefaultTreeMinAge() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_IsPioner() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_DefaultDeseaseProb() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_StartingScale() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_ChildrenProbs() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_HSpace() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeType_Name() {
		return (EAttribute) treeTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTreeType__GetChildType__float() {
		return treeTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVector3f() {
		return vector3fEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFloat() {
		return floatEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForestFactory getForestFactory() {
		return (ForestFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		forestEClass = createEClass(FOREST);
		createEReference(forestEClass, FOREST__TYPES);
		createEReference(forestEClass, FOREST__TREES);
		createEAttribute(forestEClass, FOREST__SIZE);
		createEAttribute(forestEClass, FOREST__DEBUG);
		createEAttribute(forestEClass, FOREST__AGE);
		createEAttribute(forestEClass, FOREST__PIONER_TREE_PROB);
		createEAttribute(forestEClass, FOREST__MAX_NUMBER_OF_TREE);
		createEAttribute(forestEClass, FOREST__YEAR_PERIOD);

		treeEClass = createEClass(TREE);
		createEAttribute(treeEClass, TREE__SIZE);
		createEReference(treeEClass, TREE__CHILDREN);
		createEAttribute(treeEClass, TREE__IS_SICK);
		createEAttribute(treeEClass, TREE__MAX_AGE);
		createEAttribute(treeEClass, TREE__CURRENT_AGE);
		createEAttribute(treeEClass, TREE__DESEASE_PROB);
		createEAttribute(treeEClass, TREE__HEAL_PROB);
		createEAttribute(treeEClass, TREE__MAX_SIZE);
		createEReference(treeEClass, TREE__TYPE);
		createEAttribute(treeEClass, TREE__LOCATION);
		createEAttribute(treeEClass, TREE__HEADING);

		treeTypeEClass = createEClass(TREE_TYPE);
		createEAttribute(treeTypeEClass, TREE_TYPE__ASSET);
		createEAttribute(treeTypeEClass, TREE_TYPE__DEFAULT_TREE_MAX_AGE);
		createEAttribute(treeTypeEClass, TREE_TYPE__DEFAULT_MAX_SIZE);
		createEAttribute(treeTypeEClass, TREE_TYPE__DEFAULT_HEAL_PROB);
		createEAttribute(treeTypeEClass, TREE_TYPE__DEFAULT_TREE_MIN_AGE);
		createEAttribute(treeTypeEClass, TREE_TYPE__IS_PIONER);
		createEAttribute(treeTypeEClass, TREE_TYPE__DEFAULT_DESEASE_PROB);
		createEAttribute(treeTypeEClass, TREE_TYPE__STARTING_SCALE);
		createEAttribute(treeTypeEClass, TREE_TYPE__CHILDREN_PROBS);
		createEAttribute(treeTypeEClass, TREE_TYPE__HSPACE);
		createEAttribute(treeTypeEClass, TREE_TYPE__NAME);
		createEOperation(treeTypeEClass, TREE_TYPE___GET_CHILD_TYPE__FLOAT);

		// Create data types
		vector3fEDataType = createEDataType(VECTOR3F);
		floatEDataType = createEDataType(FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(forestEClass, Forest.class, "Forest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForest_Types(), this.getTreeType(), null, "types", null, 0, -1, Forest.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getForest_Trees(), this.getTree(), null, "trees", null, 0, -1, Forest.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getForest_Size(), ecorePackage.getEFloat(), "size", "120f", 0, 1, Forest.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForest_Debug(), ecorePackage.getEBoolean(), "debug", "false", 0, 1, Forest.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForest_Age(), ecorePackage.getEInt(), "age", null, 0, 1, Forest.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForest_PionerTreeProb(), ecorePackage.getEFloat(), "pionerTreeProb", "0.05f", 0, 1,
				Forest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getForest_MaxNumberOfTree(), ecorePackage.getEInt(), "maxNumberOfTree", "1500", 0, 1,
				Forest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getForest_YearPeriod(), ecorePackage.getEInt(), "yearPeriod", "400", 0, 1, Forest.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeEClass, Tree.class, "Tree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTree_Size(), ecorePackage.getEFloat(), "size", "0.3f", 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTree_Children(), this.getTree(), null, "children", null, 0, -1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getTree_IsSick(), ecorePackage.getEBoolean(), "isSick", null, 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_MaxAge(), ecorePackage.getEInt(), "maxAge", "100", 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_CurrentAge(), ecorePackage.getEInt(), "currentAge", "0", 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_DeseaseProb(), ecorePackage.getEFloat(), "deseaseProb", null, 0, 1, Tree.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_HealProb(), ecorePackage.getEFloat(), "healProb", null, 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_MaxSize(), ecorePackage.getEFloat(), "maxSize", null, 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTree_Type(), this.getTreeType(), null, "type", null, 1, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getTree_Location(), this.getVector3f(), "location", "{0;0;0}", 1, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_Heading(), ecorePackage.getEFloat(), "heading", null, 0, 1, Tree.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeTypeEClass, TreeType.class, "TreeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTreeType_Asset(), ecorePackage.getEString(), "asset", null, 0, 1, TreeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_DefaultTreeMaxAge(), ecorePackage.getEInt(), "defaultTreeMaxAge", null, 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_DefaultMaxSize(), ecorePackage.getEFloat(), "defaultMaxSize", "2.0", 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_DefaultHealProb(), ecorePackage.getEFloat(), "defaultHealProb", "0.05f", 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_DefaultTreeMinAge(), ecorePackage.getEInt(), "defaultTreeMinAge", null, 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_IsPioner(), ecorePackage.getEBoolean(), "isPioner", null, 0, 1, TreeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_DefaultDeseaseProb(), ecorePackage.getEFloat(), "defaultDeseaseProb", "0.05f", 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_StartingScale(), ecorePackage.getEFloat(), "startingScale", null, 0, 1,
				TreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(this.getTreeType());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getFloat());
		g1.getETypeArguments().add(g2);
		initEAttribute(getTreeType_ChildrenProbs(), g1, "childrenProbs", null, 0, 1, TreeType.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_HSpace(), ecorePackage.getEFloat(), "hSpace", "1f", 0, 1, TreeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeType_Name(), ecorePackage.getEString(), "name", null, 0, 1, TreeType.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getTreeType__GetChildType__float(), this.getTreeType(), "getChildType", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "draw", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(vector3fEDataType, Vector3f.class, "Vector3f", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatEDataType, Float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ForestPackageImpl
