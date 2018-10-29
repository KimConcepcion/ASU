import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread 
{
	//	Lock and arraylist:
	public static Lock qlock = new ReentrantLock();
	static int seats = 8;
	
	public static void main(String args[]) throws InterruptedException
	{
		//	Tickets:
		Ticket Kim = new Ticket("Kim", 1);
		Ticket Lasse = new Ticket("Lasse", 2);
		Ticket Maja = new Ticket("Maja", 3);
		Ticket Kristina = new Ticket("Kristina", 4);
		
		//	Create threads:
		RunnableDemo t1 = new RunnableDemo("Worker_1", Kim);
		RunnableDemo t2 = new RunnableDemo("Worker_2", Lasse);
		RunnableDemo t3 = new RunnableDemo("Worker_3", Maja);
		RunnableDemo t4 = new RunnableDemo("Worker_4", Kristina);
		
		//	Start the thread:
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//	Join the threads:
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}
}
