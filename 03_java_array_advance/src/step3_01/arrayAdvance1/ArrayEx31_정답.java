// 20201009 17:12-18:19
package step3_01.arrayAdvance1;

import java.util.Arrays;

/*
 * # 정렬하기
 * 1. 인덱스 0번이 나머지를 검사한다.
 * 2. 제일 큰 값을 찾아 교환한다.
 * 3. 인덱스 1증가한다.
 * 4. [1~3]을 끝까지 반복한다.
 * 예)
 * 10, 50, 30, 40, 80, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 40, 30, 10, 7
 */


public class ArrayEx31_정답 {

	public static void main(String[] args) {
		
		int[] scores = {10, 50, 30, 40, 80, 7};
		int maxValue = 0;
		int maxIdx;
		
		// 0번이랑 비교해서 제일 큰값 찾아내
		for (int i = 0; i < scores.length; i++) {
			maxIdx = i;
			for (int j = i; j < scores.length; j++) {
				if(scores[maxIdx] < scores[j]) {
					maxIdx = j;
				}
				System.out.println(Arrays.toString(scores) + ", i= "+i + ", j= "+j+ ", maxIdx = " + maxIdx);
			} 
			// 찾은 제일 큰 값이랑 교환
			int temp = scores[i];
			scores[i] = scores[maxIdx];
			scores[maxIdx] = temp;			
			System.out.println(Arrays.toString(scores) + "i= " + i);
		}
		System.out.println(Arrays.toString(scores));
	}

}
