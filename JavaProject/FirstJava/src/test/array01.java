package test;

import java.util.Scanner;

public class array01 {
	public static int miniValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];				
			}
		}
		return min;
	} // 최소값 반환

	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > max) {
				max = arr[j];
			}
		}
		return max;
	} // 최대값 반환
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력 해주세요 : ");
		int min = sc.nextInt();
		
		int[] arr = new int[min];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("배열의 최소값: " + miniValue(arr));
		System.out.println("배열의 최대값: " + maxValue(arr));
		

	}

}
