package strategies;

import java.util.List;

import ludo.AbstractStrategy;
import ludo.Player;
import ludo.PlayerStats;

public abstract class Strategy extends AbstractStrategy {
	
	@Override
	protected void onGameOver(List<PlayerStats> stats, int roundCount) {
		// TODO Auto-generated method stub
		super.onGameOver(stats, roundCount);
	}
	
	@Override
	protected void onRoundOver(Player winner, int turnCount) {
		// TODO Auto-generated method stub
		super.onRoundOver(winner, turnCount);
	}
	
	
	
}
