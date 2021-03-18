public class Main {
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);
		numbers.addFirst(5); // 5 10 15 20 30 40
		numbers.remove(1); // 5 15 20 30 40
		numbers.removeFirst(); // 15 20 30 40
		numbers.removeLast(); // 15 20 30
		System.out.println(numbers.get(1)); // 20
		System.out.println(numbers.size()); // 3
		System.out.println(numbers.indexOf(20)); // 1
		System.out.println(numbers);

		System.out.println("--- ArrayList start ---");
		ArrayList.ListIterator li = numbers.listIterator();

		System.out.println("--- add(35) ---");

		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.add(35);
			}
		}
		System.out.println(numbers);

		System.out.println("--- remove(30) ---");
		li.setNextIndex(0); // nextIndex 초기화
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.remove();
			}
		}
		System.out.println(numbers);

		System.out.println("--- next(), previous() ---");
		li.setNextIndex(0); // nextIndex 초기화
		while(li.hasNext()) {
			System.out.println(li.next());
		}

		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}
}
