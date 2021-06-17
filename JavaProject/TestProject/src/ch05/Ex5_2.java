package ch05;

import java.util.Arrays;

public class Ex5_2 {

	public static void main(String[] args) {
		int sum = 0;        //총합을 저장하기 위한 변수
	    float average = 0f; //평균을 저장하기 위한 변수
	    
	    int[] score = {100,88,100,100,90};
	    
	    for(int i =0;i<score.length;i++) {
	         sum += score[i];      //반복문을 이용해서 배열에 저장되어있는값을 모두 더한다.
	         System.out.println(sum);
	    }
	    average = sum / (float)score.length;
	    
	    System.out.println(Arrays.toString(score));
	    System.out.println(sum);
	    System.out.println(average);

	}

}
