/**
 * 
 */
package schedule;

import java.util.List;
import java.util.PriorityQueue;

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
	 * Grenzwert für Local Beam Search
	 */
	private int limit;
	
	/**
	 * Konstruktor
	 * @param solutions 
	 * 
	 */
	public ChangeTasks(List<Solution> solutions) {
		this.solutions = solutions;
		this.limit = solutions.size();
	}
	
	/**
	 * Berechnet den "besten" Lösungsraum
	 * mit Local Beam Search
	 * @return
	 */
	public Solution getBestSolution() {
		Solution sol = new Solution();
		PriorityQueue<ChangeTask> pq = new PriorityQueue<>();
		/*
		 * Maximaler SolutionValue zum Start
		 */
		double maxValue = 0.0;
		for(Solution solution : this.solutions ){
			if( solution.getValue() > maxValue){
				maxValue = solution.getValue();
			}
		}
		
		/*
		 * Schleife bis "beste" Lösung gefunden
		 */
		while( !pq.isEmpty() && maxValue < pq.peek().getSolution().getValue()){
			/*
			 * berechne für jede Solution die Liste von möglichen Änderungen
		 	*/
			for(Solution solution : this.solutions ){
				pq.addAll( solution.getChangeTaskList() );
			}
			
			this.solutions.clear();
			/*
			 * füge ersten x-Solutions zu neuen StartSolutions hinzu
			 */
			for(int i = 0; i < limit; i++){
				this.solutions.add( pq.poll().getSolution() );
			}
		}
		
		
		return sol;
	}

}
