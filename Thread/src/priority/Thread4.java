package priority;
// �켱 ������ ���ٰ� �� ���� ����Ǵ°� �ƴѵ� �ϴ�.
// Ȯ�� �ʿ�!!!
public class Thread4 {
	public static void main(String args[]) {
		PriorityTest t1 = new PriorityTest("�켱 ������ ���� ������");
		PriorityTest t2 = new PriorityTest("�켱 ������ ���� ������");
		PriorityTest t3 = new PriorityTest("�켱 ������ ���� ������");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
