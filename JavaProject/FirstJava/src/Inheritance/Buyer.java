package Inheritance;

public class Buyer {//extends Object 생략

	int money;
	int bonusPoint;
	Product[] item;
	int cnt; // 구매한 제품의 개수 ->배열의 입력 index 값.
	
	public Buyer(){//받을경우 int money, int bonusPoint) {
		//super(); 생략
		this.money = 10000;//money;
		this.bonusPoint = 0;//bonusPoint;
		this.item = new Product[10];
		this.cnt = 0;
	}

	//제품들을 구매
	void buy(Product p) {
		 //보유 금액을 확인하고 구매여부 체크
		if(this.money < p.price) {
			System.out.println("잔액이 부족 합니다.");
			return; // 메소드의 종료 , 값의 반환
		}
			
	    this.money -= p.price;
	    this.bonusPoint += p.bonusPoint;
	    
	    //구매내역에 제품을 추가
	    item[cnt++] = p;
	    //cnt++;
	    System.out.println(p + " 구매");
	}
	
	void summary() {
		//구매 상품 리스트, 구매금액의 총합 출력
		int sum = 0; //구매 총액
		int bonusPoint = 0;
		String itemList = "";
		
		// 배열을 반복 문을 이용해서 구매 내역을 완성
		for(int i =0; i < cnt; i++) {
			//금액의 합
			sum += item[i].price;
			//적립될 보너스 포인트
			bonusPoint += item[i].bonusPoint;
			//구매 상품 이름
			itemList += item[i] +", ";
		}
		System.out.println("구매하신 제품은 " + itemList + " 입니다.");
		System.out.println("구매하신 총액은 " + sum + " 입니다.");
		System.out.println("구매하신 제품의 적립 포인트는 " + bonusPoint + "입니다.");
		
	}
}