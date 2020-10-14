// 2020-10-14 수 15:50-15:59
package step3_02.arrayAdvance2;

import java.util.Arrays;
import java.util.Random;

/*
 * # 1부터 5사이의 랜덤 숫자를 2개씩 arr 배열에 저장하기
 * 예) 1 3 2 1 4 4 5 2 3 5
 * 
 *  - 1부터 5까지 숫자를 2개씩 넣고 셔플로 이용해서 섞지 말것
 */

public class ArrayEx46_테스트정답 {

	public static void main(String[] args) {
		
		Random ran = new Random();

		int[] arr = new int[10];
		int[] check = new int[5];
		int temp;
		int idx = 0;
		
		while(idx < 10) {
			// 모두 두개씩 들어갔으면 == arr이 꽉찬경우 == break
			// ***** check == {2,2,2,2,2} 이렇게 비교하는거 안됨. Arrays.equals(객체) 이용하는 방법있으나 직접해보기~~
//			if(arr[9] != 0)
//				break; // idx이용해서 이거도 필요X
			
			temp = ran.nextInt(5)+1; // 1 -> check[0], 2 -> check[1], 3 -> check[2], 4 -> check[3], 5 -> check[4] 
			if(check[temp-1] == 2)
				continue;
			else {
				check[temp-1] += 1;
				arr[idx] = temp;
				idx++;
			}
		}
		System.out.println( Arrays.toString(arr));
	}
}
