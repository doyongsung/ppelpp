package singleton;

public class SocketClient {
	
	//null로 초기화
	private static  SocketClient socketClient = null;
	
	//default 생성자를 막고
	public SocketClient() {
		
	}
	
	//static을 통해서 getInstance 메소드 생성
	public static SocketClient getInstance() {
		//null 인경우 신규로 객체 생성 아닌경우 return
		if(socketClient == null) {
			socketClient = new SocketClient();
		}
		return socketClient;
	}

	public void connect() {
		System.out.println("connect");
	}
}
