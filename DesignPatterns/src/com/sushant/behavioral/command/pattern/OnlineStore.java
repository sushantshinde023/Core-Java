package com.sushant.behavioral.command.pattern;

public class OnlineStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var item1=new Item(1);
		var item2=new Item(2);
		var item3=new Item(3);
		
		item1.addToBasket();
		item2.addToBasket();
		item3.addToBasket();
		item2.removeFromBasket();

	}

}
