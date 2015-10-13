package application;

import ludo.LudoApp;
import strategies.TakeFirstMoveActionStrategy;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {
		AbstractStrategy red = new TakeFirstMoveActionStrategy(); // Replace with your implementation
		AbstractStrategy blue = new TakeFirstMoveActionStrategy(); // Replace with your implementation
		AbstractStrategy green = new TakeFirstMoveActionStrategy(); // Replace with your implementation
		AbstractStrategy orange = new TakeFirstMoveActionStrategy(); // Replace with your implementation
		
		LudoApp.setStrategies(red, blue, green, orange);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
