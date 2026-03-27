package com.sushant.prototype.pattern;

import java.util.List;

public class OrderTracker {
	
	public static void main(String[] args) {
		
		PizzaFlavor hawaiian = new PizzaFlavor("Hawaiian");
		
		//here we are createing pizza objects with same flavor
		
		Pizza hawaiianPizza1= new Pizza(4,hawaiian);
		Pizza hawaiianPizza2= hawaiianPizza1.clone();
		Pizza hawaiianPizza3= hawaiianPizza1.clone();
		Pizza hawaiianPizza4= hawaiianPizza1.clone();
		Pizza hawaiianPizza5= hawaiianPizza1.clone();
		hawaiian.setName("hawaiian with extra cheese");
		
		PizzaFlavor pepperoni = new PizzaFlavor("Pepperoni");
		
		Pizza pepperoniizza1= new Pizza(5,pepperoni);
		Pizza pepperoniizza2= pepperoniizza1.clone();
		Pizza pepperoniizza3= pepperoniizza1.clone();
		Pizza pepperoniizza4= pepperoniizza1.clone();
		Pizza pepperoniizza5= pepperoniizza1.clone();
		
		List<Meal> order=List.of(hawaiianPizza1,hawaiianPizza2,hawaiianPizza3,hawaiianPizza4,hawaiianPizza5,
				pepperoniizza1,pepperoniizza2,pepperoniizza3,pepperoniizza4,pepperoniizza5);
		
		placeOrder(order);
	}

	private static void placeOrder(List<Meal> order) {
		System.out.println("order placed");
		order.forEach(System.out::println);
		
	}

}
