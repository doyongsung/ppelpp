package ch04;

import java.util.Calendar;
import java.util.Scanner;

public class Member {
	
	int ageCal(int year) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR) - year;
		
		return currentYear - year - 1; 
	}
	public void ascertain (int birthYear) {
		int age = ageCal(birthYear);
		
		boolean check1 = age < 15 || age >= 65;
		boolean check2 = !(age >= 15 && age < 65);
		
		System.out.println(check1);
		System.out.println(check2);
		if(check1) {
			System.out.println("무료예방접종이 가능합니다.");
		}else {
			System.out.println("무료접종 대상이 아닙니다");
		}
	}
	
	public void vaccinate(int birthYear) { 
		
	 int age = 2021 - birthYear - 1;
	 
	 boolean check1 = birthYear % 2 == 0 && 2021 % 2 ==0 || birthYear % 2 == 1 && 2021 % 2 == 1;
	 boolean check2 = birthYear % 2 == 2021 % 2;
	 
	 System.out.println(check1);
	 System.out.println(check2);
	 
	 if(age >= 20) {
		 System.out.println("검진 대상");
		 if(age >= 40) {
			 System.out.println("암검진 대상자");
		 }else {
			 System.out.println("검진 대상이 아닙니다.");
		 }
	 }
		 
	}	
	Scanner sc = new Scanner(System.in);

}