package com.sushant.structural.bridge.pattern.exercise;

public class Rectangle implements Shape {
	
	private final Color color;
	
	public Rectangle(Color color) {
		this.color=color;
	}

	@Override
	public void getType() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle");

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

}
