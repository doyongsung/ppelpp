package ch03;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator Cal = new Calculator();
		System.out.println(Cal.add(5, 5));
		System.out.println(Cal.minus(5, 5));
		System.out.println(Cal.multi(5, 5));
		System.out.println(Cal.division(5, 5));
		Cal.length();
		Cal.area();

	}

}
