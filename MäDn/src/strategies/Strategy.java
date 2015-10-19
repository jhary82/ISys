package strategies;

import java.util.List;

import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;

public abstract class Strategy extends AbstractStrategy {
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		double rc = roundCount;
		double cp = stats.size();
		double dg = Math.round((rc/cp)*Math.pow(10, 2))/Math.pow(10, 2);
		System.out.println("RundenInsgesamt: " + roundCount);
		System.out.println("Ø gewinne pro Spieler: " + dg);
		
		System.out.println("------------------------------------------");
		for(PlayerStats player : stats) {
			
			double win = player.wins();
			
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			System.out.println("Spiele gewonnen in Prozent: " + win/rc*100 + " %");
			
			/*
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
			*/
			
			System.out.println("------------------------------------------");
		}
		
		
		
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		//System.out.println("Gewinner: " + winner.name() + " : " + "AnzahlRunden: " + turnCount);
	}
	
	
	
}
