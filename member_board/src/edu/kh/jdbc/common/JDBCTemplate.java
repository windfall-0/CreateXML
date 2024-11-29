package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	/*
	 * DB연결, 트렌젝션 제어, 자원반환 같은 반복적인 JDBC 코드를 모아둔 클래스
	 * 
	 * getConnection()
	 * 
	 * commit()
	 * rollback()
	 * 
	 * close() 등등
	 * 
	 */
	
	private static Connection conn;
	private static Statement stat;
	
	public static Connection getConnection() {
		// 공용으로 사용되는 conn에 커넥션이 없거나 이전 커넥션이 있었으나 닫힌 경우에만 새로 연결
		
		try {
			if (conn == null || conn.isClosed()) {
				Properties prop = new Properties();
				prop.loadFromXML(new FileInputStream("driver.xml"));
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
	
	
}
