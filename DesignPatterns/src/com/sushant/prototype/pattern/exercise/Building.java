package com.sushant.prototype.pattern.exercise;

public class Building  extends Graphic{
	
	private BuildingType buildingType;

	public Building(int heightInPixels, BuildingType buildingType) {
		super(heightInPixels);
		this.buildingType = buildingType;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}
	
	@Override
	public String toString() {
		return "Building [buildingType=" + buildingType +" Height in pixels="+super.getHeightInPixels() +"]";
	}

	@Override
	public Building clone() {
		// TODO Auto-generated method stub
		return new Building(this.getHeightInPixels(), new BuildingType(this.getBuildingType().getType()));
	}

	
	
	
	
	
	

}
