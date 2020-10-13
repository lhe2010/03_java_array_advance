// 2020-10-13 화 16:16-16:56 + 
package step3_02.arrayAdvance2; 

import java.util.Random;
import java.util.Scanner;

// # 소코반

public class ArrayEx43_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		int[][] map = new int[SIZE][SIZE];
		
		final int PLAYER = 2;
		final int BALL = 3;
		final int GOAL = 7;
		final int WALL = 9;
				
		int wallCount = 0;
		int pY = 0;
		int pX = 0;
		int ballY = 0;
		int ballX = 0;
		int goalY = 0;
		int goalX = 0;
		
		/*
		// map출력
		for (int i = 0; i < SIZE; i++) {
			System.out.print(i + "|");

			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}*/
		
		// 벽 설치 9
		System.out.print("설치할 벽의 개수 : ");
		wallCount = scan.nextInt();
		
		/* while문을 이용한 벽설치 방법1
		while(wallCount > 0) {
			pX = ran.nextInt(SIZE);
			pY = ran.nextInt(SIZE);
			
			if(map[pX][pY] != 9) {
				map[pX][pY] = 9;
				System.out.println("벽 좌표 : " + pX + " " + pY);
				wallCount--;
			} else {
				continue; 
			}
		}*/
		
		// do-while을 이용한 벽설치 방법2
		do {
			pX = ran.nextInt(SIZE);
			pY = ran.nextInt(SIZE);
			
			if(map[pX][pY] != 9) {
				map[pX][pY] = 9;
//				System.out.println("벽 좌표 : " + pX + " " + pY);
				wallCount--;
			}
		} while (wallCount > 0);
		
		// 공 설치 3
		// *** 조건 식! 의미를 ....내가 써놓고도 모르겠네.....돌아가기는 하는데.....
		// 0이아닐때 계속 돌고 0이어야 빠져나온다.
		do {
			ballX = ran.nextInt(SIZE);
			ballY = ran.nextInt(SIZE);
		} while(map[ballX][ballY] != 0 && map[ballX][ballY] != 9); 
		map[ballX][ballY] = 3;
//		System.out.println("공 좌표 : " + ballX + " " + ballY);
		
		// 골대 설치 7
		do {
			goalX = ran.nextInt(SIZE);
			goalY = ran.nextInt(SIZE);
		} while(map[goalX][goalY] != 0 && map[goalX][goalY] != 9 && map[goalX][goalY] != 3); // *** 조건 식!
		map[goalX][goalY] = 7;
//		System.out.println("골대 좌표 : " + goalX + " " + goalY);
		
		// 테스트를 위한 화면 출력 - 벽설치9 + 공설치3 + 골대설치7 + 플레이어2 배치 후
		System.out.println("  0 1 2 3 4 5 6 ");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
		
		// 플레이어 배치
		pX = 0; pY = 0;
		do {
			System.out.print("플레이어의 X좌표 : ");
			pX = scan.nextInt();			
			System.out.print("플레이어의 Y좌표 : ");
			pY = scan.nextInt();
		} while (map[pX][pY] != 0); // 0이아닐때 계속 돌고 0이어야 빠져나온다.
		map[pX][pY] = 2;
		System.out.println("플레이어 좌표 : " + pX + " " + pY);
		
		
		int move;
		
		// ========================= 게임 시작 =============================
		while(true) {
			// 유저한테 보여줄 화면 출력
			System.out.println("  0 1 2 3 4 5 6 ");
			for (int i = 0; i < SIZE; i++) {
				System.out.print(i + "|");
				for (int j = 0; j < SIZE; j++) {
					if(map[i][j] == 9)
						System.out.printf("X "); // 벽9
					else if(map[i][j] == 3)
						System.out.printf("B "); // 공3
					else if(map[i][j] == 7)
						System.out.printf("G "); // 골대7
					else if(map[i][j] == 2)
						System.out.printf("P "); // 플레이어2
					else 
						System.out.printf("* "); // 빈공간/이동가능
				}
				System.out.println();
			}
			
			
			// 화면 이동키
			System.out.print("이동할 방향입력(상1하2좌3우4) : ");
			move = scan.nextInt();
			
			switch(move) { // X가 행 Y가 열 // map[pX][pY]
			case 1: // 상
				// 안움직이는 경우: 위에 갈 인덱스 없으면/벽만나면/골대만나면
				// 움직이는 경우 : 0이면 옮기고 공을 만나면 가지고간다.
				if( pX-1 == -1 || map[pX-1][pY] ==  9 || map[pX-1][pY] == 7)
					continue;
				else if (map[pX-1][pY] == 0) { // 0은 이동가능
					map[pX][pY] = 0;
					map[pX-1][pY] = 2; 
					pX--;
				}
				else if (map[pX-1][pY] == 3 && ballX != 0) { // 공을만나면 (공이 맨위면 더 찰곳이없다. 예외처리)
					map[pX--][pY] = 0; 			
					map[ballX--][ballY] = 2;	// 캐릭터 이동
					map[ballX][ballY] = 3;  	// 공 차기
				}
				break;
			case 2: // 하
				if( pX+1 == 7 || map[pX+1][pY] ==  9 || map[pX+1][pY] == 7)
					continue;
				else if (map[pX+1][pY] == 0) {	// 0은 이동가능
					map[pX][pY] = 0;
					map[pX+1][pY] = 2; 
					pX++;
				}
				else if (map[pX+1][pY] == 3 && ballX != 6) { // 공을만나면 (공이 맨아래면 더 찰곳이없다. 예외처리)
					map[pX++][pY] = 0; 			
					map[ballX++][ballY] = 2;	// 캐릭터 이동
					map[ballX][ballY] = 3;  	// 공 차기
				}
				break;
			case 3: // 좌
				if( pY-1 == -1 || map[pX][pY-1] ==  9 || map[pX][pY-1] == 7)
					continue;
				else if (map[pX][pY-1] == 0) {	// 0은 이동가능
					map[pX][pY] = 0;
					map[pX][pY--] = 2; 
				}
				else if (map[pX][pY-1] == 3 && ballX != 0) { // 공을만나면 (공이 맨아래면 더 찰곳이없다. 예외처리)
					map[pX][pY--] = 0; 			
					map[ballX][ballY--] = 2;	// 캐릭터 이동
					map[ballX][ballY] = 3;  	// 공 차기
				}
				break;
			case 4: // 우
				default:
			}

		}
//		scan.close();
	}

}
