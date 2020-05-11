package db_test;

import java.sql.ResultSet;

public class OpenTable {
	java.sql.Connection conn;
	java.sql.Statement	stmt;
	java.sql.ResultSet	rs;
	
	public OpenTable() {
		connect();
	}
	
	// 해당 드라이버의 class를 이용하여 DB접속(conn)
	// DB에 명령어를 전달할 수 있는 객체생성(stmt)
	void connect() {
		String dbInfo = "jdbc:mysql://localhost:3306/sales?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbID = "qwer";
		String dbPW = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = java.sql.DriverManager.getConnection(dbInfo, dbID, dbPW);
			// https://m.blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140196942464&proxyReferer=https:%2F%2Fwww.google.com%2F
			// ResultSet.TYPE_SCROLL_SENSITIVE	커서이동방법
			// ResultSet.CONCUR_UPDATABLE 		수정가능한 모드
			this.stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //
		}catch (Exception e) {
			System.out.println("connection error:"+e);
		}
	}
	
	void update(String dbCommand) {
		try {
			this.stmt.execute(dbCommand);
		}catch (Exception e) {
			System.out.println("update error"+e);
		}
	}
	
	void select(String dbSelect) {
		try {
			this.rs = this.stmt.executeQuery(dbSelect);
		}catch (Exception e) {
			System.out.println("select error:"+e);
		}
	}
	
	void close() {
		try {
			conn.close();
		}catch (Exception e) {
			System.out.println("close error:"+e);
		}
	}
}
