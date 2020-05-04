package socketChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// https://victorydntmd.tistory.com/135?category=704013
public class Server {
	public static void main(String[] args) {
		final int SERVER_PORT = 5000;

		ServerSocket serverSocket = null; // SErverSocket : 서버 역할을 하는 socket 객체/client의 연결 요청을 기다리면서 연결 요청에 대한 수락을 담당

		try {
			// 1. server socket 객체 생성
			serverSocket = new ServerSocket();

			// 2. socket을 host의 port와 binding
			// InetAddress : IP주소를 표현 할 때 사용하는 class
			// getLocalHost() : localhost의 "hostname/IP주소" 반환
			// getHostAddress() : IP주소 반환
			// getHostName() : host 이름을 문자열로 반환

			// InetSocketAddress : SocketAddress를 상속받은 class로서, socket의 IP와 port를 알 수 있도록 구현한 class(domain 이름만 알아도 객체를 생성 가능)
			// (ServerSocket 객체의 bind(), Socket객체의 connect() 메소드를 호출할 때 인자로 사용)

			String localHostAddress = InetAddress.getLocalHost().getHostAddress();
			// 어떤 socket으로 연결을 기다릴 것인지 바인딩
			serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
			System.out.println("[server] binding! \naddress:" + localHostAddress + ", prot:"+SERVER_PORT);

			// 3. client로 부터 연결 요청이 올 때까지 대기
			// 연결 요청이 오기 전까지 server는 block 상태
			Socket socket = serverSocket.accept();

			// 4. 연결 요청이 오면 연결이 되었다는 메시지 출력
			// getRemoteSocketAddress() : socket에 연결된 종단의 주소를 반환
			// getAddress() : InetAddress 반환
			InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostName = remoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = remoteSocketAddress.getPort();
			System.out.println("[server] connected! \nconnected socket address:" + remoteHostName + ", port:" + remoteHostPort);
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
}

// public int read(byte[] b) : stream을 통애 buffer array b를 읽으며, data가 input될 때까지 block 상태/더 이상 읽을 data가 없으면 -1 반환
// public void write(byte[] b) : buffer b를 쓴다.