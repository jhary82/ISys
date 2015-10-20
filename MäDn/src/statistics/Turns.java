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
			pw.println("isWon;countHitChances;countTokenInHome;countTokenInStart;countComingOut;turnCount");
			for(Turn t : turns){ 
				pw.print(t.isWon()?"1;":"0;");
				pw.print(t.getCountHitChances()+";");
				pw.print(t.getCountTokenInHome()+";");
				pw.print(t.getCountTokenInStart()+";");
				pw.print(t.getCountComingOut()+";");
				pw.print(t.getTurnCount()+"\n");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Setze, ob gewonnen wurde oder nicht
	 * @param won
	 */
	public void setWon(boolean won){
		turns.get(actTurn).setWon(won);
	}
	
	/**
	 * Addiere 1 zur Schlagchance hinzu
	 */
	public void addHitChance(){
		Turn tmp = turns.get(actTurn); 
		tmp.setCountHitChances(tmp.getCountHitChances()+1);
	}
	
	/**
	 * Setze Anzahl der Runden
	 * @param tC
	 */
	public void setTurnCount(int tC){		
		turns.get(actTurn).setTurnCount(tC);
	}
	
	/**
	 * Setze die Tokens, die in Home- und Startzone sind
	 * @param inHome
	 * @param inStart
	 */
	public void setPositionCount(int inHome, int inStart){
		Turn tmp = turns.get(actTurn);
		tmp.setCountTokenInHome(inHome);
		tmp.setCountTokenInStart(inStart);
	}

	/**
	 * Loesche den letzten Turn
	 */
	public void delLast() {
		if(!turns.isEmpty()){
			turns.remove(turns.size()-1);
			actTurn--;
		}
		
	}

	/**
	 * Erhoet den Zaehler fuer Tokens, die aus der Startzone herausgezogen wurden
	 */
	public void addMoveOutStart() {
		Turn tmp = turns.get(actTurn); 
		tmp.setCountComingOut( tmp.getCountComingOut() + 1);		
	}
	
}
