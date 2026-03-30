package com.sushant.structural.proxy.pattern;

public class MusicPlayer {
	
	public static void main(String[] args){
		var user = new User("Jill");
		
		//Here for the time we are doing expensive operation that fetching songs from database
		loadHomePage(user);
		loadDiscoverPage(user);
		
	}
	private static void loadDiscoverPage(User user) {
		System.out.println("Loading discover page ....");
		var recommendations=new SongRecommendations(user);
		recommendations.showRecommendations(user);
		
	}

	private static void loadHomePage(User user) {
		System.out.println("Loading Home page ...");
		var recommendations= new SongRecommendations(user);
		recommendations.showRecommendations(user);
		
	}
}
