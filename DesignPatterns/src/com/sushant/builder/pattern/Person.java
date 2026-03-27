package com.sushant.builder.pattern;

import java.time.LocalDate;

public class Person {
	
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final LocalDate dateOfBirth;
	private final String emailAddress;
	private final String phoneNumber;
	
	private Person(PersonBuilder personBuilder) {
		super();
		this.firstName = personBuilder.firstName;
		this.middleName = personBuilder.middleName;
		this.lastName = personBuilder.lastName;
		this.dateOfBirth = personBuilder.dateOfBirth;
		this.emailAddress = personBuilder.emailAddress;
		this.phoneNumber = personBuilder.phoneNumber;
		
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	public static class PersonBuilder{
		
		private final String firstName;
		private String middleName;
		private final String lastName;
		private  LocalDate dateOfBirth;
		private String emailAddress;
		private  String phoneNumber;
		
		//Whatever are mandatory fields we will make them as final and add those to builder constructor
		public PersonBuilder(String firstName,String lastName) {
			this.firstName=firstName;
			this.lastName=lastName;
		}
		
		//Optional ones are not final and we will be adding methods to set those, these will going to return PersonBuilder object
		//we will set partivular field in builder object and return builder object
		public PersonBuilder middleName(String middleName) {
			this.middleName=middleName;
			return this;
		}
		public PersonBuilder dateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth=dateOfBirth;
			return this;
		}
		public PersonBuilder emailAddress(String emailAddress) {
			this.emailAddress=emailAddress;
			return this;
		}
		public PersonBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber=phoneNumber;
			return this;
		}
	
		
		//after that we will have build method
		public Person build() {
			return new Person(this);
		}
		
		
	}

}
