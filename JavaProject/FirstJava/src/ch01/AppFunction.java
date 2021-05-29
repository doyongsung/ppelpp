package ch01;

import java.util.Scanner;

public class AppFunction {

	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
//	Contact app = new Contact("미입력","미입력","미입력","미입력",0,"미입력");
//	app.showInfo();
//	Contact app1 = new Contact("1","2","3","4",0,"5");
//	app1.showInfo();
	SmartPhone sp = new SmartPhone();
	
	while(true) {
	System.out.println("========메뉴 선택 =========");
	System.out.println("1번. 정보를 입력   ");
	System.out.println("2번. 정보를 수정   ");
	System.out.println("3번. 정보를 삭제   ");
	System.out.println("4번. 정보를 출력   ");
	System.out.println("5번. 프로그램을 종료   ");
	System.out.println("=======================");
	System.out.print("메뉴를 선택 해주세요. : ");
	int count = Integer.parseInt(sc.nextLine());
	
	
	
	switch(count) {
	case 1:
		sp.addContact();
		break;
	case 2:
		break;
	case 3:
		sp.showSetCount();
		break;
	case 4:	
		sp.showAllContact();
		break;
	case 5:
		System.out.println("시스템을 종료 합니다.");
		return;		
	}

	
	
	}
}	
}


