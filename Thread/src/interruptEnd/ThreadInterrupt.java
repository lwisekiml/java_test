package interruptEnd;

public class ThreadInterrupt extends Thread {
	public ThreadInterrupt(String str) {
		super(str);
	}
	
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				Thread.sleep(1000);
				System.out.println(getName()+i+"��° ����");
			}
		}catch (InterruptedException e) {
			System.out.println("������ ���� ����");
			return;
		}
	}
}
