package ch07;

public class Female extends Person {

	public Female(String name, String personNumber) {
		super(name, personNumber);
	}

	@Override
	public void sayHello() {
		super.sayHello();
		System.out.println("나는 여자입니다.");
	}
	
}