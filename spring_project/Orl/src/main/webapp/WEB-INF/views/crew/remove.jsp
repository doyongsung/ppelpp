<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
<c:if test="${chk ne null && chk eq false}">
	<script>
		alert('해당 페이지에 접근 할 권한이 없습니다.');
		location.href="<c:url value='/'/>";
	</script>
</c:if>
<c:if test="${result eq 0}">
	<script>
		alert('크루명이 일치하지 않습니다.');
	</script>
</c:if>
<c:if test="${result eq 1}">
	<script>
		alert('크루를 삭제했습니다.');
		location.href="<c:url value='/'/>";
	</script>
</c:if>
	<div class="section">
		<div class="box">
			<%@ include file="/WEB-INF/frame/crew/crew-manage-nav.jsp"%>
			<div class="edit_section">
				<form method="post">
					<table>
						<tr>
							<td><label for="crewname">크루명</label></td>
							<td>
								<p id="crewname" class="text_bold">${crew.crewName}</p>
							</td>
						</tr>
						<tr>
							<td><label for="confirm">확인</label></td>
							<td><input type="text" class="form-control remove_input" name="crewName"
								placeholder="삭제를 원하시면 크루명을 입력해주세요."></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="삭제"
								class="form-control btn-secondary"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</html>