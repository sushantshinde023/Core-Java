package com.sushant.singleton.pattern;

////suppose this is used to connect to printer and print things
//public class PrintSpooler {
//	
//	//so idea here is there should only one PrintSpooler object  which control access to printer with below print method
//	void print() {
//		System.out.println("Printing ......");
//	}
//}

//This makes singleton for single thread in multithreaded env it is not safe
//public final class PrintSpooler{
//
//	private PrintSpooler() {
//		
//	}
//	
//	private static PrintSpooler INSTANCE;
//	// suppose two threads working on this at a time there might chance that we end up with two threads
//	public static PrintSpooler getInstance() {
//		if(INSTANCE==null) {
//			INSTANCE=new PrintSpooler();
//		}
//		
//		return INSTANCE;
//	}
//	
//	void print() {
//		System.out.println("Printing ......");
//	}
//	
//}

//Thread sAfety

public enum PrintSpooler{
	
	INSTANCE; //It is value of enum , enums are best way that guarantees it is thread safe
	private PrintSpooler() {
		
	}
	
	// suppose two threads working on this at a time there might chance that we end up with two threads
	public static PrintSpooler getInstance() {
		return INSTANCE;
	}
	
	void print() {
		System.out.println("Printing ......");
	}
	
}
