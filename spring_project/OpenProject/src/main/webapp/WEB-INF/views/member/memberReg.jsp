
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:if test="${result==1}">
<script>
	alert('등록되었습니다.');
</script>
</c:if>
<c:if test="${result==0}">
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
	window.history.go(-1);
</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

<style>

</style>
<script>
</script>
</head>
<body>

<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	
	<div class="contents">

		<h2>회원가입</h2>
		<hr>
			<table>
				<tr>
					<td>아이디</td>
					<td>
					${memberRegRequest.memberid}
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					${memberRegRequest.password}
	               </td>
				</tr>
				<tr>
					<td>이름</td>
                	<td>
					${memberRegRequest.membername}
	               </td>
				</tr>
				<tr>
					<td>사진</td>
	               <td>
	               <img src='<c:url value="/uploadfile/${memberRegRequest.memberphoto.originalFilename}"/>'>
	               </td>
				</tr>

			</table>
	


	</div>


</body>
</html>