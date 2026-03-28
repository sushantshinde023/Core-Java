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
			return new Bike(new RoadBikeHandlebars(),new RoadBikePedals(),new RoadBikeTire(),new RoadBikeTire());
		}else if(bikeType.equalsIgnoreCase("MOUNTAIN")) {
			return new Bike(new MountainBikeHanldeBars(),new MountainBikePedals(),new MountainBikeTire(),new MountainBikeTire());
		}else {
			throw new IllegalArgumentException("Illegal bike type");
		}
	}

}
