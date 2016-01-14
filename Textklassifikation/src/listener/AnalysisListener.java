package listener;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import syntaxAnalyse.*;

/**
 * Antlr - Listener bestimmt die Eigenschaften der zu parsenden Datei
 * @author Simon und Erik
 *
 */
public final class AnalysisListener extends SyntaxBaseListener{

	/*
	 * Anzahl der Konstanten
	 */
	final public static int MAX_ELEMENTS = 26;
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
	final public static int WORD_LENGTH_3 = 14;
	final public static int WORD_LENGTH_4 = 15;
	final public static int WORD_LENGTH_5 = 16;
	final public static int WORD_LENGTH_6 = 17;
	final public static int WORD_LENGTH_7 = 18;
	final public static int WORD_LENGTH_8 = 19;
	final public static int NOUN_LENGTH_3 = 20;
	final public static int NOUN_LENGTH_4 = 21;
	final public static int NOUN_LENGTH_5 = 22;
	final public static int NOUN_LENGTH_6 = 23;
	final public static int NOUN_LENGTH_7 = 24;
	final public static int NOUN_LENGTH_8 = 25;
	
	/**
	 * Indizes der Liste der Eigenschaften sind die obigen	
	 */
	private List<Integer> symbols;
	
	/**
	 * Anzahl der Woerter
	 */
	private int words = 0;
	
	/**
	 * speichert die Anzahl der Woerter bei Eintritt in einen Satz zwischen
	 */
	private int word_counter_sentence = 0;
	/**
	 * speichert die Anzahl der Woerter bei Eintritt in einen Nebensatz zwischen
	 */
	private int word_counter_subsentence = 0;
	
	/**
	 * Laengen von Woertern
	 */
	private int word_length[];
	
	/**
	 * Laengen von Nomen
	 */
	private int noun_length[];
	
	/**
	 * Konstruktor
	 */
	public AnalysisListener(List<Integer> list) {		
		symbols = list;
		for(int i = 0; i < MAX_ELEMENTS; i++){
			symbols.add(0);
		}
		word_length = new int[6];
		noun_length = new int[6];
	}
	
	/*
	 * sentence
	 */
	/**
	 * Mit dieser Methode werden die Anzahl der Hauptsaetze erfasst
	 */
	@Override
	public void enterSentence(@NotNull SyntaxParser.SentenceContext ctx) {
		word_counter_sentence = words;
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}

	/**
	 * Mit dieser Methdode wird die maxiamle Satzlenge und die durchschnittliche Satzlaenge erfasst.
	 */
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
	
	/**
	 * Mit dieser Methdode werden Fragzeichen und Ausrufezeichen erfasst.
	 */
	@Override 
	public void enterQuestion(@NotNull SyntaxParser.QuestionContext ctx) { 
		symbols.set(QUESTION, symbols.get(QUESTION)+1);		
	}
	
	/**
	 * Mit dieser Methode werden Kommatas und Nebensaetze erfasst.
	 */
	@Override
	public void enterComma(@NotNull SyntaxParser.CommaContext ctx) {
		word_counter_subsentence = words;
		symbols.set(COMMA, symbols.get(COMMA)+1);
		symbols.set(SUB_SENTENCES, symbols.get(SUB_SENTENCES) + 1);
	}
	
	/**
	 * Mit dieser Methode werden die Punkte erfasst.
	 */
	@Override 
	public void enterDot(@NotNull SyntaxParser.DotContext ctx) {
		symbols.set(DOT, symbols.get(DOT)+1);
	}
	
	/**
	 * Mit dieser Methdode wird die maxiamle Satzlaenge und die durchschnittliche Satzlaenge erfasst.
	 */
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
	/**
	 * Mit dieser Methode werden die Newlines erfasst.
	 */
	@Override 
	public void enterNl(SyntaxParser.NlContext ctx) {
		symbols.set(NL, symbols.get(NL)+1);		
	}		
	
	/**
	 * Mit dieser Methode werden Zitate erfasst.
	 */
	@Override 
	public void enterCite( SyntaxParser.CiteContext ctx) {
		symbols.set(CITE, symbols.get(CITE)+1);
	}
	
	/**
	 * Mit dieser Methode werden Nummer mit Punkten erfasst.
	 */
	@Override
	public void enterNumber_with_dot( SyntaxParser.Number_with_dotContext ctx) {
		symbols.set(NUMBER_WITH_DOT, symbols.get(NUMBER_WITH_DOT)+1);		
	}
	
	/**
	 * Mit dieser Methode werden vierstellige Nummer und Nummer erfasst, die nicht vierstellig sind oder punkte beinhalten.
	 */
	@Override
	public void enterNumber(@NotNull SyntaxParser.NumberContext ctx) {
		if( ctx.getText().length() == 4){
			symbols.set(NUMBER_FOUR, symbols.get(NUMBER_FOUR)+1);
		}
		else{			
			symbols.set(NUMBER_REST, symbols.get(NUMBER_REST)+1);
		}
	}
	
	/**
	 * Mit dieser Methode wird die Anzahl an Klammern gezaehlt.
	 */
	@Override
	public void enterBrack(@NotNull SyntaxParser.BrackContext ctx) {
		symbols.set(BRACK, symbols.get(BRACK)+1);		
	}
	
	/**
	 * Mit dieser Methode werden die Laengen der Woerter erfasst und es werden Woerter,
	 * die in der Vergangenheit geschrieben sind miterfasst.
	 */
	@Override
	public void enterWord(@NotNull SyntaxParser.WordContext ctx) {		
		String text = ctx.getText();
		/*
		 * 	| WORD ('te'|'test'|'ten'|'tet'|'st'|'en'|'t') #wordPreat
		 */
		if(text.startsWith("ge") && (text.endsWith("t")||text.endsWith("en"))) {
			// es kann sich um Partizip II handeln.
			symbols.set(PAST, symbols.get(PAST)+1);
		} else if(text.endsWith("te") || text.endsWith("test") ||
				text.endsWith("ten") || text.endsWith("tet")||
				text.endsWith("st") || text.endsWith("en") ||
				text.endsWith("t")) {
			// es kann sich um Pr�teritum handeln
			symbols.set(PAST, symbols.get(PAST)+1);
		}		
		words++;
		/*
		 * Laengenermittlung
		 */
		switch(text.length()){
			case 3: word_length[0]++;break;
			case 4: word_length[1]++;break;
			case 5: word_length[2]++;break;
			case 6: word_length[3]++;break;
			case 7: word_length[4]++;break;
			default: word_length[5]++;break;
		}
	}
	
	/**
	 * Die Laenge der Nomen werden erfasst
	 */
	@Override
	public void enterNoun(@NotNull SyntaxParser.NounContext ctx) {
		words++;
		symbols.set(NOUN, symbols.get(NOUN)+1);
		/*
		 * Laengenermittlung
		 */
		switch(ctx.getText().length()){
			case 3: noun_length[0]++;break;
			case 4: noun_length[1]++;break;
			case 5: noun_length[2]++;break;
			case 6: noun_length[3]++;break;
			case 7: noun_length[4]++;break;
			default: noun_length[5]++;break;
		}
	}
	
	/**
	 * Bei Beenden von stat berechne Mittelwerte
	 */
	@Override
	public void exitStat(@NotNull SyntaxParser.StatContext ctx) { 
		int words_per_sentence_avg = symbols.get(SENTENCE_LENGTH_AVG)/symbols.get(SUB_SENTENCES);
		symbols.set(SENTENCE_LENGTH_AVG, words_per_sentence_avg);
		/*
		 * setze Word und Nomenlaengen
		 */
		for(int i = 0; i < 6; i++){
			symbols.set(i+14, word_length[i]);
			symbols.set(i+20, noun_length[i]);
		}
	}




}
