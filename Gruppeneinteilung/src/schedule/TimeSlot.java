/**
 * 
 */
package schedule;

import java.io.Serializable;

/**
 * @author skrause
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
	
	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}
	
	@Override
	public String toString(){
		return "Zeitslot: "+pos;
	}
}
