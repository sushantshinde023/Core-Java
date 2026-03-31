package com.sushant.behavioral.interpreter.pattern;

public class FirstLowerLetter implements Expression {
	private final NoWhiteSpace noWhiteSpace = new NoWhiteSpace();
	@Override
	public String interpret(String context) {
		// TODO Auto-generated method stub
		context=context.substring(0,1).toLowerCase()+context.substring(1);
		//rule chain
		return noWhiteSpace.interpret(context);
	}

}
