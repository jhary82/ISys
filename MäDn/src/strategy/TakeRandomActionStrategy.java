package strategy;

import java.util.List;
import java.util.Random;

import ludo.AbstractAction;
import ludo.Token;

/**
 * Bei dieser Strategie wird immer eine zufaellige Aktion durchgefuehrt.
 * @author Simon und Erik
 *
 */
public class TakeRandomActionStrategy extends Strategy{

	/**
	 * Standart-Konstruktor
	 */
	public TakeRandomActionStrategy(){
		super(false, -1, "");
	}
	/**
	 * Konstruktor fuer die Strategie.
	 * @param evaluate - true, wenn die Strategie statistisch erfasst werden soll.
	 * @param ownIndex - Den eigenen Index
	 * @param csvName - Name der Datei fuer die Statistik
	 */
	public TakeRandomActionStrategy(boolean evaluate, int ownIndex, String csvName) {
		super(evaluate, ownIndex, csvName);
	}
	
	@Override
	public int chooseAction(List<Token> arg0, int arg1, int arg2, List<AbstractAction> arg3) {

		return new Random().nextInt(arg3.size());
	}
	

}
