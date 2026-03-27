package com.sushant.singleton.pattern.logger;

public class Cat {
	private final Logger logger=Logger.INSTANCE;
	
	public void meow() {
		System.out.println("Hash code form Cat "+logger.hashCode());
		logger.log("Meow");
	}

}
