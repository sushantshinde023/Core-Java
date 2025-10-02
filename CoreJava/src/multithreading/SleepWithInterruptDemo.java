package multithreading;

class SleepRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("child thread");
		}
		System.out.println("Thread going to sleep");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println("Thread got interrupted...");
			e.printStackTrace();
		}
		
	}
	
}
public class SleepWithInterruptDemo {

	public static void main(String[] args) {
		
		SleepRunnable r=new SleepRunnable();
		Thread t=new Thread(r);
		
		t.start();
		t.interrupt();
		System.out.println("Main thread completed");
	}

}
