<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
      Object loginObj = session.getAttribute("member");
    
    %>
    <nav>
    	<ul>
    	<li><a href="regForm.jsp">회원가입</a></li>
    	<li><a href="loginForm.jsp">로그인</a></li>
    	<li><a href="logout.jsp">로그아웃</a></li>
    	<li><a href="list_view.jsp">회원리스트</a></li>
    	</ul>
    </nav>