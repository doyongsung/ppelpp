package ch05;

public class MemberMain {

	public static void main(String[] args) {
		Member member1 = new Member("철수","010-0000-0000", "음악", 4, "ch@gmail.com", "2000-10-10", "서울");

		
		
		
		
		//member1.name = "영희";  //field 변수 private을 썻기때문에 참조 불가능
		member1.setName("영희");
	    member1.showInfo();
	    System.out.println(member1.getName());
	}

}
