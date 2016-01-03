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
	final public static int PAST = 11;
	final public static int NOUN = 12;
	final public static int SENTENCE_LENGTH_MAX = 13;	
	
	/**
	 * Indizes der Liste der Eigenschaften sind die obigen	
	 */
	private List<Integer> symbols;
	
	/**
	 * Anzahl der Wörter
	 */
	private int words = 0;
	
	/**
	 * speichert die Anzahl der Wörter bei Eintritt in einen Satz zwischen
	 */
	private int word_counter_sentence = 0;
	/**
	 * speichert die Anzahl der Wörter bei Eintritt in einen Nebensatz zwischen
	 */
	private int word_counter_subsentence = 0;
	
	/**
	 * Konstruktor
	 */
	public AnalysisListener(List<Integer> list) {
		symbols = list;
		for(int i = 0; i <= 13; i++){
			symbols.add(0);
		}
	}
	
	/*
	 * sentence
	 */
	@Override
	public void enterSentence(@NotNull SyntaxParser.SentenceContext ctx) {
		word_counter_sentence = words;
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}

	@Override 
	public void exitSentence(@NotNull SyntaxParser.SentenceContext ctx) {
		int dif = words - word_counter_sentence;		
		if(dif > symbols.get(SENTENCE_LENGTH_MAX)){
			symbols.set(SENTENCE_LENGTH_MAX, dif);
		}
		symbols.set(SENTENCE_LENGTH_AVG, symbols.get(SENTENCE_LENGTH_AVG) + dif);
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
		word_counter_subsentence = words;
		symbols.set(COMMA, symbols.get(COMMA)+1);
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}
	
	@Override 
	public void enterDot(@NotNull SyntaxParser.DotContext ctx) {
		symbols.set(DOT, symbols.get(DOT)+1);
	}
		
	@Override
	public void exitComma(@NotNull SyntaxParser.CommaContext ctx) {
		int dif = words - word_counter_subsentence;		
		if(dif > symbols.get(SENTENCE_LENGTH_MAX)){
			symbols.set(SENTENCE_LENGTH_MAX, dif);
		}
		symbols.set(SENTENCE_LENGTH_AVG, symbols.get(SENTENCE_LENGTH_AVG) + dif);		
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
	public void enterNumber(@NotNull SyntaxParser.NumberContext ctx) {
		if( ctx.getText().length() == 4){
			symbols.set(NUMBER_FOUR, symbols.get(NUMBER_FOUR)+1);
		}
		else{			
			symbols.set(NUMBER_REST, symbols.get(NUMBER_REST)+1);
		}
	}

	@Override
	public void enterBrack(@NotNull SyntaxParser.BrackContext ctx) {
		symbols.set(BRACK, symbols.get(BRACK)+1);		
	}
		
	@Override
	public void enterWord(@NotNull SyntaxParser.WordContext ctx) {		
		String text = ctx.getText();
		/*
		 * 	| WORD ('te'|'test'|'ten'|'tet'|'st'|'en'|'t') #wordPreat
		 */
		if(text.startsWith("ge") && (text.endsWith("t")||text.endsWith("en"))) {
			// es kann sich um Partizip II handeln.
			symbols.set(PAST, symbols.get(PAST)+1);
		} else if(/*text.endsWith("te") || */text.endsWith("test") /*||
				text.endsWith("ten")*/ || text.endsWith("tet")/*||
				text.endsWith("st")*/ /*|| text.endsWith("en")*/ /*||
				text.endsWith("t")*/) {
			// es kann sich um Pr�teritum handeln
			symbols.set(PAST, symbols.get(PAST)+1);
		}		
		words++;
	}

	@Override
	public void enterNoun(@NotNull SyntaxParser.NounContext ctx) {
		words++;
		symbols.set(NOUN, symbols.get(NOUN)+1);
	}
	
	/*
	 * Bei Beenden von stat berechne Mittelwerte
	 */
	@Override
	public void exitStat(@NotNull SyntaxParser.StatContext ctx) { 
		int words_per_sentence_avg = symbols.get(SENTENCE_LENGTH_AVG)/symbols.get(SUB_SENTENCES);
		symbols.set(SENTENCE_LENGTH_AVG, words_per_sentence_avg);
	}




}
