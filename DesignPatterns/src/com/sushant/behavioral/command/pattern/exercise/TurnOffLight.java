package com.sushant.behavioral.command.pattern.exercise;

public class TurnOffLight implements LightOperation {
	
	private final Light light;
	

	public TurnOffLight(Light light) {
		super();
		this.light = light;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.turnOffLight();
	}

}
