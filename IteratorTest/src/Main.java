
public class Main {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		
		ArrayList.ListIterator li = numbers.listIterator();
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());

		while(li.hasNext()) {
			System.out.println(li.next());
		}

		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}
}
