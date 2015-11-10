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
	 */
	private List<Student> students;
	
	/**
	 * Groupnummer
	 */
	private int groupNr;
	
	/**
	 * der verwendete TimeSlot;
	 */
	private TimeSlot timeSlot;
	

	/**
	 * Konstruktor
	 */
	public Group(int nr){
		students = new LinkedList<>();
		this.groupNr = nr;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		
		str.append( "Gruppe Nr.: ");
		str.append(groupNr);
		str.append(" mit ");
		str.append(students.size());
		str.append(" Teilnehmern am Termin: ");
		str.append(timeSlot);
		str.append("\n");
		
		for(Student stud : students){
			str.append(stud);
			str.append("\n");
		}
		
		return str.toString();
	}
	
	/**
	 * @return the timeSlot
	 */
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
}
