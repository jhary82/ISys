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
 * Mit dieser Klasse arbeitet auf den Trainingsdaten und extrahiert die
 * Merkmalsauspraegungen in eine CSV-Datei.
 * @author Simon und Erik
 */
public class Learning {

	/**
	 * Programmstart - Hier werden die Trainingdaten eingelesen und die CSV-Datein vorbereitet.
	 * @param args - ohne Parameter
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
	
	/**
	 * Mit dieser Methode wird in der CSV-Datei in der ersten Zeile eine Überschrift hinzugefügt.
	 * @param csv - Name der CSV-Datei
	 */
	private static void makeUeberschriften(String csv) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			pw.println("DOT;COMMA;BRACK;QUESTION;CITE;NUMBER_WITH_DOT;"
					+ "NL;NUMBER_REST;NUMBER_FOUR;SENTENCE_LENGTH_AVG;"
					+ "SUB_SENTENCES;PAST;NOUN;SENTENCE_LENGTH_MAX;"
					+ "WORD_LENGTH_3;WORD_LENGTH_4;"
					+ "WORD_LENGTH_5;WORD_LENGTH_6;WORD_LENGTH_7;WORD_LENGTH_8;"
					+ "NOUN_LENGTH_3;NOUN_LENGTH_4;NOUN_LENGTH_5;NOUN_LENGTH_6;"
					+ "NOUN_LENGTH_7;NOUN_LENGTH_8");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Mit dieser Methode werden die Merkmale aus den Texte herausgelesen und in eine CSV-Datei gespeichert.
	 * @param texte - Eine Liste von Texten die Analysiert werden sollen.
	 * @param name - Name der CSV-Datei.
	 */
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

			saveToCSV(name, list);
		}
	}
	
	/**
	 * Mit dieser Methode werden die Merkmale in eine CSV-Datei gespeichert.
	 * @param name - Name der CSV-Datei
	 * @param counts - Liste mit den analysierten Merkmalen
	 */
	private static void saveToCSV(String name, List<Integer> counts) {
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
