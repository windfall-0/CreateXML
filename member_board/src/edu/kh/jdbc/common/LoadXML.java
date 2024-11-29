package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadXML {
	public static void main(String[] args) {
		//외부에 있는 XML파일 읽어오기
		
		Properties prop = new Properties();
		//<String, String> 인 K:V map
		
		try {
			prop.loadFromXML(new FileInputStream("driver.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("driver"));
		// property 속성(데이터)
		// map과 유사한 방식
		
		
		// 컴파일 언어인 자바의 효율성을 위해 외부 파일 XML사용
		// -> DB연결 정보, SQL내용은 변동이 많아 외부 파일에 기록
		
		// + 보기 좋고 관리가 쉬움
		
		
		System.out.println(JDBCTemplate.getConnection());
		
	}
}
