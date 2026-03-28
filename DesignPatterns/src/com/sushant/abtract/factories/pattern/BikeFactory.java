package com.sushant.abtract.factories.pattern;

public interface BikeFactory {
	
	Handlebars createHandlebars();
	Pedals createPedals();
	Tire createTire();

}
