<%@page import="service.MemberRegService"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int result = MemberRegService.getInstance().regMember(request);
	//request.setAttribute("result", result);
%>
<jsp:forward page="reg_view.jsp"/>
