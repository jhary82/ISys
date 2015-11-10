/**
 * 
 */
package schedule;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.Parameters;

/**
 * @author simon
 *
 */
public final class Schedule {

	/**
	 * Alle Studierenden
	 */
	private List<Student> students;
	
	/**
	 * Alle Fächer
	 */
	private List<Subject> subjects;
	
	/**
	 * Alle TimeSlots
	 */
	private TimeSlots timeSlots;
	
	/**
	 * Alle Parameter
	 */
	private Parameters p;
	
	/**
	 * Konstruktor
	 */
	public Schedule(){
		p = new Parameters();
		p.load();
		
		addStudSubs();
		calcStudentsChoice();
		calcTimeSlots();
				
	}
	
	/**
	 * Fügt die Studierenden und Fächer hinzu
	 */
	private void addStudSubs(){
		
		for( int i = 0; i < p.getCountStudents(); i++){
			students.add( new Student(p,i) );
		}
		
		this.subjects = p.getSubjects();
	}
	
	/**
	 * Berechnet, auf Basis von welche Studierenden, welche Fächer belegen,
	 * die benötigten Gruppenstärken der einzelnen Fächer
	 */
	private void calcStudentsChoice(){
		Map<Subject, Integer> map = new TreeMap<>();
		
		for(Student stud: this.students){
			for(Subject sub: stud.getSubjects()){
				map.put( sub, map.get(sub) );
			}			
		}
		
		for(Subject sub: this.subjects){
			sub.setCountStudents( map.get(sub) );
		}
	}
	
	/**
	 * Berechnet die max. benötigten TimeSlots und 
	 * erstellt mit Überschneidungsgrad die Gruppentermine
	 */
	private void calcTimeSlots(){
		/*
		 * Anzahl an Gruppen
		 */
		int countGroups = 0;
		for(Subject sub : this.subjects){
			countGroups += sub.getGroupCount();			
		}
		
		/*
		 * setze maximale TimeSlots
		 */
		timeSlots = new TimeSlots(countGroups);
		
		/*
		 * Berechne für alle Gruppenkonstellationen die Anzahl der sich überschneidenden
		 * TmeSlots mit Überschneidungsfaktor
		 */
		

	}
}
