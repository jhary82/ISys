package strategies;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Klasse implementiert eine einfache Strategie.
 * Es wird bei jedem Zug die erste MoveAktion der Liste der m�glichen
 * Aktionen durchgef�hrt. Wenn keine gefunden wurde, wird eine zuf�llige Aktion
 * durchgef�hrt.
 * @author Simon
 *
 */
public class TakeFirstMoveActionStrategy extends Strategy {

	public TakeFirstMoveActionStrategy(boolean savable) {
		super(savable);
		// TODO Auto-generated constructor stub
	}

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
