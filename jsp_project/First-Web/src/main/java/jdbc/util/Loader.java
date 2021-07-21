package jdbc.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 데이터베이스 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("드라이버 로드 성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}

	}

}