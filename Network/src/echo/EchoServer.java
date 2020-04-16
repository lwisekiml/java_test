package echo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("Waiting Connect...");
			
			Socket sock = server.accept();
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress()+" 濡쒕????묒냽?덉뒿?덈떎.");
			
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println("client濡쒕????꾩넚諛쏆? 臾몄옄??:"+line);
				pw.println(line);
				pw.flush();
			}
			
			pw.close();
			br.close();
			sock.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
