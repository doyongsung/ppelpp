<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String idx = request.getParameter("idx");
    
    Connection conn = null;
    MemberDao dao = null;
    
    conn = ConnectionProvider.getConnection();
    dao = MemberDao.getInstance();
    
    request.setAttribute("member", dao.selectByIdx(conn, Integer.parseInt(idx)));
    %>
    
    <jsp:forward page ="editForm_view.jsp"/>
    