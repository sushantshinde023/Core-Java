package com.sushant.structural.bridge.pattern;

public class Shirt implements ClothingItem {
	private final Size size;
	
	public Shirt(Size size) {
		this.size=size;
	}
	@Override
	public void getType() {
		// TODO Auto-generated method stub
		System.out.println("Shirt");
	}
	@Override
	public Size getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
