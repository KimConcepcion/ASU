
public class TestThread 
{
	public static void main(String[] args) 
	{
		RunnableDemo rd_1 = new RunnableDemo("Thread_1");
		rd_1.start();
		
		RunnableDemo rd_2 = new RunnableDemo("Thread_2");
		rd_2.start();
	}
}