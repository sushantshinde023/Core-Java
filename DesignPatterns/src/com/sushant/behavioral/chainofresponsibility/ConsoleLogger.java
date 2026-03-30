package com.sushant.behavioral.chainofresponsibility;

public class ConsoleLogger extends Logger {

	@Override
	public void log(LoggerRequest request) {
		System.out.println(request.getMessage());
		
	}

}
