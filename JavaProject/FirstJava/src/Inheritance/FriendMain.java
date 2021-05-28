package Inheritance;
class Friend{
	String myName;
	Friend (String name){
		myName = name;
	}
	//오버라이딩
	public String toString() { //toString오버라이딩
		return "나의 이름은 "+myName + " 입니다.";
	}
	public boolean equals(Object o) {//equals 오버라이딩
		boolean result = false ;
		if(o !=null && o instanceof Friend) {
			Friend f= (Friend)o;
			if(myName.equals(f.myName)) { //-> myName.equals((Friend)o.myName)
				result = true;
			}
		}
		return result;//형변환 안되면 false넘어옴
	}
}
public class FriendMain {
	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");

		System.out.println(f1); //f1.toString() 호출
		System.out.println(f2); //f2.toString() 호출
		System.out.println(f3); //f3.toString() 호출

		System.out.println(f1==f3); //참조변수 주소값 비교
		System.out.println(f1.equals(f3)); //오버라이딩 안하면 위에랑 같은결과나옴. 거짓 ->오버라이딩해주어야함. //String은 오버라이딩 되어있음

		
	}
}