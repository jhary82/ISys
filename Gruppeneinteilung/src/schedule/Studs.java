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
	 * Liste der Fächer
	 */
	private List<Subject> subjects;
	
	/**
	 * Konstruktor
	 */
	public Studs(Parameters p){
		this.setSubjectsByKey(p);
	}

	/**
	 * Setzt die Fächer nach definierten Schlüsseln
	 * @param p
	 */
	private void setSubjectsByKey(Parameters p) {
		//new Random().nextInt(4);
		
	}
}
