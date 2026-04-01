package com.sushant.behavioral.observer.pattern;

import java.util.ArrayList;
import java.util.List;

public class Newsfeed {
	
	private List<String> statuses=new ArrayList<>();
	
	public void printStatus() {
		statuses.forEach(System.out::println);
	}

}
