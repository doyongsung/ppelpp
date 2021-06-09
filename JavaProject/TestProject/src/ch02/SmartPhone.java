package ch02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import common.util.ScannerUtil;


public class SmartPhone {
	private  Map<String, Contact> ContactkMap;
	
	public SmartPhone() {
		
		Contact[] contacts = new Contact[10];
		int count = 0;
		ContactkMap = new HashMap<>();
	}
	

	
	
	
	
	
	public void save() {
		
		System.out.println("============================================================");
		System.out.print("이름을 입력해주세요: ");
	    String name = ScannerUtil.getInputString();
		System.out.print("전화번호를 입력해주세요: ");
		String phone = ScannerUtil.getInputString();
		System.out.print("이메일을 입력해주세요: ");
		String email = ScannerUtil.getInputString();
		System.out.print("주소를 입력해주세요: ");
		String address = ScannerUtil.getInputString();
		System.out.print("생일을 입력해주세요: ");
		int birthday = ScannerUtil.getInputInteger();
		System.out.print("그룹을 입력해주세요: ");
		String group = ScannerUtil.getInputString();
		System.out.println("정보가 저장되었습니다.");
		System.out.println("============================================================");
		ContactkMap.put(name, new Contact(name, phone, email, address, birthday, group));
		
	
	
		
		
	}
	public void correct() {
		System.out.println();
		System.out.println("새롭게 수정할 전화번호를 입력해주세요");
		System.out.print("이 름 >>");
		String name = ScannerUtil.getInputString();
		if(ContactkMap.get(name) == null) {
			System.out.println(name + "님은 전화번호 정보가 없습니다.");
			return;
		}
		System.out.print("전화번호: ");
		String phone = ScannerUtil.getInputString();
		System.out.print("이메일: ");
		String email = ScannerUtil.getInputString();
		System.out.print("주소: ");
		String address = ScannerUtil.getInputString();
		System.out.print("생일: ");
		int birthday = ScannerUtil.getInputInteger();
		System.out.print("그룹: ");
		String group = ScannerUtil.getInputString();
		
		Contact c = new Contact(name, phone, email, address, birthday, group);
		ContactkMap.put(name, c);
		
		System.out.println(name + " 수정 완료");
		
	}
	public void delete() {
		System.out.println();
		System.out.print("삭제할 정보의 이름을 입력해주세요: ");
		String name = ScannerUtil.getInputString();
		
		//remove(key) -> 삭제 성공하면 삭제된 value값만 반환하고, 실패하면 null반환
		if(ContactkMap.remove(name) == null) {
			System.out.println(name + "님은 등록된 이름이 아닙니다.");
		}else {
			System.out.println(name + "님 정보를 삭제했습니다.");
		}
		System.out.println("삭제 완료");
	}
	public void search() {
		System.out.println();
		System.out.println("검색할 전화번호의 이름을 입력해주세요: ");
		String name = ScannerUtil.getInputString();
		
		Contact c = ContactkMap.get(name);
		
		if(c == null) {
			System.out.println(name + "님의 정보가 없습니다.");
		}else {
			System.out.println(name + "님의 연락처 정보");
			System.out.println("이름: " + c.getName());
			System.out.println("전화번호: " + c.getPhone());
			System.out.println("이메일: " + c.getEmail());
			System.out.println("주소: " + c.getAddress());
			System.out.println("생일: " + c.getBirthday());
			System.out.println("그룹: " + c.getGroup());
		}
		System.out.println("검색 작업 완료");
	}
	public void print() {
				Set<String> keySet = ContactkMap.keySet();
				
				System.out.println("==============================");
				System.out.println("이름 \t전화번호 \t이메일 \t주소 \t생일 \t그룹");
				System.out.println("==============================");
				
				if(keySet.size() == 0) {
					System.out.println("등록된 전화번호가 없습니다.");
				}else {
					Iterator<String> it = keySet.iterator();
					
					int cnt = 0;
					while(it.hasNext()) {
						cnt++;
						String name = it.next();
						Contact c = ContactkMap.get(name);
						System.out.println(" " + cnt + "\t" + c.getName() + "\t" + c.getPhone() + "\t" 
						                   + c.getEmail() + "\t" + c.getAddress() + "t" + c.getBirthday()
						                   + "\t" + c.getGroup());
				System.out.println("================================");
				System.out.println("출력 완료");
					}
				}
	}
	public void Menu() {
		while(true) {
			ContactMenu();
		    int menuNum = ScannerUtil.getInputInteger();
		      switch(menuNum) {
		      case 1 : save();
		               break;
		      case 2 : correct();
		               break;
		      case 3 : delete();
		               break;
		      case 4 : search();
		               break;
		      case 5 : print();
		      case 0 :
		    	  System.out.println("프로그램을 종료 합니다.");
		    	  return;
		      }
		      System.out.println("잘못입력했습니다. 다시입력해주세요.");
			}
		
	}
	public void ContactInfo() {
		System.out.print("이 름 >>");
		String name = ScannerUtil.getInputString();
		System.out.print("전화번호: ");
		String phone = ScannerUtil.getInputString();
		System.out.print("이메일: ");
		String email = ScannerUtil.getInputString();
		System.out.print("주소: ");
		String address = ScannerUtil.getInputString();
		System.out.print("생일: ");
		int birthday = ScannerUtil.getInputInteger();
		System.out.print("그룹: ");
		String group = ScannerUtil.getInputString();
		
		Contact c = new Contact(name, phone, email, address, birthday, group);
		ContactkMap.put(name, c);
	}
	public void ContactMenu() {
		System.out.println("============================================================");
		System.out.println("1. 등록    2. 수정    3.삭제    4.검색    5.리스트   0.프로그램 종료");
		System.out.println("============================================================");
		System.out.print("번호를 입력해주세요 >> ");		
	}
	
	
	
		
		
		


}

