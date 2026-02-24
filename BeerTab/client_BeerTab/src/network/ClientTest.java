package network;

import java.io.IOException;

public class ClientTest 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Client client = new Client("127.0.0.1");
		client.startRunning();
	}
}