// 2020-10-12 day17 1교시
package step3_01.arrayAdvance1;
// # 2차원 배열
// 이차원배열에서 가로길이 : arr.length
// ******* 세로길이 : arr[i].length

public class ArrayEx34 {

	public static void main(String[] args) {
		
		//2차원배열만들기
		 
		int[][] arr = new int [3][3];
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		arr[2][0] = 70;
		arr[2][1] = 80;
		arr[2][2] = 90;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { // ******* 세로 값 얻기
				System.out.println(arr[i][j] + " ");
				
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-----------------------------");
		
		int[] temp = arr[1]; // 배열의 주소가 대입 ******
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();

	}

}
