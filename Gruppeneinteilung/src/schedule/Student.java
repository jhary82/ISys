package schedule;

import io.Parameters;

import java.util.List;
import java.util.Random;

/**
 * 
 * @author simon
 *
 */
public final class Student {
		
	/**
	 * Matrikelnummer
	 */
	private int id;
	
	/**
	 * Liste der F�cher
	 */
	private List<Subject> subjects;
	
	/**
	 * Konstruktor
	 * @param p Parameter 
	 * @param id MatriklNr
	 */
	public Student(Parameters p, int id){
		this.setSubjectsByKey(p);
	}

	/**
	 * Setzt die F�cher nach definierten Schl�sseln
	 * @param p
	 */
	private void setSubjectsByKey(Parameters p) {
		List<Subject> subs = p.getSubjects();
		
		for( Subject sub : subs){
			if( new Random().nextInt( 100 ) >= p.getProbability(sub) ){
				this.subjects.add(sub);
			}
		}
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return String.valueOf(id);
	}

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	
}
