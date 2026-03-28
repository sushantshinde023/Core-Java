package com.sushant.structural.bridge.pattern;

public class App {
	
	public static void main(String[] args) {
		var hoodie=new Hoodie(new AdultSize());
		hoodie.getType();
		hoodie.getSize().get();
		
		var childSize=new ChildSize();
		var shirt=new Shirt(childSize);
		shirt.getType();
		shirt.getSize().get();
	}

}
