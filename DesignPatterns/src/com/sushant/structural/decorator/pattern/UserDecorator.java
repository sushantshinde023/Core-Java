package com.sushant.structural.decorator.pattern;

public abstract class UserDecorator implements User {
	private final User user;
	
	public UserDecorator(User user) {
		this.user=user;
	}
	
	@Override
	public void printPrevileges() {
		user.printPrevileges();
	}
}
