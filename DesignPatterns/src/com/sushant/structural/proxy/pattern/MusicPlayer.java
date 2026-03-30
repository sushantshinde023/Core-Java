package com.sushant.structural.proxy.pattern;

public class MusicPlayer {
	
	public static void main(String[] args){
		var user = new User("Jill");
		var recommendations= new SongRecommendations(user);
		
		//Here for the time we are doing expensive operation that fetching songs from database
		loadHomePage(user,recommendations);
		loadDiscoverPage(user,recommendations);
		
	}
	private static void loadDiscoverPage(User user,SongRecommendations songRecommendations) {
		System.out.println("Loading discover page ....");
		songRecommendations.showRecommendations(user);
		
	}

	private static void loadHomePage(User user,SongRecommendations songRecommendations) {
		System.out.println("Loading Home page ...");
		songRecommendations.showRecommendations(user);
		
	}
}
