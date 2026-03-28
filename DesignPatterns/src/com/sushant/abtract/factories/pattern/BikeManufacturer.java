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
		
		if(bikeType.equalsIgnoreCase("ROAD")) {
			var roadBikeFactory=new RoadBikeFactory();
			var handlebars=roadBikeFactory.createHandlebars();
			var pedals= roadBikeFactory.createPedals();
			var frontTire=roadBikeFactory.createTire();
			var backTire= roadBikeFactory.createTire();
			return new Bike(handlebars,pedals,frontTire,backTire);
			//return new Bike(new RoadBikeHandlebars(),new RoadBikePedals(),new RoadBikeTire(),new RoadBikeTire());
		}else if(bikeType.equalsIgnoreCase("MOUNTAIN")) {
			var mountainBikeFactory=new MountainBikeFactory();
			var handlebars=mountainBikeFactory.createHandlebars();
			var pedals= mountainBikeFactory.createPedals();
			var frontTire=mountainBikeFactory.createTire();
			var backTire= mountainBikeFactory.createTire();
			return new Bike(handlebars,pedals,frontTire,backTire);
			//return new Bike(new MountainBikeHanldeBars(),new MountainBikePedals(),new MountainBikeTire(),new MountainBikeTire());
		}else {
			throw new IllegalArgumentException("Illegal bike type");
		}
	}

}
