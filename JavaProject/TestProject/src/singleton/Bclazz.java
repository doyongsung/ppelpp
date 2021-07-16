package singleton;

public class Bclazz {
	
	private SocketClient socketClient;
	
	public Bclazz() {
		this.socketClient = SocketClient.getInstance();
		
		
		//this.socketClient = new SocketClient();
		//->false;
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}


}
