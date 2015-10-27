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

	public TakeFirstBeatTokenStrategy() {
		super(true, 0, "TFBT");
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
			/*
			 * Number 1
			 * Keine Zugmoeglichkeit.
			 */
			//statistics(1);
			return new Random().nextInt(actions.size());
		} else {
			hits = canHit(tokens, moves);
			sortMoves = sortPosition(moves);
			int anzahlFelder = tokens.size() / 4 * 12 - 1;
			if (!hits.isEmpty()) {
				for (MoveAction actMove : hits) {
					if (actMove.destination().position() >= anzahlFelder - 6) {
						/*
						 * Number 2
						 * Sonderfall rueckschlagen um in die Homebase zu
						 * kommen.
						 */
						//statistics(2);
						return actions.indexOf(actMove);
					} else if (sortMoves.get(0).equals(actMove)	&& actMove.token().field().position() + die == actMove.destination().position()) {
						/*
						 * Number 3
						 * Mit der vordersten Spielfigur nach vorne schlagen.
						 */
						//statistics(3);
						return actions.indexOf(actMove);
					} else {
						/*
						 * Number 4
						 * Mit der vorderste Spielfigur ziehen.
						 */
						//statistics(4);
						return actions.indexOf(sortMoves.get(0));
					}
				}
			} else {
				/*
				 * Number 4
				 * Mit der vorderste Spielfigur ziehen.
				 */
				//statistics(4);
				return actions.indexOf(sortMoves.get(0));
			}
		}
		/*
		 * Number4
		 * Mit der vorderste Spielfigur ziehen.
		 */
		//statistics(4);
		return actions.indexOf(sortMoves.get(0));
	}
}