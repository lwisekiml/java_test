package thread;

public class Thread1 {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
// ���ÿ� ���	: 001122....
//		t1.start();
//		t2.start();

// �Ѱ� �Ϸ� �Ǹ� ������ ��� : 0123...9012...
		t1.run();
		t2.run();
	}
}
