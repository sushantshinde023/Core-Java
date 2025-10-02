package multithreading;
/*
 * Both the threads are waiting for each other
 * If the thread calls join method on same thread itself then also deadlock situation occurs
 * */
class JoinDeadlockRunnable implements Runnable{
	
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

public class DeadlockWithJoin {

	public static void main(String[] args) throws InterruptedException {
		JoinDeadlockRunnable.mt=Thread.currentThread();
		JoinDeadlockRunnable r=new JoinDeadlockRunnable();
		Thread t=new Thread(r);
		
		t.start();
		t.join();
		
		for(int i=0;i<10;i++) {
			System.out.println("main Thread");
		}

	}

}
