/**
 * 
 */
package schedule;

import java.io.Serializable;

/**
 * @author skrause
 *
 */
public final class ChangeTask implements Comparable<ChangeTask>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Student fromStudent, toStudent;
	
	/**
	 * 
	 */
	private Group fromGroup, toGroup;
	
	/**
	 * der Lösungsraum, auf dem die Änderung stattfindet
	 */
	private Solution solution;
	
	/**
	 * der Wert (+/-) der Veränderung
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
	 * Führe Änderung durch
	 */
	public void execute() {
		/*
		 * lösche altes Tupel raus
		 */
		fromStudent.delGroup(fromGroup);
		fromGroup.delStudent(fromStudent);
		toStudent.delGroup(toGroup);
		toGroup.delStudent(toStudent);
		/*
		 * und füge in neue Gruppe ein
		 */
		fromGroup.addStudent(toStudent);
		toGroup.addStudent(fromStudent);
	}

}
