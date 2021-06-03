package ch01;

public class Member {
	String name = "도용성";
	int age = 28;
	double height = 178.2;
	boolean hasBook = true;
	
	
	public static void main(String[] args) {
	Member member = new Member();
	System.out.println("이름: " + member.name);
	System.out.println("나이: " + member.age);
	System.out.println("키: " + member.height);
	System.out.println("책 보유: " + member.hasBook);
		}

}
