<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크루 가입중</title>
</head>
<body>
	<c:if test="${resultCnt == 1}">
		<script>
			alert('크루에 가입 완료 되었습니다.');
			window.history.go(-1);
		</script>
	</c:if>
</body>
</html>