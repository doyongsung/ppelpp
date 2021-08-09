<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result > 0}">
<script>
	alert('가입되었습니다.')
	location.href="<c:url value='/index'/>";
</script>
</c:if>
<c:if test="${result eq 0}">
<script>
		alert('가입에 실패했습니다.')
</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	<h1>회원가입</h1>
	<hr>                   
			<table>
				<tr>
					<td>아이디</td>
					<td>
						${memberid} / ${memberId} / ${regRequest.memberid} 
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						${password} / ${memberPassword} / ${regRequest.password}
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						${membername} / ${memberName} / ${regRequest.membername}
					</td>
				</tr>
				<tr>
					<td>사진</td>
					<td></td>
				</tr>
			</table>

</body>
</html>