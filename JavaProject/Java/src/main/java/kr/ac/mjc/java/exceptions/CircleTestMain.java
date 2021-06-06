package kr.ac.mjc.java.exceptions;

public class CircleTestMain {

	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		
			c1.setRadius(-5);
			System.out.format("c1의 반지름은 %d 입니다. \n",c1.getRadius());
		
			Circle c2 = new Circle(10);
			System.out.format("c2의 반지름은 %d 입니다. \n",c2.getRadius());
	}

}
