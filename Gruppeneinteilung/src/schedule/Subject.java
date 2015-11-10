/**
 * 
 */
package schedule;

import java.util.List;

import io.Parameters;

/**
 * @author simon
 *
 */
public final class Subject {
	
	/**
	 * Name des Fachs
	 * TODO Name aus JSON eingelesen
	 */
	private String name;
	
	/**
	 * Anzahl der teilnehmenden Studierenden
	 */
	private int countStudents;
	
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
	 * @param groupSize
	 */
	public Subject(Parameters p){
		this.groupSize = p.getGroupSize();		
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
			groups.add( new Group(i) );
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
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		
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
	
}
