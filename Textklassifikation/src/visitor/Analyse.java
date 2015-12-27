/**
 * 
 */
package visitor;

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
		- Zahlenfolgen vierstellig und sonstige						fertig
		- Satzl�nge, wieviele W�rter pro Satz						fertig
		- Wieviele Nebens�tze ( Anzahl , zwischen zwei Punkten)		fertig
		- und wenn Du Lust hast, noch die typischen Vergangen- und
		Gegenwartsendungen
	 */
	private void berechne() {
		int anzahlZitate = counts.get(7)/2; //Anzahl Zitate
		int anzahlNebens�tze = counts.get(1)/counts.get(2); // Durchschnittliche Nebens�tze im Satz.
		int satzl�nge = counts.get(9)/counts.get(1);	// Satzl�nge, wieviele W�rter pro Satz.
		counts.set(0, anzahlNebens�tze); 
		counts.set(7, anzahlZitate);
		counts.set(13, satzl�nge);
	}
	
	public void saveToCSV(String name){
		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");*/
		File csv = new File(name+".csv");
		// speichere in CSV-Datei ab
		  try {			
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			for (int i = 0; i < counts.size()-1; i++) {
				pw.print(counts.get(i)+";");
			}
			pw.print(counts.get(counts.size()-1));
			pw.println();
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
