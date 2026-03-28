package com.sushant.abtract.factories.pattern;



public class BikeManufacturer {
	public static void main(String[] args) {
		Bike roadBike=buildBike("ROAD");
		Bike mountainBike=buildBike("MOUNTAIN");
		
		System.out.println(roadBike);
		System.out.println(mountainBike);

	}

	private static Bike buildBike(String bikeType) {
		// TODO Auto-generated method stub
			var roadBikeFactory=FactoryMaker.createFactory(bikeType);
			var handlebars=roadBikeFactory.createHandlebars();
			var pedals= roadBikeFactory.createPedals();
			var frontTire=roadBikeFactory.createTire();
			var backTire= roadBikeFactory.createTire();
			return new Bike(handlebars,pedals,frontTire,backTire);
	}

}
