package daemon;
/*
- 동일한 프로세스 안에서 다른 스레드의 수행을 돕는 스레드로 다른 스레드를 서비스 해주면서 다른 스레드가 모두 종료되면 자신도 종료되는 스레드
- 프로그램이 종료되는 것을 막지 않으며 가비지 컬렉터나 메인 스레드가 데몬 스레드입니다.
- 스레드를 생성하고 setDaemon(true)를 설정하면 됨
- 스레드가 시작하기 전에 설정해야 합니다. 
*/
public class Thread3 extends Thread {
	int num=0;
	public void run() {
		try {
			System.out.println("Daemon Thread Start!");
			while(true) {
				sleep(1000);
				System.out.println(num++);
			}
		}catch (Exception e) { }
	}
	public static void main(String[] args) {
		Thread3 t = new Thread3();

		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
		t.start();
		System.out.println("Main Method End!");
	}

}


//class Thread3 implements Runnable{
//    static boolean autoSave = false;
//
//    public static void main(String[] args) {
//        Thread t = new Thread(new Thread3());
//        //t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
//        // 디폴트: 독립==> setDaemon(true): 데몬쓰레드로 (메인쓰레드 종료시 종속쓰레드는 작업 다 못끝내도 메인 쓰레드와 함께 종료된다.)
//        t.start();
//         
//        for(int i=1; i<=20; i++)
//        {
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){}
//            System.out.println(i);
//            if(i==5)
//                autoSave = true;
//        }
//        System.out.println("프로그램을 종료합니다.");
//    }
//
//    @Override
//    public void run() {
//        while(true)
//        {
//            try{
//                Thread.sleep(3 * 1000);
//            }catch(InterruptedException e){}
//            if(autoSave)
//                autoSave();
//        }
//    }
//
//    private void autoSave() {
//        System.out.println("작업파일이 자동저장되었습니다.");
//    }
//}
