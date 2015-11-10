/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
import schedule.Subject;

/**
 * @author simon
 *
 */
public final class Parameters {
		
	/**
	 * Map der Fächer und zugehörigen Belegungswahrscheinlichkeiten
	 * von 0 .. 100 für 0.0 bis 1.0
	 */
	private Map<Subject, Integer> probabilities;
	
	/**
	 * Maximale Anzahl an Studs in Gruppe
	 */
	private int groupSize;

	/**
	 * Anzahl der Studierenden
	 */
	private int countStudents;
	
	/**
	 * Inhalt der JSON-Datei.
	 */
	private JSONObject jsonInput;
	
	/**
	 * Konstruktor
	 */
	public Parameters(String file) {
		this.probabilities = new TreeMap<>();
		
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
	 * TODO bei sinnfreien Werten wie groupsize <= 0 throw Error
	 */
	public void load() {
		
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
		Subject sa;
		Subject sb;
		Subject sc;
		try {
		gs = jsonInput.getJSONObject("A").getInt("Groupsize");
		sa = new Subject("A", gs);
		gs = jsonInput.getJSONObject("B").getInt("Groupsize");
		sb = new Subject("B", gs);
		gs = jsonInput.getJSONObject("C").getInt("Groupsize");
		sc = new Subject("C", gs);
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-001: " + e.getMessage());
		}
		list.add(sa);
		list.add(sb);
		list.add(sc);
		return list;//new LinkedList<Subject>();
	}
	
	/**
	 * @return the groupSize
	 */
	public int getGroupSize() {
		try {
			groupSize = jsonInput.getJSONObject("A").getInt("Groupsize");
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-003: " + e.getMessage());
		}
		return groupSize;//groupSize;
	}

	/**
	 * @return the countStuds
	 */
	public int getCountStudents() {
		try {
			countStudents = jsonInput.getInt("Students");
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-003: " + e.getMessage());
		}
		return countStudents;//countStudents;
	}
	/*
	 
package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.*;
import schedule.Subject;

public final class Parameters {
	
	private JSONObject jsonInput;
	private String jstud = "Students";
	private String jpf = "Participants factor";
	private String jps = "Participants size";
	Parameters(String file) {
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
	public void load() {
		
	}
	public Subject getSubject(String name) {
		JSONObject jSub = null;
		Subject sub = null;
		int stud;
		double pf;
		int ps;
		double stud_number;
		try {
			jSub = jsonInput.getJSONObject(name);
			stud = jsonInput.getInt(jstud);
			pf = jSub.getDouble(jpf);
			ps = jSub.getInt(jps);
			stud_number = stud * pf;
			sub = new Subject(name, stud_number, pf, ps);
		} catch (Exception e) {
			throw new Error("ErrorCode: Parameters-002: " + e.getMessage());
		}
		return sub;
	}
	
	public String toString() {
		return jsonInput.toString();
	}
	
	public static void main(String[] args) {
		Parameters p = new Parameters("parameters.json");
		System.out.println(p.toString());
		Subject a = p.getSubject("A");
		a.toString();
	}
	
}

	 */
}
