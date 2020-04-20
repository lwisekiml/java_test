package echo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EchoThread implements Runnable {
	Socket sock;

	public EchoThread(Socket sock) {
		this.sock=sock;
	}

	public void run() {
		InetAddress inetaddr = sock.getInetAddress();
		System.out.println(inetaddr.getHostAddress()+" 로 부터 접속했습니다.");
		try {
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
			EchoServer.maxThreadCnt--;
			System.out.println("현재 접속 인원 :" + EchoServer.maxThreadCnt);
			System.out.println("종료");

		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
