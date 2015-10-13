package application;

import ludo.LudoApp;
import ludo.AbstractStrategy;

public class Main {
	public static void main(String[] args) {
		AbstractStrategy red = new MyStrategy(); // Replace with your implementation
		AbstractStrategy blue = new MyStrategy(); // Replace with your implementation
		AbstractStrategy green = new MyStrategy(); // Replace with your implementation
		AbstractStrategy orange = new MyStrategy(); // Replace with your implementation
		
		LudoApp.setStrategies(red, blue, green, orange);
		LudoApp.launch(LudoApp.class, args);
	}
}