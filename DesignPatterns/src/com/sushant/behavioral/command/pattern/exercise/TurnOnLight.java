package com.sushant.behavioral.command.pattern.exercise;

public class TurnOnLight implements LightOperation {
	
	private final Light light;
	

	public TurnOnLight(Light light) {
		super();
		this.light = light;
	}


	@Override
	public void execute() {
		light.turnOnLight();
	}

}
