package ch07;

public class test {

	public static void main(String[] args) {
//	for(int i = 0; i < 10; i++){
//	     int sum = i;
//	     for(int j =i; j < 10+i; j++) {
//	    	 System.out.print((j < 10)? ++ sum :--sum); //10을 넘으면 값을 감소시켜 가며 출력한다.
//	     }
//	     System.out.println();
//	}
		
//		int[] score = {50,60,39,50,12,54,34};
//		int min =score[0];
//		int max =score[0];
//		
//		for(int i = 0; i< score.length; i++) {
//			if(score[i]> max) {
//				max = score[i];
//			}
//				if(score[i]<min) {
//					min = score[i];
//				}
//			
//		}
//		System.out.println("최대값" + max);
//		System.out.println("최초값" + min);
//	
//			}
//	
		int[] ball = new int[45];
		for(int i = 0; i< ball.length; i++) {
			ball[i] = i+1;
		}
		
		int temp = 0;
		
		for(int i =0; i< 1000; i++) {
			int j = (int) (Math.random() * 45);
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		
		//배열 ball의 앞에서 부터 5개를 얻는다.
		for(int i =0; i <=5; i++) {
			System.out.println(ball[i]+" ");
		}
	}		
}
