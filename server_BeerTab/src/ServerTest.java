
import java.io.IOException;
import network.Server;

public class ServerTest 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Server server_1 = new Server("Thread_1", "127.0.0.1", 1700);
		server_1.start();
		
		Server server_2 = new Server("Thread_2", "127.0.0.1", 1900);
		server_2.start();
	}
}
