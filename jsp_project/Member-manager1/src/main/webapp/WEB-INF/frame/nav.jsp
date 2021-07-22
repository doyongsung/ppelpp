<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
      Object loginObj = session.getAttribute("member");
    
    %>
    <nav>
    	<ul>
    	<li><a href="#">회원가입</a></li>
    	<li><a href="#">로그인</a></li>
    	<li><a href="#">로그아웃</a></li>
    	<li><a href="#">회원리스트</a></li>
    	</ul>
    </nav>