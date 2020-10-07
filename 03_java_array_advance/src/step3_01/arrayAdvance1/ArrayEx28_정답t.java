package step3_01.arrayAdvance1;

import java.util.Random;

/*
 * # 중복숫자 금지[2단계]
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */

public class ArrayEx28_정답t {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = new int[5];
		int rNum = 0;
		int check = 0;
		int i = 0;
		int j = 0;
		
		while ( i < 5 ) {
			
			rNum = ran.nextInt(10) + 1;
			check = 1;
			j = 0;
			
			while ( j < i ) {
				
				if (rNum ==arr[j]) {
					check = -1;
				}
				j++;
			
			}
			
			if (check == 1) {
				arr[i] = rNum; 
				i++;
			}
			
		}
		
		for (int k=0; k<5; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
		
	}
	
}
