package com.sushant.behavioral.chainofresponsibility;

import com.sushant.behavioral.chainofresponsibility.LoggerRequest.LoggerType;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var message="Hello world";
		var request=new LoggerRequest(message, LoggerType.CONSOLE);
		Logger logger=new ConsoleLogger();
		logger.log(request);

	}

}
