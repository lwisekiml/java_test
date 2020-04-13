package thread;

public class Thread1 {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
// 동시에 출력	: 001122....
//		t1.start();
//		t2.start();

// 한개 완료 되면 다음거 출력 : 0123...9012...
		t1.run();
		t2.run();
	}
}
