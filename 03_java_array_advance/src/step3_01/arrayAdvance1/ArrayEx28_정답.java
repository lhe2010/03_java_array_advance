// 20201007수 16:10-16:40
package step3_01.arrayAdvance1;

import java.util.Arrays;
import java.util.Random;

/*
 * # 중복숫자 금지[2단계]
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */

public class ArrayEx28_정답 {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = {0,0,0,0,0};
		int idxCnt = 0; 	// 채워진 인덱스 수 
		int num;
		boolean isRepeat = false;
		
		System.out.println("1-10숫자뽑기!");
		while(idxCnt < 5) {
			// 랜덤 숫자를 뽑는다. 
			num = ran.nextInt(9)+1;
			
			for (int i = 0; i <= idxCnt; i++) {
//				System.out.printf("arr[%d]=%d, num=%d, idxCnt=%d\n", i, arr[i], num, idxCnt);
				if(arr[i] == num) {
					isRepeat = true;	
				}
			}
			
//			if(isRepeat) {
//				continue;			// 이미 있는 숫자라면 다시 뽑는다. ************************ 필요없음!
//			} else {
//				arr[idxCnt] = num; // 이미 있는 숫자가 아니면 저장한다.
//				idxCnt++;
//			}
			if(!isRepeat) {
				arr[idxCnt] = num; // 이미 있는 숫자가 아니면 저장한다.
				idxCnt++;
			}
			
			isRepeat = false;
//			System.out.println("현재까지 배열은 " + Arrays.toString(arr));
//			System.out.println(idxCnt);
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
}
