
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	String name; 
	Socket socket;
	DataOutputStream out;
	
	Sender(Socket socket) throws IOException{
		this.socket = socket;	
		out = new DataOutputStream(socket.getOutputStream());
		name = "[" + socket.getInetAddress() + ":" + socket.getPort()
                + "] ";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		while(out != null){
			try {
				out.writeUTF("[CLIENT] :"+s.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
