package ch09;

public class currentTimeMillis {

		public static void main(String[] args) {
			
			long startTime = System.currentTimeMillis();

			long sTime = System.nanoTime();
			System.out.println(sTime);
			
			long sum = 0;
			
			for(int i=1; i<= 100000000; i++) {
				sum += i;
			}
					
			long endTime = System.currentTimeMillis();
			
			long checkTime = endTime-startTime;
			
			System.out.println("1~100,000,000 까지의 합은 "+sum+" 입니다.");
			System.out.println("1~100,000,000 까지의 합을 처리한 시간은 "+checkTime+" ms 입니다.");

		}

	}