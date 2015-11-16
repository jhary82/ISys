/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;

/**
 * @author simon
 *
 */
public final class Subject {
	
	/**
	 * Name des Fachs 
	 */
	private String name;
		
	/**
	 * Liste der Gruppen
	 */
	private List<Group> groups;
	
	/**
	 * Gruppengröße
	 */
	private int groupSize;
	
	/**
	 * Konstruktor
	 * @param name Name
	 * @param gs groupSize
	 */
	public Subject(String name, int gs){
		this.groupSize = gs;	
		this.name = name;
		groups = new LinkedList<>();
	}
	
	/**
	 * Setzt die Anzahl der teilnehmenden Studierenden
	 * und gibt die benötigte Anzahl der Gruppen zurück
	 * @param value
	 * @return
	 */
	public int setCountStudents(int value){		
		int size = (value / groupSize) + ( value % groupSize != 0? 1 : 0);
		
		/*
		 * Erzeuge neue leere Gruppen
		 */
		groups.clear();
		for( int i = 0; i < size; i++){
			groups.add( new Group(i, groupSize, this) );
		}
		
		return size;
	}
	
	/**
	 * Gibt die Anzahl der Gruppen zurück
	 * @return
	 */
	public int getGroupCount(){
		return groups.size();
	}
	
	/**
	 * Gibt die Gruppen zurück
	 * @return
	 */
	public List<Group> getGroups(){
		return groups;
	}
	
	/**
	 * Gibt Namen zurück
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		
		str.append("Fach: ");
		str.append(name);
		str.append(" mit ");
		int countStudents = 0;
		for(Group g : groups){
			countStudents += g.countStudents();
		}
		str.append(countStudents);
		str.append(" Teilnehmern\n");
		
		for(Group g: groups){
			str.append(g.toString());
		}
		
		return str.toString();
	}
	
	/**
	 * Fügt einen TimeSlot zu einer Gruppe hinzu
	 * @param slot 
	 * @return false, wenn kein Slot mehr hinzugefügt werden konnte
	 */
	public boolean addTimeSlot(TimeSlot slot){		
		
		for(Group grp: groups){
			if( grp.getTimeSlot() == null){
				grp.setTimeSlot(slot);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Fügt einen Studierenden zu einer ihm passenden Gruppe hinzu 
	 * @param stud
	 * @return false, wenn keine passende Gruppe gefunden
	 */
	public boolean addStudentToGroup(Student stud){
		/*
		 * reservierte Zeitslots
		 */
		List<TimeSlot> slots = stud.getReservedTimeSlots();
				
		/*
		 * suche eine Gruppe mit sich nicht überschneidenden Zeitslot 
		 */
		for(int i = 0; i < this.groups.size(); i++){
			Group grp = groups.get(i);
			boolean reserved = false;
			TimeSlot slot = grp.getTimeSlot();
			/*
			 * Überprüfe, ob slot schon belegt wurde
			 */
			for(TimeSlot reservedSlot: slots){
				if( reservedSlot == slot){
					reserved = true;
				}
			}
			if( !reserved && !grp.isFull() ){
				grp.addStudent(stud);
				stud.addGroup( grp );				
				return true;  
			}			
		}
		
		return false;
	}
	
	/**
	 * Löscht einen Studierenden aus Gruppe
	 * @param stud
	 * @return true, wenn herausgelöscht
	 */
	public boolean delStudent(Student stud){
		for(Group grp : groups){
			if(grp.delStudent(stud)){
				stud.delGroup(grp);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the groupSize
	 */
	public int getGroupSize() {
		return groupSize;
	}

}
