/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;

/**
 * @author skrause
 *
 */
public final class Group {
	
	/**
	 * Liste der teilnehmenden Studierenden
	 * mit Student.id als Index
	 */
	private List<Integer> students;
	
	
	
	/**
	 * Konstruktor
	 */
	public Group(){
		students = new LinkedList<>();
	}
	
	
}
