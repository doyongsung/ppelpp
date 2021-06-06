package TestThread;

 class TimerRunnable implements Runnable{//class TimerThread extends Thread{
	@Override
	public void run() {
		for(int i =0; i < 5; i++) {
			System.out.format("%s : %d\n",Thread.currentThread().getName(),i);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e ) {
				
			}
		}
	}
	

}
public class TestThread {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Runnable r1 = new TimerRunnable();
		Thread th1 = new Thread(r1);
		th1.start();
		
		
		//다른방법
		new Thread(new TimerRunnable()).start();
		
		//다른방법
		new Thread(new Runnable(){//class TimerThread extends Thread{
			@Override
			public void run() {
				for(int i =100; i < 105; i++) {
					System.out.format("%s : %d\n",Thread.currentThread().getName(),i);
					try {
						Thread.sleep(500);
					}catch (InterruptedException e ) {
						
					}
				}
			}
			

		}).start();
		
		new Thread(() -> {
			for(int i =100; i < 105; i++) {
				System.out.format("%s : %d\n",Thread.currentThread().getName(),i);
				try {
					Thread.sleep(500);
				}catch (InterruptedException e ) {					
				}			
		        }
	}).start();
		
		System.out.println("main 스레드 끝");

		
	}
		
	}//다른방법
//	    System.out.format("%s : 메인 스레드를 시작합니다.\n", Thread.currentThread().getName());
//		Thread t1 = new TimerThread();
//		t1.start();
//		
//		new TimerThread().start();
//		System.out.format("%s : 메인 스레드를 종료합니다.\n", Thread.currentThread().getName());
//	}
//}
