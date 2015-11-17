/**
 * 
 */
package schedule;

import java.io.Serializable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author skrause
 *
 */
public final class ChangeTasks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 *  Berechnet den "besten" Lösungsraum
	 * mit Local Beam Search
	 * @param pref Präferenzen der Studierenden
	 * @return
	 */
	public Solution getBestSolution() {		
		PriorityQueue<ChangeTask> pq = new PriorityQueue<>();
		/*
		 * Abbruchwert,
		 * letzter Wert des Lösungsraums
		 */
		double lastValue = 0.0;
		Solution lastSolution = null;
				
		/*
		 * Schleife bis "beste" Lösung gefunden
		 */
		do{			
			lastValue = solutions.get(0).getValue();
			lastSolution = solutions.get(0);
			/*
			 * leere PriorityQueue
			 */
			pq.clear();			
			/*
			 * berechne für jede Solution die Liste von möglichen Änderungen
		 	*/
			for(Solution solution : this.solutions ){
				pq.addAll( solution.getChangeTaskList() );
			}
			//System.out.println("pq.size = " + pq.size()); TODO Raum möglicher Änderungen für DEBUG-Zwecke
			/*
			 * sollte keine Änderungsliste erstellt werden können, nehme eine der vorhandenen Lösungsräume
			 */
			if( pq.isEmpty() ){
				return solutions.get(new Random().nextInt(solutions.size()));
			}
			
			this.solutions.clear();
			/*
			 * Führe ersten x-ChangeTasks aus und 
			 * füge deren Solutions zu neuen StartSolutions hinzu
			 */
			for(int i = 0; i < limit; i++){
				ChangeTask task = pq.poll();
				task.execute();
				this.solutions.add( (Solution) task.getSolution().copy() );
			}
			System.out.println(lastValue+" > "+ solutions.get(0).getValue()+ "?");			
		}while( lastValue < solutions.get(0).getValue() );
				
		return lastSolution;
	}

}
