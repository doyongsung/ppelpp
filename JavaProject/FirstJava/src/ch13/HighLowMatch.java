package ch13;


import javax.swing.JOptionPane;

public class HighLowMatch extends Thread{

		public void run() {
			System.out.println("랜덤 숫자를 생성 합니다.");
			int comNumber = (int)(Math.random() * 100);
			
			while(!HighLowMain.chk) {			
				String number = JOptionPane.showInputDialog("숫자를 입력해주세요");
				System.out.println("숫자 " + number + "를 입력하셨습니다.");
				 int userNumber = Integer.parseInt(number);
				 int result = comNumber - userNumber;
				 if(result > 0) {
					 System.out.println("up");
				 }else if(result < 0) {
					 System.out.println("down");
				 }else {
					 System.out.println("correct");
					 System.out.println("게임에서 승리하셨습니다.");
					 HighLowMain.chk = true;
				 }
				 
			}
		
		}
		
	}


