
package network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import common.*;
import static network.ServerAttributes.*;

/**
 * Threaded server class
 * @author Kim
 * @since 2018
 */
public class Server implements Runnable, ServerMethods
{
	/**
	 * Bind socket server to ip & port
	 * @throws IOException
	 */
	public Server(String name) throws IOException
	{
		ServerAttributes.threadName = name;
		
		loggerSetup();
		ServerAttributes.server = new ServerSocket();
		ServerAttributes.server.bind(new InetSocketAddress("127.0.0.1", ServerAttributes.port));
		
		Listen();
	}
	
	/**
	 * Setup logfile:
	 * @throws IOException if file was not found
	 */
	public void loggerSetup() throws IOException
	{
		ServerAttributes.log_writer = new FileWriter(ServerAttributes.logFile);
		ServerAttributes.logger = new BufferedWriter(ServerAttributes.log_writer);
	}
	
	/**
	 * Writes details to logfile:
	 * @param bf
	 * @param S
	 * @throws IOException if failure occured during read/write operations
	 */
	public void logger(BufferedWriter bf, Socket S) throws IOException
	{
		bf.write("\nDate: " + Calendar.getInstance().getTime());
		bf.write("\nThe client has connected to the server!\n");
		bf.write(" --- Server Details --- \n");
		bf.write("@ Port: " + S.getPort() + "\n");
		bf.write("@ IP Address: " + S.getInetAddress().getHostAddress() + "\n");
		bf.write("@ HostName: " + S.getInetAddress().getHostName() + "\n");
	}
	
	/**
	 * Closes IO
	 * @author Kim
	 * @throws IOException 
	 */
	public void closeIO() throws IOException
	{
		System.out.println("Closing connections...");
		
		ServerAttributes.connection.close();
		ServerAttributes.logger.close();
		ServerAttributes.output.close();
		ServerAttributes.input.close();
	}
	
	/**
	 * The connection is the socket and the accept call is used to accept an incomming connection from a client.
		Waits periodically for an incomming connection with the while loop.
		The accept call blocks until a connection is made.
		Can only create a socket, when someone actually connects. We do not generate 1mio empty sockets...
	 * @throws IOException
	 */
	public void Listen() throws IOException
	{
		System.out.println("Waiting for incomming connections...");
		ServerAttributes.connection = ServerAttributes.server.accept();
		
		//	getInetAddress returns the address of where the socket is connected:
		System.out.println("Client now connected to: " + ServerAttributes.connection.getInetAddress());	
		logger(ServerAttributes.logger, ServerAttributes.connection);
		
		//	Start thread:
		//ServerAttributes.threadName = "testThread";
		//start();
	}
	
	/**
	 * Setup I/O streams
	 * @throws IOException
	 */
	public void setUpStreams() throws IOException
	{
		//	Creating the pathway that allows us to connect to another process/client:
		ServerAttributes.output = new ObjectOutputStream(ServerAttributes.connection.getOutputStream());
		//	If there are any bytes left in the buffer, flush it:
		ServerAttributes.output.flush();
		//	Only they can flush your toilet, so no need to flush the toilet:
		ServerAttributes.input = new ObjectInputStream(ServerAttributes.connection.getInputStream());
		//System.out.println("Streams are set up!");
	}
	
	/**
	 * Send a message through output stream
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException
	{
		ServerAttributes.output.writeObject("@Server: " + msg);
		ServerAttributes.output.flush();
		System.out.println("@Server: " + msg);
	}
	
	/**
	 * Receive message
	 * @throws IOException
	 */
	public void receiveMsg() throws IOException
	{		
		System.out.print(">>");
		ServerAttributes.msg = ServerAttributes.sc.nextLine();		//	Input the msg here
		sendMsg(ServerAttributes.msg);
	}
	
	/**
	 * Communicate between client and server
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void whileChatting() throws ClassNotFoundException, IOException
	{
		//	Inform the client about succesful connection:
		sendMsg("You are now connected!");
		
		//	Have a conversation:
		do
		{
			//	Read the input from the client:
			ServerAttributes.msg = (String) ServerAttributes.input.readObject();
			System.out.println(ServerAttributes.msg);
			
			//	Evaluate the input:
			if(ServerAttributes.msg.equals("@Client: Add Drink") == true)
			{
				sendMsg("What would you like to drink? <Newcastle, Carlsbreg, Tuborg>");
				
				//	Get the drink:
				ServerAttributes.msg = (String) ServerAttributes.input.readObject();
				ServerAttributes.Xbeer = ServerAttributes.msg.substring(9);
				sendMsg("You have chosen a " + ServerAttributes.Xbeer);
				
				if(ServerAttributes.Xbeer.equals(ServerAttributes.beer.beerNewcastle))
				{
					ServerAttributes.person.addBeer(beerType.NewCastle);
				}
				
				else if(ServerAttributes.Xbeer.equals(ServerAttributes.beer.beerCarlsberg))
				{
					ServerAttributes.person.addBeer(beerType.Carlsberg);
				}
				
				else if(ServerAttributes.Xbeer.equals(beer.beerTuborg))
				{
					ServerAttributes.person.addBeer(beerType.Tuborg);
				}
			}
			
			else if(ServerAttributes.msg.equals("@Client: cheers") == true)
			{
				sendMsg("Choose a drink <Newcastle, Carlsberg, Tuborg>");
				
				//	Get the drink:
				ServerAttributes.msg = (String) ServerAttributes.input.readObject();
				ServerAttributes.Xbeer = ServerAttributes.msg.substring(9);
				sendMsg("You have chosen a " + ServerAttributes.Xbeer + " Now enter amount");
				
				//	Get the amount:
				ServerAttributes.msg = (String) ServerAttributes.input.readObject();
				ServerAttributes.Ybeer = Integer.parseInt(ServerAttributes.msg.substring(9));
				
				if(ServerAttributes.Xbeer.equals(beer.beerNewcastle))
				{
					ServerAttributes.person.addBeer(beerType.NewCastle);
					ServerAttributes.person.addPerson(Xbeer, Ybeer);
				}
				
				else if(ServerAttributes.Xbeer.equals(ServerAttributes.beer.beerCarlsberg))
				{
					ServerAttributes.person.addBeer(beerType.Carlsberg);
					ServerAttributes.person.addPerson(ServerAttributes.Xbeer, ServerAttributes.Ybeer);
				}
				
				else if(ServerAttributes.Xbeer.equals(ServerAttributes.beer.beerTuborg))
				{
					ServerAttributes.person.addBeer(beerType.Tuborg);
					ServerAttributes.person.addPerson(ServerAttributes.Xbeer, ServerAttributes.Ybeer);
				}
				
				//	Print hashmap:
				ServerAttributes.person.printHashMap(ServerAttributes.person.beerMap);
			}
			
			//	Input message to client from server:
			receiveMsg();
			
		}while(!ServerAttributes.msg.equals("@Client: END"));
	}
		
	/**
	 * If thread was constructed, this will run
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void run()
	{
		try
		{
			setUpStreams();			//	Setup the I/O stream/connection between server and client
			whileChatting();		//	Handle messages between server and client
			closeIO();
			
			Thread.sleep(50);
		}
		
		catch(IOException | ClassNotFoundException | InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread " + ServerAttributes.threadName + " has terminated");
	}
	
	/**
	 * Start thread
	 */
	public void start()
	{
		if(ServerAttributes.t == null)
		{
			ServerAttributes.t = new Thread (this, ServerAttributes.threadName);
			ServerAttributes.t.start();
		}
	}
}