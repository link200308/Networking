import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss=new ServerSocket(8080);
			System.out.println("Waiting For Connection:-");
			Socket s=ss.accept();
			Scanner scanner=new Scanner(System.in);
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				String client_message=din.readUTF();
				System.out.println("Client:-"+client_message);
				if(client_message.equals("exit"))
				{
					System.out.println("Leaving Conversation");
					din.close();
					dout.close();
					scanner.close();
					s.close();
					ss.close();
					System.exit(0);
				}
			
				System.out.println("Enter message:-");
				String server_message=scanner.nextLine();
				dout.writeUTF(server_message);
				if(server_message.equals("exit"))
				{
					System.out.println("Leaving Conversation");
					din.close();
					dout.close();
					scanner.close();
					s.close();
					ss.close();
					System.exit(0);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}