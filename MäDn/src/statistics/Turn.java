/**
 * 
 */
package statistics;

/**
 * Speichert für eine Runde statistische Daten
 * @author simon
 *
 */
public class Turn {

	private boolean won;
	private int countHitChances;
	private int countTokenInHome;
	private int countTokenInStart;
	private int countComingOut;
	private int turnCount;
	
	/**
	 * Konstruktor
	 */
	public Turn(){
		
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
	 * @return the countTokenInHome
	 */
	public int getCountTokenInHome() {
		return countTokenInHome;
	}

	/**
	 * @param countTokenInHome the countTokenInHome to set
	 */
	public void setCountTokenInHome(int countTokenInHome) {
		this.countTokenInHome = countTokenInHome;
	}

	/**
	 * @return the countTokenInStart
	 */
	public int getCountTokenInStart() {
		return countTokenInStart;
	}

	/**
	 * @param countTokenInStart the countTokenInStart to set
	 */
	public void setCountTokenInStart(int countTokenInStart) {
		this.countTokenInStart = countTokenInStart;
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
	
}
