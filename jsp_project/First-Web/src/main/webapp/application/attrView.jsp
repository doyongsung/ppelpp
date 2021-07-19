<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


   <%
   
   Enumeration e = application.getAttributeNames();
   
   while(e.hasMoreElements()){
	   String name = (String) e.nextElement();
	   out.println(name +"="+application.getAttribute(name)+ "<br><br>");
   }
   %>
   
   
   
   <h3><a href="remAttr.jsp">속성 삭제</a></h3>
</body>
</html>