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
	 * Gruppengröße 
	 */
	private int groupSize;
	
	/**
	 * Konstruktor
	 */
	public Group(int nr, int groupSize){
		students = new LinkedList<>();
		this.groupNr = nr;
		this.groupSize = groupSize;
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
			str.append(stud.toString());
			str.append(", ");
		}
		str.append("\n");
		
		return str.toString();
	}
	
	/**
	 * Gibt die Anzahl der teilnehmenden Studierenden zurück
	 * @return
	 */
	public int countStudents(){
		return students.size();
	}
	
	/**
	 * @return the timeSlot
	 */
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	/**
	 * 
	 * @return true, wenn Gruppe voll ist
	 */
	public boolean isFull(){
		return (students.size() == groupSize);
	}
	
	/**
	 * Fügt einen Student zur Gruppe hinzu
	 * @param stud
	 */
	public void addStudent(Student stud){
		students.add(stud);
	}
	
	/**
	 * Löscht den übergebenden Studenten aus Gruppe
	 * @param stud
	 * @return true, wenn Student erfolgreich gelöscht wurde
	 */
	public boolean delStudent(Student stud){
		for(int i = 0; i < students.size(); i++){
			Student s = students.get(i);
			if( s == stud){
				students.remove(i);				
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	
}
