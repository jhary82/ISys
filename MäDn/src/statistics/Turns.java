/**
 * 
 */
package statistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Sammelt und speichert statistische Daten über eine Liste von Runden.
 * @author Simon
 *
 */
public class Turns {
	
	/*
	 * Zähler für die maximale Anzahl an Runde in einem Spiel
	 */
	private static int maxTurnCount = 0;
	
	/*
	 * die aktuelle Runde
	 */
	private int actTurn;
	
	/*
	 * Liste aller Runden
	 */
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
		int size = turns.get(actTurn).getTurnValue().size();
		setMaxTurnCount(size);
		turns.get(actTurn).setMyTurnCount( size );
		actTurn++;
		turns.add(new Turn());
	}
		
	/**
	 * Speichert die gesammelten statistischen Daten in eine CSV-Datei ab
	 * @param name der Name der CSV-Datei, Zeitstempel wird automatisch angehangen
	 */
	public void saveToCSV(String name){
		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");*/
		File csv = new File(name+".csv");
		// speichere in CSV-Datei ab
		  try {			
			PrintWriter pw = new PrintWriter(new FileWriter(csv, false));
			pw.print("isWon;countHitChances;countComingOut;turnCount;myTurnCount");
			for(int i = 0; i < getMaxTurnCount(); i++){
				pw.print(";"+i);
			}
			pw.println();
			
			for(Turn t : turns){ 
				pw.print(t.isWon()?"1;":"0;");
				pw.print(t.getCountHitChances()+";");
				pw.print(t.getCountComingOut()+";");
				pw.print(t.getTurnCount()+";");
				pw.print(t.getMyTurnCount());
				List<Integer> list = t.getTurnValue();
				for(int i = 0; i < t.getMyTurnCount(); i++){
					pw.print(";"+ list.get(i));	
				}		
				pw.println();
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
	 * Setze den ermittelten Spielwert für aktuellen Turn.
	 * Der ermittelte Spielwert ergibt sich aus: (alle Tokenwerte / 4).
	 * @param value
	 */
	public void setTurnValue(int value){
		turns.get(actTurn).addTurnValue(value);
	}
	
	/**
	 * Setze Anzahl der Runden
	 * @param tC
	 */
	public void setTurnCount(int tC){		
		turns.get(actTurn).setTurnCount(tC);
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
	
	/**
	 * Gibt die bisher angetroffene maximale Anzahl an Runden eines Spiels zurück
	 * @return
	 */
	public static int getMaxTurnCount(){
		return maxTurnCount;
	}
	
	/**
	 * Setzt die bisher angetroffene maximale Anzahl an Runden eines Spiels
	 * @param value
	 */
	public static void setMaxTurnCount(int value){
		if(value > maxTurnCount){
			maxTurnCount = value;
		}
	}		
}
