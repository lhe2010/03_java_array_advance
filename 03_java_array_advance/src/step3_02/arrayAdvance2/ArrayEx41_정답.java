// 2020-10-12 day17 3교시 17:14-17:38 (답안보고풀기)
// 사다리 표현하는 것 까먹음 17:40-17:52 (미완성)

// 2020-10-12 자습 21:05-22:45
package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
 * # 사다리 게임
 * 1. 0을 만나면 아래로 내려간다.
 * 2. 1일 때에는 좌우를 검사해 1인 쪽으로 이동 후 아래로 내려간다.
 * 3. x의 위치를 입력받고 사다리를 표현한다.
 * 		x = 0	x = 4
 * 		x = 1	x = 2
 * 		x = 2	x = 1
 * 		x = 3	x = 3
 * 		x = 4	x = 0
 */

public class ArrayEx41_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int ladder[][]= {
				{0,0,0,0,0},
				{1,1,0,1,1},
				{0,1,1,0,0},
				{0,0,1,1,0},
				{1,1,0,0,0},
				{0,1,1,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,0,0}
		};
		
		int x = 0; int y = 0;
		int num = 0;
		
		// 게임 전에 사다리출력(특수문자 : ㅂ + 한자)	//  ─│├ ┤ ━ ┃ ┣ ┫ 
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[0].length; j++) {
				num = ladder[i][j];
				if(num == 0) {
					System.out.print(" ┃ ");
				}

				if(j<4 && num == 1 && ladder[i][j+1] == 1) {
					System.out.print(" ┣━");
				}
				if(j>0 && num == 1 && ladder[i][j-1] == 1) { // *** j-1>0아니고 J>0
					System.out.print("━┫ ");
				}
			}
			System.out.println();
		}
/*
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[0].length; j++) {
				if(ladder[i][j] == 0) System.out.print(" │ ");
				else if (j+1 < 5 && ladder[i][j] == 1 && ladder[i][j+1] == 1)
					System.out.print(" ├─");
				else if (j > 0 && ladder[i][j] == 1 && ladder[i][j-1] == 1)
					System.out.print("─┤ ");
				
			}
			System.out.println();
		}
*/		
		System.out.print("x위치를 선택하세요(0-4): ");
		y = 0; 				// 행 (세로)
		x = scan.nextInt(); // 열 (가로)

		while(y < ladder.length) {
			if(ladder[y][x] == 0) {				// 0이면 내려간다. 
//				System.out.printf("\n[0]ladder[%d][%d] == %d ", y,x,ladder[y][x]);
				y++;
			}
			if(y != 9 && ladder[y][x] == 1) {			// **** if문 조건의 순서가 중요하다. 바꿨더니 인덱스에러. 인덱스먼저 잡기
				if(x < 4 && ladder[y][x+1] == 1) { // 오른쪽이1이면 // 내려가니 1이 오른쪽에 있다. 
//					System.out.printf("\n[1]ladder[%d][%d] == %d ", y,x,ladder[y][x]);
					y++;x++;
				} else if(x > 0 && ladder[y][x-1] == 1) { // 왼쪽이1이면 // 내려가니 1이 왼쪽에 있다. 
//					System.out.printf("\n[2]ladder[%d][%d] == %d ", y,x,ladder[y][x]);
					y++;x--;
				}
			}
		}
		
		System.out.printf("\n사다리끝! 말의 위치: %d", x);
		
		scan.close();
	}

}
