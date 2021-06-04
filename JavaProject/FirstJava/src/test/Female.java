package test;

public class Female extends Person{

	String phone;
	public Female(String name, String number,String phone) {
		super(name, number);
		this.phone = phone;

	}
	public void sayHello() {
		System.out.println("안녕하세요. 저는 " + name + " 입니다." + number + "입니다." + "전화번호는" + phone + "입니다.");
	}

}
