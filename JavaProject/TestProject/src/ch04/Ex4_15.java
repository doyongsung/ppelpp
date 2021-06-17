package ch04;

import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
		int input = 0;
		int answer = 0;

		Scanner sc = new Scanner(System.in);
//		
//		answer = (int)(Math.random() * 100) +1;	
//		System.out.print("1부터 100까지의 숫자를 입력해주세요>>");
//		input = sc.nextInt();
//		
//		while(answer != input) {
//
//			if(answer > input) {
//				System.out.println("더 높은 숫자입니다.");
//			}else if (answer < input) {
//				System.out.println("더 낮은 숫자입니다.");
//			}
//			System.out.print("1부터 100까지의 숫자를 입력해주세요>>");
//			input = sc.nextInt();
//		}
//		
		answer = (int)(Math.random() * 100) +1;	
		System.out.println(answer);
		do {
		System.out.print("1부터 100까지의 숫자를 입력해주세요>>");
		input = sc.nextInt();
		
		
		if(answer > input) {
			System.out.println("더 높은 숫자입니다.");
		}else if (answer < input) {
			System.out.println("더 낮은 숫자입니다.");
		}
		}while(answer != input); // 참일때
		System.out.println("정답입니다.");
	
		
		
		

	}

}
