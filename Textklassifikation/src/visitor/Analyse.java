/**
 * 
 */
package visitor;

import static syntaxAnalyse.SyntaxLexer.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Erik
 *
 */
public class Analyse {
	
	private List<Integer> counts = null;
	
	public Analyse(List<Integer> list) {
		this.counts = list;
		berechne();
	}
	/*
	 * 	- Anzahl von ,.!?[( 										fertig
		- Wie viele Zitate? (Anzahl / 2 von " oder >> << ) 			fertig
		- Wie viele Abs�tze gibt es? 								fertig
		- Zahlenfolgen vierstellig und sonstige						
		- Satzl�nge, wieviele W�rter pro Satz						fertig
		- Wieviele Nebens�tze ( Anzahl , zwischen zwei Punkten)		fertig
		- und wenn Du Lust hast, noch die typischen Vergangen- und
		Gegenwartsendungen
	 */
	private void berechne() {
		int anzahlZitate = counts.get(CITE)/2; //Anzahl Zitate
		int anzahlNebens�tze = counts.get(DOT)/counts.get(KOM); // Durchschnittliche Nebens�tze im Satz.
		int satzl�nge = counts.get(WORD)/counts.get(DOT);	// Satzl�nge, wieviele W�rter pro Satz.
		counts.set(0, anzahlNebens�tze); 
		counts.set(CITE, anzahlZitate);
	}
	
	public void saveToCSV(String name){
		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");*/
		File csv = new File(name+".csv");
		// speichere in CSV-Datei ab
		  try {			
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			for (int count : this.counts) {
				pw.print(count+";");
			}
			pw.println();
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
