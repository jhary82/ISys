package apply;


import java.util.LinkedList;
import java.util.List;

import listener.AnalysisListener;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

/**
 * Klasse beinhaltet die Eigenschaften einer der zu klassifizierenden Klassen
 * @author Simon und Erik
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
	 * @param elem - Wurzelknoten einer Eigenschaft(z.B. Film)
	 */
	public Classifier_Class(Element elem) {
		list = new LinkedList<>();		
		
		/*
		 * erzeuge neue Eintraege fuer alle Konstanten
		 */
		for(int i = 0; i < AnalysisListener.MAX_ELEMENTS; i++){
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
	 * @param elem - Wurzelknoten einer Eigenschaft(z.B. Film)
	 * @throws DataConversionException 
	 */
	private void loadFromElement(Element elem) throws DataConversionException {
		for(Element obj : elem.getChild("comma").getChildren()){
			list.get(AnalysisListener.COMMA).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("dot").getChildren()){
			list.get(AnalysisListener.DOT).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}		
		for(Element obj : elem.getChild("question").getChildren()){
			list.get(AnalysisListener.QUESTION).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("cite").getChildren()){
			list.get(AnalysisListener.CITE).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("sentence_length_avg").getChildren()){
			list.get(AnalysisListener.SENTENCE_LENGTH_AVG).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}		
		for(Element obj : elem.getChild("number_with_dot").getChildren()){
			list.get(AnalysisListener.NUMBER_WITH_DOT).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("nl").getChildren()){
			list.get(AnalysisListener.NL).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("number_four").getChildren()){
			list.get(AnalysisListener.NUMBER_FOUR).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("number_rest").getChildren()){
			list.get(AnalysisListener.NUMBER_REST).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("brack").getChildren()){			
			list.get(AnalysisListener.BRACK).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("sub_sentences").getChildren()){			
			list.get(AnalysisListener.SUB_SENTENCES).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("past").getChildren()){			
			list.get(AnalysisListener.PAST).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("noun").getChildren()){			
			list.get(AnalysisListener.NOUN).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(Element obj : elem.getChild("sentence_length_max").getChildren()){			
			list.get(AnalysisListener.SENTENCE_LENGTH_MAX).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );
		}
		for(int i = 0; i < 6; i++){
			String str = "word_length_"+(i+3);
			for(Element obj : elem.getChild(str).getChildren()){			
				list.get(14+i).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );				
			}
			str = "noun_length_"+(i+3);
			for(Element obj : elem.getChild(str).getChildren()){			
				list.get(20+i).add( new Attribut( obj.getAttribute("low").getIntValue(), obj.getAttribute("high").getIntValue(), obj.getAttribute("value").getDoubleValue()) );				
			}
		}
	}

	/**
	 * Gibt fuer den uebergebenden Wert die richtige Wahrscheinlichkeit zurueck
	 * @param value - "Messwert"
	 * @param chooseValue - zu verwendene Eigenschaft
	 * @return - Gibt den Wahrscheinlichkeitswert zurueck
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
	 * @author Simon und Erik
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
		 * @param low - untere Intervallgrenze
		 * @param high - obere Intervallgrenze
		 * @param value - Wahrscheinlichkeitswert
		 */
		private Attribut(int low, int high, double value){
			this.low = low;
			this.high = high;
			this.value = -Math.log(value);			
		}
		
		/**
		 * Diese Methode gibt die untere Intervallgrenze zurueck
		 * @return - gibt die untere Intervallgrenze zurueck
		 */
		private int getLow(){
			return low;
		}
		
		/**
		 * Diese Methode gibt die obere Intervallgrenze zurueck
		 * @return - gibt die obere Intervallgrenze zurueck
		 */
		private int getHigh(){
			return high;
		}
		
		/**
		 * Diese Methode gibt den Wahrscheinlichkeitswert zurueck
		 * @return gibt den Wahrscheinlichkeitswert zurueck
		 */
		private double getValue(){
			return value;
		}
	}
	
}
