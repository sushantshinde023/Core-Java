package com.sushant.behavioral.state.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var auction = new Auction();
		
		auction.startAuction();
		auction.placeBid();
		
		auction.startAuction();
		
		auction.closeAuction();
		auction.placeBid();
		auction.closeAuction();

	}

}
