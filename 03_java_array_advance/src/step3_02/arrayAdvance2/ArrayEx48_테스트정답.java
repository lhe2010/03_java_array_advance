// 2020-10-14 수 17:12-17:39

package step3_02.arrayAdvance2;

import java.util.Scanner;

/*
	문제1) 1 ~ 백만 사이의 숫자를 입력받고 가운데 숫자 출력 
	(단 ! 짝수자리의 수는 짝수자리라고 출력)
	예)  123 ==> 2
	예)  1234 ==> 짝수의 자리이다
	예)  1 ==> 1
	예)  1234567 ==> 4
	
	힌트) 자리수를 구하고 배열을 만든다음 하나씩 저장 
	예) ==> 123 ==> 3 ==> arr[] = new int[3];
*/

public class ArrayEx48_테스트정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num;
		int cnt = 1;

		System.out.print("1~백만까지의 숫자 : ");
		num = scan.nextInt();
		
		if(num > 9999999) {
			System.out.println("[ERROR] 백만까지만 입력가능합니다.");
			return;
		}

		int temp = num;
		while(temp > 9) {
			temp /= 10;
			cnt++;
//			System.out.printf("[log] temp=%d, cnt=%d\n", temp, cnt);
		}
		
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[cnt-1-i] = num % 10;
			num /= 10;
		}
		
		if(arr.length % 2 == 0) {
			System.out.println("[결과] 짝수의 자리이다.");
		} else {
			System.out.println("[결과] " + arr[arr.length/2]);
		}
//		System.out.println(Arrays.toString(arr));
	}
}