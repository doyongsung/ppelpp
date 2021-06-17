package ch04;

public class Ex4_8 {

	public static void main(String[] args) {
		int i =1; // 변수 i 의 scope(범위) 좁을수록 좋다. -선언위치부터 선언된 블럭의 끝까지
		
		// i = 10  (i)10 >= 1; (i) 10 9 8 7 6 5 4 
		//무한반복문 ture
		for(;;) {
			System.out.println("i="+i);
		}
		//무한반복으로 도니까 이곳으로 안옴
		//System.out.println();
	}

}
