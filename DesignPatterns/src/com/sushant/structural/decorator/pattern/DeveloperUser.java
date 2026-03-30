package com.sushant.structural.decorator.pattern;

public class DeveloperUser  extends UserDecorator{

	public DeveloperUser(User user) {
		super(user);
	}
	
	@Override
	public void printPrevileges() {
		super.printPrevileges();
		System.out.println("Can deploy to production");
	}

}
