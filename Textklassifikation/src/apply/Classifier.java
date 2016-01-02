package apply;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import syntaxAnalyse.SyntaxLexer;
import syntaxAnalyse.SyntaxParser;
import visitor.Analyse;
import visitor.Visitor;

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
	public static int FILM = 0;
	/**
	 * Klasse der Textdatei
	 */
	public static int NEWS = 1;
	
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
		Visitor visitor = new Visitor();
		visitor.visit(tree);
		Analyse ana = new Analyse(visitor.getCountSymbols());
		return ana.getCounts();
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
		filmValue += film.getDotValue(attributs.get(2));
		
		/*
		 * berechne News-Wert
		 */
		newsValue += news.getDotValue(attributs.get(2));
		
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
				System.out.println("Film klassifiert.");
				film++;
			}
			else{
				System.out.println("Nachrichten klassifiert.");
				news++;
			}
		}
		System.out.println(film+ " / "+(film+news) +" = " +(film/(film+news)) +" % richtig erkannt." );
		
	}


}
