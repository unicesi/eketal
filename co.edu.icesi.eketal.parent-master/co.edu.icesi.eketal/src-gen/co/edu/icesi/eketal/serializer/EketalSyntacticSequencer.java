/*
 * generated by Xtext 2.10.0
 */
package co.edu.icesi.eketal.serializer;

import co.edu.icesi.eketal.services.EketalGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class EketalSyntacticSequencer extends AbstractSyntacticSequencer {

	protected EketalGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AtomEvent_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_AtomEvent_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Model_SemicolonKeyword_0_2_q;
	protected AbstractElementAlias match_Step___RightParenthesisKeyword_2_4_3_VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1__a;
	protected AbstractElementAlias match_Step___VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__a;
	protected AbstractElementAlias match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (EketalGrammarAccess) access;
		match_AtomEvent_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getAtomEventAccess().getLeftParenthesisKeyword_1_0());
		match_AtomEvent_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getAtomEventAccess().getLeftParenthesisKeyword_1_0());
		match_Model_SemicolonKeyword_0_2_q = new TokenAlias(false, true, grammarAccess.getModelAccess().getSemicolonKeyword_0_2());
		match_Step___RightParenthesisKeyword_2_4_3_VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getStepAccess().getRightParenthesisKeyword_2_4_3()), new TokenAlias(false, false, grammarAccess.getStepAccess().getVerticalLineVerticalLineKeyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getStepAccess().getLeftParenthesisKeyword_2_4_1()));
		match_Step___VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getStepAccess().getVerticalLineVerticalLineKeyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getStepAccess().getLeftParenthesisKeyword_2_4_1()), new TokenAlias(false, false, grammarAccess.getStepAccess().getRightParenthesisKeyword_2_4_3()));
		match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()));
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_a = new TokenAlias(true, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_AtomEvent_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_AtomEvent_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AtomEvent_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_AtomEvent_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model_SemicolonKeyword_0_2_q.equals(syntax))
				emit_Model_SemicolonKeyword_0_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Step___RightParenthesisKeyword_2_4_3_VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1__a.equals(syntax))
				emit_Step___RightParenthesisKeyword_2_4_3_VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Step___VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__a.equals(syntax))
				emit_Step___VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XImportDeclaration_SemicolonKeyword_2_a.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) op='!'
	 *     (rule start) (ambiguity) tipoEvento=EventPredicate
	 *     (rule start) (ambiguity) {AndEvent.left=}
	 *     (rule start) (ambiguity) {OrEvent.left=}
	 */
	protected void emit_AtomEvent_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) op='!'
	 *     (rule start) (ambiguity) {AndEvent.left=}
	 *     (rule start) (ambiguity) {OrEvent.left=}
	 */
	protected void emit_AtomEvent_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QualifiedName (ambiguity) (rule end)
	 *     name=QualifiedName (ambiguity) importSection=XImportSection
	 *     name=QualifiedName (ambiguity) typeDeclaration=EventClass
	 */
	protected void emit_Model_SemicolonKeyword_0_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (')' '||' '(')*
	 *
	 * This ambiguous syntax occurs at:
	 *     transitions+=TransDef ')' '||' '(' (ambiguity) transitions+=TransDef
	 *     transitions+=TransDef (ambiguity) transitions+=TransDef
	 */
	protected void emit_Step___RightParenthesisKeyword_2_4_3_VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('||' '(' ')')*
	 *
	 * This ambiguous syntax occurs at:
	 *     transitions+=TransDef ')' (ambiguity) ';' (rule end)
	 */
	protected void emit_Step___VerticalLineVerticalLineKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     annotationType=[JvmAnnotationType|QualifiedName] (ambiguity) (rule end)
	 */
	protected void emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) expressions+=XExpressionOrVarDeclaration
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '=>' returnType=JvmTypeReference
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     importedNamespace=QualifiedNameWithWildcard (ambiguity) (rule end)
	 *     importedType=[JvmDeclaredType|QualifiedName] (ambiguity) (rule end)
	 *     memberName=ValidID (ambiguity) (rule end)
	 *     wildcard?='*' (ambiguity) (rule end)
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '(' type=JvmTypeReference
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'new' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=XExpression
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpPostfix]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=CHARACTER
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XJArrayAccessExpression.array=}
	 *     (rule start) (ambiguity) {XJClassObject.typeExpression=}
	 *     (rule start) (ambiguity) {XJConditionalExpression.if=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '(' type=JvmTypeReference
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'new' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=XExpression
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpPostfix]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=CHARACTER
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XJArrayAccessExpression.array=}
	 *     (rule start) (ambiguity) {XJClassObject.typeExpression=}
	 *     (rule start) (ambiguity) {XJConditionalExpression.if=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
