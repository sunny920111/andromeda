import java.net.Socket;


public class Client {
	public static void main(String[] args){
		  try{
	            String serverIp = "127.0.0.1";
	            Socket socket = new Socket(serverIp, 9000);

	            System.out.println("Successfully Connected With Server.");
	            
	            System.out.println("test");
	            
	    		Sender sender = new Sender(socket);
	 	        Receiver receiver = new Receiver(socket);
	 	             
	 	        sender.start();
	 	        receiver.start();
	    	
	           
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
