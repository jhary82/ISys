/**
 * 
 */
package io;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	 * Konstruktor
	 */
	public Parameters() {
		this.probabilities = new TreeMap<>();
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
		return 0;
	}
	
	/**
	 * Gibt eine Liste der Belegungsfächer zurück
	 * @return
	 */
	public List<Subject> getSubjects(){
		return new LinkedList<Subject>();
	}
	
	/**
	 * @return the groupSize
	 */
	public int getGroupSize() {
		/*
		 * TODO für Testzwecke
		 */
		return 12;//groupSize;
	}

	/**
	 * @return the countStuds
	 */
	public int getCountStudents() {
		return countStudents;
	}
}
