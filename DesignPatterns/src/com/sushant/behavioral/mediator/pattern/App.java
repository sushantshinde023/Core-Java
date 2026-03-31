package com.sushant.behavioral.mediator.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var board=new Board();
		var ticket=new Ticket();
		var assignee=new Assignee();
		var mediator=new Mediator(ticket,assignee,board);
//		assignee.pickUpTicket(ticket, board);
//		System.out.println();
//		assignee.resolveTicket(ticket, board);
		mediator.pickUpTicket();
		System.out.println();
		mediator.resolveTicket();

	}

}
