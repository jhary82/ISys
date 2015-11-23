package schedule;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

/**
 * Eine Wrapper-Klasse fuer die Klasse TimeSlot
 * @author Erik
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
	 * Gibt den TimeSlot an pos im Zeitstrahl zurueck
	 * erweitert die Anzahl der TimeSlots, wenn noetig
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
