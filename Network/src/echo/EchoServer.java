package echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	public static int maxThreadCnt = 0;
	public static ServerSocket server;
	public static void main(String[] args) throws IOException {
		server = new ServerSocket(10001);
		System.out.println("Waiting Connect...");

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		EchoServerEnd serv_end = new EchoServerEnd();
		Thread t1 = new Thread(serv_end);
		t1.start();

		while(true) {
			if(maxThreadCnt != 5) {
				Socket sock = server.accept();
				Runnable dothread = new EchoThread(sock);
				executorService.execute(dothread);	
				maxThreadCnt++;
				System.out.println("!!!현재 접속 인원:" + maxThreadCnt);
			}else {
				continue;
			}
		}


		/*			
			Socket sock = server.accept();

			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress()+" 로 부터 접속했습니다.");

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;

			while((line = br.readLine()) != null) {
				System.out.println("client로 부터 전송받은 문자열 :"+line);
				pw.println(line);
				pw.flush();
			}

			pw.close();
			br.close();
			sock.close();
			server.close();
		 */
	}
}
