package basic;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		//Create scanner object
		Scanner sc=new Scanner(System.in);
		//Give prompt to user for enter something
		System.out.println("Enter your name : ");
		//Read entered input
		String name=sc.nextLine();
		//Prompt to enter age
		System.out.println("Enter your Age : ");
		//Read entered age
		int age=sc.nextInt();
		
		//print user input
		System.out.println("Name : "+name+ " and Age is "+age);
		
		// close scanner
		sc.close();
		
		

	}

}
