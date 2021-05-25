package test;

import java.util.*;



public class Member1 {
	
	void vaccinCheck(int birthYear) {
		
		//int age = 2021 - birthYear - 1; // 나이 연산
	//	int age = 2021 - birthYear -1;
		int age = ageCal(birthYear);
		
		boolean check1 = age < 15 || age >= 65;
		boolean check2 = !(age >= 15 && age < 65);
		
		
		System.out.println(check1);
		System.out.println(check2);
		if(check1) {
			System.out.println("무료예방접종이 가능합니다.");
		}else {
			System.out.println("무료접종 대상이 아닙니다.");			
		}
	}
		void checkup(int birthYear) {
			int age = 2021 - birthYear - 1;
			
			boolean check1 = birthYear % 2 == 0 && 2021 % 2 == 0 || birthYear % 2 == 1 && 2021 % 2 == 1;
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
	// 태어난 년도를 입력하면 나이를 반환하는 메소드
		int ageCal(int year) {
			
			int currentYear = Calendar.getInstance().get(Calendar.YEAR) - year;
			
			return currentYear - year -1;
			
		}
	
//public static void  vaccination () {
//	
//	   int year = getUserInput();
//	   if(year < 15 || year >= 65) {
//		   System.out.println("무료예방접종이 가능합니다.");
//	   }else {
//		   System.out.println("무료접종 대상이 아닙니다.");
//	   }
//   }
//public static void inoculation() {
//	int year = getUserInput();
//	int now = getUserInput();
//	
//if(year % 2 == now % 2) {
//	System.out.println("건강검진 대상 입니다.");
//    if(now >= 40) {
//    	System.out.println("암검사 무료입니다.");
//    }
//}
//}
//
	public static void main(String[] args) {
		
	//	System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println("태어난 년도를 입력해주세요");
		int birthYear = getUserInput();
		
		Member1 member = new Member1();
		
		member.vaccinCheck(birthYear);
		member.checkup(birthYear);
		
//		Member1 mb = new Member1();
//		
//		mb.inoculation();
//		mb.vaccination();
//		
//
	}
	private static int getUserInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

}
