package application;

import ludo.LudoApp;
import strategies.*;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {
		AbstractStrategy red = new TakeFirstTokenStrategy(); // Replace with your implementation
		AbstractStrategy blue = new TakeRandomActionStrategy(); // Replace with your implementation
		AbstractStrategy green = new TakeRandomActionStrategy(); // Replace with your implementation
		//AbstractStrategy orange = new TakeRandomActionStrategy(); // Replace with your implementation
		
		LudoApp.setStrategies(red, blue, green);
		LudoApp.launch(LudoApp.class, args);
	}
	
}
