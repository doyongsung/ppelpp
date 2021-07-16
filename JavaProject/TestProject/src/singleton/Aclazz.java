package singleton;

public class Aclazz {
	
	private SocketClient socketClient;
	
	public Aclazz() {
		this.socketClient = SocketClient.getInstance();
		
		
		//this.socketClient = new SocketClient();
		//->false;
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}


}
