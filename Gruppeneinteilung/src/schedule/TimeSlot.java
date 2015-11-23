package schedule;

import java.io.Serializable;

/**
 * Eine Klasse fuer einen Time Slot
 * @author Erik und Simon
 *
 */
public final class TimeSlot implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Position im Zeitstrahl dieses Slots
	 */
	private int pos;
	
	/**
	 * Konstruktor	 
	 * @param pos Position des Slots in Zeitstrahl
	 */
	public TimeSlot(int pos){
		this.pos = pos;		
	}
		
	@Override
	public String toString(){
		return "Zeitslot: "+pos;
	}
}
