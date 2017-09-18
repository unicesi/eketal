/**
 * generated by Xtext 2.12.0
 */
package co.edu.icesi.eketal.eketal.util;

import co.edu.icesi.eketal.eketal.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see co.edu.icesi.eketal.eketal.EketalPackage
 * @generated
 */
public class EketalAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EketalPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EketalAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EketalPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EketalSwitch<Adapter> modelSwitch =
    new EketalSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseEventClass(EventClass object)
      {
        return createEventClassAdapter();
      }
      @Override
      public Adapter caseDecl(Decl object)
      {
        return createDeclAdapter();
      }
      @Override
      public Adapter caseJVarD(JVarD object)
      {
        return createJVarDAdapter();
      }
      @Override
      public Adapter caseMSig(MSig object)
      {
        return createMSigAdapter();
      }
      @Override
      public Adapter caseEvDecl(EvDecl object)
      {
        return createEvDeclAdapter();
      }
      @Override
      public Adapter caseEventExpression(EventExpression object)
      {
        return createEventExpressionAdapter();
      }
      @Override
      public Adapter caseEventPredicate(EventPredicate object)
      {
        return createEventPredicateAdapter();
      }
      @Override
      public Adapter caseKindAttribute(KindAttribute object)
      {
        return createKindAttributeAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseJVMTYPE(JVMTYPE object)
      {
        return createJVMTYPEAdapter();
      }
      @Override
      public Adapter caseGroup(Group object)
      {
        return createGroupAdapter();
      }
      @Override
      public Adapter caseHost(Host object)
      {
        return createHostAdapter();
      }
      @Override
      public Adapter caseAutomaton(Automaton object)
      {
        return createAutomatonAdapter();
      }
      @Override
      public Adapter caseStep(Step object)
      {
        return createStepAdapter();
      }
      @Override
      public Adapter caseTransDef(TransDef object)
      {
        return createTransDefAdapter();
      }
      @Override
      public Adapter caseRc(Rc object)
      {
        return createRcAdapter();
      }
      @Override
      public Adapter caseBody(Body object)
      {
        return createBodyAdapter();
      }
      @Override
      public Adapter caseOrEvent(OrEvent object)
      {
        return createOrEventAdapter();
      }
      @Override
      public Adapter caseAndEvent(AndEvent object)
      {
        return createAndEventAdapter();
      }
      @Override
      public Adapter caseUnaryEvent(UnaryEvent object)
      {
        return createUnaryEventAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.EventClass <em>Event Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.EventClass
   * @generated
   */
  public Adapter createEventClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Decl
   * @generated
   */
  public Adapter createDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.JVarD <em>JVar D</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.JVarD
   * @generated
   */
  public Adapter createJVarDAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.MSig <em>MSig</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.MSig
   * @generated
   */
  public Adapter createMSigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.EvDecl <em>Ev Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.EvDecl
   * @generated
   */
  public Adapter createEvDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.EventExpression <em>Event Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.EventExpression
   * @generated
   */
  public Adapter createEventExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.EventPredicate <em>Event Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.EventPredicate
   * @generated
   */
  public Adapter createEventPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.KindAttribute <em>Kind Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.KindAttribute
   * @generated
   */
  public Adapter createKindAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.JVMTYPE <em>JVMTYPE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.JVMTYPE
   * @generated
   */
  public Adapter createJVMTYPEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Host <em>Host</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Host
   * @generated
   */
  public Adapter createHostAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Automaton <em>Automaton</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Automaton
   * @generated
   */
  public Adapter createAutomatonAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Step <em>Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Step
   * @generated
   */
  public Adapter createStepAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.TransDef <em>Trans Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.TransDef
   * @generated
   */
  public Adapter createTransDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Rc <em>Rc</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Rc
   * @generated
   */
  public Adapter createRcAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.Body <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.Body
   * @generated
   */
  public Adapter createBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.OrEvent <em>Or Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.OrEvent
   * @generated
   */
  public Adapter createOrEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.AndEvent <em>And Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.AndEvent
   * @generated
   */
  public Adapter createAndEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link co.edu.icesi.eketal.eketal.UnaryEvent <em>Unary Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see co.edu.icesi.eketal.eketal.UnaryEvent
   * @generated
   */
  public Adapter createUnaryEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //EketalAdapterFactory
