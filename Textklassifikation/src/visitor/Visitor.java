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
	
	/**
	 * INDEX: DOT=1,KOM=2,AUS=3,BRACK=4,RBRACK=5,QUES=6,CITE=7,NUMBER=8,WORD=9,NL=10
	 */
	//private int[] countSymbols = new int[11];

	private List<Integer> countSymbols = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	
	@Override
	public String visitSymbolStat(SymbolStatContext ctx) {
		// TODO Auto-generated method stub
		return visitChildren(ctx);
	}
	
	@Override
	public String visitDotStat(DotStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(1, this.countSymbols.get(1)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitKomStat(KomStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(2, this.countSymbols.get(2)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitAusStat(AusStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(3, this.countSymbols.get(3)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitBrackStat(BrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(4, this.countSymbols.get(4)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitRbrackStat(RbrackStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(5, this.countSymbols.get(5)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitQuesStat(QuesStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(6, this.countSymbols.get(6)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitCiteStat(CiteStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(7, this.countSymbols.get(7)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberStat(NumberStatContext ctx) {
		// TODO Auto-generated method stub
		if(ctx.getText().length() == 4) {
			// 12
			this.countSymbols.set(12, this.countSymbols.get(12)+1);
		} else {
			// 11
			this.countSymbols.set(11, this.countSymbols.get(11)+1);
		}
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNumberDotStat(NumberDotStatContext ctx) {
		// 8
		this.countSymbols.set(8, this.countSymbols.get(8)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitWordStat(WordStatContext ctx) {
		// TODO Auto-generated method stub
		String text = ctx.getText();
		/*
		 * 	| WORD ('te'|'test'|'ten'|'tet'|'st'|'en'|'t') #wordPreat
		 */
		if(text.startsWith("ge") && (text.endsWith("t")||text.endsWith("en"))) {
			// es kann sich um Partizip II handeln.
			this.countSymbols.set(14, this.countSymbols.get(14)+1);
		} else if(/*text.endsWith("te") || */text.endsWith("test") /*||
				text.endsWith("ten")*/ || text.endsWith("tet")/*||
				text.endsWith("st")*/ /*|| text.endsWith("en")*/ /*||
				text.endsWith("t")*/) {
			// es kann sich um Präteritum handeln
			this.countSymbols.set(14, this.countSymbols.get(14)+1);
		}
		this.countSymbols.set(9, this.countSymbols.get(9)+1);
		return visitChildren(ctx);
	}
	
	@Override
	public String visitNlStat(NlStatContext ctx) {
		// TODO Auto-generated method stub
		this.countSymbols.set(10, this.countSymbols.get(10)+1);
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
