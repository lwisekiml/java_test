package daemon;
/*
- ������ ���μ��� �ȿ��� �ٸ� �������� ������ ���� ������� �ٸ� �����带 ���� ���ָ鼭 �ٸ� �����尡 ��� ����Ǹ� �ڽŵ� ����Ǵ� ������
- ���α׷��� ����Ǵ� ���� ���� ������ ������ �÷��ͳ� ���� �����尡 ���� �������Դϴ�.
- �����带 �����ϰ� setDaemon(true)�� �����ϸ� ��
- �����尡 �����ϱ� ���� �����ؾ� �մϴ�. 
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

		t.setDaemon(true); // �� �κ��� ������ ������� �ʴ´�.
		t.start();
		System.out.println("Main Method End!");
	}

}


//class Thread3 implements Runnable{
//    static boolean autoSave = false;
//
//    public static void main(String[] args) {
//        Thread t = new Thread(new Thread3());
//        //t.setDaemon(true); // �� �κ��� ������ ������� �ʴ´�.
//        // ����Ʈ: ����==> setDaemon(true): ���󾲷���� (���ξ����� ����� ���Ӿ������ �۾� �� �������� ���� ������� �Բ� ����ȴ�.)
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
//        System.out.println("���α׷��� �����մϴ�.");
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
//        System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
//    }
//}
