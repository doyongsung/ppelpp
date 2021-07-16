package singleton;



import java.util.concurrent.atomic.AtomicLong;

import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import aop.AopBrowser;

public class Main {

	public static void main(String[] args) {

//		Aclazz aClazz = new Aclazz();
//		Bclazz bClazz = new Bclazz();
//		
//		SocketClient aClient = aClazz.getSocketClient();
//		SocketClient bClient = bClazz.getSocketClient();
//		
//		System.out.println("두개의 객체가 동일한가?");
//		System.out.println(aClient.equals(bClient));
//		
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
		//프록시 패턴
//		IBrowser browser = new BrowserProxy("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
//		
//		AtomicLong start = new AtomicLong();
//		AtomicLong end = new AtomicLong();
//		
		
		//aop
//		IBrowser aopBrowser = new AopBrowser("www.naver.com",
//				//람다식, 쓰레드
//				()->{
//					System.out.println("before");
//					start.set(System.currentTimeMillis());
//					
//				},
//				()->{
//					long now = System.currentTimeMillis();
//					end.set(now - start.get());
//					
//				}
//				);
//		aopBrowser.show();
//		System.out.println("Loading time : "+end.get());
//		
//		aopBrowser.show();
//		System.out.println("Loading time : "+end.get());
//		
	}

}
