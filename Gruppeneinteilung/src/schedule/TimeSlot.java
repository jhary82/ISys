/**
 * 
 */
package schedule;

/**
 * @author skrause
 *
 */
public final class TimeSlot {
	
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
	
}
