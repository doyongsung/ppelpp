package test;

import java.util.*;

// java.lang.*;
public class Calculator {
	
	//메소드 -> 기능 ( 재료 -> 처리 -> 반환)
	//반환타입 메소드 이름(매개변수들){ 처리 구문}
//	void plus (int n1, int n2) {
//		System.out.println(n1 + n2);
//	}
//	
//	void minus(int n1, int n2) {
//		System.out.println(n1 - n2);
//	}
//	
//	void multi(int n1, int n2) {
//		System.out.println(n1 * n2);
//	}
//	
//	void div(int n1, int n2) {
//		System.out.println(n1 / n2);
//	}
	long plus(int num1, int num2) {
//		long result = num1 + num2;
//		return result;
		return (long)num1 + num2;
	}
	long minus(int num1, int num2) {

		return (long)num1 - num2;
	}
	long multi(int num1, int num2) {

		return (long)num1 * num2;
	}
	float div(int num1, int num2) {

		return (float)num1 / num2;
	}
	// 클래스 이름 -> 대문자 시작 캐멀 케이스
	// 변수 이름 -> 소문자 시작 캐멀 케이스
	// 상수 -> 모두 대문자
	double pi = 3.14d;
	float pi1 = 3.14f;
	final float PI = 3.14f; //상수
	
	float circum(float r) {
		return 2 * PI * r; // int * float *float
	}
	
	float cirArea(float r) {
		return PI * r * r; // float * float * float
	}
//	   public static double Perimeter(double radius){
//	        return 2 * Math.PI * radius;
//	    }
//
//	   public static double area(double radius){
//	        return  radius * radius * Math.PI;
//	    }

		
	public static void main(String[] args) {
//		int getRadius = Integer.parseInt(sc.nextLine());
		// 인스턴스 생성 -> 클래스의 정의가 필요 (필요한 변수, 필요한 메소드)
		// 클래스이름 참조변수 = new 클래스이름
		Calculator cal = new Calculator();
	    
		System.out.print("반지름을 입력해주세요 : ");
		 float num = getInputInteger();
		 System.out.println("원둘레 :" + cal.circum(num));
		 System.out.println("원넓이 :" + cal.cirArea(num));
//        System.out.print("반지름을 입력해주세요 : ");
//        double radius = getInputInteger();
//        System.out.println("원둘레 : " +Calculator.Perimeter(radius));
//        System.out.println("원넓이 : " +Calculator.area(radius));
//        
        System.out.print("덧셈을 합니다. \n 숫자 1을 입력해주세요." );
        int num1 = getInputInteger();
        System.out.print(" 숫자 2를 입력해주세요.");
        int num2 = getInputInteger();
        
        System.out.println(num1 +" + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 +" - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 +" * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 +" / " + num2 + " = " + (num1 / num2));
        
        System.out.println("반지름을 입력해주세요.");
        float r = getInputInteger();
        
        System.out.print("입력 받은 반지름의 길이 : " + r);
        System.out.println("원의 둘레 : " + cal.circum(r));
        System.out.println("원의 넓이 : " + cal.cirArea(r));
        
//	    System.out.println(cal.plus(5, 4));
//	    System.out.println(cal.minus(5, 4));
//	    System.out.println(cal.multi(5, 4));
//	    System.out.println(cal.div(5, 4));
	    
	    //cal.plus(5, 5);
	    //cal.minus(5, 5);
	    //cal.multi(5, 5);
	    //cal.div(5, 5);
    }
private static int getInputInteger() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return  Integer.parseInt(input);
}
}

