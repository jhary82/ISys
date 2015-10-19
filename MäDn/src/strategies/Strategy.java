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
	 * CSV-Datei f√ºr statistische Daten erzeugen
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
		double dg = Math.round((rc/cp)*Math.pow(10, 2))/Math.pow(10, 2);
		System.out.println("RundenInsgesamt: " + roundCount);
<<<<<<< HEAD
		System.out.println("ÿ gewinne pro Spieler: " + dg);
		
		System.out.println("------------------------------------------");
=======
		System.out.println("ÔøΩ gewinne pro Spieler: " + dg);
>>>>>>> 58ec56b0ce5f5bd2b63078606d2697100f8d42e0
		for(PlayerStats player : stats) {
			
			double win = player.wins();
			
<<<<<<< HEAD
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			System.out.println("Spiele gewonnen in Prozent: " + win/rc*100 + " %");
=======
			double gh = Math.round((win/rc)*Math.pow(10, 2))/Math.pow(10, 2);
			System.out.println("GewinnHÔøΩufigkeit: " + gh*100);
			
>>>>>>> 58ec56b0ce5f5bd2b63078606d2697100f8d42e0
			
			/*
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
			*/
			
<<<<<<< HEAD
			System.out.println("------------------------------------------");
		}
		
		
=======
		}		*/
>>>>>>> 58ec56b0ce5f5bd2b63078606d2697100f8d42e0
		
		
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
