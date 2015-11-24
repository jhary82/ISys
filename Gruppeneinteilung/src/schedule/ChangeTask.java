package schedule;

import java.io.Serializable;

/**
 * Eine Klasse f�r die Vertauschung von Studenten.
 * @author Erik und Simon
 *
 */
public final class ChangeTask implements Comparable<ChangeTask>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Die Studenten 
	 */
	private Student fromStudent, toStudent;
	
	/**
	 * Die Gruppen
	 */
	private Group fromGroup, toGroup;
	
	/**
	 * der Loesungsraum, auf dem die Aenderung stattfindet
	 */
	private Solution solution;
	
	/**
	 * der Wert (+/-) der Veraenderung
	 */
	private double changeValue;
	
	/**
	 * Konstruktor
	 * @param fromStudent
	 * @param fromGroup
	 * @param toStudent
	 * @param toGroup
	 * @param sol
	 * @param changeValue
	 */
	public ChangeTask(Student fromStudent, Group fromGroup, Student toStudent, Group toGroup, Solution sol, double changeValue) {	
		this.fromGroup = fromGroup;
		this.fromStudent = fromStudent;
		this.toGroup = toGroup;
		this.toStudent = toStudent;
		this.solution = sol;
		this.changeValue = changeValue;
	}

	@Override
	public int compareTo(ChangeTask arg0) {
		/*
		 * mit 100 multipliziert, falls zu kleine Werte auftreten
		 * und bei -0.3 auf 0 gerundet wird
		 */
		return  (int) ( (this.changeValue*100) - (arg0.getChangeValue()*100) ) ;		
	}

	/**
	 * @return the solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * @return the changeValue
	 */
	public double getChangeValue() {
		return changeValue;
	}

	/**
	 * Fuehre Aenderung durch
	 */
	public boolean execute(Solution sol) {
		/*
		 * loesche altes Tupel raus
		 */
		Student fStudent = null, tStudent = null;
		Group fGroup = null, tGroup = null;
		for(Subject sub : sol.getSubjects()){
			for(Group grp : sub.getGroups()){
				if( grp.getID().compareTo( fromGroup.getID()) > 0){
					fGroup = grp;
				}
				if( grp.getID().compareTo( toGroup.getID()) > 0){
					tGroup = grp;
				}
			}		
		} 
		
		for(Student stud : sol.getStudents()){
			if( stud.getId() == fromStudent.getId()){
				fStudent = stud;
			}
			if( stud.getId() == toStudent.getId()){
				tStudent = stud;
			}
		}
			
		if(fStudent == null || tStudent == null || fGroup == null || tGroup == null){
			return false;
		}
		
		fStudent.delGroup(fGroup);
		fGroup.delStudent(fStudent);
		tStudent.delGroup(tGroup);
		tGroup.delStudent(tStudent);
		/*
		 * und fuege in neue Gruppe ein
		 */
		fGroup.addStudent(tStudent);
		tGroup.addStudent(fStudent);
		return true;
	}
	

}
