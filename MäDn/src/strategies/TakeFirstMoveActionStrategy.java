package strategies;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Klasse implementiert eine einfache Strategie.
 * Es wird bei jedem Zug die erste MoveAktion der Liste der möglichen
 * Aktionen durchgeführt. Wenn keine gefunden wurde, wird eine zufällige Aktion
 * durchgeführt.
 * @author Simon
 *
 */
public class TakeFirstMoveActionStrategy extends Strategy {

	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, 
			List<AbstractAction> arg3) {
		
		for(int i = 0; i < arg3.size(); i++){
			if( arg3.get(i).getClass().equals(MoveAction.class)){
				return i;
			}
		}
								
		return new Random().nextInt(arg3.size());
	}

}
