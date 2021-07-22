<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/member.css">
</head>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

 		<div class="contents">
 		
 		<h2>Login</h2>
 		<hr>
 	<table>
 		<tr>
 		<th>ID</th>
 		<td><input type="text" name="memberid"></td>
 		</tr>
 		<tr>
 		<th>PW</th>
 		<td><input type="password" name="password"></td>
 		</tr>
 		<tr>
 		<th></th>
 		<td><input type="checkbox" name="reid" value="on">아이디 기억하기</td>
 		</tr>
 		<tr>
 		<th></th>
 		<td><input type="submit"></td>
 		</tr>
 	</table>
 		
 		
 		</div>
</body>
</html>