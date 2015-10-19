/**
 * 
 */
package statistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Sammelt und speichert statistische Daten über eine Liste von Runden.
 * Und wertet diese aus.
 * @author Simon
 *
 */
public class Turns {
	
	private int actTurn;
	
	private List<Turn> turns;
	
	/**
	 * Konstruktor
	 */
	public Turns(){
		turns = new ArrayList<>();
		actTurn = 0;
		turns.add(new Turn());
	}
	
	/**
	 * Fügt eine neue Runde hinzu
	 */
	public void nextTurn(){
		actTurn++;
		turns.add(new Turn());
	}
		
	/**
	 * Speichert die gesammelten statistischen Daten in eine CSV-Datei ab
	 * @param name der Name der CSV-Datei, Zeitstempel wird automatisch angehangen
	 */
	public void saveToCSV(String name){
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");
		// speichere in CSV-Datei ab
		  try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			for(Turn t : turns){
				pw.print(t.isWon()?"1;":"0;");
				pw.print(t.getCountHitChances()+";");
				pw.print(t.getCountTokenInHome()+";");
				pw.print(t.getCountTokenInStart()+";");
				pw.print(t.getCountComingOut()+";");
				pw.print(t.getTurnCount()+";\n");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setWon(boolean won){
		turns.get(actTurn).setWon(won);
	}
	
	public void addHitChance(){
		Turn tmp = turns.get(actTurn); 
		tmp.setCountHitChances(tmp.getCountHitChances()+1);
	}
	
}
