package thread;
/*
��ó : https://postitforhooney.tistory.com/entry/JavaThread-Java-Thread-Pool%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-Thread%EB%A5%BC-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0Thread-Runnable
run() : class�� �������̵� �� �޼ҵ带 ȣ���ؼ� ����ϴ°����� ����
start() : ���ο� �����尡 �۾��� �����ϴµ� �ʿ��� ȣ�⽺��(����)�� ������ ���� run()�� ȣ���ؼ� �� ��(����)�� run()�� ����Ǵ� ���̴�.
��, �����带 ����ϱ� ���� start()�� �����Ű�� ���� �����常�� �������� �۾� ������ ȣ�⽺���� ��������� ���̴�.
�� �Ŀ� ȣ�� ���þȿ� �� �����ϰ��� �ϴ� ���� ��� run()�� ���� �޼ҵ���� ����Ǵ� ���̴�.
ȣ�� ���ÿ� �ִ� �ֿ���� ��� �����ϰ� ���� ������� ȣ�⽺�� ������ �Բ� �޸� �󿡼� �Ҹ�ȴ�.
*/
public class Thread1 {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
// ���ÿ� ���	: 001122....
//		t1.start();
//		t2.start();

// �Ѱ� �Ϸ� �Ǹ� ������ ��� : 0123...9012...
		t1.run();
		t2.run();
	}
}
