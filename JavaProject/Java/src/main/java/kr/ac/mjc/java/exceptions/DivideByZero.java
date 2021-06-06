package kr.ac.mjc.java.exceptions;

import java.util.Scanner;

public class DivideByZero {
	
	public void go() {//자동적으로 포함되있는것과 같음 throws ArithmeticException{
		Scanner sc = new Scanner(System.in);
		System.out.print("분자를 입력하세요 : ");
		int dividend = sc.nextInt();
		System.out.print("분모를 입력하세요.");
		int divisor = sc.nextInt();
		try {
			int result = dividend / divisor;
			System.out.format("%d / %d = %d\n", dividend,divisor, result);
			//System.out.println(dividend + "/" + divisor + "=" + dividend / divisor);
		} catch (ArithmeticException e) {
			//ArithmeticException이 발생할 경우에 처리하는 구문
			System.out.println(e);
		}
		
		sc.close();
		System.out.println("스캐너를 닫고 프로그램을 정상적으로 종료합니다.");
	}
	
	public void come() {
		try {
		go();
		}catch(ArithmeticException e) {
			
		}
	}

	public static void main(String[] args) {
	DivideByZero zero = new DivideByZero();
	
	zero.come();
	}

}
