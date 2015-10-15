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
		double dg = rc/cp;
		System.out.println("RundenInsgesamt: " + roundCount);
		System.out.println("Ø gewinne pro Spieler: " + dg);
		for(PlayerStats player : stats) {
			System.out.println("------------------------------------------");
			
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			
			double win = player.wins();
			
			double gh = Math.round((win/rc)*Math.pow(10, 2))/Math.pow(10, 2);
			System.out.println("GewinnHäufigkeit: " + gh*100);
			
			
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
			
		}
		
		
		
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		//System.out.println("Gewinner: " + winner.name() + " : " + "AnzahlRunden: " + turnCount);
	}
	
	
	
}
