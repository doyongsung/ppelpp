package ch04;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member member = new Member();
	
		System.out.print("태어난 년도를 입력해주세요: ");
		int year = sc.nextInt();
		member.ascertain(year);
		member.vaccinate(year);
		
	
		
	}
}
