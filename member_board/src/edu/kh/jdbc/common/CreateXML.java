package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML { // 혼자 실행하면 파일 사라짐 주의!
	// XML (eXtensible Markup Language) : 단순화된 데이터 기술 형식
	
	//  XML 이유
	/*
	 * DB 연결 정보, SQL문 같이 수정이 빈번한 내용을 코드에 직접 작성하면 좋지 않음
	 * 
	 * java는 컴파일 언어 -> 코드가 조금만 수정되어도 전체 컴파일 다시함 : 시간이 오래걸림
	 */
	
	
	// XML 외부 파일을 이용해서 XML 내용을 바꿔도 java에서 읽어오는 코드는 변하지 않음
	//  > 컴파일 X -> 시간 효율 상승
	
	
	public static void main(String[] args) {
		// XML은 K:V 형식 map, 문자열만 저장
		
		// Map<String,String> == Properties
		
		/*
		 * Properties
		 * 1. <String, String> 인 K:V map
		 * 2. XML 파일을 생성하고 읽어오는데 특화
		 */
		
		Properties prop = new Properties();
		
		try {
			
			FileOutputStream fos = new FileOutputStream("driver.xml");
			
			prop.storeToXML(fos, "DB Connection Data"); // XML파일 생성
								// 주석
		} catch (IOException e) {// IO 예외
			e.printStackTrace();
		} 
		
	}
	
	
	
	
}
