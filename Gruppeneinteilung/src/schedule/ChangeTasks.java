/**
 * 
 */
package schedule;

import java.util.List;

/**
 * @author skrause
 *
 */
public class ChangeTasks {

	/**
	 * Liste von Lösungsräumen
	 */
	private List<Solution> solutions;
	
	/**
	 * Konstruktor
	 * @param solutions 
	 * 
	 */
	public ChangeTasks(List<Solution> solutions) {
		this.solutions = solutions;
	}
	
	/**
	 * Berechnet den "besten" Lösungsraum
	 * @return
	 */
	public Solution getBestSolution() {
		Solution sol = new Solution();
		return sol;
	}

}
