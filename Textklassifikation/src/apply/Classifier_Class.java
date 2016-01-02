/**
 * 
 */
package apply;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

/**
 * Klasse beinhaltet die Eigenschaften einer der zu klassifizierenden Klassen
 * @author skrause
 *
 */
public final class Classifier_Class {
	
	/**
	 * Anzahl der Kommata
	 */
	private List<Integer> kom;
	/**
	 * Anzahl der Punkte
	 */
	private List<Integer> dot;
	/**
	 * Anzahl der Ausrufezeichen
	 */
	private List<Integer> aus;
	/**
	 * Anzahl der Fragezeichen
	 */
	private List<Integer> ques;
	/**
	 * Anzahl der Zitate
	 */
	private List<Integer> cite;
	/**
	 * Satzlaengen
	 */
	private List<Integer> satzlaenge;
	/**
	 * Anzahl der Vergangenheitsformen
	 */
	private List<Integer> vergangenheit;
	/**
	 * Zahlen mit Punk enthalten
	 */
	private List<Integer> numberWithDot;
	/**
	 * Anzahl von NewLine
	 */
	private List<Integer> nl;
	/**
	 * Anzahl von vierstelligen Zahlen
	 */
	private List<Integer> numberFour;
	/**
	 * Restliche Zahlen
	 */
	private List<Integer> numberRest;
	
	/**
	 * 
	 */
	public Classifier_Class(Element kom, Element dot, Element aus, Element ques, Element cite, Element satzlaenge,
			Element vergangenheit, Element numberWithDot, Element nl, Element numberFour, Element numberRest) {
		this.kom = new ArrayList<>();
		this.dot = new ArrayList<>();
		this.aus = new ArrayList<>();
		this.ques = new ArrayList<>();
		this.cite = new ArrayList<>();
		this.satzlaenge = new ArrayList<>();
		this.vergangenheit = new ArrayList<>();
		this.numberWithDot = new ArrayList<>();
		this.nl = new ArrayList<>();
		this.numberFour = new ArrayList<>();
		this.numberRest = new ArrayList<>();
		
	}

	/**
	 * Private Klasse, die die Attribute einzelner Eigenschaften speichert
	 * @author skrause
	 *
	 */
	private class Attribut {
		/**
		 * untere Intervallgrenze
		 */
		private int low;
		/**
		 * obere Intervallgrenze
		 */
		private int high;
		/**
		 * Wahrscheinlichkeitswert als negativer Logarithmus
		 */
		private double value;
		
		/**
		 * Konstruktor
		 * @param low untere Intervallgrenze
		 * @param high obere Intervallgrenze
		 * @param value Wahrscheinlichkeitswert
		 */
		private Attribut(int low, int high, int value){
			this.low = low;
			this.high = high;
			this.value = -Math.log(value);
		}
		
		/**
		 * 
		 * @return gibt die untere Intervallgrenze zurueck
		 */
		private int getLow(){
			return low;
		}
		
		/**
		 * 
		 * @return gibt die obere Intervallgrenze zurueck
		 */
		private int getHigh(){
			return high;
		}
		
		/**
		 * 
		 * @return gibt den Wahrscheinlichkeitswert zurueck
		 */
		private double getValue(){
			return value;
		}
	}
	
}
