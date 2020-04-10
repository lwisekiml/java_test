package test;
public class Threadtest extends Thread {
	static int num = 0;
	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();
		MyThread2 th2 = new MyThread2();

		th1.start();
		th2.start();
	}
}

class MyThread1 extends Thread{
	public void run() {
		for(int i=0; i<1000; i++) {
			//synchronized (this) {
				Threadtest.num++;
				System.out.println("num1:"+Threadtest.num);
			//}
		}
	}
}


class MyThread2 extends Thread{
	public void run() {
		for(int i=0; i<1000; i++) {
			//synchronized (this) {
				Threadtest.num--;
				System.out.println("num2:"+Threadtest.num);
			//}
		}
	}
}

class MyThreadRun implements Runnable{
	public void run() {

	}
}
