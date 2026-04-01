package com.sushant.behavioral.strategy.pattern;

public class LoginPage {
	
	public void logInUser(Authenticator authenticator) {
		authenticator.logIn();
	}

}
