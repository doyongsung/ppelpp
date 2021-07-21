<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    
    // DB 연결
    Connection conn = null;
    MemberDao dao = MemberDao.getInstance();
    
    
    conn = ConnectionProvider.getConnection();
    
    request.setAttribute("result", dao.getMemberList(conn));
    
    %>
    
    <!-- view 의 역할만 -->
    <jsp:forward page ="memberList_view.jsp"/>