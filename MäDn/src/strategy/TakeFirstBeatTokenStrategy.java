package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie nimm eine der folgenden Strategie: 1. Schlaege, mit der
 * Spielfigur, die am weitesten vorne liegt. 2. Schlage, mit irgendeine
 * Spielfigur. 3. Ziehe, mit der Spielfigur die am weitesten vorne liegt.
 * 
 * @author Erik
 *
 */
public class TakeFirstBeatTokenStrategy extends Strategy {

	public TakeFirstBeatTokenStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
	}
	
	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();
		List<MoveAction> hits = new ArrayList<>();
		List<MoveAction> sortMoves = new ArrayList<>();
		
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).getClass().equals(MoveAction.class)) {
				moves.add((MoveAction) actions.get(i));
			}
		}
		if (moves.isEmpty()) {
			return new Random().nextInt(actions.size());
		} else {
			hits = canHit(tokens, moves);
			sortMoves = sortPosition(moves);
			int anzahlFelder = tokens.size()/4*12-1;
			if (!hits.isEmpty()) {
				for (MoveAction actMove : hits) {
					if (actMove.destination().position() >= anzahlFelder - 6) {
						/*
						 * Sonderfall rueckschlagen um in die Homebase zu kommen.
						 */
						return actions.indexOf(actMove);
					} else if (die < 3 && actMove.token().field().position() - die == actMove.destination().position()) {
						/*
						 * nach hinten schlagen bei würfelwert unter 3
						 */
							return actions.indexOf(actMove);
					} else if (die >= 3 && actMove.token().field().position() + die == actMove.destination().position()) {
						/*
						 * nach vorne schlagen bei würfelwert hoeher gleich 3
						 */
							return actions.indexOf(actMove);
					} else {
						return actions.indexOf(sortMoves.get(0));
					}
				}
			} else {
				if(sortMoves.size() > 2) {
					if (die < 3) {
						System.out.println("hallo3");
						return actions.indexOf(sortMoves.get(1));
					} else if (die >= 3) {
						System.out.println("hallo1");
						return actions.indexOf(sortMoves.get(0));
					} else {
						
						return actions.indexOf(sortMoves.get(0));
					}
				}
				
			}	
		}
		System.out.println("hallo2");
		return actions.indexOf(sortMoves.get(0));
	}
}

/*MoveAction move = moves.get(0);
for (MoveAction actMove : moves) {
	for (Token actToken : tokens) {
		boolean beat = actToken.field().position() == actMove.destination().position();
		boolean first = actMove.destination().position() > move.destination().position();
		if (beat && first) {
			return actions.indexOf(actMove);
		} else if (beat) {
			return actions.indexOf(actMove);
		} else if (first) {
			if(!actMove.token().field().inHomeArea()){
				if (actMove.destination().inHomeArea()) {
					return actions.indexOf(actMove);
				} else {
					move = actMove;
				}
			}
			move = actMove;
		}
	}
}
return actions.indexOf(move);
*/
