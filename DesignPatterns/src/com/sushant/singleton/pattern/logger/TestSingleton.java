package com.sushant.singleton.pattern.logger;

public class TestSingleton {
	
	public static void main(String[] args) {
		var dog=new Dog();
		dog.woof();
		
		var cat = new Cat();
		cat.meow();
	}

}
