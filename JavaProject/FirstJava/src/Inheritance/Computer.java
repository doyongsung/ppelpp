package Inheritance;

public class Computer extends Product{

	Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
		//return "Computer [price=" + price + ", bonusPoint=" + bonusPoint + "]";
		return "Computer";
	}
	
	
}
