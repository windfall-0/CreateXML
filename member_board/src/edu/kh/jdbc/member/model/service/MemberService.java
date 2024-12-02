package edu.kh.jdbc.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.member.dto.Member;
import edu.kh.jdbc.member.model.dao.MemberDAO;
import oracle.jdbc.OracleConnection.CommitOption;

//import static 구문 : static 메소드를 import 하여 클래스명.method(); -> method(); 로 사용
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;

/** Service
 * @author user1
 * 데이터 가공 + 트랜잭션 제어 처리
 *  -> 하나의 Service 메소드에서 n 개의 DAO메소드를 호출할 수 있음
 *  -> n 개의 DAO 에서 수행된 SQL을 한 번에 commit/rollback
 */
public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	
	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return result
	 */
	public int duplicateCheck(String memberId) throws Exception {
		
		Connection conn = getConnection();
		// DAO 메소드 호출 후 결과 반환 받기
		int result = dao.duplicateCheck(conn, memberId);
		// SELECT 문은 별도의 트랜잭션 제어 필요 X
		close(conn);
		
		return result;
	}


	/**회원가입 Service
	 * @param signUpMember
	 * @return result
	 * @throws SQLException 
	 */
	public int signUp(Member signUpMember) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, signUpMember);
		
		if (result == 1) JDBCTemplate.commit(conn);
		
		close(conn);
		
		return result;
	}


	public Member idCheck(String memberId) throws SQLException {
		Connection conn = getConnection();

		Member result = dao.signIn(conn, memberId);
		close(conn);
		return result;

	}
}
