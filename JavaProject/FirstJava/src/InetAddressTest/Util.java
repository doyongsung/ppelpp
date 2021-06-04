package InetAddressTest;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Util {

	public static void close(ServerSocket ss) {
		
		if(ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void close(Socket s) {
		
		if(s != null){
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(FilterInputStream fin) {
		
		if(fin != null) {
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(FilterOutputStream fout) {
		if(fout != null) {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}

