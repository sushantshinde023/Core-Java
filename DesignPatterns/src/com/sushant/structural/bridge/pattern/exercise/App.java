package com.sushant.structural.bridge.pattern.exercise;

public class App {
	
	public static void main(String[] args) {
		var rectangle=new Rectangle(new Red());
		rectangle.getType();
		rectangle.getColor().get();
		
		var circle=new Circle(new Blue());
		circle.getType();
		circle.getColor().get();
	}

}
