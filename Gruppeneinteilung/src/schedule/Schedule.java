/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
	 * @param p
	 */
	public Schedule(Parameters p){
		this.p = p;		
		students = new LinkedList<>();
		subjects = new LinkedList<>();
		
		/*
		 * Aufgabenteil 1
		 */
		addStudSubs();
		calcStudentsChoice();
		calcTimeSlots();
			
		/*
		 * TODO testausgabe alle Gruppen mit Zeitslots
		 */
		for(Subject sub : subjects){			
			System.out.println(sub);
		}
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
		Map<String, Integer> map = new HashMap<>();
		
		for(Student stud: this.students){
			for(Subject sub: stud.getSubjects()){
				Integer value = map.get(sub.getName() );
				if( value == null){
					map.put( sub.getName(), 1);
				}
				else{
					map.put( sub.getName(), value+1);
				}
												
			}			
		}
		
		for(Subject sub: this.subjects){
			Integer value = map.get(sub.getName() );
			sub.setCountStudents( value==null? 0: value );
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
		double faktor = p.getOverlapFactor();
		List<Integer> slots = new LinkedList<>();
		
		/*
		 * aktueller TimeSlot
		 */
		int timePos = 0;
		
		/*
		 * z.B. 
		 * A und B -> min gemeinsame Anzahl an Groups * faktor
		 * A und C
		 * B und C
		 */
		for(int i = 0; i < this.subjects.size() - 1; i++){
			for(int a = i+1; a < this.subjects.size(); a++){
				
				int value = Math.min(subjects.get(i).getGroupCount(), subjects.get(a).getGroupCount());
				
				value *= faktor;
				
				/*
				 * Trage TimeSlots für beide Gruppen ein
				 */
				for(int b = 0; b < value; b++){
					subjects.get(i).addTimeSlot( timeSlots.getSlots(timePos) );
					subjects.get(a).addTimeSlot( timeSlots.getSlots(timePos) );
					timePos++;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
