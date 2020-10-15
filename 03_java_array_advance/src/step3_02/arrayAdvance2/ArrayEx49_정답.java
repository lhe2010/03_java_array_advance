// 2020-10-15 목 15:13-15:36
package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
 * 
 * # 나만의 마블
 * P □ □ □ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ □ □ □ □
 * 
 * 
 * 정답의 소스를 컴파일 해보고 동작을 파악하여 코드를 작성하기.
 * 
 */


public class ArrayEx49_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int[][] map = {
				{0,   1,  2,  3, 4},	
				{15, 20, 20, 20, 5},
				{14, 20, 20, 20, 6},
				{13, 20, 20, 20, 7},
				{12, 11, 10,  9, 8}
			};
			
		int player = 0; // player의 위치
		int choice = -1;

		do {
			// 프린트
			System.out.println();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 20) {
						System.out.print("■ ");
					} else if(map[i][j] == player) {
						System.out.print("P ");
					} else {
						System.out.print("□ ");
					}
				}
				System.out.println();
			}
			
			// 입력받기
			System.out.print("1-3 사이의 값을 입력하세요(0:종료) : ");
			choice = scan.nextInt();
			
			// 예외처리
			if(choice > 3) {
				System.out.println("입력할수있는 숫자는 1,2,3입니다. ");
				continue;
			}
			
			player += choice;
			player %= 16;
			
//			System.out.printf("[log] player의 choice는 %d이며, 이동할 위치에있는 값은 %d\n\n", choice, player);
			
		} while(choice != 0);
		
		System.out.println("[게임종료]");
		scan.close();
	}
}
