// 2020-10-12 day17 이차원배열 연습
// (1번/2번)16:24-16:30, (3번) 16:30-16:45, (4번)16:45-16:50
package step3_01.arrayAdvance1;

import java.util.Arrays;
import java.util.Scanner;

/* 
 *	# 관리비
*/

public class ArrayEx38_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		int[] pays = new int[apt.length];

		for(int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				pays[i] += pay[i][j];
			}
		}
		System.out.println("[1] 각 층별 관리비 합: " + Arrays.toString(pays));
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		System.out.print("[2] 관리비가 궁금한 호수 : ");
		int roomNum = scan.nextInt();

		System.out.printf("%d호의 관리비는 %d원", roomNum, pay[roomNum/100-1][roomNum%10-1]); // ******* 각 인덱스에서 1빼줘야함
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		int maxPay = 0; int minPay = pay[0][0];
		int maxRoom = 0; int minRoom = 0;
		for (int i = 0; i < pay.length; i++) {
			for (int j = 0; j < pay[i].length; j++) {
				if(pay[i][j] > maxPay) {
					maxPay = pay[i][j];
					maxRoom = (i+1)*100+(j+1);
//					System.out.printf("\n최댓값 발견! pay[%d][%d] ~~~~ %d호 ",i,j, maxRoom);
				}
				
				// 최솟값
				// ****minPay를 0으로 초기화하고 시작했더니 0보다 작은 값이 나오지 않으니까 0으로 끝남. 최소값을 0이 아닌 수로 해보자.
				if(minPay > pay[i][j]) {
					minPay = pay[i][j];
					minRoom = (i+1)*100+(j+1); 
//					System.out.printf("\n최솟값 발견! pay[%d][%d] ~~~~ %d호 ",i,j, minRoom);
				}
			}
		}
		System.out.printf("\n[3] 가장 많이 나온 집(%d), 가장 적게 나온 집(%d)", maxRoom, minRoom);		
		
		// 문제 4) 호 2개를 입력하면 관리비 교체
		System.out.print("[4] 호 두개를 입력하면 서로 관리비가 교체됩니다. \n교체하고싶은 호수 : ");
		int rNum1 = scan.nextInt();
		int rNum2 = scan.nextInt();
		
		System.out.printf("\n교체 전 각 호수의 관리비: %d, %d", pay[rNum1/100-1][rNum1%10-1], pay[rNum2/100-1][rNum2%10-1]);
		int temp = pay[rNum1/100-1][rNum1%10-1];
		pay[rNum1/100-1][rNum1%10-1] = pay[rNum2/100-1][rNum2%10-1];
		pay[rNum2/100-1][rNum2%10-1] = temp;
		System.out.printf("\n교체 후 각 호수의 관리비: %d, %d", pay[rNum1/100-1][rNum1%10-1], pay[rNum2/100-1][rNum2%10-1]);
		
	}

}
