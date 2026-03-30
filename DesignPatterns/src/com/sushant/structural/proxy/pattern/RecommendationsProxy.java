package com.sushant.structural.proxy.pattern;

public class RecommendationsProxy implements Recommendations{
	
	private Recommendations recommendations;
	@Override
	public void showRecommendations(User user) {
		// TODO Auto-generated method stub
		if(user.isPremium()) {
		if(recommendations == null) {
			recommendations=new SongRecommendations(user);
		}
		recommendations.showRecommendations(user);
		}else {
			System.out.println("Upgrade to premium to see song recommendations");
		}
	}

}
