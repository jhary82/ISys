package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;
/**
 * Diese Strategie ist eine Kombination auf den Strategien TakeFirstBeatToken und KillAndFlee.
 * @author Erik und Simon
 *
 */
public class TFBTandKAF extends Strategy {

	/**
	 * Konstruktor fuer die Strategie.
	 * @param evaluate - true, wenn die Strategie statistisch erfasst werden soll.
	 * @param ownIndex - Den eigenen Index
	 * @param csvName - Name der Datei fuer die Statistik
	 */
	public TFBTandKAF(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
	}
	/**
	 * Standart-Konstruktor
	 */
	public TFBTandKAF(){
		super(true, 0, "TFBTandKAF");
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
			 * Keine Zugmoeglichkeit
			 */
			statistics(1);
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
						statistics(2);
						return actions.indexOf(actMove);
					} else if (sortMoves.get(0).equals(actMove)	&& actMove.token().field().position() + die == actMove.destination().position()) {
						/*
						 * Number 3
						 * Mit der vordersten Spielfigur nach vorne schlagen.
						 */
						statistics(3);
						return actions.indexOf(actMove);
					} else {
						/*
						 * Number 4
						 * Mit der vorderste Spielfigur ziehen.
						 */
						statistics(4);
						return actions.indexOf(sortMoves.get(0));
					}
				}
			} else {
				List<MoveAction> inDanger = new ArrayList<>();
				for (MoveAction move : moves) {
					for (Token token : tokens) {
						if (token.field().inTrackArea()) {
							if (token.field().position() + 5 < move.destination().position()
								|| token.field().position() - 5 > move.destination().position()) {

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
					 * Mit der ersten gefaehrdeten Spielfigur ziehen.
					 */
					statistics(6);
					return actions.indexOf( inDanger.get(0) );
				}
			}
		}
		/*
		 * Number 4
		 * Mit der vorderste Spielfigur ziehen.
		 */
		statistics(4);
		return actions.indexOf(sortMoves.get(0));
	}
}
