package runnable;

public class Thread2 {
	public static void main(String[] args) {
		RunnableTest Obj1 = new RunnableTest();
		RunnableTest Obj2 = new RunnableTest();
		
		Thread t1 = new Thread(Obj1);
		Thread t2 = new Thread(Obj2);
		
		t1.start();
		t2.start();
		
		System.out.println("main End~");
	}

}
