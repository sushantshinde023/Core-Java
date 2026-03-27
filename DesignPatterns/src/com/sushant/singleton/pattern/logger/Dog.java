package com.sushant.singleton.pattern.logger;

public class Dog {
	
	private final Logger logger=Logger.INSTANCE;
	
	public void woof() {
		System.out.println("Hash code form Dog "+logger.hashCode());
		logger.log("Woof");
	}

}
