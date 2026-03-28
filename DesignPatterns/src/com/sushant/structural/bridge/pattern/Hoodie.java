package com.sushant.structural.bridge.pattern;

public class Hoodie implements ClothingItem {
	private final Size size;
	
	Hoodie(Size size){
		this.size=size;
	}
	@Override
	public void getType() {
		System.out.println("Hoodie");

	}

	@Override
	public Size getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
