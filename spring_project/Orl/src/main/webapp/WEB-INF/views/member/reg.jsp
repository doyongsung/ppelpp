<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입중</title>
<c:if test="${result>0}">
	<script>
		alert('등록되었습니다.');
		location.href = '<c:url value="/index"/>';
	</script>
</c:if>
<c:if test="${result eq 0}">
	<script>
		alert('아이디 중복 여부를 확인해주세요. \n입력페이지로 다시 이동합니다.');
		window.history.go(-1);
	</script>
</c:if>
</head>
</html>