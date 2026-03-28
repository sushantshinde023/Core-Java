package com.sushant.abtract.factories.pattern;

public class MountainBikeFactory implements BikeFactory {

	@Override
	public Handlebars createHandlebars() {
		// TODO Auto-generated method stub
		return new MountainBikeHanldeBars();
	}

	@Override
	public Pedals createPedals() {
		// TODO Auto-generated method stub
		return new MountainBikePedals();
	}

	@Override
	public Tire createTire() {
		// TODO Auto-generated method stub
		return new MountainBikeTire();
	}

}
