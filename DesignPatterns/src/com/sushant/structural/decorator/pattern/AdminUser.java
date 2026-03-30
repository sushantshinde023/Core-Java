package com.sushant.structural.decorator.pattern;

public class AdminUser extends UserDecorator {

	public AdminUser(User user) {
		super(user);
		
	}
	@Override
	public void printPrevileges() {
		super.printPrevileges();
		System.out.println("Can create new  user");
	}

}
