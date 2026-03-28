package com.sushant.factory.method.pattern;

public class TicketMachine {
	
	public Ticket createTicket(String ticketType) {
		// TODO Auto-generated method stub
		if(ticketType.equalsIgnoreCase("Bus"))
			return new BusTicket();
		else
			return new TrainTickets();
		
	//The if else is ok for  2-3 types but let say we have some other implementation of tciket class as well. This will not feasible
	}

}
