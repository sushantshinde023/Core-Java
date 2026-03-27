package com.sushant.prototype.pattern;

public class Pizza extends Meal{
	
	private PizzaFlavor pizzaFlavor;

	public Pizza(int price, PizzaFlavor pizzaFlavor) {
		super(price);
		this.pizzaFlavor=pizzaFlavor;
	}

	public PizzaFlavor getPizzaFlavor() {
		return pizzaFlavor;
	}

	public void setPizzaFlavor(PizzaFlavor pizzaFlavor) {
		this.pizzaFlavor = pizzaFlavor;
	}

	@Override
	public String toString() {
		return "Pizza [ price = "+super.getPrice()+"pizzaFlavor=" + pizzaFlavor + "]";
	}
	
	

}
