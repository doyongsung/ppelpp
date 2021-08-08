package com.bitcamp.op;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;


import org.junit.Test;

public class mysqlTest1 {
	 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	 private static final String URL = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	 private static final String USER = "bit"; //DB 사용자명
	 private static final String PW = "1234";   //DB 사용자 비밀번호
	 
	 @Test
	 public void testConnection() throws Exception{
	  Class.forName(DRIVER);
	  
	  try(Connection con = DriverManager.getConnection(URL, USER, PW)){
	   System.out.println("성공");
	   System.out.println(con);
	  }catch (Exception e) {
	   System.out.println("에러발생");
	   e.printStackTrace();
	  }
	 }
}
	
