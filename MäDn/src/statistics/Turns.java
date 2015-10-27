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
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			pw.print("isWon;countHitChances;countComingOut;turnCount;countSubStrategies;");
			int countSub = turns.get(actTurn).getCountSubStrategy().size();
			for(int i = 1; i <= countSub; i++){
				pw.print(";"+i);
			}
			pw.println();
			for(Turn t : turns){ 
				pw.print(t.isWon()?"1;":"0;");
				pw.print(t.getCountHitChances()+";");
				pw.print(t.getCountComingOut()+";");
				pw.print(t.getTurnCount());
				for(int value: t.getCountSubStrategy()){
					pw.print(";"+value);
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
	 * Addiert 1 zu Anzahl Benutzung von Unterstrategie
	 * @param value
	 */
	public void addToSubStrategy(int value){
		if(value > -1 && value < turns.get(actTurn).getCountSubStrategy().size() ){
			turns.get(actTurn).addCountSubStrategy(value);
		}
	}
	
	
}
