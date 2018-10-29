
public class RunnableDemo extends Thread
{
	private Thread t;
	private String threadName;
	private Ticket ticket;
	
	public RunnableDemo(String name, Ticket tck)
	{
		threadName = name;
		ticket = tck;
	}
	
	public void run()
	{
		try
		{
			//	Lock:
			TestThread.qlock.lock();
			
			if(TestThread.seats != 0)
			{
				System.out.println(threadName + ": I will handle your ticket!");
				
				//	Update seats:
				TestThread.seats -= 1;
				System.out.println("Name: " + ticket.name);
				System.out.println("Seat: " + ticket.seat);
				System.out.println("Seats left: " + TestThread.seats);
			}
			
			else
			{
				System.out.println(threadName + " No more seats");
			}
			
			Thread.sleep(50);
		}
		
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//System.out.println(threadName + " is done!" + "\n-------------------------------");
		System.out.println(threadName + ": Your ticket has been registered!" + 
		"\n--------------------------------------------");
		
		//	Unlock:
		TestThread.qlock.unlock();
	}
}
