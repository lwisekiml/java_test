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

		// Iterator : �÷��ǿ� ����� �����͸� �����ϴµ� ����ϴ� �������̽�
		Iterator iter = list.iterator(); // Iterator�� List, Set, Map �� ��� ����
		
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
		
//		for(int i=0; i<list.size(); i++) {
//			Object obj = list.get(i); // get()�� ArrayList���� ����ϴ� �Լ�
//			System.out.println(obj);
//		}
	}
}
