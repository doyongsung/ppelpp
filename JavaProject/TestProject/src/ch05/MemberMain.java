package ch05;

public class MemberMain {

	public static void main(String[] args) {
		Member member = new Member("도용성","010-5508-6927","컴퓨터",3,"ppelpp@naver.com",4,"부천");
		Member member1 = new Member("도용성","010-5508-6927","컴퓨터",3,"ppelpp@naver.com");
		member.showInfo();
		member1.showInfo();
	}

}
