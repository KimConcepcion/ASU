
import java.io.*;
import java.net.*;
import java.util.*;

public class Client 
{
	//	Main method:
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		int inputNumber = 0;
		int result = 0;
		
		//	We need a scanner in order to get an input from the user:
		Scanner sc1 = new Scanner(System.in);
		
		/* A socket is an interface which enbales a client and 
		 * server to communicate and parse information from each other.
		 * There are two types of sockets in java.
		 */
		Socket s = new Socket("127.0.0.1", 1900);
		
		if(s.isConnected() == true)
		{
			System.out.println("The client has been connected to server...");
			System.out.println(" --- Server Details ---");
			System.out.println("@ Port: " + s.getPort());
			System.out.println("@ IP Address: " + s.getInetAddress().getHostAddress());
			System.out.println("@ Hostname: " + s.getInetAddress().getHostName());
		}
		
		//	Another scanner:
		Scanner sc2 = new Scanner(s.getInputStream());
	    
		//	Store input from user of client program:
		System.out.print("Enter a number to be multiplied by 10: ");
		inputNumber = sc1.nextInt();
		
		//	Transfer data via the socket client socket over port 1900:
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(inputNumber);
		
		//	The sc2 scanner is connected to the inputstream, which is connected to the 
		result = sc2.nextInt();
		System.out.println("Result: " + result);
	    
		//	Close scanners and socket:
		sc2.close();
		sc1.close();
		s.close();
	}
}