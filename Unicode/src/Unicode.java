import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Unicode {
	
	private static Charset UTF_8 = StandardCharsets.UTF_8;
	private static Charset US_ASCII = StandardCharsets.US_ASCII;
	private static Charset UTF_16 = StandardCharsets.UTF_16;
	
	public static void fileWriter(BufferedWriter wBuffer, String filename, String content, Charset encoding) throws IOException {
		//wBuffer = new BufferedWriter(new FileWriter(filename));
		wBuffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), encoding));
		
		wBuffer.write(content);
		wBuffer.close();
	}
	
	public static void fileAppend(BufferedWriter aBuffer, String filename, String content, Charset encoding) throws IOException {
		//aBuffer = new BufferedWriter(new FileWriter(filename, true));
		aBuffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true), encoding));
		
		//	Probably want a space between the new word and the old word:
		aBuffer.append(' ');
		
		aBuffer.append(content);
		aBuffer.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter buffer = null;
		fileWriter(buffer, "file.txt", "Java 😎👌", UTF_8);
		fileAppend(buffer, "file.txt", "Programming! 😜😁 \u263a", UTF_8);
		fileAppend(buffer, "file.txt", "\n\uD83D\uDE00", UTF_8);
		
	}
}
