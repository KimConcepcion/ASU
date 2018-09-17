
//	Might change the imports to reduce overhead:
import java.net.*;
import java.io.*;
import java.util.*;

public class Client 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnknownHostException, IOException
	{	
		//	IP address, port:
		String addr = "127.0.0.1";
		int port = 1700;
		
		//	Socket - Method uses IP address and port number:
		Socket s = new Socket(addr, port);
		
		//	Evaluate if socket is connected to server socket:
		if(s.isConnected() == true)
		{
			//	Inform in console:
			System.out.println("Client is running!");
			
			//			Start and build GUI:
			GUItest gui = new GUItest();
			gui.main(null);
		}
		
		System.out.println("Client closed!");
		
		//	Close I/O:
		s.close();
		 
	}
}