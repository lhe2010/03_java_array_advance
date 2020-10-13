// 2020-10-13 화 15:35-16:11
package step3_02.arrayAdvance2; 

import java.util.Scanner;

// #오목

public class ArrayEx42_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		final int SIZE = 10;
		int[][] omok = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
		};

		int p1Y = 0;
		int p1X = 0;
		int p2Y = 0;
		int p2X = 0;
		
		int turn = 1; // 1이면 p1차례, 2이면 p2차례
		int win = 0;
		
		
		
		while (true) {
			// 전체화면 출력
			System.out.print("  ");
			for (int i = 0; i < omok.length; i++) {
				System.out.printf(" %d", i);
			}
			for (int i = 0; i < omok.length; i++) {
				System.out.printf("\n %d", i);
				for (int j = 0; j < omok[0].length; j++) {
					System.out.printf(" %d", omok[i][j]);
				}
			}
			
			// 승자 확인
			if(win == 1) {
				System.out.println("\n[p1 WIN]");
				break;
			} else if(win == 2) {
				System.out.println("\n[p2 WIN]");
				break;
			}
			
			// 승자가 없으면 p1부터 게임시작
			if(turn == 1) {
				System.out.print("\n[p1] Y좌표 입력(0-9) : ");
				p1Y = scan.nextInt();
				System.out.print("[p1] X좌표 입력(0-9) : ");
				p1X = scan.nextInt();
				// 이미 선택된 자리라면 다시선택하고, 잘 선택했으면 배열 수정
				if(omok[p1X][p1Y] != 0) {
					System.out.println("[ERROR] 이미선택된 자리입니다. 다시선택하세요.");
					continue;
				} else {
					omok[p1X][p1Y] = turn;
					turn = 2;
				}
			} else if(turn == 2) {
				System.out.print("\n[p2] Y좌표 입력(0-9) : ");
				p2Y = scan.nextInt();
				System.out.print("[p2] X좌표 입력(0-9) : ");
				p2X = scan.nextInt();
				// 이미 선택된 자리라면 다시선택하고, 잘 선택했으면 배열 수정
				if(omok[p2X][p2Y] != 0) {
					System.out.println("[ERROR] 이미선택된 자리입니다. 다시선택하세요.");
					continue;
				} else {
					omok[p2X][p2Y] = turn;
					turn = 1;
				}
			}
			
			// 가로 검사
			for (int i = 0; i < omok.length; i++) {
				for (int j = 0; j < omok[0].length-4; j++) {
					if(omok[i][j] == 1 && omok[i][j+1] == 1 && omok[i][j+2] == 1 && omok[i][j+3] == 1 && omok[i][j+4] == 1 ) win = 1;
					if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 && omok[i][j+4] == 2 ) win = 2;
				}
			}
			
			// 세로 검사
			for (int i = 0; i < omok.length-4; i++) {
				for (int j = 0; j < omok[0].length; j++) {
					if(omok[i][j] == 1 && omok[i+1][j] == 1 && omok[i+2][j] == 1 && omok[i+3][j] == 1 && omok[i+4][j] == 1 ) win = 1;
					if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2 && omok[i+4][j] == 2 ) win = 2;
				}
			}
			
			// 대각선 검사
			for (int i = 0; i < omok.length-4; i++) {
				for (int j = 0; j < omok[0].length-4; j++) {
					if(omok[i][j] == 1 && omok[i+1][j+1] == 1 && omok[i+2][j+2] == 1 && omok[i+3][j+3] == 1 && omok[i+4][j+4] == 1 ) win = 1;
					if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2 ) win = 2;
				}
			}
		}
		scan.close();

	}

}
