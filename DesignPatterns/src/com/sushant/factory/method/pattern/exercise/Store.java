package com.sushant.factory.method.pattern.exercise;

public class Store {
	
	private static final VendingMachine vendingMachine=new VendingMachine();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		buyChips();
		buyDrink();

	}

	private static void buyDrink() {
		// TODO Auto-generated method stub
		var snack=vendingMachine.getSnack("Drink");
		
		System.out.println("Drink purchased Price : $"+snack.getPrice());
		
	}

	private static void buyChips() {
		// TODO Auto-generated method stub
		var snack=vendingMachine.getSnack("Chips");
		System.out.println("Chips purchased. Price : $"+snack.getPrice());
		
	}

}
