package com.sushant.behavioral.observer.pattern;

import java.beans.PropertyChangeSupport;

public class User {
	
	private String status;
	private PropertyChangeSupport support=new PropertyChangeSupport(this);
	
	public void setStatus(String status) {
		/*
		 * first property status - field to listen
		 * second property this.status - current
		 * third property status - new value
		 * */
		support.firePropertyChange("status",this.status,status);
		this.status=status;
	}
	
	public void addPropertyChangeListener(Newsfeed newsfeed) {
		support.addPropertyChangeListener(newsfeed);
	}

}
