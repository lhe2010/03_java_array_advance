// 2020-10-12 15:36-15:49
package step3_01.arrayAdvance1;

import java.util.Scanner;

/*
 *	# 2차원배열 기본문제[2단계]
*/

public class ArrayEx36_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = new int[3][3];
		
		int k = 1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		int idx1 = 0;
		int idx2 = 0;
		int nValue = 0;
		
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
		System.out.print("인덱스1 입력 : ");
		idx1 = scan.nextInt();
		
		System.out.print("인덱스2 입력 : ");
		idx2 = scan.nextInt();
		
		System.out.printf("arr[%d][%d] = %d", idx1, idx2, arr[idx1][idx2]);
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
		idx1=0;idx2=0;
		System.out.print("\n값 입력 : ");
		nValue = scan.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == nValue) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.printf("인덱스1 출력 : %d, 인덱스2 출력 : %d", idx1, idx2);
		
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		int maxValue = 0;
		idx1 = 0; idx2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] > maxValue) {
					maxValue = arr[i][j];
					idx1 = i; idx2 = j;
				}
			}
		}
		System.out.printf("\n가장 큰 값의 인덱스 : arr[%d][%d] = %d", idx1, idx2, arr[idx1][idx2]);
		
		// 문제 4) 값 2개를 입력받아 값 교체
		idx1= 0; idx2 = 0; nValue = 0;
		System.out.print("\n바꾸고싶은 인덱스1 입력 : ");
		idx1 = scan.nextInt();
		
		System.out.print("바꾸고싶은 인덱스2 입력 : ");
		idx2 = scan.nextInt();
		
		System.out.printf("현재 arr[%d][%d] 의 값은 %d이다. \n바꾸고싶은 값 입력 : ", idx1, idx2, arr[idx1][idx2]);		
		arr[idx1][idx2] = scan.nextInt();
		
		System.out.printf("바뀐 arr[%d][%d] 의 값은 %d이다.", idx1, idx2, arr[idx1][idx2]);
		
		scan.close();
	}

}
