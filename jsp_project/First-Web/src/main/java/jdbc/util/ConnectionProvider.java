package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {

		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String user = "bit";
		String pw = "1234";

		try {
	        Class.forName("com.mysql.jdbc.Driver");
	 
	} catch (ClassNotFoundException e) {
	}
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}

}