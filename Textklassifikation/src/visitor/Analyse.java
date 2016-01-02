///**
// * 
// */
//package visitor;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
///**
// * @author Erik
// *
// */
//public class Analyse {
//	
//	private List<Integer> counts;
//	private Visitor visitor;
//	
//	public Analyse(List<Integer> list, Visitor visitor) {
//		this.counts = list;
//		this.visitor = visitor;
//		berechne();
//	}
//	/*
//	 * 	- Anzahl von ,.!?[( 										fertig
//		- Wie viele Zitate? (Anzahl / 2 von " oder >> << ) 			fertig
//		- Wie viele Abs�tze gibt es? 								fertig
//		- Zahlenfolgen vierstellig und sonstige						fertig
//		- Satzl�nge, wieviele W�rter pro Satz						fertig
//		- Wieviele Nebens�tze ( Anzahl , zwischen zwei Punkten)		fertig
//		- und wenn Du Lust hast, noch die typischen Vergangen- und
//		Gegenwartsendungen
//	 */
//	private void berechne() {
//		int anzahlZitate = counts.get(visitor.CITE)/2; //Anzahl Zitate
//		int satzlaenge = counts.get(visitor.WORDS)/counts.get(visitor.DOT);	// Satzl�nge, wieviele W�rter pro Satz.
//		counts.set(visitor.CITE, anzahlZitate);
//		counts.set(visitor.SENTENCE_LENGTH, satzlaenge);
//	}
//	
//	public void saveToCSV(String name){
//		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
//		File csv = new File(name+"_"+currentTime+".csv");*/
//		File csv = new File(name+".csv");
//		// speichere in CSV-Datei ab
//		  try {			
//			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
//			for (int i = 0; i < counts.size()-1; i++) {
//				pw.print(counts.get(i)+";");
//			}
//			pw.print(counts.get(counts.size()-1));
//			pw.println();
//			pw.flush();
//			pw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 
//	 * @return gibt die berechneten Haeufigkeiten zurueck
//	 */
//	public List<Integer> getCounts(){
//		return this.counts;
//	}
//	
//}
