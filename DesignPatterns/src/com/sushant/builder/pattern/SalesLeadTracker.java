package com.sushant.builder.pattern;

import java.time.LocalDate;

public class SalesLeadTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var person1= new Person.PersonBuilder("Tracy","westby").dateOfBirth( LocalDate.of(1985, 1,1)).emailAddress("tracy@example.com").build();
		
		
		addPersonToLeadTracker(person1);
	
		var person2=new Person.PersonBuilder("Jerome", "donaldson").phoneNumber("123456789").build();
		addPersonToLeadTracker(person2);
		
		
		//with builder pattern
		var person3= new Person.PersonBuilder("Sushant","Shinde").emailAddress("sush@gmail.com").build();
		addPersonToLeadTracker(person3);

	}

	private static void addPersonToLeadTracker(Person person) {		
		System.out.println("A person added to lead tracker : \n "+person);
		
	}

}
