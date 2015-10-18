package strategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;

/**
 * Abstrakte Strategieklasse mit Hilfsmethoden für die statistische Datenerhebung.
 * @author Simon
 *
 */
public abstract class Strategy extends AbstractStrategy {	 
		
	private boolean savable = false;
	
	/*
	 * in die zu speichernde CSV-Datei
	 */
	private File csv;
	
	/**
	 * Konstruktor
	 * @param savable true, wenn für diese Strategie eine CSV-Datei mit statistischen Daten erstellt werden soll
	 */
	public Strategy(boolean savable){
		this.savable = savable;
		if(savable){
			Date currentTime = new Date();
			csv = new File("Strategy_"+currentTime.toString()+".csv");
		}
	}
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		if(!this.savable){
			return;
		}
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
			
		}		
		
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		if(!this.savable){
			return;
		}		
		System.out.println(winner.name());
		// speichere in CSV-Datei ab
		  try {
			PrintWriter pw = new PrintWriter(new FileWriter(csv, true));
			pw.println("Test "+turnCount);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
