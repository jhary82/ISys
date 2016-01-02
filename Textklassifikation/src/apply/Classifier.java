package apply;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * 
 */

/**
 * Diese Klasse laedt ein Klassifizierungs-XML fuer die
 * beiden Unterscheidungsarten News oder Film ein und klassifiziert dann
 * uebergebende Dateien 
 * @author skrause
 *
 */
public final class Classifier {

	/**
	 * Klassifizierungsattribute für Nachrichten
	 */
	private Classifier_Class news;
	
	/**
	 * Klassifizierungsattribute für Filme
	 */
	private Classifier_Class film;
	
	/**
	 * Konstruktor
	 * @param xml Klassifizierungs-XML mit dem "Brain"
	 */
	public Classifier(File xml) {		
		try {
			Document doc = new SAXBuilder().build(xml);
			Element root = doc.getRootElement();
			List<Element> children = root.getChildren();
			film = new Classifier_Class( 
					children.get(0).getChild("kom"),
					children.get(0).getChild("dot"),
					children.get(0).getChild("aus"),
					children.get(0).getChild("ques"),
					children.get(0).getChild("cite"),
					children.get(0).getChild("satzlaenge"),
					children.get(0).getChild("vergangenheit"),
					children.get(0).getChild("numberwithdot"),
					children.get(0).getChild("nl"),
					children.get(0).getChild("numberfour"),
					children.get(0).getChild("numberrest")
					);
			news = new Classifier_Class( 
					children.get(1).getChild("kom"),
					children.get(1).getChild("dot"),
					children.get(1).getChild("aus"),
					children.get(1).getChild("ques"),
					children.get(1).getChild("cite"),
					children.get(1).getChild("satzlaenge"),
					children.get(1).getChild("vergangenheit"),
					children.get(1).getChild("numberwithdot"),
					children.get(1).getChild("nl"),
					children.get(1).getChild("numberfour"),
					children.get(1).getChild("numberrest")
					);
			
		} catch (JDOMException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Einladen des "Brains" und anwenden auf uebergebende Dateiliste
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
