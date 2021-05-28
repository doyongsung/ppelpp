package ch07;

public class Male extends Person {
	String address;
  Male(String name, int age, String address) {
		super(name, age);
		this.address = address;
	}
 
  @Override
   void PersonInfo() {	  
	   System.out.println("안녕하세요. 저는 " + name + "입니다 " + ageCal(age) + " 살입니다." + "주소는 " + address + " 입니다.");
  }
}
