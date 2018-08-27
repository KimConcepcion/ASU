
//	Import all the I/O stuff:
import java.io.*;

public class file 
{
	//	String convert function:
	public String convert(String input)
	{
		StringBuilder sb_input = new StringBuilder(input);
		for(int i = 0; i < sb_input.length(); i++)
		{
			//	Fetch the character:
			char ch = sb_input.charAt(i);
			if(Character.isLowerCase(ch))
				sb_input.setCharAt(i, Character.toUpperCase(ch));	//	Convert to upper case
			else
				sb_input.setCharAt(i, Character.toLowerCase(ch));	//	Convert to lower case
		}
		return new String(sb_input);	//	Finally return the converted string...
	}
	
	//	main:
	static public void main(String[] args) throws IOException
	{
		//	Use member functions:
		file test = new file();
		
		System.out.println("---- Opgave 1 (fil håndtering i Java) ----");
		
		//	Files to handle:
		String file_read = "/Users/kimnielsen/ASU/Opgave1/readFile.txt";	//	<-- File to read
		String file_write = "/Users/kimnielsen/ASU/Opgave1/writeFile.txt";	//	<-- File to write
		
		//	Open files:
		FileReader filereader = new FileReader(file_read);
		FileWriter filewriter = new FileWriter(file_write);
		
		//	File buffers:
		BufferedReader readBuffer = new BufferedReader(filereader);
		BufferedWriter writeBuffer = new BufferedWriter(filewriter);
	
		String res;
		String line = readBuffer.readLine();
		while(line != null)
		{
			res = test.convert(line);		//	Convert file content
			System.out.println(res);		//	Print the converted string
			writeBuffer.write(res);			//	Write the converted content
			writeBuffer.write("\n");		//	Manually write the newline
			line = readBuffer.readLine();	//	Increment to read the next line
		}
		
		//	Close the files:
		readBuffer.close();
		writeBuffer.close();
	}
}