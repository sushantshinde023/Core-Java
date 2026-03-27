package com.sushant.prototype.pattern;

import java.util.List;

public class OrderTracker {
	
	public static void main(String[] args) {
		
		PizzaFlavor hawaiian = new PizzaFlavor("Hawaiian");
		
		//here we are createing pizza objects with same flavor
		
		Pizza hawaiianPizza1= new Pizza(4,hawaiian);
		Pizza hawaiianPizza2= new Pizza(4,hawaiian);
		Pizza hawaiianPizza3= new Pizza(4,hawaiian);
		Pizza hawaiianPizza4= new Pizza(4,hawaiian);
		Pizza hawaiianPizza5= new Pizza(4,hawaiian);
		
		PizzaFlavor pepperoni = new PizzaFlavor("Pepperoni");
		
		Pizza pepperoniizza1= new Pizza(5,pepperoni);
		Pizza pepperoniizza2= new Pizza(5,pepperoni);
		Pizza pepperoniizza3= new Pizza(5,pepperoni);
		Pizza pepperoniizza4= new Pizza(5,pepperoni);
		Pizza pepperoniizza5= new Pizza(5,pepperoni);
		
		List<Meal> order=List.of(hawaiianPizza1,hawaiianPizza2,hawaiianPizza3,hawaiianPizza4,hawaiianPizza5,
				pepperoniizza1,pepperoniizza2,pepperoniizza3,pepperoniizza4,pepperoniizza5);
		
		placeOrder(order);
	}

	private static void placeOrder(List<Meal> order) {
		System.out.println("order placed");
		order.forEach(System.out::println);
		
	}

}
