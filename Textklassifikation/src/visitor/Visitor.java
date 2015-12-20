package visitor;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import syntaxAnalyse.SyntaxParser.*;
import syntaxAnalyse.SyntaxVisitor;
import static syntaxAnalyse.SyntaxLexer.*;

/**
 * @author Erik
 *
 */
public class Visitor extends AbstractParseTreeVisitor<String> implements SyntaxVisitor<String> {
	
	/**
	 * INDEX: DOT=1,KOM=2,AUS=3,BRACK=4,RBRACK=5,QUES=6,CITE=7,NUMBER=8,WORD=9,NL=10
	 */
	private int[] countSymbols = new int[11];

	@Override
	public String visitSymbolStat(SymbolStatContext ctx) {
		// TODO Auto-generated method stub
		return visitChildren(ctx);
	}
	
	@Override
	public String visitDotStat(DotStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[DOT]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitKomStat(KomStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[KOM]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitAusStat(AusStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[AUS]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitBrackStat(BrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[BRACK]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitRbrackStat(RbrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[RBRACK]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitQuesStat(QuesStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[QUES]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitCiteStat(CiteStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[CITE]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberStat(NumberStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[NUMBER]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitWordStat(WordStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[WORD]++;
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNlStat(NlStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols[NL]++;
		return visitChildren(ctx);
	}

	/**
	 * INDEX: DOT=1,KOM=2,AUS=3,BRACK=4,RBRACK=5,QUES=6,CITE=7,NUMBER=8,WORD=9,NL=10
	 * @return the countSymbols
	 */
	public int[] getCountSymbols() {
		return countSymbols;
	}
	
}
