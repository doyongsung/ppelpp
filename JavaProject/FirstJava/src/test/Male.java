package test;

public class Male extends Person{
   
   String address;
	
	public Male(String name, String number,String address) {
		super(name, number);
		this.address = address;
	}
	public void sayHello() {
		System.out.println("안녕하세요. 저는 " + name + " 입니다." + number + "입니다." + "주소는" + address + "입니다.");
	}

}
