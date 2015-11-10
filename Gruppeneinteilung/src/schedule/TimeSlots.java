/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author skrause
 *
 */
public final class TimeSlots {

	/**
	 * Liste der TimeSlots
	 */
	private List<TimeSlot> slots;
	
	/**
	 * Konstruktor
	 * @param max Maximale Anzahl der TimeSlots
	 */
	public TimeSlots(int max){
		
		slots = new LinkedList<>();
		
		for(int i = 0; i < max; i++){
			slots.add( new TimeSlot(i) );
		}
	}

	/**
	 * Gibt den TimeSlot an pos im Zeitstrahl zurück
	 * @param pos
	 * @return
	 */
	public TimeSlot getSlots(int pos) {
		return slots.get(pos);
	}
}
