package com.sushant.behavioral.command.pattern;

public class RemoveItemFromBasket implements ItemOperation {
	
	private final Item item;
	
	

	public RemoveItemFromBasket(Item item) {
		super();
		this.item = item;
	}



	@Override
	public void execute() {
		item.removeFromBasket();

	}

}
