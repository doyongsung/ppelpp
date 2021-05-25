package test;

import java.util.Scanner;

public class Member2 {

	private String name;
	private String phon;
	private String major;
	private int grade;
	private String email;	
	private int HBD;
	private String address;
	
	
	
	Member2(){}
	
	Member2(String name, String phon, String major,int grade, String email, int HBD,String address){
		this.name = name;
		this.phon = phon;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.HBD = HBD;
		this.address = address;
	}
	Member2(String name, String phon, String major, int grade, String email ){
		this(name, phon, major, grade,email,0, "없음");
	}
	public void information() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phon);
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
		String phon = getInputString();
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
		
		Member2 mb = new Member2(name, phon, major, grade, email);
		Member2 mb2 = new Member2(name, phon, major,grade, email, HBD, address);
		
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
