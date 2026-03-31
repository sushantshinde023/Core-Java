package com.sushant.behavioral.interpreter.pattern;

public class NoWhiteSpace implements Expression {

	@Override
	public String interpret(String context) {
		// TODO Auto-generated method stub
		//terminal
		return context.replaceAll(" ", "");
	}

}
