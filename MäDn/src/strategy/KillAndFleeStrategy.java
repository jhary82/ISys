/**
 * 
 */
package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.MoveAction;
import ludo.Token;

/**
 * Diese Strategie versucht möglichst sichere Züge zu machen.
 * Andere Token werden geschlagen oder gemieden.
 * @author Simon
 * 
 */
public class KillAndFleeStrategy extends Strategy {

	public KillAndFleeStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
		// TODO Auto-generated constructor stub
	}

	public KillAndFleeStrategy()  {
		super(true, 0, "KAF");
	}
	
	@Override
	public int chooseAction(List<Token> tokens, int turn, int die, List<AbstractAction> actions) {
		List<MoveAction> moves = new ArrayList<>();
		List<MoveAction> hits = new ArrayList<>();
		
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).getClass().equals(MoveAction.class)) {
				moves.add((MoveAction) actions.get(i));
			}
		}
		if (moves.isEmpty()) {
			return new Random().nextInt(actions.size());
		} else {
			
			hits = canHit(tokens, moves);						
			if(!hits.isEmpty()){
				return actions.indexOf( hits.get( new Random().nextInt(hits.size()) ));
			}
			else{
				List<MoveAction> inDanger = new ArrayList<>();
				for(MoveAction move : moves){
					for(Token token : tokens){
						if(token.field().inTrackArea() ){
							if( token.field().position() + 6 < move.destination().position() ||
								token.field().position() - 6 > move.destination().position() ){
								
								inDanger.add(move);
							}
						}
					}
				}
				
				if( inDanger.isEmpty()){
					return actions.indexOf( sortPosition(moves).get(0) );
				}
				else{
					return actions.indexOf( inDanger.get(0) );
				}
			}			
		}
		
	}

}
