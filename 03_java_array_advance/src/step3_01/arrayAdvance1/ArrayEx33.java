// 20201008 1교시 수업 
package step3_01.arrayAdvance1;

import java.util.Arrays;

/*
 * [ 배열의 주소 ]
 * 
 * 
 */
public class ArrayEx33 {

	public static void main(String[] args) {
		
		int[] arr = {87, 100, 24, 11, 79}; // arr변수는 stack에, 배열은 heap에 저장 
		int[] temp = null;
		
		System.out.println("arr: " + arr); // 메모리어디에 저장되어있는지 위치
		System.out.println("temp: " + temp);
		System.out.println();

		temp = arr; // arr 주소를 대입
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("temp: " + Arrays.toString(temp));

		temp[0] = 999;
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("temp: " + Arrays.toString(temp));
		
		arr[0] = 777;
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("temp: " + Arrays.toString(temp));
		
		
	}

}
