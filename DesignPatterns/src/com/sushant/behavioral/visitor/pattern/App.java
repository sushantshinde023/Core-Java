package com.sushant.behavioral.visitor.pattern;

public class App {

	public static void main(String[] args) {
		
		var directory1= new Directory("Directory1");
		var file1=new File("file.txt",100);
		directory1.addElement(file1);
		
		var directory2= new Directory("Directory2");
		var file2=new File("file2.txt",200);
		directory1.addElement(file2);
		
		directory1.addElement(directory2);
		
		//now suppose we want to know total size of file system created above
		var visitor = new CalculateSizeVisitor();
		directory1.accept(visitor);
		System.out.println("Total Size : "+visitor.getTotalSize());
	}

}
