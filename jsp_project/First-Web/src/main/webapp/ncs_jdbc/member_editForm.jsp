<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    
    // 사용자가 전달하는 아이디 받기
    String memberId = request.getParameter("memberId");
    
    // DB 연결
    Connection conn = null;
    MemberDao dao = null;
    try{
    conn = ConnectionProvider.getConnection();
    dao = MemberDao.getInstance();
    
    request.setAttribute("member", dao.selectById(conn,memberId));
	}catch(SQLException e){
	e.printStackTrace();
	}
    
    
    %>