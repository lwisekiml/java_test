package db_test;

public class TestMySQL {
	public static void main(String[] args) {
		OpenTable ot = new OpenTable();
		
		ot.update("INSERT INTO members (mbNo, mbName, mbAddr)"
					+ "VALUES (10, '김보경', '광주시 북구')");
		
		ot.select("SELECT * FROM members");
		
		try {
			ot.rs.beforeFirst(); // 커서를 개체의 첫 번째 행 앞으로 이동 (http://egloos.zum.com/kaludin/v/2934008)
			
			while(ot.rs.next()) {
				System.out.println(ot.rs.getString("mbNo")+
									ot.rs.getString("mbName")+
									ot.rs.getString("mbAddr"));
			}
		}catch (Exception e) {
			System.out.println("getString error:"+e);
		}
		
		ot.close();
	}
}
		
/*
public class TestMySQL {
	public static void main(String[] args) {
		// Connection 레퍼런스 타입은 java.sql.Connection 클래스
		Connection conn;
		
		try {
			// 1) 해당 클래스를 메모리에 로드, 해당 클래스가 존재하는지 여부 확인
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2) 해당 드라이버의 클래스를 이용하여 DB접속
			// jdbc:[Driver종류]://[IP]:[port]/[DB명], [ID], [PW]
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "qwer", "1234");
			System.out.println("DB connect success...");

			// 3) DB에 명령어를 전달할 수 있는 객체 생성
			java.sql.Statement stmt = conn.createStatement();
			
			// 4) 쿼리문장이 실행된 결과를 ResultSet 객체의 참조변수에 담는다.
			java.sql.ResultSet rs = stmt.executeQuery("select * from members");
			
			// 5) 결과를 가져와 출력
			while(rs.next()) {
				System.out.println(rs.getString("mbNo")+
									rs.getString("mbName")+
									rs.getString("mbAddr"));
			}
			
			conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버가 존재하지 않습니다."+e);
		} catch (Exception e) {
			System.out.println("오류:"+e);
		}
	}
}
*/