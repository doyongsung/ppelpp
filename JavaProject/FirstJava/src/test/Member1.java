package test;

import java.util.*;

public class Member1 {
	
public static void  vaccination () {
	
	   int year = getUserInput();
	   if(year < 15 || year >= 65) {
		   System.out.println("무료예방접종이 가능합니다.");
	   }else {
		   System.out.println("무료접종 대상이 아닙니다.");
	   }
   }
public static void inoculation() {
	int year = getUserInput();
	int now = getUserInput();
	
if(year % 2 == now % 2) {
	System.out.println("건강검진 대상 입니다.");
    if(now >= 40) {
    	System.out.println("암검사 무료입니다.");
    }
}
}

	public static void main(String[] args) {
		Member1 mb = new Member1();
		
		mb.inoculation();
		mb.vaccination();
		

	}
	private static int getUserInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

}
