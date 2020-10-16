// 2020-10-15 목 15:40-17:45
// 2020-10-16 금 15:11-15:38, 15:40-16:08 선생님답 이해해보기
package step3_02.arrayAdvance2;

/*
 * # 달팽이
 * 1	2	3	4	5	
 * 16	17	18	19	6	
 * 15	24	25	20	7	
 * 14	23	22	21	8	
 * 13	12	11	10	9
 * 
 * 1) 오른쪽 방향으로 순서대로 숫자저장
 * 2) 아래쪽 방향으로 순서대로 숫자저장
 * 3) 왼쪽 방향으로 순서대로 숫자저장
 * 4) 윗쪽 방향으로 순서대로 숫자저장
 * 1)2)3)4) 반복
 */


public class ArrayEx50_정답 {

	public static void main(String[] args) {

		final int SIZE = 5; // 달팽이 가로 길이
		
		int[][] map = new int[SIZE][SIZE];
		
		int num = 0;
		int x = SIZE-1;		// 행 최고값을 조절  
		int y = SIZE; 		// 열 최고값을 조절
		
		for (int i = 0; i < SIZE/2+1 ; i++) { 	// 행
//			System.out.println(i + "번째턴");
	
			// 오른쪽으로 저장(j값증가)	
			for (int j = i; j < y; j++) { // 열
				if(i == 1 && j == 1) {
//					System.out.printf("[오]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
					map[1][0] = ++num;
					map[i][j] = ++num;
				} else if (i > 1 && j == i) { // 2번째턴이후이면서 맨 처음 j돌때
//					System.out.printf("[오]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
					map[i][j-1] = ++num;
					map[i][j] = ++num;
				} else {
//					System.out.printf("[오]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
					map[i][j] = ++num;  	
				}
			}
			num--;

			// 아래로 저장(i값증가)		
			for (int j = i; j < y; j++) {
//				System.out.printf("[아래]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[j][x] = ++num;		// 아래로 첫번째 턴
			}
			num--;
			
			// 왼쪽으로 저장(j값감소) 	
			for (int j = x; j >= i; j--) { 
//			for (int j = x; j >= i; j-=2) { // ********j조건식에 2씩 줄이는 방법
//				System.out.printf("[왼]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[x][j] = ++num;
			}
			num--;
			
			// 위쪽으로 저장(i값감소)	
			for (int j = x; j > i ; j--) {
//			for (int j = SIZE-1-2*i; j > SIZE-1 + i*2 ; j--) {
//				System.out.printf("[위]i=%d,j=%d,x=%d,y=%d,num=%d\n",i,j,x,y,num);
				map[j][i] = ++num;
			}
			num--;
			
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
