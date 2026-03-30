package com.sushant.behavioral.chainofresponsibility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.sushant.behavioral.chainofresponsibility.LoggerRequest.LoggerType;

public class FileLogger extends Logger{

	public FileLogger(Logger nextLogger) {
		super(nextLogger);
		
	}

	@Override
	public void log(LoggerRequest request) {
		if(request.getLoggerType()== LoggerType.FILE) {
		try {
			var writer=new BufferedWriter(new FileWriter("src/test.txt"));
			writer.write(request.getMessage() +"\n");
			writer.close();
		}catch( IOException ex) {
			throw new RuntimeException(ex);
		}
		}else if(nextLogger!=null) {
			nextLogger.log(request);
		}
		
	}

}
