
package network;

import java.net.InetAddress;
//	Might change the imports to reduce overhead:
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import windowBuilder.ui.GUI;
import java.util.Scanner;

public class Client 
{	
	//	Streams for I/O:
	static ObjectOutputStream output;
	static ObjectInputStream input;
	static Scanner sc = new Scanner(System.in);
	
	//	Network attributes:
	static String serverIP;
	static int port = 1700;
	static Socket connection;
	static String msg;
	
	//	Constructor:
	public Client(String host)
	{
		serverIP = host;
	}
	
	//	Function for printing menu:
	public void printMenu()
	{
		System.out.println("Options:");
		System.out.println("- Add Drink");
		System.out.println("- cheers");
	}
	
	//	Function to close I/O:
	public void closeIO() throws IOException
	{
		System.out.println("Connections closed!");
		
		connection.close();
		output.close();
		input.close();
	}
	
	//	Function to connect to server:
	public void connectToServer() throws IOException
	{
		System.out.println("Trying to connect...");
		connection = new Socket(InetAddress.getByName(serverIP), port);
		System.out.println("Connected to: " + connection.getInetAddress());
	}
	
	//	Setup them streams:
	public void setUpStreams() throws IOException
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("The streams are ready...\n");
	}
	
	//	Send messages to server:
	public void sendMsg(String msg) throws IOException
	{
		output.writeObject("@Client: " + msg);
		output.flush();
		System.out.println("@Client: " + msg);
	}
	
	public void inputMsg() throws IOException
	{	
		System.out.print(">>");
		msg = sc.nextLine();	//	Input the msg here
		sendMsg(msg);
	}
	
	//	Function for handling communication:
	public void whileChatting() throws ClassNotFoundException, IOException
	{
		//	Print the menu:
		printMenu();
		
		do
		{
			//	Read input from server:
			msg = (String) input.readObject();
			System.out.println(msg);
			
			//	Send msg from client to server:
			inputMsg();
			
		}while(!msg.equals("@Server: END"));
	}
	
	//	Connect to server:
	public void startRunning() throws IOException, ClassNotFoundException
	{	
		connectToServer();
		setUpStreams();
		whileChatting();
		
		//	Start and build GUI - perhaps place in constructor:
		//GUI gui = new GUI();
		//gui.setup();
		
		//	Close crap:
		closeIO();
	}
}
