package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
 * 
 * # 나만의 마블
 * 옷 □ □ □ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ □ □ □ □
 * 
 * 
 * 정답의 소스를 컴파일 해보고 동작을 파악하여 코드를 작성하기.
 * 
 */

public class ArrayEx49_정답T {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int road = 20;
		
		int[][] map = {
			{0,   1,  2,  3, 4},	
			{15, 20, 20, 20, 5},
			{14, 20, 20, 20, 6},
			{13, 20, 20, 20, 7},
			{12, 11, 10,  9, 8}
		};
		
		int player = 0;
		
		while(true) {
			
			// 화면출력
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					if (map[i][j] == road) {
						System.out.print("■ ");
					}
					else if (map[i][j] == player) {
						System.out.print("P ");
					}
					else {
						System.out.print("□ ");
					}
				}
				System.out.println();
			}
			System.out.println();
			
			
			
			// 입력받기
			System.out.print("1~3을 입력하세요 : ");
			int move = scan.nextInt();
			
			player += move;
			
			player %= 16;
			
		}

	}

}
