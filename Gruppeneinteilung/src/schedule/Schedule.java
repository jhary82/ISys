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
		 * Aufgabenteil 2 
		 */
		//studToGroupAllocation();
			
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
		/* 
		 * setze Fächer
		 */
		this.subjects = p.getSubjects();
		
		/*
		 * hole Belegungswahscheinlichkeiten
		 */
		List<Integer> prob = new LinkedList<>();
		for(Subject sub: subjects){
			prob.add( p.getProbability(sub) );
		}
		
		/*
		 * setze Fächer/Belegungswahrscheinlichkeiten bei Studierenden ein
		 */
		for( int i = 0; i < p.getCountStudents(); i++){
			students.add( new Student(i, subjects, prob) );
		}		
		
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
		 * alle TimeSlots
		 */
		timeSlots = new TimeSlots(1);
		
		/*
		 * Berechne für alle Gruppenkonstellationen die Anzahl der sich überschneidenden
		 * TmeSlots mit Überschneidungsfaktor
		 */
		double faktor = p.getOverlapFactor();		
		
		/*
		 * aktueller TimeSlot
		 */
		int timePos = 0;
				
		/*
		 * Min gemeinsame Anzahl an Gruppen
		 */
		int minCountGroups = this.subjects.get(0).getGroupCount();
		for(Subject sub: this.subjects){
			if( sub.getGroupCount() < minCountGroups){
				minCountGroups = sub.getGroupCount();
			}
		}
		
		/*
		 * Multiplikation mit Überschneidungsfaktor 
		 */
		minCountGroups *= faktor;
		
		/*
		 * jedes Fach bekommt gemeinsame TimeSlots
		 */
		for(Subject sub: this.subjects){				
				/*
				 * Trage TimeSlots für Gruppe ein
				 */
			for(int i = 0; i < minCountGroups; i++){
				sub.addTimeSlot( timeSlots.getSlots(i));
			}							
		}
		
		timePos = minCountGroups;
		
		/* 
		 * fülle restliche Timeslots auf	 
		 */
		for(Subject sub: subjects) {
			for(Group grp: sub.getGroups()){
				if( grp.getTimeSlot() == null){
					sub.addTimeSlot( timeSlots.getSlots(timePos) );
					timePos++;
				}
			}
		}		
	}
	
	/**
	 * Zuordnung aller Studierenden zu ihren Gruppen
	 * konfliktfrei 
	 */
	private void studToGroupAllocation() {
		
		for(Student stud: this.students){
			for(Subject studSub: stud.getSubjects()){
				if( !studSub.addStudentToGroup(stud) ){
					System.out.println("Konflikt, keine passende Gruppe gefunden.");
					return;
				}
			}
		}
		
	}
	
}
