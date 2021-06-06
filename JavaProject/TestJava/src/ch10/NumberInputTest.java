package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요");
try {
	

		int number = sc.nextInt();
		
		System.out.println("입력하신 숫자는 : " + number);
} catch (InputMismatchException e) {
	System.out.println("입력하신 데이터는 숫자가 아닙니다.");
	//e.printStackTrace();
}  

System.out.println("프로그램 종료");
	}

}
