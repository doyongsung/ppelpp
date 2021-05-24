package test;

public class Calculator {
	int add(int a, int b) { return a + b;}

    int sub (int a, int b) {return a - b;}
    int mul (int a, int b) {return a * b;}
    int iMul (int a, int b) {return a / b;}
    
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		System.out.println(cal.add(5, 5));
		System.out.println(cal.sub(5, 5));
		System.out.println(cal.mul(5, 5));
		System.out.println(cal.iMul(5, 5));

	}

}
