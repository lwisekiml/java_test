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
		
//		ExecutorService�� ��� �۾� ���� �ٸ� thread ȣ���� 10�� ���� ����
//		executorService.awaitTermination(10, TimeUnit.SECONDS);
		
		/* ExecutorService ���� */
		executorService.shutdown(); // Executor�� �۾��� ��ٸ��� �����Ų��. �ٸ� �۾��� ���Ḧ ��ٷ���(������ ���� �ȵ�)
		
		/* ExecutorService ����Ǿ����� Ȯ�� */
		while(!executorService.isTerminated()) {
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
		Calendar time1 = Calendar.getInstance();
		String format_time1 = format1.format(time1.getTime());
		System.out.println("["+format_time1+"]"+"��� Thread�� ����Ǿ����ϴ�.");
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
		
		// ExecutorService�� ��� �۾� ���� �ٸ� thread ȣ���� 10�� ���� ����
		try {
			
			if(!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
				System.out.println("ó������ �۾� ����");
				executorService.shutdownNow();
				if(!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
					System.out.println("������ �������� ���� �۾� ����");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			executorService.shutdownNow();
//			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		// ExecutorService ����
//		executorService.shutdown(); // Executor�� �۾��� ��ٸ��� �����Ų��. �ٸ� �۾��� ���Ḧ ��ٷ���(������ ���� �ȵ�)
		
		// ExecutorService ����Ǿ����� Ȯ��
		while(!executorService.isTerminated()) {
		}
		
		System.out.println("��� Thread�� ����Ǿ����ϴ�.");
	}
}
*/
