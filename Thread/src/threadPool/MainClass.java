package threadPool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=1; i<=10; i++) {
			Runnable dothread = new ThreadPool("Sleepthread"+i);
			executorService.execute(dothread);
		}
		
//		ExecutorService의 모든 작업 이후 다른 thread 호출을 10초 동안 차단
//		executorService.awaitTermination(10, TimeUnit.SECONDS);
		
		/* ExecutorService 종료 */
		executorService.shutdown(); // Executor의 작업을 기다리고 종료시킨다. 다른 작업의 종료를 기다려줌(없으면 종료 안됨)
		
		/* ExecutorService 종료되었는지 확인 */
		while(!executorService.isTerminated()) {
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
		Calendar time1 = Calendar.getInstance();
		String format_time1 = format1.format(time1.getTime());
		System.out.println("["+format_time1+"]"+"모든 Thread가 종료되엇습니다.");
	}
}


/*
public class MainClass {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=1; i<=10; i++) {
			Runnable dothread = new ThreadPool("Sleepthread"+i);
			executorService.execute(dothread);
		}
		
		// ExecutorService의 모든 작업 이후 다른 thread 호출을 10초 동안 차단
		try {
			
			if(!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
				System.out.println("처리중인 작업 존재");
				executorService.shutdownNow();
				if(!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
					System.out.println("여전히 종료하지 않은 작업 존재");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			executorService.shutdownNow();
//			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		// ExecutorService 종료
//		executorService.shutdown(); // Executor의 작업을 기다리고 종료시킨다. 다른 작업의 종료를 기다려줌(없으면 종료 안됨)
		
		// ExecutorService 종료되었는지 확인
		while(!executorService.isTerminated()) {
		}
		
		System.out.println("모든 Thread가 종료되엇습니다.");
	}
}
*/
