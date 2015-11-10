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
	 * Matrikelnummer als Index 
	 * bei Berechnungen benutzt
	 */
	private int id;
	
	/**
	 * Liste der F�cher
	 */
	private List<Subject> subjects;
	
	/**
	 * Konstruktor
	 */
	public Student(Parameters p){
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
}
