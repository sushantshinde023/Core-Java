package com.sushant.singleton.pattern.logger;

public enum Logger {
	
	INSTANCE;
	
	private Logger() {
		
	}
	
	public Logger getLoggerInsance() {
		return INSTANCE;
	}
	
	public void log(String logMessage) {
		System.out.println(logMessage);
	}

}
