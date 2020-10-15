// 2020-10-15 목 15:40-17:45
package step3_02.arrayAdvance2;

/*
 * # 달팽이
 * 1	2	3	4	5	
 * 16	17	18	19	6	
 * 15	24	25	20	7	
 * 14	23	22	21	8	
 * 13	12	11	10	9
 * 
 * 
 * 1) 오른쪽 방향으로 순서대로 숫자저장
 * 2) 아래쪽 방향으로 순서대로 숫자저장
 * 3) 왼쪽 방향으로 순서대로 숫자저장
 * 4) 윗쪽 방향으로 순서대로 숫자저장
 * 
 * 1)2)3)4) 반복
 */


public class ArrayEx50_정답 {

	public static void main(String[] args) {

		final int SIZE = 7; // 달팽이 가로 길이
		
		int[][] map = new int[SIZE][SIZE];
		
		int num = 0;
		int x = SIZE-1;		// 행 최고값을 조절
		int y = SIZE; 	// 열 최고값을 조절
		
		for (int i = 0; i < SIZE/2 ; i++) { 	// 행
			System.out.println(i + "번째턴");
			// 첫번째 FOR 진행중 i = 0, x=4,y=5
			// 두번째 FOR 진행중 i = 1, x=3,y=4
	
			// 오른쪽으로 저장(j값증가)	// 00 01 02 03 04 // 10 11 12 13 // 21 22 끝
			for (int j = i; j < y; j++) { // 열
//				for (int j = i; j < SIZE	- ((i-1)*2+1); j++) { 
				if(i == 1 || i == 0) {
					System.out.printf("[오]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
					map[i][j] = ++num;
				} else {
					System.out.printf("[오]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
					map[i-1][j] = ++num;  	// 가로 첫번째 턴
				}
				
			}
			num--;

/*			// turn0. i=0,x=4,y=5
			// 아래로 저장(i값증가)		// 04 14 24 34 44 // 13 23 33
			for (int j = i; j < y; j++) { // j:0,1,2,3,4
//				for (int j = i; j < y; j++) { // j:0,1,2,3,4
				System.out.printf("[아래]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[j][x] = ++num;		// 아래로 첫번째 턴
			}
			num--;*/
			
			// turn0. i=0,x=4,y=5
			// turn1. i=1,x=3,y=4
			// 왼쪽으로 저장(j값감소) 	// 44 43 42 41 40 // 33 32 31
			/*for (int j = x; j >= i; j--) { // ********j조건식에 2씩 줄이는 방법
//				for (int j = x; j >= i; j-=2) { // ********j조건식에 2씩 줄이는 방법
//				for (int j = x; j >= i; j--) {
				System.out.printf("[왼]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[x][j] = ++num;
			}
			num--;*/
			/*
			System.out.printf("[log]i=%d,x=%d,y=%d,num=%d\n",i,x,y,num);
			// turn0. i=0,x=4,y=5, j = 4,
			// turn1. i=1,x=3,y=4, j = 3,
			// 위쪽으로 저장(i값감소)	// 40 30 20 10 // 31 21
			for (int j = x; j > i ; j--) {
//				for (int j = SIZE-1-2*i; j > SIZE-1 + i*2 ; j--) {
				System.out.printf("[위]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[j][i] = ++num;
			}
			num--;*/
			
			System.out.println(num);
			y--;x--;
			
		}
		 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + "\t"); 
			}
			System.out.println();
		}
		
		
		
	}

}
