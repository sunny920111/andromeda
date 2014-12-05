import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args){
		 ServerSocket serverSocket = null;
	        Socket socket = null;
	 
	        try {
	            serverSocket = new ServerSocket(9000);
	            System.out.println("������ �غ�Ǿ����ϴ�.");
	 
	            socket = serverSocket.accept();
	 
	            Sender sender = new Sender(socket);
	            Receiver receiver = new Receiver(socket);
	 
	            sender.start();
	            receiver.start();
	        } catch (Exception e) {
	        }
	}
}
