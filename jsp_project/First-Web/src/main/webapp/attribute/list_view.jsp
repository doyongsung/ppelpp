<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String[] players =(String[]) request.getAttribute("players");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view Page</title>
</head>
<body>
	<h1>선수 리스트</h1>
<%
	for(int i =0; i <players.length; i++){
		out.println(players[i]+"<br>");
	}
%>

</body>
</html>