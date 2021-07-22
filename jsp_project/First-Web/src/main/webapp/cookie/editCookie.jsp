<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
      // 쿠키의 수정은 같은 이름의 쿠키를 만들어서 설정
      // 새로운 쿠키 생성
      // Cookie c = new Cookie("cname","king");
      // response.addCookie(c);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키 값이 변경되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>