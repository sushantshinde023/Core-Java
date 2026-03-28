package com.sushant.factory.method.pattern.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class VendingMachine {
	
	private static final Map<String,Supplier<Snack>> snackSupplier=new HashMap<>();
	static {
		snackSupplier.put("Chips",Chips::new);
		snackSupplier.put("Drink",Drink::new);
		snackSupplier.put("ChocolateBar",ChocolateBar::new);
	}
	public Snack getSnack(String snackType) {
		// TODO Auto-generated method stub
		if(snackSupplier.get(snackType)!=null) {
			return snackSupplier.get(snackType).get();
		}else {
			throw new IllegalArgumentException("Snack type is not available");
		}
	}

}
