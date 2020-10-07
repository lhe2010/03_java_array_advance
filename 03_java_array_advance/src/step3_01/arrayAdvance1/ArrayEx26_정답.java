// 20201007수 15:09-16:00
package step3_01.arrayAdvance1;

import java.util.Random;
import java.util.Scanner;

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */


public class ArrayEx26_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
	
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		int num = 0;
		int turn = 1;			// 정답 인덱스에 들어있는 배열값
		int answer = 0; 		// 사용자가 입력해야한 정답인덱스
		int userAnswer = -1; 	// 사용자가 입력한 정답인덱스
		
		System.out.println("[게임시작]");
		
		// front와 back 채우기
		for (int i = 0; i < SIZE; i++) {
			front[i] = i+1;
			back[i] = SIZE + i+1;
		}
		
		int temp = 0;
		// ************** 랜덤 위치 돌린다 
		
		for (int i = 0; i < 100; i++) {
			num = ran.nextInt(SIZE);	// 여기서 num은 랜덤 인덱스
			temp = front[0];
			front[0] = front[num];
			front[num] = temp;
			
			num = ran.nextInt(SIZE);
			temp = back[0];
			back[0] = back[num];
			back[num] = temp;
		}
		
		while(turn <= 18) {
			System.out.println();
			// 게임화면 프린트
			for (int i = 0; i < front.length; i++) {
				if(front[i] == 0)
					System.out.printf("\t"); 
				else
					System.out.printf("%d\t", front[i]);
//					System.out.printf("%d (%d)\t", front[i], i); // 테스트용
					
				if(i%3 == 2)
					System.out.println();
			}
			// 테스트용 back 프린트
//			for (int i = 0; i < back.length; i++) {
//				System.out.printf("%d\t", back[i]);
//				if(i%3 == 2)
//					System.out.println();
//			}
			
			System.out.printf("%d의 인덱스는??! 사용자입력: ", turn);
			userAnswer = scan.nextInt();
			
			for (int i = 0; i < front.length; i++) {
				if(front[i] == turn)
					answer = i;
			}
			
			if(userAnswer == answer) {
				System.out.println("정답입니다!");
				turn++;
				if(turn > 10)
					front[answer] = 0;
				else
					front[answer] = back[answer];
			} else {
				System.out.println("땡!");
			}			
			
		}
		System.out.println("\n[1to18 게임종료]");
		scan.close();
	}
}