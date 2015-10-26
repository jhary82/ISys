package application;

import ludo.LudoApp;
import strategy.*;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {		
		//AbstractStrategy red = new TakeFirstBeatTokenStrategy(false, 0, "TakeFirstBeatStrategy"); // Replace with your implementation
		//AbstractStrategy red = new KillAndFleeStrategy(false, 0, "KillAndFleeStrategy"); // Replace with your implementation
		AbstractStrategy red = new TFBTandKAF(true, 0, "TFBTandKAF"); // Replace with your implementation
		AbstractStrategy blue = new TakeRandomActionStrategy(); // Replace with your implementation
		AbstractStrategy green = new TakeRandomActionStrategy(); // Replace with your implementation
		AbstractStrategy orange = new TakeRandomActionStrategy();// Replace with your implementation
		AbstractStrategy darkred = new TakeRandomActionStrategy();
		AbstractStrategy purple = new TakeRandomActionStrategy();
		
		LudoApp.setStrategies(red, blue, green, orange, darkred, purple);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
