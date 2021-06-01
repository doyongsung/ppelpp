package ch07;

public class Male extends Person {

	public Male(String name, String personNumber) {
		super(name, personNumber);
	}

	@Override
	public void sayHello() {
		super.sayHello();
		System.out.println("나는 남자입니다.");
	}

}