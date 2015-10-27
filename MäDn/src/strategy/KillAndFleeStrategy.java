/**
 * 
 */
package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie versucht moeglichst sichere Zuege zu machen.
 * Andere Token werden geschlagen oder gemieden.
 * @author Erik und Simon
 * 
 */
public class KillAndFleeStrategy extends Strategy {
	/**
	 * Konstruktor f�r die Strategie.
	 * @param evaluate - true, wenn die Strategie statistisch erfasst werden soll.
	 * @param ownIndex - Den eigenen Index
	 * @param csvName - Name der Datei f�r die Statistik
	 */
	public KillAndFleeStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
	}
	/**
	 * Standart-Konstruktor
	 */
	public KillAndFleeStrategy()  {
		super(true, 0, "KAF");
	}
	
	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();
		List<MoveAction> hits = new ArrayList<>();
		
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).getClass().equals(MoveAction.class)) {
				moves.add((MoveAction) actions.get(i));
			}
		}
		if (moves.isEmpty()) {
			/*
			 * Number 1
			 * Keine Zugmoeglichkeit.
			 */
			statistics(1);
			return new Random().nextInt(actions.size());
		} else {
			
			hits = canHit(tokens, moves);						
			if(!hits.isEmpty()){
				/*
				 * Number 5
				 * Schlaeg zufaellig eine Spielfigur raus.
				 */
				statistics(5);
				return actions.indexOf( hits.get( new Random().nextInt(hits.size()) ));
			}
			else{
				List<MoveAction> inDanger = new ArrayList<>();
				for(MoveAction move : moves){
					for(Token token : tokens){
						if(token.field().inTrackArea() ){
							if( token.field().position() + 5 < move.destination().position() ||
								token.field().position() - 5 > move.destination().position() ){
								
								inDanger.add(move);
							}
						}
					}
				}
				if( inDanger.isEmpty()){
					/*
					 * Number 4
					 * Mit der vordersten Spielfigur ziehen.
					 */
					statistics(4);
					return actions.indexOf( sortPosition(moves).get(0) );
				}
				else{
					/*
					 * Number 6
					 * Mit der ersten gef�hrdeten Spielfigur ziehen.
					 */
					statistics(6);
					return actions.indexOf( inDanger.get(0) );
				}
			}			
		}
	}
}
