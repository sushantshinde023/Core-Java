package com.sushant.singleton.pattern;

//public class DocumentPrinter {
//	
//	public void printDocument() {
//		var spooler=new PrintSpooler();
//		spooler.print();
//	}
//}

public class DocumentPrinter {
	
	public void printDocument() {
		var spooler=PrintSpooler.getInstance();
		spooler.print();
	}
}

