package network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import common.Beer;
import common.Person;

public class ServerAttributes 
{
	//	Person, Beer objects:
	static Person person = new Person();
	static Beer beer = new Beer();
	
	//	Threading:
	static Thread t;
	static String threadName;
	
	//	Beer variables:
	static String Xbeer = null;
	static int Ybeer = 0;
	
	//	Server settings:
	static ServerSocket server;
	static Socket connection;
	static int port = 1700;
	static int BACKLOG = 5;
	static String msg = null;
	
	//	Files MacOS + Windows:
	//static String path = "/Users/kimnielsen/Dropbox/Elektronik/5. Semester/ASU/workspace/server_BeerTab/";
	static String path = "C:\\Users\\Kim\\Dropbox\\Elektronik\\5. Semester\\ASU\\workspace\\server_BeerTab";
	
	//	Logging:
	static String logFile = path+"serverLog.txt";
	static FileWriter log_writer;
	static BufferedWriter logger;
	
	//	Streams:
	static ObjectOutputStream output;
	static ObjectInputStream input;
	static Scanner sc = new Scanner(System.in);
}
