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
	public void execute() {
		/*
		 * loesche altes Tupel raus
		 */		
		fromStudent.delGroup(fromGroup);
		fromGroup.delStudent(fromStudent);
		toStudent.delGroup(toGroup);
		toGroup.delStudent(toStudent);
		/*
		 * und fuege in neue Gruppe ein
		 */
		fromGroup.addStudent(toStudent);
		toGroup.addStudent(fromStudent);		
	}
	
	/**
	 * mache Aenderung rueckgaengig
	 */
	public void reExecute() {
		/*
		 * loesche altes Tupel raus
		 */		
		fromStudent.delGroup(toGroup);
		fromGroup.delStudent(toStudent);
		toStudent.delGroup(fromGroup);
		toGroup.delStudent(fromStudent);
		/*
		 * und fuege in neue Gruppe ein
		 */
		fromGroup.addStudent(fromStudent);
		toGroup.addStudent(toStudent);		
	}
	

}
