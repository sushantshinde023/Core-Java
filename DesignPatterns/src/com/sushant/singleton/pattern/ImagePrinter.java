package com.sushant.singleton.pattern;

//public class ImagePrinter {
//		
//		public void printImage() {
//			var spooler=new PrintSpooler();
//			spooler.print();
//		}
//}

public class ImagePrinter {
	
	public void printImage() {
		var spooler=PrintSpooler.getInstance();
		spooler.print();
	}
}
