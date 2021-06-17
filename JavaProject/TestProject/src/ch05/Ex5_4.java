package ch05;

import java.util.Arrays;

public class Ex5_4 {

	public static void main(String[] args) {
		int[] numArr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(numArr));
		
		for(int i =0; i < numArr.length; i++) {
			int n = (int)(Math.random() *10); // 0~9 중의 한 값을 임의로 얻는다.
			int temp = numArr[i];
			numArr[i] = numArr[n];       //numArr[0]과 numArr[n]의 값을 서로 바꾼다.
			numArr[n] = temp;
			System.out.println(Arrays.toString(numArr));
		}
		//System.out.println(Arrays.toString(numArr));
	}

}
