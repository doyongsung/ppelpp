package test;

import java.util.Scanner;

public class array03 {
	public static void getArray(int[][] count) {
		System.out.println("현재상황");
		for(int[] ints : count) {
			for(int i : ints) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void selArray(int[][] count) {
		for(int i = 0; i < count.length; i++) {
			for(int j = 0; j <count[i].length; j++) {
				System.out.println((i+1) + " 번째의 행과 " + (j+1) + " 번째의 열을 입력하세요");
				count[i][j] = getInput();
			}
		}
	}
	public static void ShuffleArray(int[][] arr) {
		int[] temp;
		for(int i = arr.length-1; i > 0; i-- ) {
			temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		System.out.print("배열의 행을 입력해주세요 : ");
		int arrOne = getInput();
		System.out.print("배열의 열을 입력해주세요 : ");
		int arrTwo = getInput();
		int[][] arr1 = new int[arrOne][arrTwo];
		selArray(arr1);
		getArray(arr1);
		ShuffleArray(arr1);
		getArray(arr1);

	}

	public static int getInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
}
