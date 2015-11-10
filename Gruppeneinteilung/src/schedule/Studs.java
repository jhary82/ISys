package schedule;

import io.Parameters;

import java.util.List;
import java.util.Random;

/**
 * 
 * @author simon
 *
 */
public final class Studs {
	
	/**
	 * Liste der F�cher
	 */
	private List<Subject> subjects;
	
	/**
	 * Konstruktor
	 */
	public Studs(Parameters p){
		this.setSubjectsByKey(p);
	}

	/**
	 * Setzt die F�cher nach definierten Schl�sseln
	 * @param p
	 */
	private void setSubjectsByKey(Parameters p) {
		//new Random().nextInt(4);
		
	}
}
