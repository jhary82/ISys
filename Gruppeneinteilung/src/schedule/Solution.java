package schedule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Eine Klasse fuer den Loesungsraum
 * @author Erik und Simon
 *
 */
public final class Solution implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Alle Studierenden
	 */
	private List<Student> students;
	
	/**
	 * Alle Faecher
	 */
	private List<Subject> subjects;
		
	/**
	 * Matrix von den Praeferenzen von Studenten
	 */
	private double[][] preferences;
	
	/**
	 * Konstruktor
	 * @param pref Praeferenzen der Studierenden
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
	 * Gibt eine Liste von allen Studenten zurueck
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Legt eine Liste von Studenten fest
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Gibt alle Faecher zurueck
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * Legt eine Liste von Faechern fest
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	/**
	 * Berechnet den Wert dieses Loesungsraums aus
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
	 * Gibt eine Liste aller moeglichen Tausch-Moeglichkeiten zurueck
	 * @return
	 */
	public PriorityQueue<ChangeTask> getChangeTaskList() {
		PriorityQueue<ChangeTask> pq = new PriorityQueue<>();
		
		/*
		 * fuer alle Faecher
		 */
		for( Subject sub : this.subjects ){
			/*
			 * fuer alle Gruppen
			 */
			for( Group fromGroup : sub.getGroups()){
				/*
				 * fuer Studierende der Gruppe
				 */
				for(int i = 0; i < fromGroup.getStudents().size(); i++){
					Student fromStudent = fromGroup.getStudents().get(i);
					/*
					 * fuer alle anderen Gruppen und deren Studierenden
					 */
					for(Group toGroup : sub.getGroups()){
						if( toGroup != fromGroup){							
							for(Student toStudent: toGroup.getStudents()){
								if(toStudent != fromStudent){																		
									if( canChange((Student)fromStudent, (Group)fromGroup, (Student)toStudent, (Group)toStudent.getGroup(sub)) ){
										double value = changeValue((Student)fromStudent, (Group)fromGroup, (Student)toStudent, (Group)toStudent.getGroup(sub));
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
	 * Berechnet, ob fuer die Kombination von Studenten ein Tausch moeglich ist
	 * @param fromStudent
	 * @param toStudent
	 * @param fromGroup
	 * @param toGroup
	 * @return false, wenn kein Tausch moeglich oder keine Verbesserung bringt
	 */
	private boolean canChange(Student fromStudent, Group fromGroup, Student toStudent, Group toGroup) {
		/*
		 * Ueberpruefe, ob Wechsel moeglich ist
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
		if( possible){
			return !possible;
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
		
		return !possible;
	}
	
	/**
	 * Berechnet fuer das StudentenTupel den Wert der Veraenderung des Loesungsraumswerts
	 * @param fromStudent
	 * @param fromGroup
	 * @param toStudent
	 * @param toGroup
	 * @return
	 */
	private double changeValue(Student fromStudent, Group fromGroup, Student toStudent, Group toGroup) {		
		double fromValue = this.getGroupValue(fromGroup);
		double toValue = this.getGroupValue(toGroup);
		double newFromValue = 0.0;
		double newToValue = 0.0;
		/*
		 * Berechne neuen Gruppenwert,
		 * wenn toStudent in fromGroup waere
		 */
		for(int i = 0; i < fromGroup.getStudents().size(); i++){
			Student stud = fromGroup.getStudents().get(i);
			if(stud == fromStudent){
				stud = toStudent;
			}
			for(int a = 0; a < fromGroup.getStudents().size(); a++){
				Student otherStud = fromGroup.getStudents().get(a);
				if( otherStud == fromStudent){
					continue;
				}
				else{
					newFromValue += preferences[stud.getId()][otherStud.getId()];
				}
			}
		}
		/*
		 * Berechne neuen Gruppenwert,
		 * wenn fromStudent in toGroup waere
		 */
		for(int i = 0; i < toGroup.getStudents().size(); i++){
			Student stud = toGroup.getStudents().get(i);
			if(stud == toStudent){
				stud = fromStudent;
			}
			for(int a = 0; a < toGroup.getStudents().size(); a++){
				Student otherStud = toGroup.getStudents().get(a);
				if( otherStud == toStudent){
					continue;
				}
				else{
					newFromValue += preferences[stud.getId()][otherStud.getId()];
				}
			}
		}
		
		return -newFromValue - newToValue + fromValue + toValue;
	}
	
	/**
	 * Kopiert diese Instanz
	 * @return
	 */
	public Solution copy(){	
		Solution sol = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			bos.close();
			byte[] byteData = bos.toByteArray();

			/*
			 * Restore your class from a stream of bytes:
			 */
			ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
			sol = (Solution) new ObjectInputStream(bais).readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} 
		return sol;

	}
	
}
