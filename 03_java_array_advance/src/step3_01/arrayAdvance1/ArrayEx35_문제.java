package step3_01.arrayAdvance1;

/*
 *	# 2차원배열 기본문제[1단계]
*/

public class ArrayEx35_문제 {

	public static void main(String[] args) {

		int[][] arr = new int[3][3];
		
		int k = 1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		// 문제 1) 전체 합 출력
		// 정답 1) 450
		
		// 문제 2) 4의 배수만 출력
		// 정답 2) 20 40 60 80 
		
		// 문제 3) 4의 배수의 합 출력
		// 정답 3) 200
		
		// 문제 4) 4의 배수의 개수 출력
		// 정답 4) 4



	}

}
