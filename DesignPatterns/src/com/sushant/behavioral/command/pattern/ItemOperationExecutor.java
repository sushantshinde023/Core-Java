package com.sushant.behavioral.command.pattern;

import java.util.ArrayList;
import java.util.List;

public class ItemOperationExecutor {
	//To delay  operations with  with command pattern
	List<ItemOperation> itemOperations= new ArrayList<>();
		
//	public void doOperation(ItemOperation itemOperation) {
//		//itemOperation.execute();
//	
//	}
	
	public void queueOperation(ItemOperation itemOperation) {
		itemOperations.add(itemOperation);
	}
	public void checkout() {
		itemOperations.forEach(ItemOperation::execute);
		itemOperations.clear();
	}

}
