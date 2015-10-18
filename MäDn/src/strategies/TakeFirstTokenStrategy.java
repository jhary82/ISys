/**
 * 
 */
package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie nimmt, wenn m�glich, die Spielfigur, die am weitesten vorne liegt.
 * Ansonsten wird eine zuf�llige Aktion ausgew�hlt.
 * @author Simon
 *
 */
public class TakeFirstTokenStrategy extends Strategy{

	public TakeFirstTokenStrategy(boolean savable) {
		super(savable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, List<AbstractAction> arg3) {
		List<MoveAction> moves = new ArrayList<>(); 		
		
		for(int i = 0; i < arg3.size(); i++){
			if( arg3.get(i).getClass().equals(MoveAction.class)){
				moves.add((MoveAction)arg3.get(i));
			}
		}
		
		if(moves.isEmpty()){
			return new Random().nextInt(arg3.size());
		}
		else{
			MoveAction bestPosition = moves.get(0);
			for( MoveAction act: moves){
				if( act.destination().position() > bestPosition.destination().position()){
					if(act.destination().inHomeArea()){
						bestPosition = act;
					} else {
						bestPosition = act;
					}
					
				}
			}
			return  arg3.indexOf(bestPosition) ;
		}
	}

}
