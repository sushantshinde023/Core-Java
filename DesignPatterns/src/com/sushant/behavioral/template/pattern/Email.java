package com.sushant.behavioral.template.pattern;

//add common part here
public abstract class Email {
	public void sendGreeting() {
		System.out.println("Hello");
	}
	
	public abstract void sendMessageBody();
	
	public void sendClosing() {
		System.out.println("Best regards, sam");
	}
}
