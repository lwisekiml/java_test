package multi;

public class Thread6 {
	public static void main(String[] args) {
		Bank b1 = new Bank("ATM");
		Bank b2 = new Bank("����");
		
		b1.start();
		b2.start();
	}
}
