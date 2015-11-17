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
public class Solution implements Cloneable{

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
				for(Student stud : grp.getStudents()){
					value += stud.rateGroup(grp, this.preferences);
				}
			}
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
				for(Student fromStudent: fromGroup.getStudents()){
					/*
					 * für alle anderen Gruppen und deren Studierenden
					 */
					for(Group toGroup : sub.getGroups()){
						if( toGroup == fromGroup){
							continue;
						}
						else{
							for(Student toStudent: toGroup.getStudents()){
								if(toStudent == fromStudent){
									continue;
								}
								else{
									double value = canChange(fromStudent, fromGroup, toStudent, toStudent.getGroup(sub));
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
		double oldValue = this.getValue();
		double newValue = 0.0;
		/*
		 * lösche beide Studierenden raus
		 */
		fromStudent.delGroup(fromGroup);
		fromGroup.delStudent(fromStudent);
		toStudent.delGroup(toGroup);
		toGroup.delStudent(toStudent);
		/*
		 * Überprüfe, ob Einfügen möglich ist und berechne newValue
		 */
		if( fromGroup.addStudent(toStudent) ){
			if(toGroup.addStudent(fromStudent)){
				newValue = this.getValue();
				/*
				 * mache Tausch rückgängig
				 */
				fromStudent.delGroup(toGroup);
				fromGroup.delStudent(toStudent);
				toStudent.delGroup(fromGroup);
				toGroup.delStudent(fromStudent);
				return newValue - oldValue;
			}
			else{
				toStudent.delGroup(fromGroup);
				fromGroup.delStudent(toStudent);
				return 0.0;
			}			
		}
		else {
			return 0.0;
		}		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
