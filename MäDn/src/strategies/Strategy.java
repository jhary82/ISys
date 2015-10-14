package strategies;

import java.util.List;

import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;

public abstract class Strategy extends AbstractStrategy {
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		
		// TODO Auto-generated method stub
		//super.onGameOver(stats, roundCount);
		for(PlayerStats player : stats) {
			System.out.print("Spielername: " + player.player().name() + " : ");
			System.out.println("AnzahlGewonnen: " + player.wins());
			
			double win = player.wins();
			double rc = roundCount;
			double gh = Math.round((win/rc)*Math.pow(10, 2))/Math.pow(10, 2);
			System.out.println("GewinnHäufigkeit: " + gh*100);
			
			double dg = roundCount/stats.size();
			double dgv = ((win-dg)/dg);
			System.out.println("Gewinne/Verluste im Durchschnitt: " + dgv*100);
		}
		System.out.println(" " + roundCount);
		
		
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		// TODO Auto-generated method stub
		//super.onRoundOver(winner, turnCount);
		System.out.println("Gewinner: " + winner.name() + " : " + "AnzahlRunden: " + turnCount);
	}
	
	
	
}
