package ch04;

import java.util.Scanner;

public class Ex4_18 {

	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square");
			System.out.println("(3) square");
			System.out.println("원하는 메뉴(1~3)를 선택하세요. (종료:0)>");
			
			String tmp = sc.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(!(1 <= menu && menu <=3)) {
				System.out.println("메뉴를 잘못 선택하셧습니다.(종료는0)");
				continue;
			}
		}

	}

}
