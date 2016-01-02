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
