package com.sushant.behavioral.command.pattern.exercise;

public class LightCommandExecutor {
	
	public void doOperation(LightOperation lightOperation) {
		lightOperation.execute();
	}

}
