package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie nimm eine der folgenden Strategie: 1. Schl�ge, mit der
 * Spielfigur, die am weitesten vorne liegt. 2. Schlage, mit irgendeine
 * Spielfigur. 3. Ziehe, mit der Spielfigur die am weitesten vorne liegt.
 * 
 * @author Erik
 *
 */
public class TakeFirstBeatTokenStrategy extends Strategy {
	
	public TakeFirstBeatTokenStrategy(boolean evaluate, int ownIndex) {
		super(evaluate, ownIndex);
		// TODO Auto-generated constructor stub
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
		return hits;
	}
	
	public List<MoveAction> sortPosition(List<MoveAction> moves) {
		MoveAction move = null;
		for(int i = 0; i < moves.size()-1; i++) {
			boolean first = moves.get(i).destination().position() > moves.get(i+1).destination().position();
			if(first) {
				if(moves.get(i).destination().inHomeArea()) {
					
				}
			}
		}
		
		/*MoveAction move = moves.get(0);
		for(MoveAction actMove : moves) {
			boolean first = actMove.destination().position() > move.destination().position();
			if(first) {
				if(actMove.destination().inHomeArea()) {
					
				}
			}
		}*/
		/*
		 * 
		 */
		/*MoveAction move = moves.get(0);
		for (MoveAction actMove : moves) {
				boolean first = actMove.destination().position() > move.destination().position();
				if (first) {
					if(!actMove.token().field().inHomeArea()){
						if (actMove.destination().inHomeArea()) {
							return moves.indexOf(actMove);
						} else {
							move = actMove;
						}
					}
					move = actMove;
				}
			
		}*/
		/*
		 * 
		 */
		return null;
	}
	
	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();
		//List<MoveAction> hits = new ArrayList<>();

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
			 * 
			 */
			//hits = canHit(tokens, moves);
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
