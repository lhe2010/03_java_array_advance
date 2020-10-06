// 20201006 17:23-17:48
package step3_01.arrayAdvance1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 숫자이동[2단계]
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */

public class ArrayEx27_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {0,0,1,0,2,0,0,1,0};
		int move = 0;
		int idx = -1; // 캐릭터의 위치
		
		// 현재 턴에서 캐릭터의 위치인덱스를 idx변수에 저장합니다. 
		for (int i = 0; i < game.length; i++) {
			if(game[i] == 2)
				idx = i;
		}

		while(true) {
			
			System.out.println(Arrays.toString(game));
			System.out.print("1:왼쪽, 2:오른쪽, 3:격파! 숫자를 입력하세요:");
			move = scan.nextInt();
					
			if(idx == 0 || idx == game.length-1) {
				System.out.println("캐릭터가 맨끝에 있으므로 더이상 이동 불가!");
				break;				
			}
			
			if(move == 1) {
				if(game[idx-1] == 1) {
					System.out.println("벽을 만났습니다.");
					continue;					
				} else {
					// 왼쪽으로 이동
					game[idx] = 0;
					game[--idx] = 2;
				}
			} else if(move == 2) {
				if(game[idx+1] == 1) {
					System.out.println("벽을 만났습니다.");
					continue;					
				} else {
					// 오른쪽으로 이동
					game[idx] = 0;
					game[++idx] = 2;
				}
			} else if(move == 3) {
				// 캐릭터의 오른쪽에 벽이 있다면
				if(game[idx+1] == 1) {
					System.out.println("벽격파!!");
					game[idx+1] = 0;
				} else if(game[idx-1] == 1) {
					// 캐릭터의 왼쪽에 벽이 있다면
					System.out.println("벽격파!!");
					game[idx-1] = 0;
				} else {
					System.out.println("읭? 멘땅에 헤딩!");				
				}
				continue;
			} else {
				System.out.println("1/2/3 범위 내에 숫자를 입력해야합니다.");
			}
			
		}
		System.out.println("[게임종료]");
		
	}
	
}
