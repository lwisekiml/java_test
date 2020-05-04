package socketChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// https://victorydntmd.tistory.com/135?category=704013
public class Server {
	public static final int PORT = 5000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null; // SErverSocket : 서버 역할을 하는 socket 객체/client의 연결 요청을 기다리면서 연결 요청에 대한 수락을 담당
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>();

		try {
			serverSocket = new ServerSocket();

			// InetAddress : IP주소를 표현 할 때 사용하는 class
			// getLocalHost() : localhost의 "hostname/IP주소" 반환
			// getHostAddress() : IP주소 반환
			// getHostName() : host 이름을 문자열로 반환

			// InetSocketAddress : SocketAddress를 상속받은 class로서, socket의 IP와 port를 알 수 있도록 구현한 class(domain 이름만 알아도 객체를 생성 가능)
			// (ServerSocket 객체의 bind(), Socket객체의 connect() 메소드를 호출할 때 인자로 사용)

			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			// 어떤 socket으로 연결을 기다릴 것인지 바인딩
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			consoleLog("connect waiting... " + hostAddress + ":"+PORT);

			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerProcessThread(socket, listWriters).start();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void consoleLog(String log) {
		System.out.println("[server " + Thread.currentThread().getId() + "] " + log);
	}
}