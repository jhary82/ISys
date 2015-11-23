package schedule;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

/**
 * Eine Klasse für die Gruppe von Studenten
 * @author Erik und Simon
 *
 */
public final class Group implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * Gruppengroesse 
	 */
	private int groupSize;
	
	/**
	 * Das Fach der Gruppe
	 */
	private Subject subject;
	
	/**
	 * Konstruktor
	 * @param nr
	 * @param groupSize
	 * @param subject
	 */
	public Group(int nr, int groupSize, Subject subject){
		students = new LinkedList<>();
		this.groupNr = nr;
		this.groupSize = groupSize;
		this.subject = subject;
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
	 * Gibt die Anzahl der teilnehmenden Studierenden zurueck
	 * @return
	 */
	public int countStudents(){
		return students.size();
	}
	
	/**
	 * Gibt den TimeSlot zurueck
	 * @return the timeSlot
	 */
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	/**
	 * Ueberprueft ob die Gruppe voll ist
	 * @return true, wenn Gruppe voll ist
	 */
	public boolean isFull(){
		return (students.size() == groupSize);
	}
	
	/**
	 * Fuegt einen Student zur Gruppe hinzu
	 * @param stud
	 */
	public boolean addStudent(Student stud){		
		/*
		 * reservierte Zeitslots
		 */
		List<TimeSlot> slots = stud.getReservedTimeSlots();
				
		/*
		 * suche eine Gruppe mit sich nicht Ueberschneidenden Zeitslot 
		 */
		boolean reserved = false;		
		/*
		 * Ueberpruefe, ob slot schon belegt wurde
		 */
		for(TimeSlot reservedSlot: slots){
			if( reservedSlot == this.timeSlot){
				reserved = true;
			}
		}
		if( !reserved && !this.isFull() ){
			students.add(stud);
			stud.addGroup( this );				
			return true;  
		}			
		
		
		return false;
	}
	
	/**
	 * Loescht den Uebergebenden Studenten aus Gruppe
	 * @param stud
	 * @return true, wenn Student erfolgreich geloescht wurde
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
	 * Setzt den Timeslot
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * Gibt die Liste aller Studenten zurueck
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Gibt das Fach zurueck
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

}
