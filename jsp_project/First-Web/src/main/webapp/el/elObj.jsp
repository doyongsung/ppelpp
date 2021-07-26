<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
     
     request.setAttribute("name", "손흥민");
     session.setAttribute("name", "이강인");
     application.setAttribute("name", "메시");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  표현식 : <span><%= request.getAttribute("name") %></span> <br>
  
  표현언어1 : <span>${requestScope.name}</span> <br>
  내장객체의 표현식이 생략되었을때 규칙 <br>
  
  1. pageScope의 속성을 찾는다 -> 2. requestScope -> 3. sessionScope -> 4. applicationScope 순으로 찾는다. <br><br>
  표현언어2 : <span>${name}</span> <br><br>
  
  표현언어3 : <span>${sessionScope.name}</span> <br>
  표현언어4 : <span>${applicationScope.name}</span> <br>
  
  <hr>
  <!--표현식은 값이 없을때 null 직관적이고 더좋음 -->
  param.code : <%= request.getParameter("code") %> <br>
    
  param.code : ${param.code}
  
  <hr>
  pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %> <br>
  ${pageContext.request.requestURL} <br>
  ${pageContext.request.requestURI} <br>
  ${pageContext.request.contextPath} <br>
  
  <hr>                                    <!-- null은 아무것도 출력되지 않음  -->
  ${true} / ${false} / ${100} / ${'손흥민'} / ${null}
  
  
</body>
</html>