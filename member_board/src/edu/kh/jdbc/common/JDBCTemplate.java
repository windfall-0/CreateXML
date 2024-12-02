package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static Connection getConnection() {
		// 공용으로 사용되는 conn에 커넥션이 없거나 이전 커넥션이 있었으나 닫힌 경우에만 새로 연결
		
		try {
			if (conn == null || conn.isClosed()) {
				Properties prop = new Properties();
				prop.loadFromXML(new FileInputStream("member_board/driver.xml"));
				
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
	
	// close() 작성
	
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stat) {
		try {
			if (stat != null && !stat.isClosed()) stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션 제어
	
	// commit
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) conn.commit();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) conn.rollback();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
