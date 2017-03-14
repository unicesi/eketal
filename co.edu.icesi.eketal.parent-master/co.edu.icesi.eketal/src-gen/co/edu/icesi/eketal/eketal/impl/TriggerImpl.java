/**
 * generated by Xtext 2.10.0
 */
package co.edu.icesi.eketal.eketal.impl;

import co.edu.icesi.eketal.eketal.EketalPackage;
import co.edu.icesi.eketal.eketal.JVMTYPE;
import co.edu.icesi.eketal.eketal.TPrefix;
import co.edu.icesi.eketal.eketal.Trigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.icesi.eketal.eketal.impl.TriggerImpl#getTriggerType <em>Trigger Type</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.impl.TriggerImpl#getReturndef <em>Returndef</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.impl.TriggerImpl#getEsig <em>Esig</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.impl.TriggerImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggerImpl extends EventPredicateImpl implements Trigger
{
  /**
   * The default value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerType()
   * @generated
   * @ordered
   */
  protected static final TPrefix TRIGGER_TYPE_EDEFAULT = TPrefix.CALL;

  /**
   * The cached value of the '{@link #getTriggerType() <em>Trigger Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerType()
   * @generated
   * @ordered
   */
  protected TPrefix triggerType = TRIGGER_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getReturndef() <em>Returndef</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturndef()
   * @generated
   * @ordered
   */
  protected JVMTYPE returndef;

  /**
   * The default value of the '{@link #getEsig() <em>Esig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEsig()
   * @generated
   * @ordered
   */
  protected static final String ESIG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEsig() <em>Esig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEsig()
   * @generated
   * @ordered
   */
  protected String esig = ESIG_EDEFAULT;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeReference> params;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TriggerImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EketalPackage.Literals.TRIGGER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TPrefix getTriggerType()
  {
    return triggerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerType(TPrefix newTriggerType)
  {
    TPrefix oldTriggerType = triggerType;
    triggerType = newTriggerType == null ? TRIGGER_TYPE_EDEFAULT : newTriggerType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EketalPackage.TRIGGER__TRIGGER_TYPE, oldTriggerType, triggerType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JVMTYPE getReturndef()
  {
    return returndef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturndef(JVMTYPE newReturndef, NotificationChain msgs)
  {
    JVMTYPE oldReturndef = returndef;
    returndef = newReturndef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EketalPackage.TRIGGER__RETURNDEF, oldReturndef, newReturndef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturndef(JVMTYPE newReturndef)
  {
    if (newReturndef != returndef)
    {
      NotificationChain msgs = null;
      if (returndef != null)
        msgs = ((InternalEObject)returndef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EketalPackage.TRIGGER__RETURNDEF, null, msgs);
      if (newReturndef != null)
        msgs = ((InternalEObject)newReturndef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EketalPackage.TRIGGER__RETURNDEF, null, msgs);
      msgs = basicSetReturndef(newReturndef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EketalPackage.TRIGGER__RETURNDEF, newReturndef, newReturndef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEsig()
  {
    return esig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEsig(String newEsig)
  {
    String oldEsig = esig;
    esig = newEsig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EketalPackage.TRIGGER__ESIG, oldEsig, esig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmTypeReference> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, EketalPackage.TRIGGER__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EketalPackage.TRIGGER__RETURNDEF:
        return basicSetReturndef(null, msgs);
      case EketalPackage.TRIGGER__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EketalPackage.TRIGGER__TRIGGER_TYPE:
        return getTriggerType();
      case EketalPackage.TRIGGER__RETURNDEF:
        return getReturndef();
      case EketalPackage.TRIGGER__ESIG:
        return getEsig();
      case EketalPackage.TRIGGER__PARAMS:
        return getParams();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EketalPackage.TRIGGER__TRIGGER_TYPE:
        setTriggerType((TPrefix)newValue);
        return;
      case EketalPackage.TRIGGER__RETURNDEF:
        setReturndef((JVMTYPE)newValue);
        return;
      case EketalPackage.TRIGGER__ESIG:
        setEsig((String)newValue);
        return;
      case EketalPackage.TRIGGER__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends JvmTypeReference>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EketalPackage.TRIGGER__TRIGGER_TYPE:
        setTriggerType(TRIGGER_TYPE_EDEFAULT);
        return;
      case EketalPackage.TRIGGER__RETURNDEF:
        setReturndef((JVMTYPE)null);
        return;
      case EketalPackage.TRIGGER__ESIG:
        setEsig(ESIG_EDEFAULT);
        return;
      case EketalPackage.TRIGGER__PARAMS:
        getParams().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EketalPackage.TRIGGER__TRIGGER_TYPE:
        return triggerType != TRIGGER_TYPE_EDEFAULT;
      case EketalPackage.TRIGGER__RETURNDEF:
        return returndef != null;
      case EketalPackage.TRIGGER__ESIG:
        return ESIG_EDEFAULT == null ? esig != null : !ESIG_EDEFAULT.equals(esig);
      case EketalPackage.TRIGGER__PARAMS:
        return params != null && !params.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (triggerType: ");
    result.append(triggerType);
    result.append(", esig: ");
    result.append(esig);
    result.append(')');
    return result.toString();
  }

} //TriggerImpl
