package com.sushant.structural.flyweight.pattern;

public class Order {
	
	private String name;
	
	public Order(String name) {
		this.name=name;
		System.out.println("Creating "+name+" Object");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		System.out.println("Done creating "+name+"  name");
	}

}
