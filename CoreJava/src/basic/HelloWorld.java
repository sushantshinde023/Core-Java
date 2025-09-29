package basic;


public class HelloWorld {
	/*
	 * public static void main is the entry point of every standard java application
	 * public - means method is accessible from anywhere. JVM needs to access this method from outside your class, so public
	 * static - method belongs to class, not an object. JVM doesn't create an object f your class to start the program
	 * void- the method doesn't return any value, After main finishes JVM  doesn't expect any result
	 * main - name of method that JVM looks for when starting program
	 * String[] args - parameter that stores command line arguments
	 * 
	 * */
	public static void main(String[] args) {
		//prints given message to console
	 System.out.println("Hello World of Java !");

	}

}
