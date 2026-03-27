package com.sushant.prototype.pattern.exercise;

import java.util.List;

public class CityScape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuildingType houseBuildingType= new BuildingType("House");
		
		Building house=new Building(21, houseBuildingType);
		Building house1=house.clone();
		
		Building house2=house.clone();;
		Building house3=house.clone();
		Building house4=house.clone();
		
		houseBuildingType.setType("House with Yard");
		
		BuildingType skyscraperBuildingType=new BuildingType("skyscraper");
		
		Building skyscraper1=new Building(86,skyscraperBuildingType);
		Building skyscraper2=new Building(86,skyscraperBuildingType);
		Building skyscraper3=new Building(86,skyscraperBuildingType);
		Building skyscraper4=new Building(86,skyscraperBuildingType);
		Building skyscraper5=new Building(86,skyscraperBuildingType);
		
		List<Graphic> graphic=List.of(house,house1,house2,house3,house4,skyscraper1,skyscraper2,skyscraper3,skyscraper4,skyscraper5);
		createCityscape(graphic);
	}

	private static void createCityscape(List<Graphic> graphic) {
		// TODO Auto-generated method stub
		System.out.println("Creating city scape...");
		graphic.forEach(System.out::println);
	}

}
