// 2020-10-12 day17 3교시 17:14-17:38 (답안보고풀기)
// 사다리 표현하는 것 까먹음 17:40-17:52 (미완성)
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
		
		// [3] 사다리를 표현한다. 특수문자 : ㅂ + 한자

		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[0].length; j++) {
				if(ladder[i][j] == 0) System.out.print(" │ ");
				else if (j+1 < 5 && ladder[i][j] == 1 && ladder[i][j+1] == 1)
					System.out.print(" ├─");
				else if (j-1 > 0 && ladder[i][j] == 1 && ladder[i][j-1] == 1)
					System.out.print("─┤ ");
				
			}
			System.out.println();
		}
		
		System.out.print("x의 위치(0-4) : ");
		int start = scan.nextInt();
		
		int x = 0;	// 가로 
		int y = start;	// 세로
		
		while(x < ladder.length) {
			if(ladder[x][y] == 0) { // 0이면 내려간다. 
				x++;
				continue;
			}
			if(ladder[x][y] == 1) { // **** if문 조건의 순서가 중요하다. 바꿨더니 인덱스에러. 인덱스먼저 잡기
				if((y+1) < ladder[0].length && ladder[x][y+1] == 1) { // 내려가니 1이 오른쪽에 있다. 
					x++;y++; 
					continue;
				} else if( (y-1) >= 0 && ladder[x][y-1] == 1) { // 내려가니 1이 왼쪽에 있다. 
					x++;y--;
					continue;
				}
				
			}
		}


		System.out.printf("%d의 사다리결과는 (0~4) %d ", start, y);
		scan.close();
	}

}
