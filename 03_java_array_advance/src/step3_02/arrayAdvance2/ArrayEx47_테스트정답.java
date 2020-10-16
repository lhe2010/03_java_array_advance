// 2020-10-14 수 16:00-17:10	(되돌아가기 한번만 가능하게)
// 2020-10-16 금 16:08-16:50	(되돌아가기 여러번 가능하게) 
package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
문제1) 숫자 0이 플레이어이다. 
	    
	    1) left 2)right 3)up 4)down 5)되감기
		번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다. 
		 예) 1 ==> 
		
	    {1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,0,15}		
		 
		
문제2) 심화  ==> 한칸한칸이동할때마다 yx배열에 이동한경로를 저장했다가 
 	5번입력시 ==> 왔던길로 되돌아가기 한다.
 	
*/

public class ArrayEx47_테스트정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int choice;		// user choice
		int turn = 1; 	
		boolean bMove, rMove;
		int rCnt = 0;
		int rStart = 0;

		int game[][] = {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,0}
				};
		int xy[][] = new int[100][2];	// 한칸한칸이동할때마다 yx에 이동한경로 저장 // 테스트위해서 10번으로 한정
		
		int x = 3; int y = 3; 		// 현재 turn에서 0의 위치 (현재 turn의 위치 : yx[turn][0], yx[turn][1])
		xy[0][0] = x; xy[0][1] = y; // 처음의 위치는 [3][3]
		
		do {
			// 변수 초기화
			bMove = false; 
			rMove = false;

			// 경로를 저장하는 xy배열 프린트 // 테스트용
//			System.out.print("\n-------------------------------------------------------------\n");
//			for (int i = 0; i < xy.length; i++) {
//				System.out.println("[turn" + i + "] " + Arrays.toString(xy[i]));
//			}
//			System.out.print("-------------------------------------------------------------\n");
			
			// GAME 배열 프린트
			System.out.print("\n-------------------------------------------------------------\n");
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[0].length; j++) {
					System.out.print(game[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.print("-------------------------------------------------------------\n"
					+ "[1]left [2]right [3]up [4]down [5]되감기 [0]종료\n"
					+ turn + "번째 이동방향 : ");
			choice = scan.nextInt();
		
			switch(choice) {
			case 1: // 왼쪽
				if(y == 0) { // 0의 y좌표가 0이면 더이상 이동 불가
					System.out.println("\n[이동불가] 왼쪽벽에 부딪힘!");
					continue;
				} else {				
					bMove = true;		// 이동가능 (이동후 값교체)
					--y;
				}
				break;
			case 2: // 오른쪽
				if(y == 3) { // 0의 y좌표가 0이면 더이상 이동 불가
					System.out.println("\n[이동불가] 오른쪽벽에 부딪힘!");
					continue;
				} else {				
					bMove = true;		// 이동가능 (이동후 값교체)
					++y;
				}
				break;
			case 3: // 위쪽
				if(x == 0) { // 현재 0의 x좌표가 0이면 더이상 이동 불가
					System.out.println("\n[이동불가] 윗쪽벽에 부딪힘!");
					continue;
				} else {				
					bMove = true;		// 이동가능 (이동후 값교체)
					--x;
				}
				break;
			case 4: // 아래쪽
				if(x == 3) { // 현재 0의 x좌표가 3이면 더이상 이동 불가
					System.out.println("\n[이동불가] 아래쪽벽에 부딪힘!");
					continue;
				} else {				
					bMove = true;		// 이동가능 (이동후 값교체)
					++x;
				}
				break;
			case 5: // 되감기
				if(turn == 1) {
					System.out.println("[이동불가] 되감을수 없음");
					continue; // 처음 턴에서는 되감을 수 없다. 
				}
				rCnt++;
				if(rCnt == 1) rStart = turn-1;  // 되감기 시작할때 그 기준점 변수에 저장
				else { // 되감기가 처음이 아니라면 맨첫번째 그이상 되감을 수 없게 검사 ****** 
					if(rStart-rCnt < 0) {	
						System.out.println("[이동불가] 더이상 되감을수 없음");
						continue;
					}
				}

//				x = xy[turn-2][0];
//				y = xy[turn-2][1];
				x = xy[rStart-rCnt][0];
				y = xy[rStart-rCnt][1];
				
				rMove = true;		// 이동가능 (이동후 값교체)
				break;
			}
			// switch후에 x와 y값은 이동한 현재 0의 위치
			
			if(bMove) { // 움직이면 값바꿔준다. xy배열 인덱스로 조작
				xy[turn][0] = x; 
				xy[turn][1] = y; 	// 새로운 좌표
				// 바꾸기 대상
				game[xy[turn-1][0]][xy[turn-1][1]] = game[x][y]; 	// 새로운 xy좌표 (0의 위치가되어야할곳)
				game[x][y] = 0;

				turn++;
				rCnt = 0; 
			}
			if(rMove) {
				xy[turn][0] = x; 
				xy[turn][1] = y; 	// 새로운 좌표
				// 바꾸기 대상
//				game[xy[rStart-rCnt][0]][xy[rStart-rCnt][1]] = game[x][y]; 	// 새로운 xy좌표 (0의 위치가되어야할곳)
				game[xy[turn-1][0]][xy[turn-1][1]] = game[x][y]; 	// 새로운 xy좌표 (0의 위치가되어야할곳)
				game[x][y] = 0;
				
				turn++;
			}
		
//			System.out.println("[log] 다음턴 시작전 rCnt : " + rCnt);
		
		} while (choice != 0); // 종료버튼 누르면 종료

		scan.close();
	}

}
