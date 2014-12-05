package server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

	
public class Server {
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			System.out.println(getTime()+" server is already ready");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			
			try {
				System.out.println(getTime()+" waiting request of connection");
				
				Socket socket = new Socket();
				System.out.println(getTime()+socket.getInetAddress()+" is connected");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("It is message from server side");
				System.out.println("Successfully send data to clinet");
				
				dos.close();
				socket.close();
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static String getTime(){
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
