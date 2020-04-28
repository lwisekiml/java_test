package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("사용법 : java ChatClient [이름] [접속할 서버ip]");
			System.exit(1);
		}
		
		Socket sock = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;
		
		try {
		/*****************************************************************
		 * 입력받은 ip로 10001번 포트에 접속(args[0] : id, args[1] : 서버 ip)
		 * 1. 서버에 접속하기 위해 Socket 생성하고, Socket으로부터 InputStream과 OutputStream을 얻어와서
		 *    각각 Buffered와 PrintWriter 형태로 변환 시킴
		 *****************************************************************/
			System.out.println("!!!!!!!!!:"+args[1]);
			sock = new Socket(args[1], 10003);
			System.out.println("aaaaaaaa");
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		/*****************************************************************
		 * 2. 키보드로 부터 입력받기 위한 BufferedReader를 생성한 후,
		 *    서버로부터 전달된 문자열을 모니터에 출력하는 InputThread 객체를 생성
		 *****************************************************************/
			System.out.println("bbbbbbbb");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// 사용자의 id를 서버로 전송
			pw.println(args[0]);
			pw.flush();
			System.out.println("cccccccc");
			
			InputThread it = new InputThread(sock, br);
			it.start();
		/*****************************************************************
		 * 3. 키보드로부터 한 줄씩 입력받아 서버에 전송(/quit를 입력받기 전까지)
		 *****************************************************************/
			String line = null;
			
			while((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
				
				if(line.contentEquals("/quit")) {
					endflag = true;
					break;
				}
			}
			System.out.println("클라이언트의 접속을 종료합니다.");
		}catch (Exception ex) {
			if(!endflag)
				System.out.println(ex);
		}finally {
			try {
				if(pw != null)
					pw.close();
			}catch (Exception ex) { }
			
			try {
				if(sock != null)
					sock.close();
			}catch (Exception ex) { }
		}
	}
}
	
/*****************************************************************
 * 4. 서버로부터 전달 받은 문자열을 모니터에 출력하는 InputThread 객체를 생성하여
 *    BufferedReader와 Socket 객체를 인자로 전달 받음 
 *****************************************************************/
class InputThread extends Thread{
	private Socket sock = null;
	private BufferedReader br = null;
	public InputThread(Socket sock, BufferedReader br) {
		this.sock = sock;
		this.br = br;
	}
	
	/*****************************************************************
	 * 5. 서버로부터 문자열을 읽어 들여 모니터에 출력
	 *****************************************************************/
	public void run() {
		try {
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch (Exception e) {
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch (Exception ex) { }
			try {
				if(sock != null) {
					sock.close();
				}
			}catch (Exception ex) { }
		}
	}
}
