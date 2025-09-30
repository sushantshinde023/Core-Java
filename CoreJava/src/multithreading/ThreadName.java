package multithreading;

public class ThreadName {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());//main
		MyRunnable r=new MyRunnable();
		Thread t=new Thread(r);
		
		System.out.println(t.getName());//Thread-0
		
		Thread.currentThread().setName("Updated main");
		System.out.println(Thread.currentThread().getName());

	}

}
