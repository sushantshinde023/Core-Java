package com.sushant.behavioral.command.pattern;

public class ItemOperationExecutor {
	
	public void doOperation(ItemOperation itemOperation) {
		itemOperation.execute();
	}

}
