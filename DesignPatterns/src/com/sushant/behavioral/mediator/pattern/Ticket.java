package com.sushant.behavioral.mediator.pattern;

//Ticket to track progress
public class Ticket {
	
	//person working on ticket
	private Assignee assignee;
	
	public enum Status{
		SUBMITTED,
		IN_PROGRESS,
		DONE
	}
	
	private Status status;
	public Ticket() {
		this.status=status.SUBMITTED;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status=status;
		System.out.println("Ticket status changed to "+status);
	}
	
	public void setAssignee(Assignee assignee) {
		this.assignee=assignee;
	}

}
