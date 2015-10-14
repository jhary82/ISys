/**
 * 
 */
package strategies;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.Token;

/**
 * Bei dieser Strategie wird immer eine zufällige Aktion durchgeführt.
 * @author Simon
 *
 */
public class TakeRandomActionStrategy extends Strategy{

	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, List<AbstractAction> arg3) {

		return new Random().nextInt(arg3.size());
	}

}
