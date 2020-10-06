// 20201006 17:05-17:22
package step3_01.arrayAdvance1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * # 최대값 구하기[3단계]
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 * 
 */


public class ArrayEx25_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] arr = {11, 87, 42, 100, 24};
		int input, max, idx;
		int zeroCnt=0;
		
		while(true) {
			
			max = 0;
			idx = -1;

			System.out.println("\n" + Arrays.toString(arr));		
			System.out.print("가장 큰 값을 입력하세요: ");
			input = scan.nextInt();
			
			for (int i = 0; i < arr.length; i++) {
				if(max < arr[i]) {
					max = arr[i];
					idx = i;				
				}
			}
			
			if(input == max) {
				System.out.println("[정답]");
				arr[idx] = 0; 
				zeroCnt++;
			} else { 
				System.out.println("[땡!]");
			}
			
			if(zeroCnt == 5) {
				System.out.println("=====[게임종료]=====");
				break;
			}
		}
		
	
	}
}
