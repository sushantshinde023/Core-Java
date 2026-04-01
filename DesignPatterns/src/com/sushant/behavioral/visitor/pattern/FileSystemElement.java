package com.sushant.behavioral.visitor.pattern;

public interface FileSystemElement {
	String getName();
	
	void accept(Visitor visitor);
}
