<%@page import="com.bitcamp.orl.member.domain.MemberDto"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인중</title>
<c:if test="${findPw eq null}">
<script>
		alert('찾으시는 정보가 없습니다.');
		window.history.go(-1);
	</script>
</c:if>

<c:if test="${findPw ne null}">
	<script>
		alert('비밀번호를 메일로 발송하였습니다.');
		location.href='<c:url value="/member/login"/>';
	</script>
</c:if>
</head>

</html>