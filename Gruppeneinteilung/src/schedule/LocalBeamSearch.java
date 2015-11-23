package schedule;

import java.io.Serializable;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Eine Klasse für den Local Beam Search
 * @author Erik und Simon
 *
 */
public final class LocalBeamSearch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Liste von Loesungsraeumen
	 */
	private List<Solution> solutions;
	
	/**
	 * Grenzwert fuer Local Beam Search
	 */
	private int limit;
	
	/**
	 * Konstruktor
	 * @param solutions 
	 * 
	 */
	public LocalBeamSearch(List<Solution> solutions) {
		this.solutions = solutions;
		this.limit = solutions.size();
	}
	
	/**
	 * Berechnet den "besten" Loesungsraum
	 * mit Local Beam Search
	 * @param pref Praeferenzen der Studierenden
	 * @return
	 */
	public Solution getBestSolution() {
		PriorityQueue<ChangeTask> pq = new PriorityQueue<>();
		
		/*
		 * Abbruchwert,
		 * letzter Wert des Loesungsraums
		 */
		double lastValue = 0.0;
		Solution lastSolution = null;
				
		/*
		 * Schleife bis "beste" Loesung gefunden
		 */
		while( lastValue < solutions.get(0).getValue() ){			
			lastValue = solutions.get(0).getValue();
			lastSolution = solutions.get(0);
			/*
			 * leere PriorityQueue
			 */
			pq.clear();			
			/*
			 * berechne fuer jede Solution die Liste von moeglichen Aenderungen
		 	*/
			for(Solution solution : this.solutions ){
				pq.addAll( solution.getChangeTaskList() );
			}
			System.out.println("pq.size = " + pq.size()); 
			/*
			 * sollte keine Aenderungsliste erstellt werden koennen, nehme eine der vorhandenen Loesungsraeume
			 */
			if( pq.isEmpty() ){
				return solutions.get(Schedule.getRandom().nextInt(solutions.size()));
			}
			
			this.solutions.clear();
			/*
			 * Fuehre ersten x-ChangeTasks aus und 
			 * fuege deren Solutions zu neuen StartSolutions hinzu
			 */
			for(int i = 0; i < limit; i++){
				ChangeTask task = pq.poll();
				task.execute();
				this.solutions.add( (Solution) task.getSolution().copy() );
			}
			System.out.println(lastValue+" > "+ solutions.get(0).getValue());			
		}
				
		return lastSolution;
	}

}
