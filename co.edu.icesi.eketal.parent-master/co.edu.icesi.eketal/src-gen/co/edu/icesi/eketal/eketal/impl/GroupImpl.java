/**
 * generated by Xtext 2.10.0
 */
package co.edu.icesi.eketal.eketal.impl;

import co.edu.icesi.eketal.eketal.EketalPackage;
import co.edu.icesi.eketal.eketal.Group;
import co.edu.icesi.eketal.eketal.Host;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.icesi.eketal.eketal.impl.GroupImpl#getHosts <em>Hosts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends DeclImpl implements Group
{
  /**
   * The cached value of the '{@link #getHosts() <em>Hosts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHosts()
   * @generated
   * @ordered
   */
  protected EList<Host> hosts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupImpl()
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
    return EketalPackage.Literals.GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Host> getHosts()
  {
    if (hosts == null)
    {
      hosts = new EObjectContainmentEList<Host>(Host.class, this, EketalPackage.GROUP__HOSTS);
    }
    return hosts;
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
      case EketalPackage.GROUP__HOSTS:
        return ((InternalEList<?>)getHosts()).basicRemove(otherEnd, msgs);
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
      case EketalPackage.GROUP__HOSTS:
        return getHosts();
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
      case EketalPackage.GROUP__HOSTS:
        getHosts().clear();
        getHosts().addAll((Collection<? extends Host>)newValue);
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
      case EketalPackage.GROUP__HOSTS:
        getHosts().clear();
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
      case EketalPackage.GROUP__HOSTS:
        return hosts != null && !hosts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupImpl