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

import java.util.LinkedList;
import java.util.List;

import listener.AnalysisListener;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import syntaxAnalyse.SyntaxLexer;
import syntaxAnalyse.SyntaxParser;

/**
 * @author Erik und Simon
 *
 */
public class Learning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File[] trainFilme = new File("Datensatz_1_2015-12-14/Filme/Training/")
				.listFiles();
		File[] trainNachrichten = new File(
				"Datensatz_1_2015-12-14/Nachrichten/Training/").listFiles();
		File fCsv = new File("Auswertung/Film.csv");
		File nCsv = new File("Auswertung/Nachrichten.csv");
		if (fCsv.exists()) {
			fCsv.delete();
		}
		if (nCsv.exists()) {
			nCsv.delete();
		}
		makeUeberschriften("Auswertung/Film.csv");
		makeUeberschriften("Auswertung/Nachrichten.csv");

		texteEinlesen(trainFilme, "Auswertung/Film");
		texteEinlesen(trainNachrichten, "Auswertung/Nachrichten");

	}

	/*
	 * anzahlNebens�tze;DOT;KOM;AUS;BRACK;RBRACK;QUES;CITE;NUMBERwithDOT;WORD;NL;
	 * NUMBERrest;NUMBERfour;Satzl�nge;Vergangenheit INDEX:
	 * anzahlNebens�tze=0;DOT
	 * =1;KOM=2;AUS=3;BRACK=4;RBRACK=5;QUES=6;CITE=7;NUMBERwithDOT
	 * =8;WORD=9;NL=10;NUMBERrest=11;NUMBERfour=12;Satzl�nge=13;Vergangenheit=14
	 */
	private static void makeUeberschriften(String csv) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			pw.println("DOT;COMMA;EXCLAMATION;BRACK;QUESTION;CITE;NUMBER_WITH_DOT;WORDS;NL;NUMBER_REST;NUMBER_FOUR;SENTENCE_LENGTH_AVG;PAST;SUB_SENTENCES");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void texteEinlesen(File[] texte, String name) {
		CharStream input = null;
		BufferedReader reader;
		for (int i = 0; i < texte.length; i++) {
			try {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(texte[i])));
				input = new ANTLRInputStream(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SyntaxLexer lexer = new SyntaxLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SyntaxParser parser = new SyntaxParser(tokens);
			ParseTree tree = parser.stat();

			ParseTreeWalker walker = new ParseTreeWalker(); // create standard
															// walker
			List<Integer> list = new LinkedList<>();
			AnalysisListener extractor = new AnalysisListener(list);
			walker.walk(extractor, tree);			
			
			saveToCSV( name, list);
		}
	}

	public static void saveToCSV(String name, List<Integer> counts) {
		File csv = new File(name + ".csv");
		// speichere in CSV-Datei ab
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			for (int i = 0; i < counts.size() - 1; i++) {
				pw.print(counts.get(i) + ";");
			}
			pw.print(counts.get(counts.size() - 1));
			pw.println();
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
