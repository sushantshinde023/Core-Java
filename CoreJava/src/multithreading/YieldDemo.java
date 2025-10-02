package multithreading;


/*
 * Here child thread always calls yield becoz of that main thread will get chance more, hence completing main thread first have more chance
 * Note : Some platform don't provide proper support for yield method
 * */
class YieldRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			Thread.yield();
		}
		
	}
	
}

public class YieldDemo {

	public static void main(String[] args) {
		YieldRunnable r=new YieldRunnable();
		Thread t=new Thread(r);
		
		t.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}
