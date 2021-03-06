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
 * Sammelt und speichert statistische Daten ueber eine Liste von Runden.
 * @author Erik und Simon
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
	 * Fuegt eine neue Runde hinzu
	 */
	public void nextTurn(){
		actTurn++;
		turns.add(new Turn());
	}
		
	/**
	 * Speichert die gesammelten statistischen Daten in eine CSV-Datei ab
	 * @param name der Name der CSV-Datei
	 */
	public void saveToCSV(String name){
		/*String currentTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		File csv = new File(name+"_"+currentTime+".csv");*/
		File csv = new File(name+".csv");
		// speichere in CSV-Datei ab
		  try {			
			PrintWriter pw = new PrintWriter(new FileWriter(csv, false));
			pw.print("isWon;countHitChances;countComingOut;turnCount");
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
				int max = t.getMaxExecuteSubStrategy();
				for(int value: t.getCountSubStrategy()){
					int erg = (int)(((double)value/(double)max)*100);
					pw.print(";"+erg);
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
		turns.get(actTurn).addMaxExecuteSubStrategy();
		turns.get(actTurn).addCountSubStrategy(value);		
	}
	
	
}
