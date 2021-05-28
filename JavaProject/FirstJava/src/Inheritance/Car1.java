package Inheritance;

public class Car1 {
	String color;
	int door;
	void drive() { // 운전하는 기능
	System.out.println("drive, Brrrr~");
	}
	void stop() { // 멈추는 기능
	System.out.println("stop!!!");
	}
	}
	class FireEngine extends Car1 { // 소방차
	void water() { // 물을 뿌리는 기능
	System.out.println("water!!!");
	}
	

	public static void main(String[] args) {
		Car1 car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		car = fe;// car = (Car)fe;에서 형변환이 생략된 형태다.
		// car.water(); 에러!! Car타입의 참조변수로는 water()를 호출할 수 없다.
		fe2 = (FireEngine) car; // 자손타입 <- 조상타입
		fe2.water();

	}

}
