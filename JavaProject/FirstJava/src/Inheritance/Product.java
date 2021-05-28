package Inheritance;

public class Product {
	final int price; //한번초기화되면 금액은 변경되지않는다
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price / 10.0);
	}
}
	