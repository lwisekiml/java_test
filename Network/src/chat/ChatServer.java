package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// http://blog.naver.com/PostView.nhn?blogId=cyberhole&logNo=110133796577&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10003);
			System.out.println("접속을 기다립니다.");
			HashMap hm = new HashMap();
			while(true) {
				System.out.println("accept전전전");
				Socket sock = server.accept();
				System.out.println("accept 완료");
				ChatThread chatthread = new ChatThread(sock, hm);
				chatthread.start();
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ChatThread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private boolean initFlag = false;

	public ChatThread(Socket sock, HashMap hm) {
		this.sock = sock;
		this.hm = hm;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = br.readLine();

			broadcast(id+"님이 접속했습니다.");
			System.out.println("접속한 사용자의 아이디는 "+ id + "입니다.");

			synchronized (hm) {
				hm.put(this.id, pw);
			}
			initFlag = true;
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void run() {
		try {
			String line = null;

			while((line = br.readLine()) != null) {
				if(line.contentEquals("/quit"))
					break;
				if(line.indexOf("/to") == 0) {
					sendmsg(line);
				}else {
					broadcast(id + " : " + line);
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			synchronized (hm) {
				hm.remove(id);
			}
			broadcast(id + " 님이 접속을 종료했습니다.");
			try {
				if(sock != null)
					sock.close();
			}catch (Exception ex) { }
		}
	}

	public void sendmsg(String msg) {
		int start = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", start);
		
		if(end != -1) {
			String to = msg.substring(start, end); // 상대방 이름
			String msg2 = msg.substring(end + 1); // 보낼 메세지
			Object obj = hm.get(to);
			
			if(obj != null) {
				PrintWriter pw = (PrintWriter)obj;
				pw.println(id + "님이 다음의 귓속말을 보내셨습니다. :" + msg2);
				pw.flush();
			}
		}
	}
	
	public void broadcast(String msg) {
		synchronized (hm) {
			Collection collection = hm.values(); // Collection values() : hashmap에 지정된 모든 값을 컬렉션 형태로 반환
			Iterator iter = collection.iterator();
			
			while(iter.hasNext()) { // boolean hasNxt() 읽어 올 요소가 남아있는지 확인
				PrintWriter pw = (PrintWriter)iter.next(); // 다음 요소를 읽어 옴(전에 hasNext()로 확인하는것이 안전)
				pw.println(msg);
				pw.flush();
			}
		}
	}
}