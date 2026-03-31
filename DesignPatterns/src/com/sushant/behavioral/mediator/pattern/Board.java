package com.sushant.behavioral.mediator.pattern;

import java.util.ArrayList;
import java.util.List;

//It is also tightly coupled to ticket class
public class Board {

	private List<Ticket> inProgressTicket=new ArrayList<>();
	private List<Ticket> doneTickets = new ArrayList<>();
	
	public List<Ticket> getDoneTickets(){
		return this.doneTickets;
	}
	
	public void addTicketToInProgressTickets(Ticket ticket) {
		inProgressTicket.add(ticket);
		ticket.setStatus(Ticket.Status.IN_PROGRESS);
		System.out.println("Ticket added to  inProgressTickets");
	}
	
	public void addTicketToDoneTickets(Ticket ticket) {
		ticket.setStatus(Ticket.Status.DONE);
		doneTickets.add(ticket);
		System.out.println("Ticket added to  doneTickets");
		inProgressTicket.remove(ticket);
		System.out.println("Ticket removed from  inProgressTickets");
		
	}
}
