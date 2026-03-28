package com.sushant.structural.bridge.pattern.exercise;

public class Circle implements Shape {
	
	private final Color color;
	
	public Circle(Color color) {
		this.color=color;
	}

	@Override
	public void getType() {
		System.out.println("Circle");

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}
