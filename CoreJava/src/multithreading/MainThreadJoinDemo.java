package multithreading;

class JoinRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
public class MainThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		JoinRunnable r=new JoinRunnable();
		Thread t=new Thread(r);
		t.start();
		t.join();// as main  Thread is calling join on t, Main Thread will wait until child thread completes
		//t.join(10000) we can have waiting time as well
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}
