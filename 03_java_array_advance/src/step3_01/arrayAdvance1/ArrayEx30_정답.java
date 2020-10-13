package step3_01.arrayAdvance1;

import java.util.Scanner;

/*
 * # ATM[4단계] : 전체 기능구현
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 */


public class ArrayEx30_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int MAX = 5;
		
		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];
		
		int usrCnt = 0;
		int identifier = -1; // 1이면 로그인중 -1이면 로그아웃 
		
		int usrId = 0;
		int usrPw = 0;
		
		String menu = "=== 메가IT ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		while(true) {
			
			System.out.println(menu);
			
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.println("[가입화면]");
				System.out.print("id를 입력하세요: ");
				usrId = scan.nextInt();
				// id중복체크
				for (int i = 0; i < usrCnt; i++) {
					System.out.println("id중복검사");
					if(arId[i] == usrId) {
						System.out.println("이미있는 id입니다. 초기화면으로 돌아갑니다. ");
						continue;
					}
				}
				System.out.println("pw를 입력하세요: ");
				usrPw = scan.nextInt();
				
				System.out.println("[가입완료] 가입축하 1000원 부여합니다.");
				arMoney[usrCnt] += 1000;
				
				usrCnt++;
				identifier = 1;
				
				
			}
			else if(sel == 2) {
				if(identifier != 1) { // 로그인시에만 사용가능 
					System.out.println("[Error] 로그인시에만 사용가능합니다. ");
					continue;
				}
			}
			else if(sel == 3) {		// 로그
				if(identifier != -1) { // 로그아시에만 사용가능 
					System.out.println("[Error] 로그아웃시에만 사용가능합니다. ");
					continue;
				}
				System.out.println("[로그인성공]");
				
			}
			else if(sel == 4) {
				if(identifier != 1) { // 로그인시에만 사용가능 
					System.out.println("[Error] 로그인시에만 사용가능합니다. ");
					continue;
				}
				
			}
			else if(sel == 5) {
				if(identifier != 1) { // 로그인시에만 사용가능 
					System.out.println("[Error] 로그인시에만 사용가능합니다. ");
					continue;
				}
				
			}
			else if(sel == 6) {
				if(identifier != 1) { // 로그인시에만 사용가능 
					System.out.println("[Error] 로그인시에만 사용가능합니다. ");
					continue;
				}
				
			}
			else if(sel == 7) {
				if(identifier != 1) { // 로그인시에만 사용가능 
					System.out.println("[Error] 로그인시에만 사용가능합니다. ");
					continue;
				}
				
			}
			else if(sel == 0) {
				break;
			}
		}



	}

}
