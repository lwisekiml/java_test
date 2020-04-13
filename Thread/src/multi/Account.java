package multi;

public class Account {
	int balance = 10000;
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) { }

			balance -= money;
		}
	}
}
