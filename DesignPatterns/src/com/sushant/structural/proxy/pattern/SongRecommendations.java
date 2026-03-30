package com.sushant.structural.proxy.pattern;

public class SongRecommendations implements Recommendations {
	
	public SongRecommendations(User user) {
		getData(user);
	}

	private void getData(User user) {
		// TODO Auto-generated method stub
		System.out.println("Getting : "+user.getName() + "'s top tracks from database ..");
		System.out.println("Getting : "+user.getName() + "'s top tracks from database ..");
		System.out.println("Getting : "+user.getName() + "'s top tracks from database ..");
		
	}

	@Override
	public void showRecommendations(User user) {
		// TODO Auto-generated method stub
		System.out.println("Showing song recommendations for "+user.getName()+ " based on their top tracks, artists and genres");
	}

}
