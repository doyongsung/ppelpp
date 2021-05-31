package ch01;

import java.util.Scanner;

public class SmartPhone {
	
	
	Scanner sc = new Scanner(System.in);
	int addCount;	//삽입의 대한 입력 index 역할, 정보의 개수
	int setCount;   //수정의 대한 입력 index 역할
  	int remCount;   //삭제의 대한 입력 index 역할
	boolean bool = false;   //기능 사용에 대한 논리 변수
	
	//인스턴스 10개를 저장할 수 있는 배열 정의.
	Contact[] contacts = new Contact[10];	
	Contact[] contacts1 = new CompanyContact[10];
	Contact[] contacts2 = new CustomerContact[10];
	
           SmartPhone() {
        	   for (int i = 0; i < contacts.length; i++) {
                   Contact contact = new Contact("미입력", "미입력", "미입력", "미입력", 000, "미입력");
                   contacts[i] = contact;
               }
	}

     
	public void remContact() {
		int temp = 0;
		bool = false;
		System.out.println("삭제하실 이름을 입력해주세요");
		String name = sc.nextLine();
		for(int i =0; i< contacts.length; i++) {
			if(contacts[i].getName().equals(name)) {
				bool = true;
				temp = i;
			}
			}
		    if(bool == true) {
		    	for(int i = temp; i < contacts.length-1; i++) {
		    		contacts[i] = contacts[i+1];
		    		
		    	}
		    	addCount--;
		    }else {
		    	System.out.println("다시 입력 해주세요");
		    }
		}

	public void setContact() {
		System.out.println("수정하실 이름을 입력해주세요");
		bool = false;
		int temp =0;
		String name = sc.nextLine();
		for(int i =0; i< contacts.length; i++) {
			if(contacts[i].getName().equals(name)) {
				bool = true;
				temp = i;
			}
		}
		if(bool == true) {
			
		}
	}

	public void addContact() {
		
		System.out.println("============================");
		System.out.println("정보를 입력해주세요");
		System.out.println("============================");
		System.out.print("이   름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("이 메 일 : ");
		String email = sc.nextLine();
		System.out.print("주   소 : ");
		String address = sc.nextLine();
		System.out.print("생   일 : ");
		int events = Integer.parseInt(sc.nextLine());
		System.out.print("그   룹 : ");
		String groups = sc.nextLine();
		
	   //  Contact contact = new Contact(name,phone, email, address,events , groups);
		addContactInfo(new Contact(name,phone, email, address,events , groups));
	}
	
	public void addContactInfo(Contact C) {
		contacts[addCount++] = C;
		System.out.println("정보가 저장되었습니다.");
	}
	
	public void showAllContact() {
		System.out.println("정보를 출력합니다.");
		System.out.println("======================");				
			for(int i = 0; i < addCount; i++) {
				contacts[i].showInfo();		
				System.out.println("====================");
			}
		}
}
	
	
	
	


