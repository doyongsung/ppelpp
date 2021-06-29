package ch06;
class Tv {
	//Tv의 속성(멤버변수)
	String color;
	boolean power;
	int channel;
	// tv의 기능(메서드)
	void power() {power = !power;}
	void channelUp() { ++channel;}
	void channelDown() {--channel;}
}
public class Ex6_1 {

	public static void main(String[] args) {
		
		Tv[] tvArr = new Tv[3];
		tvArr[0] = new Tv();
		tvArr[1] = new Tv();
		tvArr[2] = new Tv();
		tvArr[0].channel = 5;
		System.out.println(tvArr[0].channel);
//		Tv t = new Tv();
//		Tv t1 = new Tv();
//		t.channel = 7;
//		t.channelDown();
//		System.out.println("현재 채널은" + t.channel + "입니다.");
//		t.channelUp();
//		System.out.println("현재 채널은" + t.channel + "입니다.");
//		t1.channel = 5;
//		System.out.println("현재 채널은" + t1.channel + "입니다.");
//
//		t1 = t;
//		System.out.println(t1.channel);
		System.err.println("d");
	}

}
