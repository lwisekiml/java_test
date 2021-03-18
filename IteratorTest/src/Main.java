
public class Main {
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);
		numbers.addFirst(5); // 5 10 15 20 30 40
		numbers.remove(1);
		System.out.println(numbers);

		ArrayList.ListIterator li = numbers.listIterator();

//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//
//		while(li.hasPrevious()) {
//			System.out.println(li.previous());
//		}

	}
}
