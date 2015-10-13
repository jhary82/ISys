/**
 * 
 */
package strategies;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.AbstractStrategy;
import ludo.MoveAction;
import ludo.PlayerStats;
import ludo.Token;

/**
 * @author Erik
 *
 */
public class TakeLastMoveActionStrategy extends AbstractStrategy {
	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		
		for(int i = actions.size(); i > 0; i--){
			if( actions.get(i-1).getClass().equals(MoveAction.class)){
				return i-1;
			}
		}
								
		return new Random().nextInt(actions.size());
	}
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		/*
		 * Datei erstellen und die ergebnisse da rein kopieren.
		 */
	}
}
