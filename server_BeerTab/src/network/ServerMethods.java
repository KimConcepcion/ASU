package network;

import java.io.IOException;

public interface ServerMethods 
{
	//	Prototypes:
	public void closeIO() throws IOException;
	public void Listen() throws IOException;
	public void setUpStreams() throws IOException;
	public void sendMsg(String msg) throws IOException;
	public void receiveMsg() throws IOException;
	public void whileChatting() throws ClassNotFoundException, IOException;
}
