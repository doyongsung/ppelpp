package ch07;

public class Person {

	private String name;
	private String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	public void sayHello() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. 주민등록번호는 " + personNumber + " 입니다.");
	}
}