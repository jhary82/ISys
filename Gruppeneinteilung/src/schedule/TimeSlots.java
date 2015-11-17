/**
 * 
 */
package schedule;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author skrause
 *
 */
public final class TimeSlots implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * erweitert die Anzahl der TimeSlots, wenn nötig
	 * @param pos
	 * @return
	 */
	public TimeSlot getSlots(int pos) {
		if( pos >= slots.size()){
			for(int i = slots.size(); i <= pos; i++){
				slots.add( new TimeSlot(i) );
			}
		}
		return slots.get(pos);
	}
}
