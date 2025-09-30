package multithreading;

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
