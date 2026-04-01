package com.sushant.behavioral.visitor.pattern;

public interface Visitor {
	void visit(File file);
	void visit(Directory directory);
}
