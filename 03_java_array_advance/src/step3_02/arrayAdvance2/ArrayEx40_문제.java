// 20101008 1교시 
// 추가15:30-15:50/인덱스삭제16:00-16:50/값삭제17:00-17:35/삽입17:36-17:46
package step3_02.arrayAdvance2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
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
 * 
 */



public class ArrayEx40_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] scores = null;
		int elementCnt = 0;
		
		int[] temp = null;
		int idx = -1;
		int delValue = -1;
		int insertValue = -1;
		
		while(true) {
			
			System.out.println("\n[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				// 추가하기위한 temp배열 생성
				if(elementCnt == 0) {
					scores = new int[elementCnt+1];
				} else if(elementCnt > 0) {
					temp = scores;
					scores = new int[elementCnt+1]; 		// ***if(cnt>0) 하나만 하려했는데 순서때문에 안됨!
					for (int i = 0; i < elementCnt; i++) {	// 기존 값들 복사
						scores[i] = temp[i]; 				// ***temp[i] = scores[i];// 아니야!!!
					}
				}
				// 새로운 값 넣기
				System.out.print("\n새로 저장할 점수: ");
				scores[elementCnt++] = scan.nextInt();
				
				System.out.println("[Success] "+ Arrays.toString(scores));
				// temp를 null로 초기화
				temp = null;
			}
			else if(sel == 2) { // 삭제(인덱스) - 인덱스를 입력받아 해당 위치의 값 삭제 // t답이랑 다름. 
				if(elementCnt == 0) {
					System.out.println("\n[Error] 빈 배열이라 삭제불가, 초기메뉴로 돌아갑니다. ");
					continue;
				}

				System.out.print("\n삭제할 인덱스: ");
				idx = scan.nextInt();
				
				if(idx >= elementCnt || idx < 0) {
					System.out.println("[Error] 삭제할수없는 인덱스! 초기메뉴로 돌아갑니다. ");
					continue;
				}
				if(elementCnt == 1) {
					scores = null;
					elementCnt--;
					System.out.println("[Success] "+ Arrays.toString(scores));
					continue;
				}
				
				temp = scores;
				scores = new int[--elementCnt]; // ***** cnt--아니고 --cnt~!!!!!
				// 값복사
				for (int i = 0; i < temp.length; i++) { // 전체 scores순회
					if(i == idx) {
//						System.out.printf("[인덱스만남] 인덱스 %d 삭제!\n", idx);
						// 이후값은 그대로 복사
						while(idx < elementCnt) {
							scores[idx] = temp[idx+1];
							idx++;							
						}
						break;
					} else { // 지울 인덱스값이 나오기 전까지 = 그대로 복사
						scores[i] = temp[i];
//						System.out.println("[인덱스 안만남]");
					}
				}
				System.out.println("[Success] "+ Arrays.toString(scores));
				temp = null; 	// temp를 null로 초기화
				
			}
			else if(sel == 3) { // 값을 입력받아 삭제, 없는 값 입력 시 예외처리
				if(elementCnt == 0) {
					System.out.println("\n[Error] 빈 배열이라 삭제불가, 초기메뉴로 돌아갑니다. ");
					continue;
				}
				
				System.out.print("\n삭제할 값 : ");
				delValue = scan.nextInt(); // 삭제할 값
				idx = -1;
				
				// 먼저 삭제할 값이 있는지 찾는다. 
				for (int i = 0; i < elementCnt; i++) {
					if(scores[i] == delValue) 
						idx = i;
				}					
				// 값이 없으면 예외처리
				if(idx == -1) {
					System.out.println("[Error] 배열안에 그 값이 없네요! 초기메뉴로 갑니다. ");
					continue;
				}
				
				// 하나있는경우 
				if(elementCnt == 1 /*&& delValue == scores[0]*/) {
					scores = null;
					continue;
				} else if (elementCnt > 1) {
					// 값이 있으면 복사
					temp = scores; 
					scores = new int[elementCnt-1];
					
					// 복사방법1
					for (int i = 0; i < idx; i++) {
						scores[i] = temp[i];
					}
					for (int i = idx; i < elementCnt-1; i++) {
						scores[i] = temp[i+1];
					}
					
					// 복사방법2(t)
//					int j = 0;
//					for(int i=0; i<elementCnt; i++) {
//						if(i != delIdx) {
//							score[j] = temp[i];
//							j += 1;
//						}
//					}

					temp = null; 	// temp를 null로 초기화
				}
				elementCnt--;
				System.out.println("[Success] "+ Arrays.toString(scores));
			}
			else if(sel == 4) { // 인덱스와 값을 받아서 삽입
				System.out.print("삽입하고싶은 위치인덱스: ");
				idx = scan.nextInt();
				// 인덱스 범위 체크 // 값받기 전에 먼저 체크해서 빼준다.
				if(idx < 0 || idx > elementCnt) {
					System.out.println("[Error] 인덱스 범위 오류!");
					continue;
				} 
				
				System.out.printf("scores[%d]에 삽입하고싶은 값: ", idx);
				insertValue = scan.nextInt();
				
				temp = scores;
				scores = new int[++elementCnt];
				
				// 값복사하고 삽입
				for (int i = 0; i < idx; i++) {
					scores[i] = temp[i];
				}
				scores[idx] = insertValue;
				for (int i = idx; i < elementCnt-1; i++) {
					scores[i+1] = temp[i];
				}
				temp = null;
				System.out.println("[Success] "+ Arrays.toString(scores));
			}
			else if(sel == 0) {
				break;
			}
		}
		scan.close();
	}
}
