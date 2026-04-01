package com.sushant.behavioral.state.pattern;

public class Auction {
	
	private AuctionState state;
	
	public Auction() {
		this.state= new AuctionClosedState();
	}

	public void startAuction() {

//		if(isOpen) {
//			System.out.println("Auction already started");
//		}else {
//			this.isOpen=true;
//			System.out.println("Auction started");
//		}
		
		state.startAuction(this);
		
	}

	public void placeBid() {
//		if(this.isOpen) {
//			System.out.println("Bid placed");
//		}else {
//			System.out.println("Bid not placed because auction is closed");
//		}
		state.placeBid();
		
	}

	public void closeAuction() {
//		if(!isOpen) {
//			System.out.println("Auction already closed");
//		}else {
//			this.isOpen=false;
//			System.out.println("Auction closed");
//		}
		state.closeAuction(this);
		
	}
	
	public void setState(AuctionState state) {
		this.state=state;
	}

}
