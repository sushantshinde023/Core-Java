package com.sushant.abtract.factories.pattern;

public class RoadBikeFactory implements BikeFactory {

	@Override
	public Handlebars createHandlebars() {
		// TODO Auto-generated method stub
		return new RoadBikeHandlebars();
	}

	@Override
	public Pedals createPedals() {
		// TODO Auto-generated method stub
		return new RoadBikePedals();
	}

	@Override
	public Tire createTire() {
		// TODO Auto-generated method stub
		return new RoadBikeTire();
	}

}
