package com.sushant.structural.flyweight.pattern;

public class Restaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//With this code new object is created for each one 
//		var pizza1=new Order("Pizza");//com.sushant.structural.flyweight.pattern.Order@5b6f7412
//		var pizza2=new Order("Pizza");//Order@27973e9b
//		var pizza3=new Order("Pizza");//Order@312b1dae
		
		var pizza1=OrderFactory.createOrder("Pizza");
		var pizza2=OrderFactory.createOrder("Pizza");
		var pizza3=OrderFactory.createOrder("Pizza");
		System.out.println(pizza1);
		System.out.println(pizza2);
		System.out.println(pizza3);
		
//		var burger1=new Order("Burger");
//		var burger2=new Order("Burger");
//		var burger3=new Order("Burger");
		var burger1=OrderFactory.createOrder("Burger");
		var burger2=OrderFactory.createOrder("Burger");
		var burger3=OrderFactory.createOrder("Burger");
		System.out.println(burger1);
		System.out.println(burger2);
		System.out.println(burger3);
		
		

	}

}
