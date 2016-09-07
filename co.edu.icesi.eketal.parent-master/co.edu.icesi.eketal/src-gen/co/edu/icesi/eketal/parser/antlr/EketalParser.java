/*
 * generated by Xtext 2.10.0
 */
package co.edu.icesi.eketal.parser.antlr;

import co.edu.icesi.eketal.parser.antlr.internal.InternalEketalParser;
import co.edu.icesi.eketal.services.EketalGrammarAccess;
import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class EketalParser extends AbstractAntlrParser {

	@Inject
	private EketalGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalEketalParser createParser(XtextTokenStream stream) {
		return new InternalEketalParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public EketalGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EketalGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}