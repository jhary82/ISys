/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import schedule.Subject;

/**
 * @author simon
 *
 */
public final class Parameters {
	

	/**
	 * Anzahl der Studierenden
	 */
	private int countStudents;
	
	/**
	 * Inhalt der JSON-Datei.
	 */
	private JSONObject jsonInput;
	
	/**
	 * Der �berschneidungsfaktor
	 */
	private double overlapFactor;
	
	/**
	 * Konstruktor
	 */
	public Parameters(String file) {
		
		
		FileInputStream fr = null;
		BufferedReader br = null;
		String input = "";
		String line = "";
		try {
			fr = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fr));
			while((line = br.readLine()) != null ) {
				input = input + line;
			}
			br.close();
			jsonInput = new JSONObject(input);
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-001: " + e.getMessage());
		}
	}
		
	/**
	 * Gibt die Belegungswahrscheinlichkeit eines Fachs zurück
	 * @param sub
	 * @return
	 */
	public int getProbability(Subject sub){
		JSONObject jsub;
		int prob = 0;
		try {			
			jsub = jsonInput.getJSONObject(sub.getName());
			prob = jsub.getInt("Probability");
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-002: " + e.getMessage());
		}
		return prob;
	}
	
	/**
	 * Gibt eine Liste der Belegungsfächer zurück
	 * @return
	 */
	public List<Subject> getSubjects(){
		List<Subject> list = new LinkedList<>();
		int gs;
		try {
			Iterator<?> keys = jsonInput.keys();
			while( keys.hasNext() ) {
			    String key = (String)keys.next();
			    if ( jsonInput.get(key) instanceof JSONObject ) {
			    	gs = jsonInput.getJSONObject(key).getInt("Groupsize");
			    	list.add(new Subject(key, gs));
			    }
			}
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-003: " + e.getMessage());
		}
		return list;
	}
	
	/**
	 * @return the overlapFactor
	 */
	public double getOverlapFactor() {
		try {
			overlapFactor = jsonInput.getDouble("Overlapfactor");
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-004: " + e.getMessage());
		}
		return overlapFactor;//overlapFactor;
	}

	/**
	 * @return the countStuds
	 */
	public int getCountStudents() {
		try {
			countStudents = jsonInput.getInt("Students");
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-005: " + e.getMessage());
		}
		return countStudents;
	}
	
}

