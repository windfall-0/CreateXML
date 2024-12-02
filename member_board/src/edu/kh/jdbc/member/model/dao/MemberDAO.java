package edu.kh.jdbc.member.model.dao;

import java.sql.*;

import edu.kh.jdbc.member.dto.Member;

import static edu.kh.jdbc.common.JDBCTemplate.close;
/**DAO (Data Access Object) : 데이터가 저장되어있는 DB, 파일 등에 접근하는 객체
 *  -> DB에 접근할 수 있다 == SQL을 실행하고 결과를 반환 받을 수 있다
 * @author user1
 *
 * Java에서 DB에 접근하고 결과를 반환받기 위한 프로그래밍 API를 제공함
 * == JDBC
 */
public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * @param conn
	 * @param memberId
	 * @return result
	 */
	public int duplicateCheck(Connection conn, String memberId) throws Exception {
		
		int result = 0;
		
		try {
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND SECESSION_FL = 'N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	/**
	 * @param conn 
	 * @param signUpMember
	 * @return result
	 * @throws SQLException 
	 */
	public int signUp(Connection conn, Member signUpMember) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, DEFAULT, DEFAULT)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, signUpMember.getMemberId());
			pstmt.setString(2, signUpMember.getMemberPw());
			pstmt.setString(3, signUpMember.getMemberNm());
			pstmt.setString(4, ""+signUpMember.getMemberGender());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member signIn(Connection conn, String memberId) throws SQLException {
		Member result = null;

		try {
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				result = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5).charAt(0),
						rs.getDate(6),
						rs.getString(7).charAt(0)
						);
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;


	}
}
