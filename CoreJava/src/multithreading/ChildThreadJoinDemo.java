package multithreading;

class JoinChildRunnable implements Runnable{
	static Thread mt;
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			try {
				mt.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ChildThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JoinChildRunnable.mt=Thread.currentThread();
		JoinChildRunnable r=new JoinChildRunnable();
		Thread t=new Thread(r);
		t.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("main thread");
			Thread.sleep(2000);
		}
		

	}

}
