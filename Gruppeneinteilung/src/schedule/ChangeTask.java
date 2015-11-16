/**
 * 
 */
package schedule;

/**
 * @author skrause
 *
 */
public class ChangeTask implements Comparable<ChangeTask>{

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
		return  (int) ((this.changeValue*100) - (arg0.getChangeValue()*100)) ;		
	}

	/**
	 * @return the fromStudent
	 */
	public Student getFromStudent() {
		return fromStudent;
	}

	/**
	 * @return the toStudent
	 */
	public Student getToStudent() {
		return toStudent;
	}

	/**
	 * @return the fromGroup
	 */
	public Group getFromGroup() {
		return fromGroup;
	}

	/**
	 * @return the toGroup
	 */
	public Group getToGroup() {
		return toGroup;
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
		//TODO Änderungen ausführen 
		
	}

}
