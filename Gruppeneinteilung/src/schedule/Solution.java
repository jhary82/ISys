/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @author skrause
 *
 */
public final class Solution implements Cloneable{

	/**
	 * Alle Studierenden
	 */
	private List<Student> students;
	
	/**
	 * Alle Fächer
	 */
	private List<Subject> subjects;
		
	/**
	 * Matrix von den Pr�ferenzen von Studenten
	 */
	private double[][] preferences;
	
	/**
	 * Konstruktor
	 * @param pref Präferenzen der Studierenden
	 */
	public Solution(double[][] pref) {
		students = new LinkedList<>();
		subjects = new LinkedList<>();
		this.preferences = pref;
	}
	
	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Subject sub : subjects){			
			str.append(sub);
		}
		return str.toString();
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	/**
	 * Berechnet den Wert dieses Lösungsraums aus
	 * @return
	 */
	public double getValue(){
		double value = 0.0;
		for(Subject sub: this.subjects){
			for(Group grp: sub.getGroups()){
				value += getGroupValue(grp);
			}
		}
		return value;
	}
	
	/**
	 * Berechnet den Wert einer Gruppe aus
	 * @param grp
	 * @return
	 */
	private double getGroupValue(Group grp){
		double value = 0.0;
		for(Student stud : grp.getStudents()){
			value += stud.rateGroup(grp, this.preferences);
		}
		return value;
	}

	/**
	 * Gibt eine Liste aller möglichen Tausch-Möglichkeiten zurück
	 * @return
	 */
	public PriorityQueue<ChangeTask> getChangeTaskList() {
		PriorityQueue<ChangeTask> pq = new PriorityQueue<>();
		
		/*
		 * für alle Fächer
		 */
		for( Subject sub : this.subjects ){
			/*
			 * für alle Gruppen
			 */
			for( Group fromGroup : sub.getGroups()){
				/*
				 * für Studierende der Gruppe
				 */
				for(int i = 0; i < fromGroup.getStudents().size(); i++){
					Student fromStudent = fromGroup.getStudents().get(i);
					/*
					 * für alle anderen Gruppen und deren Studierenden
					 */
					for(Group toGroup : sub.getGroups()){
						if( toGroup != fromGroup){							
							for(Student toStudent: toGroup.getStudents()){
								if(toStudent != fromStudent){
									double value = canChange((Student)fromStudent, (Group)fromGroup, (Student)toStudent, (Group)toStudent.getGroup(sub));									
									if( value != 0.0 ){										
										pq.add( new ChangeTask(fromStudent, fromGroup, toStudent, toStudent.getGroup(sub), this, value) );
									} 
								}
							}
						}
					}
				}
			}
		}
		
		return pq;
	}

	/**
	 * Berechnet, ob für die Kombination von Studenten ein Tausch möglich ist
	 * und Berechnet für das StudentenTupel die Veränderung des Lösungsraumswerts
	 * @param fromStudent
	 * @param toStudent
	 * @param fromGroup
	 * @param toGroup
	 * @return 0.0, wenn kein Tausch möglich
	 */
	private double canChange(Student fromStudent, Group fromGroup, Student toStudent, Group toGroup) {
		/*
		 * Überprüfe, ob Wechsel möglich ist
		 */
		boolean possible = false;
		for(TimeSlot slot : fromStudent.getReservedTimeSlots()){
			if(slot == fromGroup.getTimeSlot()){
				continue;
			}
			if(slot == toGroup.getTimeSlot()){
				possible = true;
			}
		}
		if( !possible){
			return 0.0;
		}
		
		possible = false;
		for(TimeSlot slot : toStudent.getReservedTimeSlots()){
			if(slot == toGroup.getTimeSlot()){
				continue;
			}
			if(slot == fromGroup.getTimeSlot()){
				possible = true;
			}
		}
		if( !possible ){
			return 0.0;
		} 
		/*
		 * TODO hier weitermachen
		 * Erstelle Dummy-Grps für Berechnung der "neuen" Werte
		 */
		double fromValue = this.getGroupValue(fromGroup);
		double toValue = this.getGroupValue(toGroup);
		
		
		return 0.0;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
