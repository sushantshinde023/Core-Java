package com.sushant.behavioral.command.pattern.exercise;

public class App {
	public static void main(String[] args) {
		var light=new Light();
//		light.isOn();
//		light.turnOnLight();
//		light.isOn();
//		light.turnOffLight();
//		light.isOn();
		
		var lightCommandExecutor=new LightCommandExecutor();
		light.isOn();
		lightCommandExecutor.doOperation(new TurnOnLight(light));
		light.isOn();
		
	}
	

}
