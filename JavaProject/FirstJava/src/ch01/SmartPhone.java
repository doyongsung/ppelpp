package ch01;

import java.util.Scanner;

public class SmartPhone {
	
	
	Contact[] contact = new Contact[10];
	int count;	//배열의 입력 index 역할, 정보의 개수
	
	public SmartPhone(int num) {
	 this.contact = new Contact[num];
	 this.count = 0;
	}
	
	public void addContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이   름 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 : ");
		String phone = sc.nextLine();
		System.out.println("이 메 일 : ");
		String email = sc.nextLine();
		System.out.println("주   소 : ");
		String addrees = sc.nextLine();
		System.out.println("생   일 : ");
		String events = sc.nextLine();
		System.out.println("그   룹 : ");
		String groups = sc.nextLine();
	}
	
	

	}


