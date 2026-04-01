package com.sushant.behavioral.strategy.pattern;

public class App {

	public static void main(String[] args) {
		var loginPage = new LoginPage();
		
		loginPage.logInUser(new PasswordAuthenticator());
		loginPage.logInUser(new SingleSignOnAuthenticator());

	}

}
