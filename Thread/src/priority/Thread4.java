package priority;
// 우선 순위가 높다고 꼭 먼저 실행되는건 아닌듯 하다.
// 확인 필요!!!
public class Thread4 {
	public static void main(String args[]) {
		PriorityTest t1 = new PriorityTest("우선 순위가 낮은 쓰레드");
		PriorityTest t2 = new PriorityTest("우선 순위가 높은 쓰레드");
		PriorityTest t3 = new PriorityTest("우선 순위가 높은 쓰레드");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
