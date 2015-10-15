package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.AbstractStrategy;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie nimm eine der folgenden Strategie: 1. Schläge, mit der
 * Spielfigur, die am weitesten vorne liegt. 2. Schlage, mit irgendeine
 * Spielfigur. 3. Ziehe, mit der Spielfigur die am weitesten vorne liegt.
 * 
 * @author Erik
 *
 */
public class TakeFirstBeatTokenStrategy extends Strategy {

	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();

		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).getClass().equals(MoveAction.class)) {
				moves.add((MoveAction) actions.get(i));
			}
		}
		if (moves.isEmpty()) {
			return new Random().nextInt(actions.size());
		} else {
			MoveAction move = moves.get(0);
			for (MoveAction actMove : moves) {
				for (Token actToken : tokens) {
					boolean beat = actToken.field().position() == actMove.destination().position();
					boolean first = actMove.destination().position() > move.destination().position();
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
