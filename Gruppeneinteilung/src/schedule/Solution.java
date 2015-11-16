/**
 * 
 */
package schedule;

import java.util.LinkedList;
import java.util.List;

/**
 * @author skrause
 *
 */
public class Solution implements Cloneable{

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

	
	public Solution clone(){
		Solution sol = new Solution();
		List<Student> students = new LinkedList<>();
		List<Subject> subjects = new LinkedList<>();
		
		/*
		
		for(Student stud : this.students){
			Student studNew = new Student(stud.getId(), stud.getSubjects());
			students.add(studNew);
		}*/
		
		return sol;
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
}
