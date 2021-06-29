package test;

import java.util.Scanner;

public class array02 {
	 public static void addOneDArr(int[][] arr, int add){
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr[i].length; j++) {
	                arr[i][j] += add;
	            }
	        }
	    }

	 public static void setArray(int[][] count) {
		 for(int i = 0; i < count.length; i++) {
			 for(int j = 0; j < count[i].length; j++) {
				 System.out.print((i+1) + "번째의 행과 " + (j+1) + " 열을 입력 해주세요 : ");
				 count[i][j] = getInteger();				 
			 }
			 System.out.println();
		 }		
	 }
	 public static void getArray(int[][] count) {
		 System.out.println("현재 상황");
		 for(int[] ints : count) {
			 for(int i : ints) {
				 System.out.print(i + " ");
			 }
			 System.out.println();
		 }
	 }
	 
	public static void main(String[] args) {
		
		System.out.print("배열의 행을 입력해주세요 : ");
		int arrOne = getInteger();
		System.out.print("배열의 열을 입력해주세요 : ");
		int arrTwo = getInteger();
		int [][] arr = new int[arrOne][arrTwo];
	     setArray(arr);
	     getArray(arr);
	     System.out.println("증가 시킬 값을 입력해주세요");
	     int add = getInteger();
	     addOneDArr(arr,add);	     
	     getArray(arr);
	}

	public static int getInteger() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
}
