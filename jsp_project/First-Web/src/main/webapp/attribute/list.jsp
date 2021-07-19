<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       /* 핵심 처리*/
       String[] list = {"손흥민","이강인","황의조","박지성","차두리"};    
    
    //view 페이지에 선수리스트(결과)를 공유
    request.setAttribute("players", list);
    %>
    <jsp:forward page="list_view.jsp"/>;
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>