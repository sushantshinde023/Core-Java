package com.sushant.behavioral.state.pattern;

public interface AuctionState {
	void startAuction(Auction auction);
	void closeAuction(Auction auction);
	void placeBid();
}
