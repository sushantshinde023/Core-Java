package com.sushant.behavioral.memento.pattern;

public class DocumentWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var textDocument=new TextDocument();
		textDocument.write("Hello World ");
		textDocument.print();
		textDocument.write("How are you");
		textDocument.print();
	}

}
