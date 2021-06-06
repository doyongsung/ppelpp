package ch10;

import java.util.Scanner;



public class NameInputTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		
		if(name != null && !name.trim().isEmpty()) {
			if(checkChar(name)) {
				System.out.println("입력하신 이름은 : " +name);
			}else {
				try {
					
					throw new BadIdInputException("잘못된 이름을 입력하셨습니다.");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

	}
public static boolean checkChar(String name) {
	boolean result = true;
	
	for(int i =0; i < name.length(); i++) {
		char c = name.charAt(i);
		if(!(c>='a'&&c<='z' || c >= 'A' && c <='Z' || c >= '0' && c<='9')) {
			result = false;
			break;
		}
	}
	
	return result;
}
}

