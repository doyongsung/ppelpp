package ch03;

public class Calculator {
	double PI=3.141592;
    int r = 10;

	public int add(int num ,int num1) {
		return num + num1;
	}
	public int minus(int num ,int num1) {
		return num - num1;
	}
	public int multi(int num ,int num1) {
		return num * num1;
	}
	public double division(double num ,double num1) {
		return (double)num / num1;
	}
	public void length() {
		
	    double length = PI * r * r;
	    System.out.println("원의 넓이: " + length);
	}
	public void area() {
		double area = 2 * PI * r;
		System.out.println("원의 둘레: " + area);
	}
	
}
