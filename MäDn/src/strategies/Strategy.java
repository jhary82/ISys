package strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ludo.AbstractStrategy;
import ludo.MoveAction;
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
	 * CSV-Datei fuer statistische Daten erzeugen
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
	
	/*
	 * Anzahl der Tokens in Startzone
	 */
	private int tokensInStart;
	
	/*
	 * aktualisierte Liste des letzten Spielfeldstandes
	 */
	private List<Token> lastTokenList;
	
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
		/*
		 * loesche den zusaetzlichen Eintrag in turns
		 */
		turns.delLast();
		turns.saveToCSV(this.csvName);	
		
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		if(!this.evaluate){
			return;
		}	
		/*
		 * Aufsummieren, wieviele Tokens der eigenen Farbe in Home-, Startzone sind
		 * im letzten Zug. 
		 * Korrektur fuer die Statistik, wenn gewonnen, wird der letzte Token noch zu inHome hinzugezaehlt
		 */
		int inHome = (winner.index() == this.ownIndex) ? 1 : 0;
		int inStart = 0;
		for(Token tmp : this.lastTokenList){
			if(tmp.index() == this.ownIndex){
				if( tmp.field().inHomeArea()){
					inHome++;
				}
				if( tmp.field().inStartArea()){
					inStart++;
				}				
			}
		}
		
		turns.setPositionCount(inHome, inStart);
		turns.setTurnCount(turnCount);
		turns.setWon( this.ownIndex == winner.index() );		
		turns.nextTurn();
	
	}
	
	
	/**
	 * Eine Methode um die Zuege zum Schlagen anderer Figuren rauszusuchen.
	 * @param tokens - Alle Spielfiguren in dem Spiel mit deren Positionen.
	 * @param moves - List von allen MoveAction.
	 * @return - Liste aller Schlagfaehigen Zuege.
	 */	
	public List<MoveAction> canHit(List<Token> tokens, List<MoveAction> moves) {
		List<MoveAction> hits = new ArrayList<>();
		for (MoveAction actMove : moves) {
			for (Token actToken : tokens) {	
				boolean hit = actToken.field().position() == actMove.destination().position();
				if(hit) {
					hits.add(actMove);
				}
			}
		}
		
		/*
		 * sammeln von statistischen Daten
		 */
		if(this.evaluate){ 
			this.turns.addHitChance();			
			this.lastTokenList = tokens;
			
			/*
			 * Berechnung, wie oft ein Token die Startzone verlassen hat
			 */
			int inStart = 0;
			for(Token tmp : tokens){				
				if( tmp.index() == this.ownIndex && tmp.field().inStartArea()){
					inStart++;
				}
			}
			if(inStart != this.tokensInStart && inStart < this.tokensInStart){
				this.tokensInStart = inStart;
				this.turns.addMoveOutStart();
			}
			else if(inStart > this.tokensInStart){
				this.tokensInStart = inStart;
			}
		}
		return hits;
	}
	/**
	 * Eine Methode um die Zuege nach destination und HomeArea zu sortieren.
	 * Zuege in die HomeArea stehen am Anfang der Liste
	 * @param moves - List von allen MoveAction.
	 * @return - Liste nach destination und ob HomeArea sortiert.
	 */
	public List<MoveAction> sortPosition(List<MoveAction> moves) {
		List<MoveAction> sortMoves = new ArrayList<>();
		Collections.sort(moves, new Comparator<MoveAction>() {

			@Override
			public int compare(MoveAction m1, MoveAction m2) {
				
				if (m1.destination().position() > m2.destination().position())
		            return 1;
		        if (m1.destination().position() < m2.destination().position())
		            return -1;
		        return 0;
			}
		});
		/*
		 * moegliche auswertung wieviele in die HomeArea rein gehen koennten.
		 */
		for(MoveAction move : moves) {
			if(move.destination().inHomeArea()) {
				sortMoves.add(move);
			}
		}
		for(MoveAction move : moves) {
			if(!sortMoves.contains(move)) {
				sortMoves.add(move);
			}
		}		
		return sortMoves;
	}
}
