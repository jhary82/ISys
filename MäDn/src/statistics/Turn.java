/**
 * 
 */
package statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Speichert fuer eine Runde statistische Daten
 * @author Simon
 *
 */
public class Turn {

	/*
	 * Konstante für Anzahl der Unterstrategien
	 */
	private int subStrategies = 6;
	
	private boolean won;
	private int countHitChances;	
	private int countComingOut;
	private int turnCount;
	private List<Integer> countSubStrategy;
	private int maxExecuteSubStrategy = 0;
	

	/**
	 * Konstruktor
	 */
	public Turn(){		
		this.countSubStrategy = new ArrayList<>();
		for(int i = 0; i < subStrategies; i++){
			this.countSubStrategy.add(0); 
		}
	}

	/**
	 * @return the won
	 */
	public boolean isWon() {
		return won;
	}

	/**
	 * @param won the won to set
	 */
	public void setWon(boolean won) {
		this.won = won;
	}

	/**
	 * @return the countHitChances
	 */
	public int getCountHitChances() {
		return countHitChances;
	}

	/**
	 * @param countHitChances the countHitChances to set
	 */
	public void setCountHitChances(int countHitChances) {
		this.countHitChances = countHitChances;
	}
	/**
	 * @return the countComingOut
	 */
	public int getCountComingOut() {
		return countComingOut;
	}

	/**
	 * @param countComingOut the countComingOut to set
	 */
	public void setCountComingOut(int countComingOut) {
		this.countComingOut = countComingOut;
	}

	/**
	 * @return the turnCount
	 */
	public int getTurnCount() {
		return turnCount;
	}

	/**
	 * @param turnCount the turnCount to set
	 */
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

	/**
	 * @return the countSubStrategy
	 */
	public List<Integer> getCountSubStrategy() {
		return countSubStrategy;
	}

	/**
	 * Zaehlt eins hoch an Position f�r countSubStrategy
	 * @param pos
	 */
	public void addCountSubStrategy(int pos) {	
		pos--;
		this.countSubStrategy.set(pos, this.countSubStrategy.get(pos) + 1);
	}

	/**
	 * @return the maxExecuteSubStrategy
	 */
	public int getMaxExecuteSubStrategy() {
		return maxExecuteSubStrategy;
	}

	/**
	 * Fügt 1 zu maxExecuteSubStrategy hinzu
	 */
	public void addMaxExecuteSubStrategy() {
		this.maxExecuteSubStrategy = maxExecuteSubStrategy + 1;
	}

}
