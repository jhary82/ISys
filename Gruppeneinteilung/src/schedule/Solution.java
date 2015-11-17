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
public class Solution {

	/**
	 * Alle Studierenden
	 */
	private List<Student> students;
	
	/**
	 * Alle Fächer
	 */
	private List<Subject> subjects;
	
	/**
	 * 
	 */
	public Solution() {
		students = new LinkedList<>();
		subjects = new LinkedList<>();
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
		// TODO anpassen
		return 0.0;
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
									if( canChange( fromStudent, toStudent) ){
										double value = calculateChangeValue( fromStudent, toStudent);
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
	 * Berechnet für das StudentenTupel die Veränderung des Lösungsraumswerts
	 * @param stud
	 * @param oneOfAll
	 * @return
	 */
	private double calculateChangeValue(Student stud, Student oneOfAll) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	/**
	 * 	Berechnet, ob für die Kombination von Studenten ein Tausch möglich ist
	 * @param stud
	 * @param oneOfAll
	 * @return
	 */
	private boolean canChange(Student stud, Student oneOfAll) {
		// TODO Auto-generated method stub
		return false;
	}
}
