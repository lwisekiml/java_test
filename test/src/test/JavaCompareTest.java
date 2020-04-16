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
 
		System.out.println("===== 정렬 하기전 =====");
		for (User temp : users) {
			System.out.println(temp);
		}
 
		Collections.sort(users, new NameAscCompare());
		System.out.printf("\n\n===== 오름 차순 정렬 =====\n");
		for (User temp : users) {
			System.out.println(temp);
		}
 
		Collections.sort(users, new NameDescCompare());
		System.out.printf("\n\n===== 내림 차순 정렬 =====\n");
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
		 user.setName("고철수");
		 user.setAddress("경기도 성남시 분당구");
		 user.setPhone("010-1234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("박영희");
		 user.setAddress("부산 해운대");
		 user.setPhone("010-4234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("감수왕");
		 user.setAddress("충북 제천");
		 user.setPhone("010-7234-0192");
		 users.add(user);
 
 
		 user = new User();
		 user.setName("이사람");
		 user.setAddress("강원도 영울");
		 user.setPhone("010-0234-0192");
		 users.add(user);
		return users;
	}
 
 
	 /**
	  * 이름 오름차순
	  * @author falbb
	  *
	  */
	static class NameAscCompare implements Comparator<User> {
 
		/**
		 * 오름차순(ASC)
		 */
		@Override
		public int compare(User arg0, User arg1) {
			// TODO Auto-generated method stub
			return arg0.getName().compareTo(arg1.getName());
		}
 
	}
 
	/**
	 * 이름 내림차순
	 * @author falbb
	 *
	 */
	static class NameDescCompare implements Comparator<User> {
 
		/**
		 * 내림차순(DESC)
		 */
		@Override
		public int compare(User arg0, User arg1) {
			// TODO Auto-generated method stub
			return arg1.getName().compareTo(arg0.getName());
		}
 
	}
}