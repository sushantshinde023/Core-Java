package com.sushant.abtract.factories.pattern;

public class Bike {
	
	private Handlebars handleBars;
	private Pedals pedals;
	private Tire frontTire;
	private Tire backTire;
	public Bike(Handlebars handleBars, Pedals pedals, Tire frontTire,Tire backTire) {
		super();
		this.handleBars = handleBars;
		this.pedals = pedals;
		this.frontTire = frontTire;
		this.backTire=backTire;
	}
	public Handlebars getHandleBars() {
		return handleBars;
	}
	public void setHandleBars(Handlebars handleBars) {
		this.handleBars = handleBars;
	}
	public Pedals getPedals() {
		return pedals;
	}
	public void setPedals(Pedals pedals) {
		this.pedals = pedals;
	}
	public Tire getFrontTire() {
		return frontTire;
	}
	public void setFrontTire(Tire frontTire) {
		this.frontTire = frontTire;
	}
	public Tire getBackTire() {
		return backTire;
	}
	public void setBackTire(Tire backTire) {
		this.backTire = backTire;
	}
	@Override
	public String toString() {
		return "Bike [handleBars=" + handleBars.getType() + ", pedals=" + pedals.getType() + ", frontTire=" + frontTire.getWidth() + ", backTire="
				+ backTire.getWidth() + "]";
	}
	
	
	
	
	

}
