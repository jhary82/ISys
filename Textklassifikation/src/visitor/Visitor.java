package visitor;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import syntaxAnalyse.SyntaxParser.*;
import syntaxAnalyse.SyntaxVisitor;

/**
 * @author Erik
 *
 */
public class Visitor extends AbstractParseTreeVisitor<String> implements SyntaxVisitor<String> {
	
	/*
	 * Konstante Werte
	 */
	final public static int DOT = 0;
	final public static int COMMA = 1;
	final public static int EXCLAMATION = 2;
	final public static int BRACK = 3;
	final public static int QUESTION = 4;
	final public static int CITE = 5;
	final public static int NUMBER_WITH_DOT = 6;
	final public static int WORDS = 7;
	final public static int NL = 8;
	final public static int NUMBER_REST = 9;
	final public static int NUMBER_FOUR = 10;
	final public static int SENTENCE_LENGTH = 11;
	final public static int PAST = 12;
	
	
	/**
	 * INDEX: DOT=1,KOM=2,AUS=3,BRACK=4,RBRACK=5,QUES=6,CITE=7,NUMBER=8,WORD=9,NL=10
	 */
	//private int[] countSymbols = new int[11];

	private List<Integer> countSymbols = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	
	@Override
	public String visitSymbolStat(SymbolStatContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public String visitDotStat(DotStatContext ctx) {
		this.countSymbols.set(DOT, this.countSymbols.get(DOT)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitKomStat(KomStatContext ctx) {
		this.countSymbols.set(COMMA, this.countSymbols.get(COMMA)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitAusStat(AusStatContext ctx) {
		this.countSymbols.set(EXCLAMATION, this.countSymbols.get(EXCLAMATION)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitBrackStat(BrackStatContext ctx) {
		this.countSymbols.set(BRACK, this.countSymbols.get(BRACK)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitRbrackStat(RbrackStatContext ctx) {
		this.countSymbols.set(BRACK, this.countSymbols.get(BRACK)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitQuesStat(QuesStatContext ctx) {
		this.countSymbols.set(QUESTION, this.countSymbols.get(QUESTION)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitCiteStat(CiteStatContext ctx) {
		this.countSymbols.set(CITE, this.countSymbols.get(CITE)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberStat(NumberStatContext ctx) {
		if(ctx.getText().length() == 4) {
			// 12
			this.countSymbols.set(NUMBER_FOUR, this.countSymbols.get(NUMBER_FOUR)+1);
		} else {
			// 11
			this.countSymbols.set(NUMBER_REST, this.countSymbols.get(NUMBER_REST)+1);
		}
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberDotStat(NumberDotStatContext ctx) {
		// 8
		this.countSymbols.set(NUMBER_WITH_DOT, this.countSymbols.get(NUMBER_WITH_DOT)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitWordStat(WordStatContext ctx) {
		String text = ctx.getText();
		/*
		 * 	| WORD ('te'|'test'|'ten'|'tet'|'st'|'en'|'t') #wordPreat
		 */
		if(text.startsWith("ge") && (text.endsWith("t")||text.endsWith("en"))) {
			// es kann sich um Partizip II handeln.
			this.countSymbols.set(PAST, this.countSymbols.get(PAST)+1);
		} else if(/*text.endsWith("te") || */text.endsWith("test") /*||
				text.endsWith("ten")*/ || text.endsWith("tet")/*||
				text.endsWith("st")*/ /*|| text.endsWith("en")*/ /*||
				text.endsWith("t")*/) {
			// es kann sich um Präteritum handeln
			this.countSymbols.set(PAST, this.countSymbols.get(PAST)+1);
		}
		this.countSymbols.set(WORDS, this.countSymbols.get(WORDS)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNlStat(NlStatContext ctx) {
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
