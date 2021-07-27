<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		
		conn = ConnectionProvider.getConnection();
		
		request.setAttribute("result",dao.selectList(conn));

%>
<jsp:forward page = "list_view.jsp"/>