/**
 * 
 */
package strategies;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.Player;
import ludo.PlayerStats;
import ludo.Token;

/**
 * Bei dieser Strategie wird immer eine zuf�llige Aktion durchgef�hrt.
 * @author Simon
 *
 */
public class TakeRandomActionStrategy extends Strategy{




	public TakeRandomActionStrategy(boolean evaluate, int ownIndex) {
		super(evaluate, ownIndex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, List<AbstractAction> arg3) {

		return new Random().nextInt(arg3.size());
	}
	

}
