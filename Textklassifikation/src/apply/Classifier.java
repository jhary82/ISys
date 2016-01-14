package apply;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import listener.AnalysisListener;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import syntaxAnalyse.SyntaxLexer;
import syntaxAnalyse.SyntaxParser;

/**
 * Diese Klasse laedt ein Klassifizierungs-XML fuer die beiden
 * Unterscheidungsarten News oder Film ein und klassifiziert dann uebergebende
 * Dateien
 * 
 * @author Simon und Erik
 *
 */
public final class Classifier {

	/**
	 * Klasse der Textdatei
	 */
	final public static int FILM = 0;
	/**
	 * Klasse der Textdatei
	 */
	final public static int NEWS = 1;
	
	/**
	 * Klassifizierungsattribute fuer Nachrichten
	 */
	private Classifier_Class news;

	/**
	 * Klassifizierungsattribute fuer Filme
	 */
	private Classifier_Class film;

	/**
	 * Konstruktor - Klassifizierungs-XML mit dem "Brain"
	 * 
	 * @param xml - Name der XML-Datei
	 */
	public Classifier(File xml) {
		try {
			Document doc = new SAXBuilder().build(xml);
			Element root = doc.getRootElement();
			List<Element> children = root.getChildren();
			film = new Classifier_Class(children.get(0));
			news = new Classifier_Class(children.get(1));

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parst einen Text und erstellt eine Liste mit Eigenschaften
	 * @param text - zu parsender Text
	 * @return Liste mit Texteigenschaften
	 */
	public List<Integer> parseText(File text) {
		CharStream input = null;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(text)));
			input = new ANTLRInputStream(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SyntaxLexer lexer = new SyntaxLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SyntaxParser parser = new SyntaxParser(tokens);
		ParseTree tree = parser.stat();
		
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		List<Integer> list = new LinkedList<>();
		AnalysisListener extractor = new AnalysisListener(list);
		walker.walk(extractor, tree);		
		
		return list;
	}
	
	/**
	 * Klassifiziert mit uebergebenden Attributen,
	 * ob ein Film oder eine Nachricht vorliegt
	 * @param attributs - uebergebende Attribute
	 * @return FILM oder NEWS
	 */
	private int classify(List<Integer> attributs) {
		double filmValue = 0, newsValue = 0;
		/*
		 * berechne Film-Wert
		 */		
		//filmValue += film.getValue(attributs.get(AnalysisListener.DOT), AnalysisListener.DOT);
		//filmValue += film.getValue(attributs.get(AnalysisListener.COMMA), AnalysisListener.COMMA);
		filmValue += film.getValue(attributs.get(AnalysisListener.BRACK), AnalysisListener.BRACK);
		filmValue += film.getValue(attributs.get(AnalysisListener.QUESTION), AnalysisListener.QUESTION);
		//filmValue += film.getValue(attributs.get(AnalysisListener.CITE), AnalysisListener.CITE);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_WITH_DOT), AnalysisListener.NUMBER_WITH_DOT);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NL), AnalysisListener.NL);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_REST), AnalysisListener.NUMBER_REST);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_FOUR), AnalysisListener.NUMBER_FOUR);
		//filmValue += film.getValue(attributs.get(AnalysisListener.SENTENCE_LENGTH_AVG), AnalysisListener.SENTENCE_LENGTH_AVG);
		//filmValue += film.getValue(attributs.get(AnalysisListener.SENTENCE_LENGTH_MAX), AnalysisListener.SENTENCE_LENGTH_MAX);
		//filmValue += film.getValue(attributs.get(AnalysisListener.SUB_SENTENCES), AnalysisListener.SUB_SENTENCES);
		//filmValue += film.getValue(attributs.get(AnalysisListener.PAST), AnalysisListener.PAST);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN), AnalysisListener.NOUN);
		
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_3), AnalysisListener.NOUN_LENGTH_3);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_4), AnalysisListener.NOUN_LENGTH_4);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_5), AnalysisListener.NOUN_LENGTH_5);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_6), AnalysisListener.NOUN_LENGTH_6);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_7), AnalysisListener.NOUN_LENGTH_7);
		//filmValue += film.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_8), AnalysisListener.NOUN_LENGTH_8);
		
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_3), AnalysisListener.WORD_LENGTH_3);
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_4), AnalysisListener.WORD_LENGTH_4);
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_5), AnalysisListener.WORD_LENGTH_5);
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_6), AnalysisListener.WORD_LENGTH_6);
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_7), AnalysisListener.WORD_LENGTH_7);
		//filmValue += film.getValue(attributs.get(AnalysisListener.WORD_LENGTH_8), AnalysisListener.WORD_LENGTH_8);
		
		/*
		 * berechne News-Wert
		 */		
		//newsValue += news.getValue(attributs.get(AnalysisListener.DOT), AnalysisListener.DOT);
		//newsValue += news.getValue(attributs.get(AnalysisListener.COMMA), AnalysisListener.COMMA);
		newsValue += news.getValue(attributs.get(AnalysisListener.BRACK), AnalysisListener.BRACK);
		newsValue += news.getValue(attributs.get(AnalysisListener.QUESTION), AnalysisListener.QUESTION);
		//newsValue += news.getValue(attributs.get(AnalysisListener.CITE), AnalysisListener.CITE);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_WITH_DOT), AnalysisListener.NUMBER_WITH_DOT);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NL), AnalysisListener.NL);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_REST), AnalysisListener.NUMBER_REST);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_FOUR), AnalysisListener.NUMBER_FOUR);
		//newsValue += news.getValue(attributs.get(AnalysisListener.SENTENCE_LENGTH_AVG), AnalysisListener.SENTENCE_LENGTH_AVG);
		//newsValue += news.getValue(attributs.get(AnalysisListener.SENTENCE_LENGTH_MAX), AnalysisListener.SENTENCE_LENGTH_MAX);
		//newsValue += news.getValue(attributs.get(AnalysisListener.SUB_SENTENCES), AnalysisListener.SUB_SENTENCES);
		//newsValue += news.getValue(attributs.get(AnalysisListener.PAST), AnalysisListener.PAST);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN), AnalysisListener.NOUN);
		
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_3), AnalysisListener.NOUN_LENGTH_3);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_4), AnalysisListener.NOUN_LENGTH_4);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_5), AnalysisListener.NOUN_LENGTH_5);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_6), AnalysisListener.NOUN_LENGTH_6);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_7), AnalysisListener.NOUN_LENGTH_7);
		//newsValue += news.getValue(attributs.get(AnalysisListener.NOUN_LENGTH_8), AnalysisListener.NOUN_LENGTH_8);
		
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_3), AnalysisListener.WORD_LENGTH_3);
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_4), AnalysisListener.WORD_LENGTH_4);
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_5), AnalysisListener.WORD_LENGTH_5);
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_6), AnalysisListener.WORD_LENGTH_6);
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_7), AnalysisListener.WORD_LENGTH_7);
		//newsValue += news.getValue(attributs.get(AnalysisListener.WORD_LENGTH_8), AnalysisListener.WORD_LENGTH_8);
		
		
		if( filmValue <= newsValue){
			return FILM;
		}
		else{
			return NEWS;
		}
	}
	
	/**
	 * Einladen des "Brains" und anwenden auf uebergebende Dateiliste
	 * 
	 * @param args - ohne Parameter
	 */
	public static void main(String[] args) {
		File xml = new File("brain.xml");
		Classifier classifier = new Classifier(xml);

		/*
		 * Test-Daten
		 */
		/*File[] testFilme = new File("Datensatz_1_2015-12-14/Filme/Test/")
				.listFiles();
		File[] testNews = new File("Datensatz_1_2015-12-14/Nachrichten/Test/")
				.listFiles();*/
		File[] testFilme = new File("Datensatz_2_2016-01-11/Filme/Evaluation/")
		.listFiles();
		File[] testNews = new File("Datensatz_2_2016-01-11/Nachrichten/Evaluation/")
		.listFiles();

		
		/*
		 * werte die Filme aus
		 */
		int film = 0, news = 0;
		for( int i = 0; i < testFilme.length; i++){
			List<Integer> attributs = classifier.parseText( testFilme[i] );
			
			if( classifier.classify( attributs ) == Classifier.FILM){				
				film++;
			}
			else{				
				news++;
			}
		}
		double quot1 = ((double)film / ((double)film+(double)news) )*100;
		System.out.println("Klasse Filme: "+film+ " / "+(film+news) +" | " +quot1 +" % richtig erkannt." );
		
		/*
		 * werte die Nachrichten aus
		 */
		film = 0;
		news = 0;
		for( int i = 0; i < testNews.length; i++){
			List<Integer> attributs = classifier.parseText( testNews[i] );
			if( classifier.classify( attributs ) == Classifier.FILM){				
				film++;
			}
			else{				
				news++;
			}
		}
		double quot2 = ((double)news / ((double)film+(double)news) )*100;
		System.out.println("Klasse Nachrichten: "+news+ " / "+(film+news) +" | " +quot2 +" % richtig erkannt." );
		
		double quot = (quot1 + quot2 )/2;
		System.out.println("Insgesamt: "+quot+" % richtig erkannt.");
	}


}
