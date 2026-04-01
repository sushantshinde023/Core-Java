package com.sushant.behavioral.visitor.pattern;

public class File implements FileSystemElement {
	
	private final String name;
	private final int size;
	

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}


	@Override
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}


	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
