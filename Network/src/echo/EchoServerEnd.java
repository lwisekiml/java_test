package echo;

import java.io.IOException;
import java.util.Scanner;

public class EchoServerEnd implements Runnable {
	public void run() {
		System.out.println("aaa");
		Scanner scan = new Scanner(System.in);
		String exit = scan.nextLine();
		System.out.println("bbb "+exit);

		if( exit.equals("exit")) {
			System.out.println("ccc");
			scan.close();

			try {
				EchoServer.server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
