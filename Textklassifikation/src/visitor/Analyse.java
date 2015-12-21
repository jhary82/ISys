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
	}
	
	public List<Integer> berechneMetriken() {
		berechne();
		return this.counts;
	}
	
	private void berechne() {
		counts.set(0, counts.get(KOM)/counts.get(DOT)); // Durchschnittliche Nebensätze im Satz.
	}
	
	public void saveToCSV(String name){
		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");*/
		File csv = new File(name+".csv");
		// speichere in CSV-Datei ab
		  try {			
			PrintWriter pw = new PrintWriter(new FileWriter(csv, false));
			for (int count : this.counts) {
				pw.print(count+";");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
