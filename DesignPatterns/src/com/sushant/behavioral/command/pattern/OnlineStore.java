package com.sushant.behavioral.command.pattern;

public class OnlineStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var item1=new Item(1);
		var item2=new Item(2);
		var item3=new Item(3);
//		
//		item1.addToBasket();
//		item2.addToBasket();
//		item3.addToBasket();
//		item2.removeFromBasket();
		
		var itemOperationExecutor=new ItemOperationExecutor();
		itemOperationExecutor.queueOperation(new AddItemToBasket(item1));
		itemOperationExecutor.queueOperation(new AddItemToBasket(item2));
		itemOperationExecutor.queueOperation(new AddItemToBasket(item3));
		
		itemOperationExecutor.queueOperation(new RemoveItemFromBasket(item2));
		itemOperationExecutor.checkout();

	}

}
