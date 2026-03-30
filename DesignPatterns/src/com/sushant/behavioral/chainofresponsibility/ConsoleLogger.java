package com.sushant.behavioral.chainofresponsibility;

import com.sushant.behavioral.chainofresponsibility.LoggerRequest.LoggerType;

public class ConsoleLogger extends Logger {

	public ConsoleLogger(Logger nextLogger) {
		super(nextLogger);
	}

	@Override
	public void log(LoggerRequest request) {
		if(request.getLoggerType() ==LoggerType.CONSOLE) {
			System.out.println(request.getMessage());
		}else if(nextLogger!=null) {
			nextLogger.log(request);
		}
		
		
	}

}
