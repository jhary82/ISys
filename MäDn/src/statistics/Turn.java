/**
 * 
 */
package statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Speichert fÃ¼r eine Runde statistische Daten
 * @author Simon
 *
 */
public class Turn {

	private boolean won;
	private int countHitChances;	
	private int countComingOut;
	private int turnCount;
	private List<Integer> countSubStrategy;
	
	/**
	 * Konstruktor
	 */
	public Turn(){		
		this.countSubStrategy = new ArrayList<>();
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
	 * Zählt eins hoch an Position für countSubStrategy
	 * @param pos
	 */
	public void addCountSubStrategy(int pos) {		
		this.countSubStrategy.set(pos, this.countSubStrategy.get(pos) + 1);
	}


}
