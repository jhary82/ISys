package schedule;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author simon
 *
 */
public final class Student implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * Konstruktor mit Fächerwahrscheinlichkeiten
	 * @param id
	 * @param subjects
	 * @param prob
	 */
	public Student(int id, List<Subject> subjects, List<Integer> prob){
		this.subjects = new LinkedList<Subject>();		
		groups = new LinkedList<>();
		this.id = id;
		this.setSubjectsByKey(subjects, prob);		
	}
	
	
	/**
	 * Setzt die F�cher nach definierten Schl�sseln
	 * @param p
	 */
	private void setSubjectsByKey(List<Subject> subs, List<Integer> prob ){		
		
		for(int i = 0; i < subs.size(); i++){
			if(Schedule.getRandom().nextInt( 100 ) <= prob.get(i) ){
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
	
	@Override
	public String toString(){
		return ""+id;
	} 

	/**
	 * Gibt die Fächer zurück und
	 * sortiert sie dabei zufällig neu
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {		
		List<Subject> randSub = new LinkedList<>();
				
		while( !subjects.isEmpty() ){						
			randSub.add( subjects.remove(Schedule.getRandom().nextInt(subjects.size()) ) );
		}
		subjects = randSub;
		return randSub;
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

	/**
	 * Löscht den Studierenden aus allen seinen Gruppen 
	 */
	public void delFromAllGroups() {
		for(Group grp : groups){
			grp.delStudent(this);
		}		
		groups.clear();
	}


	/**
	 * Gibt die Gruppe des übergebenden Fachs zurück
	 * @param sub
	 * @return null, wenn keine Gruppe für das Fach definiert
	 */
	public Group getGroup(Subject sub) {
		for( Group grp : groups){
			if( grp.getSubject() == sub){
				return grp;
			}
		}
		return null;
	}


	/**
	 * Berechnet aus der übergebenden Gruppe aus,
	 * wie gern er mit diesen Leuten in dieser Gruppe ist
	 * @param grp
	 * @param preferences
	 * @return
	 */
	public double rateGroup(Group grp, double[][] preferences) {
		double value = 0.0;
		for( Student stud : grp.getStudents()){
			if( stud == this){
				continue;
			}
			else{
				value += preferences[this.id][stud.getId()];
			}
		}
		return value;
	}
		
	
}
