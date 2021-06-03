package ch13;


class HighLowCountDown extends Thread {
	
	
	@Override
	public void run() {
		for(int i = 10; i >0; i--) {
			if(HighLowMain.chk) {
				return;
			}
			System.out.println(i);
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("시간초과로 패배하셨습니다.");
		System.exit(0);
	}
}
