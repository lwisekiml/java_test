package socketChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	private static final String SERVER_IP = "127.0.1.1";
	private static final int SERVER_PROT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PROT));
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
