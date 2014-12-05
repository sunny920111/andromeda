package client;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args){
		String serverIp = "127.0.0.1";
		System.out.println("Client is connecting to server :"+serverIp);
		
		try {
			Socket socket = new Socket(serverIp,9000);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("Sended message from server : "+dis.readUTF());
			System.out.println("connenction close");
			
			dis.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
