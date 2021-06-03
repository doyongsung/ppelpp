package ch05;

public class Member {

	String name;
	String phone;
	String major;
	int grade;
	String email;
	int birthDay;
	String address;
	
	
	 Member(String name, String phone, String major, int grade, String email, int birthDay, String address) {
		this.name = name;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthDay = birthDay;
		this.address = address;
	}
	 Member(String name, String phone, String major, int grade, String email){
		 this(name, phone, major, grade, email, 0,"null");
	 }
	 
	 public void showInfo() {
		 System.out.println("이름: " + name);
		 System.out.println("전화번호: " + phone);
		 System.out.println("전공: " + major);
		 System.out.println("학년: " + grade);
		 System.out.println("이메일: " + email);
		 System.out.println("생일: " + birthDay);
		 System.out.println("주소: " + address);
	 }
}
