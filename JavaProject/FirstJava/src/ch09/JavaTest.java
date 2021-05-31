package ch09;

import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaTest {

	public static int getInteger() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("이름을 입력해주세요");
		int name = getInteger();	
		
		
	}

}
