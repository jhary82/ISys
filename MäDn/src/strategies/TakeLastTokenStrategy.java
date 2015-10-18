package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;
/**
 * schlechte Strategie
 * @author Erik
 *
 */
public class TakeLastTokenStrategy extends Strategy {




	public TakeLastTokenStrategy(boolean evaluate, int ownIndex) {
		super(evaluate, ownIndex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();
		for(int i = 0; i < actions.size(); i++) {
			if(actions.get(i).getClass().equals(MoveAction.class)) {
				moves.add((MoveAction) actions.get(i));
			}
		}
		if(moves.isEmpty()) {
			return new Random().nextInt(actions.size());
		} else {
			MoveAction bPosition = moves.get(0);
			for(MoveAction m : moves) {
				if(m.destination().position() < bPosition.destination().position()) {
					bPosition = m;
				}
			}
			return actions.indexOf(bPosition);
		}
	}

}
