
public class Threads {
	// Locks - object, so the locks can contain any data type:
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	
	public static class Thread1 extends Thread {
		public void run() {
			synchronized (Lock1) 
			{
				System.out.println("Thread 1 contains 1. lock");
				
				// Wait for 20 ms:
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1 is waiting for lock 2...");

				synchronized (Lock2) {
					System.out.println("Thread 1 contains 1. lock and 2. lock");
				}
			}
		}
	}

	public static class Thread2 extends Thread {
		public void run() {
			synchronized (Lock1) {
				System.out.println("Thread 2 Contains 2. lock");

				//	Wait for 20 ms:
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2 is waiting for lock 1...");

				synchronized (Lock2) {
					System.out.println("Thread 2 contains 2. lock and 1. lock");
				}
			}
		}
	}
}