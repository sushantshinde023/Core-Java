package com.sushant.behavioral.iterator.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var pen = new Item("Pen",20);
		var eraser = new Item("Eraser",15);
		var pencil =new Item("Pencil",0);
		
		//return only items which are in stock
		var inventory=new Inventory(pen,pencil,eraser);
		var stockIterator=inventory.iterator();
		
		while(stockIterator.hasNext()) {
			var item=stockIterator.next();
			System.out.println(item.getName());
		}

	}

}
