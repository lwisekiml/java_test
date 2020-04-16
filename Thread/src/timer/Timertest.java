package timer;
import java.util.Timer;

public class Timertest {
	public static void main(String[] args) {
		Mytask task = new Mytask();
		Timer timer = new Timer();
		
		timer.schedule(task, 1000, 500);
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			timer.cancel();
		}
		System.out.println("timer cancel");
//		timer.cancel(); // 없으면 Thread 종료 안됨
	}
}