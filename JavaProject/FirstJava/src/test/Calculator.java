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
}
//	int add(int a, int b) { return a + b;}
//
//    int sub (int a, int b) {return a - b;}
//    int mul (int a, int b) {return a * b;}
//    int iMul (int a, int b) {return a / b;}
//    
//	public static void main(String[] args) {
//		
//		Calculator cal = new Calculator();
//		
//		System.out.println(cal.add(5, 5));
//		System.out.println(cal.sub(5, 5));
//		System.out.println(cal.mul(5, 5));
//		System.out.println(cal.iMul(5, 5));
//
//	}
//
//}
