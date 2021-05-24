package test;

public class Calculator {
	
	//메소드 -> 기능 ( 재료 -> 처리 -> 반환)
	//반환타입 메소드 이름(매개변수들){ 처리 구문}
	void plus (int n1, int n2) {
		System.out.println(n1 + n2);
	}
	
	void minus(int n1, int n2) {
		System.out.println(n1 - n2);
	}
	
	void multi(int n1, int n2) {
		System.out.println(n1 * n2);
	}
	
	void div(int n1, int n2) {
		System.out.println(n1 / n2);
	}
	
	public static void main(String[] args) {
		
		// 인스턴스 생성 -> 클래스의 정의가 필요 (필요한 변수, 필요한 메소드)
		// 클래스이름 참조변수 = new 클래스이름
		Calculator cal = new Calculator();
	    cal.plus(1, 2);
	    cal.minus(5, 5);
	    cal.multi(5, 5);
	    cal.div(5, 5);
		
	}
}

