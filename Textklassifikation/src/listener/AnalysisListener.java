/**
 * 
 */
package listener;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import syntaxAnalyse.*;

/**
 * Antlr - Listener bestimmt die Eigenschaften der zu parsenden Datei
 * @author skrause
 *
 */
public final class AnalysisListener extends SyntaxBaseListener{

	/*
	 * Konstante Werte
	 */
	final public static int DOT = 0;
	final public static int COMMA = 1;	
	final public static int BRACK = 2;
	final public static int QUESTION = 3;
	final public static int CITE = 4;
	final public static int NUMBER_WITH_DOT = 5;	
	final public static int NL = 6;
	final public static int NUMBER_REST = 7;
	final public static int NUMBER_FOUR = 8;
	final public static int SENTENCE_LENGTH_AVG = 9;	
	final public static int SUB_SENTENCES = 10;
	
	/**
	 * Indizes der Liste der Eigenschaften sind die obigen	
	 */
	private List<Integer> symbols;
	
	/**
	 * Anzahl der Wörter
	 */
	private int words = 0;
	
	/**
	 * Konstruktor
	 */
	public AnalysisListener(List<Integer> list) {
		symbols = list;
		for(int i = 0; i <= SUB_SENTENCES; i++){
			symbols.add(0);
		}
	}
	
	/*
	 * sentence
	 */
	@Override
	public void enterSentence(@NotNull SyntaxParser.SentenceContext ctx) {
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}

	
	/*
	 * Subsentence 
	 */
	
	@Override 
	public void enterQuestion(@NotNull SyntaxParser.QuestionContext ctx) { 
		symbols.set(QUESTION, symbols.get(QUESTION)+1);		
	}
	
	@Override
	public void enterComma(@NotNull SyntaxParser.CommaContext ctx) {
		symbols.set(COMMA, symbols.get(COMMA)+1);
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}
	
	@Override 
	public void enterDot(@NotNull SyntaxParser.DotContext ctx) {
		symbols.set(DOT, symbols.get(DOT)+1);
	}
		
	/*
	 * Symbol 
	 */
	
	@Override 
	public void enterNl(SyntaxParser.NlContext ctx) {
		symbols.set(NL, symbols.get(NL)+1);		
	}		
	
	@Override 
	public void enterCite( SyntaxParser.CiteContext ctx) {
		symbols.set(CITE, symbols.get(CITE)+1);
	}
	
	@Override
	public void enterNumber_with_dot( SyntaxParser.Number_with_dotContext ctx) {
		symbols.set(NUMBER_WITH_DOT, symbols.get(NUMBER_WITH_DOT)+1);		
	}
	
	@Override
	public void enterNumber_four(@NotNull SyntaxParser.Number_fourContext ctx) { 
		symbols.set(NUMBER_FOUR, symbols.get(NUMBER_FOUR)+1);		
	}

	@Override
	public void enterBrack(@NotNull SyntaxParser.BrackContext ctx) {
		symbols.set(BRACK, symbols.get(BRACK)+1);		
	}
	
	@Override
	public void enterNumberRest(@NotNull SyntaxParser.NumberRestContext ctx) {
		symbols.set(NUMBER_REST, symbols.get(NUMBER_REST)+1);
	}
	
	@Override
	public void enterWord(@NotNull SyntaxParser.WordContext ctx) { 
		words++;
	}

	/*
	 * Bei Beenden von stat berechne Mittelwerte
	 */
	@Override
	public void exitStat(@NotNull SyntaxParser.StatContext ctx) { 
		symbols.set(SENTENCE_LENGTH_AVG, (words/symbols.get(SUB_SENTENCES)) );
	}




}
