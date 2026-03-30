package com.sushant.structural.proxy.pattern;

public class User {
	
	private String name;
	
	private final boolean isPremium;

	public User(String name,boolean isPremium) {
		super();
		this.name = name;
		this.isPremium=isPremium;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public boolean isPremium() {
		return isPremium;
	}
	
}
