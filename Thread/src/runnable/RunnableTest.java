package runnable;

public class RunnableTest implements Runnable {
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				Thread.sleep(200); // 0.2ÃÊ
				System.out.println("Thread:"+i);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
