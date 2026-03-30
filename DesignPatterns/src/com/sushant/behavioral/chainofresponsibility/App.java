package com.sushant.behavioral.chainofresponsibility;

import com.sushant.behavioral.chainofresponsibility.LoggerRequest.LoggerType;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		var message="Hello world";
//		var request=new LoggerRequest(message, LoggerType.FILE);
//		Logger logger=new FileLogger();// and here as well we will have to use FileLogger instead of ConsoleLogger these are tightly coupled
//		logger.log(request);
		
		var message="Hello World";
		var request = new LoggerRequest(message,LoggerType.CONSOLE);
		Logger logger=buildChain();
		logger.log(request);

	}
	
	private static Logger buildChain() {
		var fileLogger=new FileLogger(null);
		var consoleLogger = new ConsoleLogger(fileLogger);
		return consoleLogger;
	}

}
