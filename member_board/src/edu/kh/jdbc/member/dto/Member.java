package edu.kh.jdbc.member.dto;

import java.sql.Date;

public class Member {
	/*
	 * -- [멤버 계정]
-- 테이블명 : MEMBER
-- 컬럼명 : MEMBER_NO 숫자 기본키 '회원 번호(PK)'
--        MEMBER_ID VARCHAR2(20) NULL허용 X  '회원 아이디'
--        MEMBER_PW VARCHAR2(20) NULL허용 X '회원 비밀번호'
--        MEMBER_NM VARCHAR2(30) NULL허용 X '회원 이름'
--         MEMBER_GENDER CHAR(1) M 또는 F만 입력 가능 '회원 성별(M/F)'
--        ENROLL_DATE DATE 기본값 현재날짜 '회원 가입일'
--        SECESSION_FL CHAR(1) 기본값 'N', Y 또는 N만 입력 가능 '탈퇴여부(Y/N)'
	 */
	
	private Date enrollDate;
	private char memberGender;
	private String memberId;
	private String memberNm;
	private int memberNo;
	private String memberPw;
	private char secessionFlag;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberNo, String memberId, String memberPw, String memberNm, char memberGender, Date enrollDate,
			char secessionFlag) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNm = memberNm;
		this.memberGender = memberGender;
		this.enrollDate = enrollDate;
		this.secessionFlag = secessionFlag;
	}

	public Member(String memberId, String memberPw, String memberNm, char memberGender) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNm = memberNm;
		this.memberGender = memberGender;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}

	public char getMemberGender() {
		return memberGender;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public char getSecessionFlag() {
		return secessionFlag;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public void setSecessionFlag(char secessionFlag) {
		this.secessionFlag = secessionFlag;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNm="
				+ memberNm + ", memberGender=" + memberGender + ", enrollDate=" + enrollDate + ", secessionFlag="
				+ secessionFlag + "]";
	}
	
	

}
