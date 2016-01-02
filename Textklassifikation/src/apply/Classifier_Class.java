/**
 * 
 */
package apply;

import java.util.ArrayList;
import java.util.List;

import learning.Learning;

import org.jdom2.DataConversionException;
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
	private List<Attribut> kom;
	/**
	 * Anzahl der Punkte
	 */
	private List<Attribut> dot;
	/**
	 * Anzahl der Ausrufezeichen
	 */
	private List<Attribut> aus;
	/**
	 * Anzahl der Fragezeichen
	 */
	private List<Attribut> ques;
	/**
	 * Anzahl der Zitate
	 */
	private List<Attribut> cite;
	/**
	 * Satzlaengen
	 */
	private List<Attribut> satzlaenge;
	/**
	 * Anzahl der Vergangenheitsformen
	 */
	private List<Attribut> vergangenheit;
	/**
	 * Zahlen mit Punk enthalten
	 */
	private List<Attribut> numberWithDot;
	/**
	 * Anzahl von NewLine
	 */
	private List<Attribut> nl;
	/**
	 * Anzahl von vierstelligen Zahlen
	 */
	private List<Attribut> numberFour;
	/**
	 * Restliche Zahlen
	 */
	private List<Attribut> numberRest;
	
	/**
	 * Konstruktor
	 * @param elem Wurzelknoten einer Eigenschaft(z.B. Film)
	 */
	public Classifier_Class(Element elem) {
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
		
		try {
			loadFromElement(elem);
		} catch (DataConversionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Laedt die Kindelemente in die Klassenattribute
	 * @param elem
	 * @throws DataConversionException 
	 */
	private void loadFromElement(Element elem) throws DataConversionException {
		for(Element obj : elem.getChild("kom").getChildren()){
			kom.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("dot").getChildren()){
			dot.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("aus").getChildren()){
			aus.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("ques").getChildren()){
			ques.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("cite").getChildren()){
			cite.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("satzlaenge").getChildren()){
			satzlaenge.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("vergangenheit").getChildren()){
			vergangenheit.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("numberwithdot").getChildren()){
			numberWithDot.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("nl").getChildren()){
			nl.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("numberfour").getChildren()){
			numberFour.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("numberrest").getChildren()){
			numberRest.add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		
	}

	public double getValue(int value, int chooseValue) {
		List<Attribut> list = null;
		switch(chooseValue){
			case(Learning.DOT): list = this.dot; break;
			case(Learning.COMMA): list = this.kom; break;
		}
		for(Attribut attr : list){
			if(value < attr.getHigh() && value >= attr.getLow() ){
				return attr.getValue();
			}
		}
		return 0.0;
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
