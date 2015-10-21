package application;

import ludo.LudoApp;
import strategy.*;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {		
		AbstractStrategy red = new TakeFirstBeatTokenStrategy(true, 0, "TakeFirstBeatStrategy"); // Replace with your implementation
		//AbstractStrategy red = new KillAndFleeStrategy(true, 0, "KillAndFleeStrategy"); // Replace with your implementation
		AbstractStrategy blue = new TakeRandomActionStrategy(); // Replace with your implementation
		AbstractStrategy green = new TakeRandomActionStrategy(); // Replace with your implementation
		AbstractStrategy orange = new TakeRandomActionStrategy();// Replace with your implementation
		AbstractStrategy darkred = new TakeRandomActionStrategy();
		AbstractStrategy purple = new TakeRandomActionStrategy();
		
		LudoApp.setStrategies(red, blue, green, orange/*, darkred, purple*/);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
