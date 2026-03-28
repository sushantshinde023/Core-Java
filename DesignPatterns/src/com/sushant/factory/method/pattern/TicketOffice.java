package com.sushant.factory.method.pattern;

public class TicketOffice {
	
	private static final TicketMachine ticketMachine=new TicketMachine();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		buyABusTicket();
		buyATrainTicket();
	}
	private static void buyABusTicket() {
		// TODO Auto-generated method stub
		var ticket = ticketMachine.createTicket("Bus");
		System.out.println("One bus ticket purchased. The price is $"+ticket.getPrice());
	}
	
	private static void buyATrainTicket() {
		// TODO Auto-generated method stub
		var ticket = ticketMachine.createTicket("Train");
		System.out.println("One Train ticket purchased. The price is $"+ticket.getPrice());
	}

}
