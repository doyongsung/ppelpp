package ch09;

public class currentTimeMillis {

	public static void main(String[] args) {

		long beforeTime = System.currentTimeMillis();
		
		int sum = 0;
		for(int i =0; i < 100000000; i++) {
				sum += i;			
		}
		System.out.println(sum);
		
		long secDiffTime =beforeTime/1000;
		System.out.println("시간차이(m) : " + secDiffTime);

	}

}
