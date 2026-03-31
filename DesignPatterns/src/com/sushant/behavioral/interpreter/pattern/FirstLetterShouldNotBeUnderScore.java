package com.sushant.behavioral.interpreter.pattern;

public class FirstLetterShouldNotBeUnderScore implements Expression {
	
	private final FirstLowerLetter firstLowerLetter=new FirstLowerLetter();

	@Override
	public String interpret(String context) {
		// TODO Auto-generated method stub
		if(context.startsWith("_")) {
			context= context.substring(1);
		}
		//chaining of rule
		return firstLowerLetter.interpret(context);
	}

}
