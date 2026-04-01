package com.sushant.behavioral.memento.pattern;

public class TextDocument {
	
	private String text="";
	private TextDoxumentState state= new TextDoxumentState(text);
	
	public void write(String text) {
		this.text +=text;
	}
	
	public void print() {
		System.out.println(text);
	}
	
	public void save() {
		state.setState(text);
	}
	public void undo() {
		text=state.getState();
	}

}
