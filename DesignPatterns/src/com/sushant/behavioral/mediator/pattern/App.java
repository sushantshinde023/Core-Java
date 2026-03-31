package com.sushant.behavioral.mediator.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var board=new Board();
		var ticket=new Ticket();
		var assignee=new Assignee();
		
		assignee.pickUpTicket(ticket, board);
		System.out.println();
		assignee.resolveTicket(ticket, board);

	}

}
