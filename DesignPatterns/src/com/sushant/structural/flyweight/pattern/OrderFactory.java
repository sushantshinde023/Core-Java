package com.sushant.structural.flyweight.pattern;

import java.util.HashMap;
import java.util.Map;

public class OrderFactory {
	
	private static final Map<String,Order> orderCache=new HashMap<>();
	
	public static Order createOrder(String name) {
//		if(orderCache.containsKey(name)) {
//			return orderCache.get(name);
//		}
//		var order=new Order(name);
//		orderCache.put(name, order);
//		return order;
		
		return orderCache.computeIfAbsent(name, Order::new);
	}

}
