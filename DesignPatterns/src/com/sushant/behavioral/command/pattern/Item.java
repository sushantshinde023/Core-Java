package com.sushant.behavioral.command.pattern;

public class Item {
	
	private final int id;
	
	public Item(int id) {
		this.id=id;
	}
	
	//currently actions on item are tightly coupled with Item class
	
	public void addToBasket() {
		System.out.println("Item "+id+" added to basket.");
	}
	
	public void removeFromBasket() {
		System.out.println("Item "+id+" removed from basket.");
	}

}
