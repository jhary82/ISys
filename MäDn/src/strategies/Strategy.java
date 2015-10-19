package strategies;


import java.util.List;

import ludo.AbstractAction;
import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;
import ludo.Token;
import statistics.Turns;

/**
 * Abstrakte Strategieklasse
 * @author Simon
 *
 */
public abstract class Strategy extends AbstractStrategy {	 
		
	/*
	 * CSV-Datei für statistische Daten erzeugen
	 */
	private boolean evaluate = false;
	
	/*
	 * der eigene Index, um herauszufinden, ob eine Partie gewonnen wurde 
	 */
	private int ownIndex;
		
	/*
	 * speichert statistische Daten ab
	 */
	private Turns turns;
	
	/*
	 * Name der csv-Datei, in die abgespeichert werden soll 
	 */
	private String csvName;
	
	/**
	 * Konstruktor
	 * @param evaluate true, wenn diese Strategie ausgewertet werden soll 
	 * @param ownIndex der eigene Index
	 */
	public Strategy(boolean evaluate, int ownIndex, String csvName){
		this.evaluate = evaluate;
		this.ownIndex = ownIndex;		
		this.csvName = csvName;
		turns = new Turns();
	}
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		if(!this.evaluate){
			return;
		}
		turns.saveToCSV(this.csvName); 
		/*
		double rc = roundCount;
		double cp = stats.size();
		double dg = Math.round((rc/cp)*Math.pow(10, 2))/Math.pow(10, 2);
		System.out.println("RundenInsgesamt: " + roundCount);
		System.out.println("� gewinne pro Spieler: " + dg);
		
		System.out.println("------------------------------------------");
		System.out.println("� gewinne pro Spieler: " + dg);
		for(PlayerStats player : stats) {
			
			double win = player.wins();
			
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			System.out.println("Spiele gewonnen in Prozent: " + win/rc*100 + " %");
			double gh = Math.round((win/rc)*Math.pow(10, 2))/Math.pow(10, 2);
			System.out.println("GewinnH�ufigkeit: " + gh*100);
			
			
			/*
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
			*/
		
		
	
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		if(!this.evaluate){
			return;
		}	
		
		turns.setWon( this.ownIndex == winner.index() );
		turns.nextTurn();
	
	}
	
	
	/**
	 * Ermitteln von statistischen Werten eines Zuges und uebertrag in turns	 
	 */
	protected void setStatistics(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		if( !canHit(tokens, actions).isEmpty() ){
			turns.addHitChance();
		}
	}
	
	/**
	 * TODO Java-Dok ergänzen
	 * @param tokens
	 * @param actions
	 * @return
	 */
	public List<AbstractAction> canHit(List<Token> tokens, List<AbstractAction> actions) {
		List<AbstractAction> hits = null;
		/*
		 * TODO
		 */
		return hits;
	}
	
	
}
