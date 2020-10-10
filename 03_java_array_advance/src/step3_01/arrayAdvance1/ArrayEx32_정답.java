// 20201009 18:25-43  
package step3_01.arrayAdvance1;

import java.util.Arrays;

/*
 * # 석차 출력
 * . 성적 순으로 이름 출력
 */

public class ArrayEx32_정답 {
	public static void main(String[] args) {

		String[] names = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		int[] scores   = {    87,    42,    100,     11,     98};
		int[] ranks = new int[names.length];
		
		
		int maxIdx = 0;
		int maxValue = 0;
		int rIdx = 0;
		// 랭크가 찰때까지 
		while(rIdx < ranks.length) {
			maxValue = 0;
			// scores[]에서 제일 큰값을 찾는다.
			for (int i = 0; i < scores.length; i++) {
				if(ranks[rIdx] == i) continue;
				if(scores[i] > scores[maxIdx]) {
					maxIdx = i;
				}
			}
			
			ranks[rIdx++] = maxIdx;
			
		}
		
		System.out.println(Arrays.toString(ranks));
	}

}
