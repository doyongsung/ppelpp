package InetAddressTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessageServer {

	public static void main(String[] args) {

		ServerSocket ss = null;
		Socket s = null;

		DataInputStream din = null;
		DataOutputStream dout = null;

		try {

			ss = new ServerSocket(8888);
			System.out.println("서버 실행");
			System.out.println("----------------------------");
			s = ss.accept();
			System.out.println("client 접속");
			System.out.println("----------------------------");

			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);

			String str1 = null; // 받는 메시지
			String str2 = ""; // 보내는 메시지

			while (!str2.equals("exit")) {

				str1 = din.readUTF();
				System.out.println("Client Message : " + str1);

				str2 = sc.nextLine();
				dout.writeUTF(str2);
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			Util.close(din);
			Util.close(dout);
			Util.close(s);
			Util.close(ss);

		}

	}

}