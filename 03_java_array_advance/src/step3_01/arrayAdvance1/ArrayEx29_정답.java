// 20201007수 16:45-17:42
package step3_01.arrayAdvance1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 숫자 야구 게임
 * 1. me에 1~9 사이의 숫자 3개를 저장
 *    (단, 중복되는 숫자는 저장 불가)
 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
 * 3. 숫자와 자리가 같으면 		    strike += 1
 *    숫자만 같고 자리가 틀리면 	ball += 1
 * 예)
 * 정답 : 1 7 3
 * 3 1 5		: 2b
 * 7 5 1        : 1b
 * 1 5 6		: 1s
 * 1 7 3        : 1s 2b
 * 2 4 9        : 없음
 * 1 7 3        : 3s  > 게임종료
 * 
 */

public class ArrayEx29_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 3;
		int[] com = {1,7,3};
		int[] me  = new int[SIZE];
		int[] usrAnswer = {-1, -1, -1};
		
//		int rNum = 0;
		int num;
		int numCnt = 0;
		int check = 0; // 1이면 중복, -1이면 저장가능
		
		int strike = 0;
		int ball = 0;
		
		boolean isRun = true;
		
		/*
		while(numCnt < SIZE) {
			// 문제 28번 내용
			rNum = ran.nextInt(9)+1; // me에 넣을 1-9사이의 숫자를 랜덤으로 뽑는다.
			for (int i = 0; i <= numCnt; i++) {
				if(me[i] == rNum) { // 이미 있다면 다시 뽑아야함
					check = 1;
				}
			}
			if(check != 1) { // 중복이 아니라면 저장한다. 
				me[numCnt++] = rNum;
			}
			check = 0;		// 다시 0으로 만들어준다. 
		}
		
		// me에 숫자 세개를 저장함
		System.out.println(Arrays.toString(me));
		System.out.println(Arrays.toString(com));
		*/
		
		
		int turn = 0; // 10번만 돌립니다. 
		while(isRun && turn < 10) {
			
			System.out.println("\n숫자와 자리가 같으면 strike,\n숫자만 같고 자리가 틀리면 ball");
			System.out.print("정답을 입력하세요: " );
			
			// ***** 일정 범위의 숫자만 입력받게 처리
			numCnt = 0;
			check = 0;
			for (int i = 0; i < SIZE; i++) {
				num = scan.nextInt();
				if(num >= 10) { // 10이 넘으면 경고문을 나타내고 다시 입력받게한다. 
					System.out.println("[Error] 1-9사이의 숫자를 저장하세요.");
					check = 1; 
					break;
				} else {		// 10이 안넘고 유효한 숫자를 입력했다면 저장한다. 
					usrAnswer[numCnt++] = num;
				}
			}
			
			// 중복 불가하게 처리***************indexError
			int idx = 0;
			while(idx < usrAnswer.length)
			for (int i = 0; i < usrAnswer.length; i++) {
				if(usrAnswer[i] == usrAnswer[i+1]) { // 1+2, 2+3, 2,3 13
					System.out.println("[Error] 중복된 숫자를 입력할 수 없습니다. ");
					check = 1;
				}
			}
			if(check == 1) continue; // *****************************************
			
			System.out.println(Arrays.toString(usrAnswer));
			strike = 0;
			ball = 0;
			
			// strike: 숫자와 자리가 같다
			for (int i = 0; i < usrAnswer.length; i++) {
				if(usrAnswer[i] == com[i]) {
					strike++;
				}				
			}
			// ball: 숫자는 같지만 자리가 틀리다. 
			for (int i = 0; i < usrAnswer.length; i++) {
				for (int j = 0; j < com.length; j++) {
					if(usrAnswer[i] == com[j] && i != j) {
						ball++;
					}
				}
			}
			System.out.print("당신의 정답 " + Arrays.toString(usrAnswer));
			System.out.printf(" : %db, %ds\n", ball, strike);
			
			if(strike >= 3) {
				System.out.println("[게임종료]");
				isRun = false;
			} else {
				continue;
			}
			turn++;
		}

		scan.close();
	}
	
}
