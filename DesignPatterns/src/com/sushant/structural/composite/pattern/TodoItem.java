package com.sushant.structural.composite.pattern;


public class TodoItem implements Completable{
	
	private final String description;
	private boolean completed=false;
	
	public TodoItem(String description) {
		this.description=description;
	}
	
	
	public void complete() {
		completed=true;
	}


	@Override
	public void isCompleted() {
		// TODO Auto-generated method stub
		System.out.println("Todo item \""+ description + "\" is completed "+ completed);
	}

}
