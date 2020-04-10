package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
 
public class JavaCompareTest {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = getCreateUsers();
 
		System.out.println("===== ���� �ϱ��� =====");
		for (User temp : users) {
			System.out.println(temp);
		}
 
		Collections.sort(users, new NameAscCompare());
		System.out.printf("\n\n===== ���� ���� ���� =====\n");
		for (User temp : users) {
			System.out.println(temp);
		}
 
		Collections.sort(users, new NameDescCompare());
		System.out.printf("\n\n===== ���� ���� ���� =====\n");
		for (User temp : users) {
			System.out.println(temp);
		}
	}
 
 
	/**
	 * User Data Create
	 * @return
	 */
	 private static List<User> getCreateUsers() {
		// TODO Auto-generated method stub
		 List<User> users = new ArrayList<User>();
 
		 User user = new User();
		 user.setName("��ö��");
		 user.setAddress("��⵵ ������ �д籸");
		 user.setPhone("010-1234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("�ڿ���");
		 user.setAddress("�λ� �ؿ��");
		 user.setPhone("010-4234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("������");
		 user.setAddress("��� ��õ");
		 user.setPhone("010-7234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("�̻��");
		 user.setAddress("������ ����");
		 user.setPhone("010-0234-0192");
		 users.add(user);
		return users;
	}
 
 
	 /**
	  * �̸� ��������
	  * @author falbb
	  *
	  */
	static class NameAscCompare implements Comparator<User> {
 
		/**
		 * ��������(ASC)
		 */
		@Override
		public int compare(User arg0, User arg1) {
			// TODO Auto-generated method stub
			return arg0.getName().compareTo(arg1.getName());
		}
 
	}
 
	/**
	 * �̸� ��������
	 * @author falbb
	 *
	 */
	static class NameDescCompare implements Comparator<User> {
 
		/**
		 * ��������(DESC)
		 */
		@Override
		public int compare(User arg0, User arg1) {
			// TODO Auto-generated method stub
			return arg1.getName().compareTo(arg0.getName());
		}
 
	}
}