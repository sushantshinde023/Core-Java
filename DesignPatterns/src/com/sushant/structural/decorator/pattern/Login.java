package com.sushant.structural.decorator.pattern;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var user=new BasicUser();
		//user.printPrevileges();
		var adminUser=new AdminUser(user);
		adminUser.printPrevileges();
		var developerUser = new DeveloperUser(adminUser);
		
		developerUser.printPrevileges();
		
		
		

	}

}
