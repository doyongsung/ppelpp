package com.bitcamp.orl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApp1ApplicationTests {

	@Autowired
	private DataSource dataSource;

	private Connection conn;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println("dataSource >>>>>>" + dataSource);
		
		conn = dataSource.getConnection();
		System.out.println("Connection >>>>>>> " + conn);
		conn.close();
	}

}
