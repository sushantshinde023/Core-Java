package com.sushant.structural.composite.pattern;

import java.util.ArrayList;
import java.util.List;

public class Checklist implements Completable {
	
	List<TodoItem> todoItems=new ArrayList<>();
	
	public void addTodoItem(TodoItem todoItem) {
		todoItems.add(todoItem);
	}

	@Override
	public void isCompleted() {
		// TODO Auto-generated method stub
		todoItems.forEach(TodoItem::isCompleted);
	}

}
