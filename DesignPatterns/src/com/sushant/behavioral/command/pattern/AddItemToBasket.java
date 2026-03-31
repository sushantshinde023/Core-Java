package com.sushant.behavioral.command.pattern;

public class AddItemToBasket implements ItemOperation {
	
	private final Item item;
	
	public AddItemToBasket(Item item) {
		super();
		this.item = item;
	}

	@Override
	public void execute() {
		item.addToBasket();
	}

}
