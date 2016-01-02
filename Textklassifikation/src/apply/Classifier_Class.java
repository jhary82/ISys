/**
 * 
 */
package apply;


import java.util.LinkedList;
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
	 * Liste von Listen von Attributen,
	 * speichert die Eigenschaften 	
	 */
	private List<List<Attribut>> list;
	
	/**
	 * Konstruktor
	 * @param elem Wurzelknoten einer Eigenschaft(z.B. Film)
	 */
	public Classifier_Class(Element elem) {
		list = new LinkedList<>();		
		
		/*
		 * erzeuge neue Eintraege für alle Konstanten
		 */
		for(int i = 0; i < 13; i++){
			list.add( new LinkedList<>());
		}
		
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
		for(Element obj : elem.getChild("comma").getChildren()){
			list.get(Learning.COMMA).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("dot").getChildren()){
			list.get(Learning.DOT).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("exclamation").getChildren()){
			list.get(Learning.EXCLAMATION).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("question").getChildren()){
			list.get(Learning.QUESTION).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("cite").getChildren()){
			list.get(Learning.CITE).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("sentence_length").getChildren()){
			list.get(Learning.SENTENCE_LENGTH).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("past").getChildren()){
			list.get(Learning.PAST).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("number_with_dot").getChildren()){
			list.get(Learning.NUMBER_WITH_DOT).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("nl").getChildren()){
			list.get(Learning.NL).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("number_four").getChildren()){
			list.get(Learning.NUMBER_FOUR).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		for(Element obj : elem.getChild("number_rest").getChildren()){
			list.get(Learning.NUMBER_REST).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue(), obj.getAttribute("low").getIntValue()) );
		}
		
	}

	/**
	 * Gibt für den übergebenden Wert die richtige Wahrscheinlichkeit zurück
	 * @param value "Messwert"
	 * @param chooseValue zu verwendene Eigenschaft
	 * @return
	 */
	public double getValue(int value, int chooseValue) {		
		
		for(Attribut attr : list.get(chooseValue) ){
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
