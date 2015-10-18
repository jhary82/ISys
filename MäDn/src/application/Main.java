package application;

import ludo.LudoApp;
import strategies.*;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {
		AbstractStrategy red = new TakeFirstBeatTokenStrategy(true); // Replace with your implementation
		AbstractStrategy blue = new TakeRandomActionStrategy(false); // Replace with your implementation
		AbstractStrategy green = new TakeRandomActionStrategy(false); // Replace with your implementation
		AbstractStrategy orange = new TakeRandomActionStrategy(false);// Replace with your implementation
		AbstractStrategy darkred = new TakeRandomActionStrategy(false);
		AbstractStrategy purple = new TakeRandomActionStrategy(false);
		
		LudoApp.setStrategies(red, blue, green, orange/*, darkred, purple*/);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
