package schedule;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author simon
 *
 */
public final class Student {
		
	/**
	 * Matrikelnummer
	 */
	private int id;
	
	/**
	 * Liste der F�cher
	 */
	private List<Subject> subjects;
	
	/**
	 * Liste der belegten Gruppen
	 */
	private List<Group> groups;
	
	/**
	 * Konstruktor
	 * @param p Parameter 
	 * @param id MatriklNr
	 */
	public Student(int id, List<Subject> subjects, List<Integer> prob){
		this.subjects = new LinkedList<Subject>();		
		groups = new LinkedList<>();
		this.setSubjectsByKey(subjects, prob);
	}

	/**
	 * Setzt die F�cher nach definierten Schl�sseln
	 * @param p
	 */
	private void setSubjectsByKey(List<Subject> subs, List<Integer> prob ){		
		
		for(int i = 0; i < subs.size(); i++){
			if( new Random().nextInt( 100 ) <= prob.get(i) ){
				this.subjects.add( subs.get(i) ); 
			}
		}		
		 
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return String.valueOf(id);
	} 

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	/**
	 * Gibt eine Liste mit reservierten TimeSlots zurück
	 * @return
	 */
	public List<TimeSlot> getReservedTimeSlots(){
		List<TimeSlot> slots = new LinkedList<>();
		for(Group g : groups){
			slots.add( g.getTimeSlot() );
		}
		return slots;
	}
	
	/**
	 * Fügt Gruppe hinzu
	 * @param group
	 */
	public void addGroup(Group group){
		groups.add(group);
	}
	
	/**
	 * Löscht die übergebende Gruppe
	 * @param group
	 * @return true, wenn Löschen erfolgreich
	 */
	public boolean delGroup(Group group){
		for(int i = 0; i < groups.size(); i++){
			Group g = groups.get(i);
			if( g == group){
				groups.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
}
