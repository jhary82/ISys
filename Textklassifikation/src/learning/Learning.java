/**
 * 
 */
package learning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import syntaxAnalyse.SyntaxLexer;
import syntaxAnalyse.SyntaxParser;
import visitor.Analyse;
import visitor.Visitor;

/**
 * @author Erik und Simon
 *
 */
public class Learning {

	/*
	 * Konstante Werte
	 */
	public static int DOT = 0;
	public static int COMMA = 1;
	public static int EXCLAMATION = 2;
	public static int BRACK = 3;
	public static int QUESTION = 4;
	public static int CITE = 5;
	public static int NUMBER_WITH_DOT = 6;
	public static int WORDS = 7;
	public static int NL = 8;
	public static int NUMBER_REST = 9;
	public static int NUMBER_FOUR = 10;
	public static int SENTENCE_LENGHT = 11;
	public static int PAST = 12;
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		File[] trainFilme = new File("Datensatz_1_2015-12-14/Filme/Training/").listFiles();
		File[] trainNachrichten = new File("Datensatz_1_2015-12-14/Nachrichten/Training/").listFiles();
		File fCsv = new File("Auswertung/Film.csv");
		File nCsv = new File("Auswertung/Nachrichten.csv");
		if(fCsv.exists()) {
			fCsv.delete();
		}
		if(nCsv.exists()) {
			nCsv.delete();
		}
		makeUeberschriften("Auswertung/Film.csv");
		makeUeberschriften("Auswertung/Nachrichten.csv");
		
		texteEinlesen(trainFilme, "Film");
		texteEinlesen(trainNachrichten, "Nachrichten");
		
	}
	
	/*
	 * anzahlNebens�tze;DOT;KOM;AUS;BRACK;RBRACK;QUES;CITE;NUMBERwithDOT;WORD;NL;NUMBERrest;NUMBERfour;Satzl�nge;Vergangenheit
	 * INDEX: anzahlNebens�tze=0;DOT=1;KOM=2;AUS=3;BRACK=4;RBRACK=5;QUES=6;CITE=7;NUMBERwithDOT=8;WORD=9;NL=10;NUMBERrest=11;NUMBERfour=12;Satzl�nge=13;Vergangenheit=14
	 */
	private static void makeUeberschriften(String csv) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			pw.println("anzahlNebens�tze;DOT;KOM;AUS;BRACK;RBRACK;QUES;CITE;NUMBERwithDOT;WORD;NL;NUMBERrest;NUMBERfour;Satzl�nge;Vergangenheit");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void texteEinlesen(File[] texte, String name) {
		CharStream input = null;
		BufferedReader reader;
		for (int i = 0; i < texte.length; i++) {
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(texte[i])));
				input = new ANTLRInputStream(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SyntaxLexer lexer = new SyntaxLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SyntaxParser parser = new SyntaxParser(tokens);
			ParseTree tree = parser.stat();
			Visitor visitor = new Visitor();
			visitor.visit(tree);
			Analyse ana = new Analyse(visitor.getCountSymbols());
			ana.saveToCSV("Auswertung/" + name);
		}
	}
	
}