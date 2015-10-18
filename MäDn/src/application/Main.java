package application;

import ludo.LudoApp;
import strategies.*;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {
		AbstractStrategy red = new TakeFirstBeatTokenStrategy(true,0); // Replace with your implementation
		AbstractStrategy blue = new TakeRandomActionStrategy(false,1); // Replace with your implementation
		AbstractStrategy green = new TakeRandomActionStrategy(false,2); // Replace with your implementation
		AbstractStrategy orange = new TakeRandomActionStrategy(false,3);// Replace with your implementation
		AbstractStrategy darkred = new TakeRandomActionStrategy(false,4);
		AbstractStrategy purple = new TakeRandomActionStrategy(false,5);
		
		LudoApp.setStrategies(red, blue, green, orange/*, darkred, purple*/);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
