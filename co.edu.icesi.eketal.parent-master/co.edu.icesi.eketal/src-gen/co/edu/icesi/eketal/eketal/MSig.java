/**
 * generated by Xtext 2.12.0
 */
package co.edu.icesi.eketal.eketal;

import jbase.jbase.XJJvmFormalParameter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MSig</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.icesi.eketal.eketal.MSig#getName <em>Name</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.MSig#getParams <em>Params</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.MSig#getType <em>Type</em>}</li>
 *   <li>{@link co.edu.icesi.eketal.eketal.MSig#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see co.edu.icesi.eketal.eketal.EketalPackage#getMSig()
 * @model
 * @generated
 */
public interface MSig extends Decl
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see co.edu.icesi.eketal.eketal.EketalPackage#getMSig_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link co.edu.icesi.eketal.eketal.MSig#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link jbase.jbase.XJJvmFormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see co.edu.icesi.eketal.eketal.EketalPackage#getMSig_Params()
   * @model containment="true"
   * @generated
   */
  EList<XJJvmFormalParameter> getParams();

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmTypeReference)
   * @see co.edu.icesi.eketal.eketal.EketalPackage#getMSig_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link co.edu.icesi.eketal.eketal.MSig#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(XExpression)
   * @see co.edu.icesi.eketal.eketal.EketalPackage#getMSig_Body()
   * @model containment="true"
   * @generated
   */
  XExpression getBody();

  /**
   * Sets the value of the '{@link co.edu.icesi.eketal.eketal.MSig#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XExpression value);

} // MSig
