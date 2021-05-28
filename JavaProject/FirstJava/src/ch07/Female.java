package ch07;

public class Female extends Person{	
	String email;
	Female(String name, int age, String email) {
			super(name, age);
			this.email = email;
		}
	
@Override
	 void PersonInfo() {
		   System.out.println("안녕하세요. 저는 " + name + "입니다 " + ageCal(age) + " 살입니다." + "이메일은 " + email + " 입니다.");
	   }
}
