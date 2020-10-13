// 2020-10-12 2교시 17:00-17:14
package step3_01.arrayAdvance1;

import java.util.Arrays;

/* 
 
 	중복 안된 숫자 제거
 	
	int[] test1= {1,2,3,2,1};		
	int[] test2= {1,3,4,4,2};
	int[] test3= {1,1,1,2,1};
	// 위 배열에서 중복안된숫자를 제거하시요 
	// 1) {1,2,1,2}
	// 2) {4,4}
	// 3) {1,1,1,1}
	 
 */

public class ArrayEx39_정답 {

	public static void main(String[] args) {
		
		int[] test1 = {1,2,3,2,1};
		int[] test2 = {1,3,4,4,2};
		int[] test3 = {1,1,1,2,1};
		
		int[] result = new int[5];
		int[] check = {0,0,0,0,0};
		
		for (int i = 0; i < result.length; i++) {
			check[test1[i]]++;
		}
		
		for (int i = 0; i < check.length; i++) {
			if(check[i] > 1) {
				for (int j = 0; j < check.length; j++) {
					if(test1[j] == i) {
						result[j] = test1[j];
					}
				}
				
			}
		}
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.toString(result));

	}
	// result에서 0인거 안나오게, test1, test2, test3각각 어케?****

}
