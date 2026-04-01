package com.sushant.behavioral.template.pattern;

public class UnsubscribeEmail extends Email{
	@Override
	public void sendMessageBody() {
		System.out.println("We are sorry to see you go");
	}
	
//	public void sendClosing() {
//		System.out.println("Best regards, sam");
//	}
}
