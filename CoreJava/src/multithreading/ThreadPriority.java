package multithreading;
/*
 * The default priority of main thread is 5
 * Thread.MIN_PRIORITY 1
 * Thread.MAX_PRIORITY 10
 * Thread.NORM_PRIORITY 5
 * Note : Some OS or platform won't support thread priority
 * */

public class ThreadPriority {

	public static void main(String[] args) {
		MyRunnable r=new MyRunnable();
		Thread t=new Thread(r);
		t.setPriority(10);
		t.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
		
		

	}

}
