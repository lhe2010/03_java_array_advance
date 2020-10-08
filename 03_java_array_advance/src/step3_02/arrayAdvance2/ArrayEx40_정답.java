package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 1. 추가 - arr주소를 temp에 저장하고 새배열을 만들어 값을 복사한뒤 arr에 주소담기 
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 */



public class ArrayEx40_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = null;
		int elementCnt = 0;
		
		while(true) {
			
			for(int i=0; i<elementCnt; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				if (elementCnt == 0) {
					score = new int[elementCnt + 1];
				}
				else if (elementCnt > 0){
					int[] temp = score;
					score = new int[elementCnt + 1];
					
					for(int i=0; i<elementCnt; i++) {
						score[i] = temp[i];
					}
					
					temp = null;
				}
				System.out.print("[추가]성적 입력 : ");
				int data = scan.nextInt();
				
				score[elementCnt] = data;
				elementCnt += 1;
			}
			else if (sel == 2) {
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt();
				
				if (elementCnt-1 < delIdx || delIdx < 0) {
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				
				if (elementCnt == 1) {
					score = null;
				}
				else if(elementCnt > 1) {
					int[] temp = score;
					score = new int[elementCnt - 1];
					
					for (int i=0; i<delIdx; i++) {
						score[i] = temp[i];
					}
					for (int i=delIdx; i<elementCnt-1; i++) {
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				
				elementCnt -= 1;
			}
			else if (sel == 3) {
				System.out.print("[삭제]값 입력 : ");
				int delData = scan.nextInt();
				
				int delIdx = -1;
				for (int i=0; i<elementCnt; i++) {
					if(score[i] == delData) {
						delIdx = i;
					}
				}
				
				if (delIdx == -1) {
					System.out.println("[메세지]입력하신 값은 존재하지 않습니다.");
					continue;
				}
				
				if (elementCnt == 1) {
					score = null;
				}
				else if (elementCnt > 1) {
					int[] temp = score;
					score = new int[elementCnt - 1];
					
					int j = 0;
					for(int i=0; i<elementCnt; i++) {
						if(i != delIdx) {
							score[j] = temp[i];
							j += 1;
						}
					}
					
					temp = null;
				}
				
				elementCnt -= 1;				
			}
			else if (sel == 4) {
				System.out.print("[삽입]인덱스 입력 : ");
				int insertIdx = scan.nextInt();
				
				if (elementCnt < insertIdx || insertIdx < 0) {
					System.out.println("[메세지]해당 위치는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("[삽입]값 입력 : ");
				int insertData = scan.nextInt();
				
				if (elementCnt == 0) {
					score = new int[elementCnt + 1];
				}
				else if (elementCnt > 0) {
					
					int[] temp = score;
					score = new int[elementCnt + 1];
					
					int j = 0;
					
					for(int i=0; i<elementCnt + 1; i++) {
						if(i != insertIdx) {
							score[i] = temp[j];
							j += 1;
						}
					}
					temp = null;
				}
				
				score[insertIdx] = insertData;
				elementCnt += 1;
			}
			else if (sel == 0) {
				break;
			}
		}

		scan.close();

	}

}
