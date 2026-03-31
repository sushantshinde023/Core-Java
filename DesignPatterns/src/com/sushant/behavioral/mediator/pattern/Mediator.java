package com.sushant.behavioral.mediator.pattern;

import com.sushant.behavioral.mediator.pattern.Ticket.Status;

public class Mediator {
	
	private Ticket ticket;
	private Assignee assignee;
	private Board board;
	public Mediator(Ticket ticket, Assignee assignee, Board board) {
		super();
		this.ticket = ticket;
		this.assignee = assignee;
		this.board = board;
	}
	
	public void pickUpTicket() {
		assignee.pickUpTicket(ticket);
		ticket.setAssignee(assignee);
		ticket.setStatus(Status.IN_PROGRESS);
		board.addTicketToInProgressTickets(ticket);
	}
	
	public void resolveTicket() {
		assignee.resolveTicket(ticket);
		ticket.setStatus(Status.DONE);
		board.addTicketToDoneTickets(ticket);
		
	}

}
