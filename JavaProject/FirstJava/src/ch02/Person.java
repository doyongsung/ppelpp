package ch02;

public class Person {
	//클래수의 구성 -> 인스턴수 변수, 메소드
	
	// 회원이름을 저장하는 변수
	String name = "도용성"; //초기화를 생략가능
	
	//회원 전화 번호("000-0000-0000"//를 저장하는 변수
	String memberPhonNum = "000-0000-0000";
	
	//회워 주민번호 등록시 (00000000000 또는000000000000) 를 저장하는변수{
	String perNum1 = "74000000 - 000000000";
	long perNum2 = 7000000000L;
	
	//인스턴수 변수들의 데이터를 출력하는 메소드.
	void showData() {
		System.out.println("회원 이름 : " + this.name);
		System.out.println("회원의 주민번호1 : " + perNum1);
		System.out.println("회원의 주민번호2 : " + perNum2);
	}
	public static void main(String[] args) {
		
		//Person 인스턴스 생성
		Person person = new Person();
		
		System.out.println("이름 : " + person.name);
		person.name = "손흥민";
		person.showData();
	
					}

}
