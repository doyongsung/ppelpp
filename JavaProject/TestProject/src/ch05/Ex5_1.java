package ch05;

import java.util.Arrays;

public class Ex5_1 {

	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
		int[] iArr3 = new int[10];
		char[] chArr = {'a','b','c','d'};
		
		for ( int i =0; i < iArr1.length; i++) {
			iArr1[i] = i *2; // 1~10의 숫자를 순서대로 배열
		}
		System.out.println();
		for(int i =0; i < iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10) +1;
		}
		
		System.out.println(Arrays.toString(iArr1));
		System.out.println(Arrays.toString(iArr2));
		System.out.println(chArr);

	}

}
