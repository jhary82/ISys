package strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

public class TakeTokenDieStrategy extends Strategy {

	public TakeTokenDieStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>(); 
		MoveAction position = null;
		
		for(int i = 0; i < actions.size(); i++){
			if( actions.get(i).getClass().equals(MoveAction.class)){
				moves.add((MoveAction)actions.get(i));
			}
		}
		
		if(moves.isEmpty()){
			return new Random().nextInt(actions.size());
		}
		else if(!moves.isEmpty() && die > 3){
			position = takeFirstTokenStrategy(moves);
		} else if(!moves.isEmpty() && die < 3){
			
		}
		return  actions.indexOf(position) ;
	}
	
	private MoveAction takeFirstTokenStrategy(List<MoveAction> moves) {
		MoveAction bestPosition = moves.get(0);
		for( MoveAction act: moves){
			if( act.destination().position() > bestPosition.destination().position()){
				bestPosition = act;
			}
		}
		return bestPosition;
	}
	
	private int takeLastTokenStrategy() {
		return 0;
	}
	
}
