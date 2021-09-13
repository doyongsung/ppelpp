<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인중</title>
<c:if test="${loginChk}">
<%	
	response.sendRedirect("/orl/index");
%>
</c:if>
<c:if test="${!loginChk}">
	<script>
		alert('아이디 또는 비밀번호가 일치하지 않습니다.');
		window.history.go(-1);
	</script>
</c:if>
</head>
</html>