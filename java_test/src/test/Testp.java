package test;
/*
class Card {
	int a;
	final int b;
	
	Card(int a, int b){
		this.b = b;
		this.a = a;
	}
	Card() {
		this(1, 2);
	}
	
	public String toString() {
		return ""+a+"       "+b;
	}
}

public abstract class Testp {
	public static void main(String[] args) {
		Card c = new Card(3,4);
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c);
		
		c.a=5;
//		c.b=9;
		System.out.println(c.a);
		System.out.println(c.b);
	}
}
*/
class Car {
	String color;
	int door;
	
	Car() {
		this.color="blue";
		this.door=4;
	}
	
	Car(String color, int door) {
		this.color=color;
		this.door=door;
	}

	void drive() {
		System.out.println("drive, Brrrr~");
	}
	
	void stop() {
		System.out.println("stop!");
		
	}
}

class FireEngine extends Car {
	String color;

	FireEngine() {
		this.color="red";
	}
	void water() {
		System.out.println(super.color);
		System.out.println("water!!");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("siren~~~");
	}
}

public abstract class Testp {
	public static void main(String[] args) {
//		Car car = null;
//		FireEngine fe = new FireEngine();
//		FireEngine fe2 = null;
//		
//		fe.water();
//		car = fe;
////		car.water();
//		fe2 = (FireEngine)car;
//		fe2.water();
//		
//		
//		if(fe instanceof FireEngine) {
//			System.out.println("this is a FireEngine instance.");
//		}
//		
//		if(fe instanceof Ambulance) {
//			System.out.println("this is a FireEngine instance.");
//		}
		Car car = new FireEngine();
		FireEngine fe = new FireEngine();
		
		System.out.println(car.color);
		System.out.println(fe.color);
		System.out.println("테스트임");
				
	}
}


