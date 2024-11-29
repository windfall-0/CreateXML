package edu.kh.jdbc.member.view;

import java.sql.SQLException;
import java.util.Scanner;

import edu.kh.jdbc.member.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	/**회원 가입 화면 출력용 메소드
	 * 
	 */
	public void signUp() {
		System.out.println("[회원 가입]");
		
		try {
			System.out.print("아이디 : ");
			String memberId = sc.next();
			
			// 아이디 중복 검사 (DB에 일치하는 아이디가 있으면 중복 -> 다시 아이디 입력 받기)
			int result = service.duplicateCheck(memberId);
			if (result == 0) {
				System.out.println("사용가능한 아이디 입니다.");
				signUp(memberId);
			} else {
				System.out.println("사용 불가능한 아이디 입니다.");
				signUp();
			}
		} catch (Exception e) {
			e.printStackTrace();
			signUp();
		}
	}
	
	public void signUp(String memberId) {
		try {
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
			System.out.print("비밀번호 확인 : ");
			String memberPw2 = sc.next();
			if (memberPw.equals(memberPw2)) {
				signUp(memberId, memberPw);
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				signUp(memberId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			signUp(memberId);
		}
	}
	
	public void signUp(String memberId, String memberPw) {
		try {
			System.out.print("이름 : ");
			String memberNm = sc.next();
			signUp(memberId, memberPw, memberNm);
		} catch (Exception e) {
			e.printStackTrace();
			signUp(memberId, memberPw);
		}
	}

	private void signUp(String memberId, String memberPw, String memberNm) {
		try {
			System.out.print("성별(M/F) : ");
			char memberGender = sc.next().toUpperCase().charAt(0);
			
			if (memberGender == 'M' || memberGender == 'F') {
				Member signUpMember = new Member(memberId, memberPw, memberNm, memberGender);
				signUp(signUpMember);
			} else {
				System.out.println("성별을 M혹은 F로 입력해 주세요!");
				signUp(memberId, memberPw, memberNm);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			signUp(memberId, memberPw, memberNm);
		}
	}
	
	private void signUp(Member signUpMember) throws SQLException {
		int result = service.signUp(signUpMember);
		
		if (result == 1) {System.out.println("회원가입 성공!");}
		
	}

}
