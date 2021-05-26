package ch05;

import java.util.Scanner;

public class Member1 {

	private String name;
	private String phone;
	private String major;
	private int grade;
	private String email;	
	private int HBD;
	private String address;
	
	
	
	Member1(){}
	
	Member1(String name, String phone, String major,int grade, String email, int HBD,String address){
		this.name = name;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.HBD = HBD;
		this.address = address;
	}
	Member1(String name, String phone, String major, int grade, String email ){
		this(name, phone, major, grade,email,0, "없음");
	}
	public void information() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
		System.out.println("email : " + email);
		System.out.println("생일 : " + HBD);
		System.out.println("주소 : " + address);
	}
	
	
	public static void main(String[] args) {
		
		System.out.print("이름을 입력해주세요");
		String name = getInputString();
		System.out.print("전화번호를 입력해주세요");
		String phone = getInputString();
		System.out.print("전공을 입력해주세요");
		String major = getInputString();
		System.out.print("학년을 입력해주세요");
		int grade = getInputInteger();
		System.out.print("email을 입력해주세요");
		String email = getInputString();
		System.out.print("생일을 입력해주세요");
		int HBD = getInputInteger();
		System.out.print("주소를 입력해주세요");
		String address = getInputString();
		
		Member1 mb = new Member1(name, phone, major, grade, email);
		Member1 mb2 = new Member1(name, phone, major,grade, email, HBD, address);
		
		mb.information();
		mb2.information();
		
		
	
		
		
		

	}

	private static int getInputInteger() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	private static String getInputString() {
		Scanner sc = new Scanner(System.in);
		 return sc.nextLine();
	}
}
