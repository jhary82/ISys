package visitor;

import java.util.Arrays;
import java.util.List;

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
	//private int[] countSymbols = new int[11];

	private List<Integer> countSymbols = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0);
	
	@Override
	public String visitSymbolStat(SymbolStatContext ctx) {
		// TODO Auto-generated method stub
		return visitChildren(ctx);
	}
	
	@Override
	public String visitDotStat(DotStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(DOT, this.countSymbols.get(DOT)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitKomStat(KomStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(KOM, this.countSymbols.get(KOM)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitAusStat(AusStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(AUS, this.countSymbols.get(AUS)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitBrackStat(BrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(BRACK, this.countSymbols.get(BRACK)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitRbrackStat(RbrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(RBRACK, this.countSymbols.get(RBRACK)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitQuesStat(QuesStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(QUES, this.countSymbols.get(QUES)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitCiteStat(CiteStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(CITE, this.countSymbols.get(CITE)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberStat(NumberStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(NUMBER, this.countSymbols.get(NUMBER)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitWordStat(WordStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(WORD, this.countSymbols.get(WORD)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNlStat(NlStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(NL, this.countSymbols.get(NL)+1);
		return visitChildren(ctx);
	}

	/**
	 * INDEX: DOT=1,KOM=2,AUS=3,BRACK=4,RBRACK=5,QUES=6,CITE=7,NUMBER=8,WORD=9,NL=10
	 * @return the countSymbols
	 */
	public List<Integer> getCountSymbols() {
		return countSymbols;
	}
	
}
