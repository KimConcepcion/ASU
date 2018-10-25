
public class RunnableDemo implements Runnable
{
	private Thread t;
	private String threadName;
	
	public RunnableDemo(String name)
	{
		threadName = name;
		System.out.println("Creating thread " + threadName);
	}
	
	public void run()
	{
		try
		{
			System.out.println("Thread " + threadName + " is running!");
			Thread.sleep(50);
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Thread " + threadName + " terminated");
	}
	
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this, threadName);
			t.start();
		}
	}
}