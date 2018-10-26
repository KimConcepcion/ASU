
/**
 * This example is about deadlocks.
 * The solution to the deadlock issue in this example is to use the locks in order.
 * The root of this problem is misusing the synchronized call. Once you synchronize around locks, make sure that they
 * are synchronized in proper order.
 * 
 * Practical example: If you want to buy meat at the super market, you would visit the butcher before the salesman.
 * Consider the butcher and the salesman as threads. Would it make any sense if you were interested in buying meat,
 * but you went to the salesman first? No because we probably need a barcode etc. which the salesman can use to
 * determine your price. 
 * @author Kim
 * 
 */

public class TestThread 
{	
	public static void main(String[] args) 
	{
		Threads.Thread1 t1 = new Threads.Thread1();
		Threads.Thread2 t2 = new Threads.Thread2();
		
		t1.start();
		t2.start();
	}
}