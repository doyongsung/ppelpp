<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%@ include file="include/header.jsp" %>
     <hr>
     <%@ include file="include/nav.jsp" %>
     <div id="wrap">
     <%@ include file="include/news.jsp" %>
     <%@ include file="include/shopping.jsp" %>
          
</div>

<jsp:include page="footer.jsp">
<jsp:param value="test@gmail.com" name="email"/>
<jsp:param value="010-0000-0000" name="tel"/>
</jsp:include>a
</body>
</html>