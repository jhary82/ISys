/**
 * 
 */
package strategy;

import java.util.List;

import ludo.AbstractAction;
import ludo.Token;

/**
 * Diese Strategie versucht möglichst sichere Züge zu machen.
 * Andere Token werden gemieden oder geschlagen.
 * @author Simon
 * 
 */
public class FleeAndKillStrategy extends Strategy {

	public FleeAndKillStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, List<AbstractAction> arg3) {

		return 0;
	}

}
