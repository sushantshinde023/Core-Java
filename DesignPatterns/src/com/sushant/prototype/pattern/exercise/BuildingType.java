package com.sushant.prototype.pattern.exercise;

public class BuildingType {
	
	private String type;

	public BuildingType(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}

}
