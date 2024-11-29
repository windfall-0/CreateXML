package edu.kh.jdbc.main.view;

import java.util.Scanner;

import edu.kh.jdbc.member.dto.Member;
import edu.kh.jdbc.member.view.MemberView;

/**메인 메뉴 (메뉴 선택용 입력 화면)
 * @author user1
 *
 */
public class MainView {
	
	private Scanner sc = new Scanner(System.in);
	
	//로그인한 회원의 정보가 저장된 객체를 참조할 변수
	private Member loginMember = null;
	
	private MemberView memberview = new MemberView();
	
	/**메인 메뉴 출력용 메소드
	 * 
	 */
	public void displayMenu() {
		int menuNum = -1;
		
		do {
			try {
				
				System.out.println("\n================[ 회원제 게시판 프로그램 ]================\n");
				System.out.print("1. 로그인\n"
						+ "2. 회원가입\n"
						+ "0. 프로그램 종료\n"
						
						+ "메뉴를 선택해 주세요 >> ");
				
				menuNum = sc.nextInt();
				
				switch (menuNum) {
				case 1: break;
				case 2: memberview.signUp(); break;
				
				case 0: System.out.println("프로그램을 종료합니다."); break;
				default: System.out.println("메뉴에 작성된 번호만 입력해주세요");break;
				}
				
				
				
				
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		} while (menuNum != 0);
	}
	
}
