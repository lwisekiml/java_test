package interruptEnd;

public class Thread5 {
	public static void main(String[] args) {
		ThreadInterrupt ti = new ThreadInterrupt("������");

		ti.start();

		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) { }
		ti.interrupt();
	}
}
