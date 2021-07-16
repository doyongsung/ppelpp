package decorator;

import Facade.Ftp;
import Facade.Reader;
import Facade.Writer;
import Observer.Button;
import Observer.IButtonListener;

public class Main {


	public static void main(String[] args) {
		
		
//		Ftp ftpClient = new Ftp("www.foo.co.kr",22,"/home/etc");
//		ftpClient.connect();
//		ftpClient.moveDirectory();
//		
//		
//		Writer writer = new Writer("text.tmp");
//		writer.fileConnect();
//		writer.write();
//		
//		Reader reader = new Reader("text.tmp");
//		reader.fileConnect();
//		reader.fileRead();
//		
//		reader.fileDisconnect();
//		writer.fileDisconnect();
//		ftpClient.disConnect();
//		
		
		//파사드 패턴
		SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
		sftpClient.connect();
		
		sftpClient.writer();
		
		sftpClient.read();
		
		sftpClient.disConnect();
		
		
		
		
		
		
		
		
		//데코레이터 패턴 modelPrice 생성자에 직접입력
//		ICar audi = new Audi(1000);
//		audi.showPrice();
//		
//		// a3
//		ICar audi3 = new A3(audi, "A3");
//		audi3.showPrice();
//		
//		// a4
//		ICar audi4 = new A4(audi, "A4");
//		audi4.showPrice();
//		
//		
//		// a5
//		ICar audi5 = new A5(audi, "A5");
//		audi5.showPrice();
		
		
		//옵저버 패턴
//		Button button = new Button("버튼");
//	    
//		button.addListener(new IButtonListener() {
//
//			@Override
//			public void clickEvent(String event) {
//				System.out.println(event);
//
//				
//			}
//			
//		});
//		
//		
//		button.click("메시지 전달 : click 1");
//		button.click("메시지 전달 : click 2");
//		button.click("메시지 전달 : click 3");
//		button.click("메시지 전달 : click 4");
//
	}

}
