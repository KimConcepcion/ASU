
import java.io.IOException;
import network.Server;

public class ServerTest 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Server server_1 = new Server("Thread_1");
		server_1.start();
	}
}
