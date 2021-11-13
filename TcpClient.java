import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
try {
	Socket c=new Socket("Localhost", 8080);
	System.out.println("Connected");
	Scanner scanner=new Scanner(System.in);
	DataInputStream din=new DataInputStream(c.getInputStream());
	DataOutputStream dout=new DataOutputStream(c.getOutputStream());

	while(true)
	{
        System.out.println("Start of Conversation");
		System.out.println("Enter message:-");
		String client_message=scanner.nextLine();
		dout.writeUTF(client_message);
		if(client_message.equals("exit"))
		{
			System.out.println("Leaving Conversation");
			din.close();
			dout.close();
			scanner.close();
			c.close();
			System.exit(0);
		}
		String server_message=din.readUTF();
		System.out.println("Message from Server:"+server_message);
		if(server_message.equals("exit"))
		{
			System.out.println("Leaving Conversation");
			din.close();
			dout.close();
			scanner.close();
			c.close();
			System.exit(0);
		}
	}
} 
catch (UnknownHostException e) 
{

} 
catch (IOException e) 
{

}

	}

}