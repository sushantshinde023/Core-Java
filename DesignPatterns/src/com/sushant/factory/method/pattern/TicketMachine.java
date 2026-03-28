package com.sushant.factory.method.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TicketMachine {
	
//	public Ticket createTicket(String ticketType) {
//		// TODO Auto-generated method stub
//		if(ticketType.equalsIgnoreCase("Bus"))
//			return new BusTicket();
//		else
//			return new TrainTickets();
//		
//	//The if else is ok for  2-3 types but let say we have some other implementation of tciket class as well. This will not feasible
//	}
	//Feasible solution
	
	private static final Map<String,Supplier<Ticket>> ticketSupplier=new HashMap<>();
	
	static {
		ticketSupplier.put("Bus", BusTicket::new);
		ticketSupplier.put("Train", TrainTickets::new);
	}
	public Ticket createTicket(String ticketType) {
		if(ticketSupplier.get(ticketType)!=null) {
			return ticketSupplier.get(ticketType).get();
		}
		else {
			throw new IllegalArgumentException("Invalid ticket type");
		}
	}

}
