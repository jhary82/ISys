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
 * 
 */

/**
 * Diese Klasse laedt ein Klassifizierungs-XML fuer die beiden
 * Unterscheidungsarten News oder Film ein und klassifiziert dann uebergebende
 * Dateien
 * 
 * @author skrause
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
	 * Klassifizierungsattribute für Nachrichten
	 */
	private Classifier_Class news;

	/**
	 * Klassifizierungsattribute für Filme
	 */
	private Classifier_Class film;

	/**
	 * Konstruktor
	 * 
	 * @param xml
	 *            Klassifizierungs-XML mit dem "Brain"
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
	 * @param text zu parsender Text
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
	 * @param attributs uebergebende Attribute
	 * @return FILM oder NEWS
	 */
	private int classify(List<Integer> attributs) {
		double filmValue = 0, newsValue = 0;
		/*
		 * berechne Film-Wert
		 */		
		filmValue += film.getValue(attributs.get(AnalysisListener.DOT), AnalysisListener.DOT);
		filmValue += film.getValue(attributs.get(AnalysisListener.COMMA), AnalysisListener.COMMA);
		//filmValue += film.getValue(attributs.get(Listener.EXCLAMATION), Listener.EXCLAMATION);
		filmValue += film.getValue(attributs.get(AnalysisListener.BRACK), AnalysisListener.BRACK);
		//filmValue += film.getValue(attributs.get(Listener.QUESTION), Listener.QUESTION);
		filmValue += film.getValue(attributs.get(AnalysisListener.CITE), AnalysisListener.CITE);
		filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_WITH_DOT), AnalysisListener.NUMBER_WITH_DOT);
		//filmValue += film.getValue(attributs.get(Listener.NL), Listener.NL);
		filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_REST), AnalysisListener.NUMBER_REST);
		filmValue += film.getValue(attributs.get(AnalysisListener.NUMBER_FOUR), AnalysisListener.NUMBER_FOUR);
		//filmValue += film.getValue(attributs.get(Listener.SENTENCE_LENGTH), Listener.SENTENCE_LENGTH);
		//filmValue += film.getValue(attributs.get(Listener.PAST), Listener.PAST);
		
		/*
		 * berechne News-Wert
		 */		
		newsValue += news.getValue(attributs.get(AnalysisListener.DOT), AnalysisListener.DOT);
		newsValue += news.getValue(attributs.get(AnalysisListener.COMMA), AnalysisListener.COMMA);
		//newsValue += news.getValue(attributs.get(Listener.EXCLAMATION), Listener.EXCLAMATION);
		newsValue += news.getValue(attributs.get(AnalysisListener.BRACK), AnalysisListener.BRACK);
		//newsValue += news.getValue(attributs.get(Listener.QUESTION), Listener.QUESTION);
		newsValue += news.getValue(attributs.get(AnalysisListener.CITE), AnalysisListener.CITE);
		newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_WITH_DOT), AnalysisListener.NUMBER_WITH_DOT);
		//newsValue += news.getValue(attributs.get(Listener.NL), Listener.NL);
		newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_REST), AnalysisListener.NUMBER_REST);
		newsValue += news.getValue(attributs.get(AnalysisListener.NUMBER_FOUR), AnalysisListener.NUMBER_FOUR);
		//newsValue += news.getValue(attributs.get(Listener.SENTENCE_LENGTH), Listener.SENTENCE_LENGTH);
		//newsValue += news.getValue(attributs.get(Listener.PAST), Listener.PAST);
		
		if( filmValue >= newsValue){
			return FILM;
		}
		else{
			return NEWS;
		}
	}
	
	/**
	 * Einladen des "Brains" und anwenden auf uebergebende Dateiliste
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File xml = new File("brain.xml");
		Classifier classifier = new Classifier(xml);

		/*
		 * Test-Daten
		 */
		File[] testFilme = new File("Datensatz_1_2015-12-14/Filme/Test/")
				.listFiles();
		File[] testNews = new File("Datensatz_1_2015-12-14/Nachrichten/Test/")
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
		for( int i = 0; i < testFilme.length; i++){
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
