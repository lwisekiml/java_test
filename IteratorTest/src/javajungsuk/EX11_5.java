package javajungsuk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class EX11_5 {
	public static void main(String[] args) {
//		ArrayList list = new ArrayList();
//		HashSet list = new HashSet();
		Collection list = new HashSet();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		// Iterator : 컬렉션에 저장된 데이터를 접근하는데 사용하는 인터페이스
		Iterator iter = list.iterator(); // Iterator는 List, Set, Map 다 사용 가능
		
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
		
//		for(int i=0; i<list.size(); i++) {
//			Object obj = list.get(i); // get()은 ArrayList에서 사용하는 함수
//			System.out.println(obj);
//		}
	}
}
