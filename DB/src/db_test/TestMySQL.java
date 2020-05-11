package db_test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQL {
	public static void main(String[] args) {
		// Connection 레퍼런스 타입은 java.sql.Connection 클래스
		Connection conn;
		
		try {
			// 해당 클래스를 메모리에 로드, 해당 클래스가 존재하는지 여부 확인
			Class.forName("com.mysql.jdbc.Driver");
			
			// jdbc:[Driver종류]://[IP]:[port]/[DB명], [ID], [PW]
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "qwer", "1234");

			System.out.println("DB connect success...");
			
			conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버가 존재하지 않습니다."+e);
		} catch (Exception e) {
			System.out.println("오류:"+e);
		}
	}
}