/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

import io.Parameters;

/**
 * @author simon
 *
 */
public final class Schedule {
	
	/**
	 * Alle TimeSlots
	 */
	private TimeSlots timeSlots;
	
	/**
	 * Alle Parameter
	 */
	private Parameters p;
	
	/**
	 * Die drei Lösungsräume und EndLösungsraum für Local Beam Search
	 */
	private Solution solA, solB, solC, solExit;
	
	/**
	 * Konstruktor
	 * @param p
	 */
	public Schedule(Parameters p){
		this.p = p;		
		solA = new Solution();
		solB = new Solution();
		solC = new Solution();
		solExit = null;
		
		/*
		 * Aufgabenteil 1
		 */
		addStudSubs(solA);
		calcStudentsChoice(solA);
		calcTimeSlots(solA);
		/*
		 * clone solA -> solB und solC
		 */
		//solB = solA.clone();
		//solC = solA.clone();
		/*
		 * Aufgabenteil 2 
		 */
		studToGroupAllocation(solA);
		/*
		 * Aufgabenteil 3	
		 */
		
		
		/*
		 * Ausgabe alle Gruppen mit Zeitslots
		 */
		System.out.println(solA);
		
	}
	
	/**
	 * Fügt die Studierenden und Fächer hinzu
	 */
	private void addStudSubs(Solution sol){		
		List<Subject> subjects = p.getSubjects();
		List<Student> students = new LinkedList<>();
				
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
		
		/*
		 * fügt Students und Subject zu Solution hinzu
		 */
		sol.setStudents(students);
		sol.setSubjects(subjects);		
	}
	
	/**
	 * Berechnet, auf Basis von welche Studierenden, welche Fächer belegen,
	 * die benötigten Gruppenstärken der einzelnen Fächer
	 */
	private void calcStudentsChoice(Solution sol){
		Map<String, Integer> map = new HashMap<>();
		
		for(Student stud: sol.getStudents()){
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
		
		for(Subject sub: sol.getSubjects()){
			Integer value = map.get(sub.getName() );
			sub.setCountStudents( value==null? 0: value );
		}
	}
	
	/**
	 * Berechnet die max. benötigten TimeSlots und 
	 * erstellt mit Überschneidungsgrad die Gruppentermine
	 */
	private void calcTimeSlots(Solution sol){		
		List<Subject> subjects = sol.getSubjects();
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
		int minCountGroups = subjects.get(0).getGroupCount();
		for(Subject sub: sol.getSubjects()){
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
		for(Subject sub: subjects){				
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
	 * Löscht count zufällige Elemente aus occupied und fügt diese this.students hinzu
	 */
	private void delFromOccupied(int count, List<Student> occupied, List<Student> students){		
		for(int i = 0; i < count; i++){
			if(occupied.isEmpty()){
				return;
			}
			Student stud = occupied.remove( new Random().nextInt( occupied.size() )) ;
			if( stud != null){
				students.add( stud );
				stud.delFromAllGroups();
			}
			else{
				return;
			}
		}
	}
	
	/**
	 * Zuordnung aller Studierenden zu ihren Gruppen
	 * konfliktfrei 
	 */
	private void studToGroupAllocation(Solution sol) {
		
		List<Student> students = sol.getStudents();
		/*
		 * abgearbeitete Studierende
		 */
		List<Student> occupied = new LinkedList<>();
				
		int steps = 0;		
		/*
		 * jeder Studierende
		 */
		while( !students.isEmpty() ){
			Student stud = students.remove( new Random().nextInt(students.size()));
			/*
			 * jedes Fach des Studierenden
			 */
			for(Subject studSub: stud.getSubjects()){
				/*
				 * füge den Studierenden zu Gruppe des Fachs hinzu
				 */
				if( !studSub.addStudentToGroup(stud) ){				
					/*
					 * lösche den letzten
					 */
					stud.delFromAllGroups();
					students.add(stud);					
					
					steps++;
					if(steps % 2 == 0){						
						/*
						 * lösche x weitere
						 */
						delFromOccupied(1, occupied, students);						
					}
										
					break;
				}				
				else{
					occupied.add(stud);
				}
			}
			
		}
		
		students = occupied;					
	}
	
	
	
}
