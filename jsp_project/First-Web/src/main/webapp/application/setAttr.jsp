<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       application.setAttribute("name", "king");
       application.setAttribute("age", 11);  // 11 -> auto Boxing
      
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <h1>application 속성에 데이터를 저장</h1>
     <h3><a href="attrView.jsp">application 속성 확인</a></h3>
</body>
</html>