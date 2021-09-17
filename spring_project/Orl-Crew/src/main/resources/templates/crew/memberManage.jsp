<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크루 관리</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
let crewIdx = '${crew.crewIdx}';
let sessionMemberIdx = '${sessionScope.memberVo.memberIdx}';
</script>
<script src="<c:url value='/js/crew/memberManage.js'/>"></script>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
<c:if test="${chk ne null && chk eq false}">
	<script>
		alert('해당 페이지에 접근 할 권한이 없습니다.');
		location.href="<c:url value='/'/>";
	</script>
</c:if>
	<div class="section">
		<div class="box">
			<%@ include file="/WEB-INF/frame/crew/crew-manage-nav.jsp"%>
			<div class="edit_section">
				<label for="crewname">크루명</label>
					<table id="crewMemberList" class="table table-hover">
					</table>
			</div>
		</div>
	</div>
</body>
</body>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</html>