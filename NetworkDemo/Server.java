
//	Import packages:
import java.io.*;
import java.net.*;
import java.util.*;

public class Server 
{
	public static void main(String[] args) throws IOException
	{
		//	Inputnumber from client:
		int inputNumber = 0;
		int result = 0;
		
		//	A Server socket is different from the socket that is used with the client:
		ServerSocket s1 = new ServerSocket(1900);
		
		//		Give message about server listening:
		System.out.println("Server: Listening for incomming connection...");
		 
		//	Accept is used to listen and accept incomming traffic via the s1 server socket that is connected to port 1900.
		//	The accept method blocks until a connection is made:
		Socket ss = s1.accept();
		
		if(ss.isConnected() == true)
		{
			//			Give message about server with connection to client:
			System.out.println("###############################################");
			System.out.println("Server: Connection to client was established...");
			
			//	Details about connected client will be printed:
			System.out.println(" --- Client details ---");
			System.out.println("@ Port: " + ss.getPort());
			System.out.println("@ IP address: " + ss.getInetAddress().getHostAddress());
			System.out.println("@ Hostname: " + ss.getInetAddress().getHostName());
		}
				
		//	Scan after input from client via the new socket ss with accept:
		Scanner sc = new Scanner(ss.getInputStream());
		
		//	Awaiting input from client:
		System.out.println("Server: Awaiting input from client...");
		inputNumber = sc.nextInt();
		
		//	Perform calculation:
		result = inputNumber * 10;
				
		//	Parse whatever is currently in the output stream back to the client:
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(result);

		//	Close the socket and text scanner:
		sc.close();
		s1.close();
	}
}