package com.sushant.behavioral.interpreter.pattern;

public class App {

	public static void main(String[] args) {
		
		var context= "_My variable";
		var firstLetterShouldNotBeUnderScore=new FirstLetterShouldNotBeUnderScore();
		var result=firstLetterShouldNotBeUnderScore.interpret(context);
		System.out.println(result);

	}

}
