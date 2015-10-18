package strategies;


import java.util.List;

import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;
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
	
	/**
	 * Konstruktor
	 * @param evaluate true, wenn diese Strategie ausgewertet werden soll 
	 * @param ownIndex der eigene Index
	 */
	public Strategy(boolean evaluate, int ownIndex){
		this.evaluate = evaluate;
		this.ownIndex = ownIndex;		
		turns = new Turns();
	}
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		if(!this.evaluate){
			return;
		}
		turns.saveToCSV("Strategy"); // TODO Namen anpassen
		/*
		double rc = roundCount;
		double cp = stats.size();
		double dg = rc/cp;
		System.out.println("RundenInsgesamt: " + roundCount);
		System.out.println("� gewinne pro Spieler: " + dg);
		for(PlayerStats player : stats) {
			System.out.println("------------------------------------------");
			
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			
			double win = player.wins();
			
			double gh = Math.round((win/rc)*Math.pow(10, 2))/Math.pow(10, 2);
			System.out.println("GewinnH�ufigkeit: " + gh*100);
			
			
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
			
		}		*/
		
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		if(!this.evaluate){
			return;
		}	
		
		turns.setWon( this.ownIndex == winner.index() );
		turns.nextTurn();
	
	}
	
	
	
}
