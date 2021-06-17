package ch05;

import java.util.Arrays;

public class Ex5_1_tmp {

	public static void main(String[] args) {
		//int[] score;        //1. 배열 score를 선언(참조변수)
		//score = new int[5]; //2. 배열의 생성(int저장공간 x5 )
		
		
		//배열은 한번 생성하면 실행할동안 그 길이를 바꿀 수 없다.
//		int[] score = new int[5]; //배열의 선언과 생성을 동시에
//		score[3] = 100;
//		System.out.println("score[0]="+score[0]);
//		System.out.println("score[1]="+score[1]);
//		System.out.println("score[2]="+score[2]);
//		System.out.println("score[3]="+score[3]);
//		System.out.println("score[4]="+score[4]);
//		
//		int value = score[3];
//		System.out.println("value="+value);
//		
//
//		int[]arr = new int[5];
//		int tmp = arr.length;
//		System.out.println(tmp);
//		
//		for(int i =0; i <arr.length; i++) {
//			System.out.println(arr.length);
			
			int[] score = {50,60,70,80,20,30};
			System.out.println((Arrays.toString(score)));
		}
	

}
