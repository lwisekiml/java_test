package threadPool;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadPool implements Runnable{
	private String threadName;
//	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//	Calendar time = Calendar.getInstance();
//	String format_time = format.format(time.getTime());
	
	public ThreadPool(String threadName) {
		this.threadName=threadName;
	}
	
	public void run() {
		SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
		Calendar time1 = Calendar.getInstance();
		String format_time1 = format1.format(time1.getTime());
		
		System.out.println("["+format_time1+"]"+Thread.currentThread().getName()+"의"+threadName+"이 시작되었습니다.");

		sleepThread();
		
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		Calendar time2 = Calendar.getInstance();
		String format_time2 = format2.format(time2.getTime());

		System.out.println("["+format_time2+"]"+Thread.currentThread().getName()+"가 종료되었습니다.");
	}
	
	private void sleepThread() {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return this.threadName;
	}
}
