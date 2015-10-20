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
			/*
			 * Sonderfall rueckschlagen um in die Homebase zu kommen.
			 */
			hits = canHit(tokens, moves);
			sortMoves = sortPosition(moves);
			MoveAction move = moves.get(0);
			for (MoveAction actMove : moves) {
				for (Token actToken : tokens) {
					boolean beat = actToken.field().position() == actMove.destination().position();
					boolean first = actMove.destination().position() > move.destination().position();
					/*
					 * in Strategy als methode auslagern
					 */
					if (beat && first) {
						return moves.indexOf(actMove);
					} else if (beat) {
						return moves.indexOf(actMove);
					} else if (first) {
						if(!actMove.token().field().inHomeArea()){
							if (actMove.destination().inHomeArea()) {
								return moves.indexOf(actMove);
							} else {
								move = actMove;
							}
						}
						move = actMove;
					}
				}
			}
			return actions.indexOf(move);
		}
		
	}
}
