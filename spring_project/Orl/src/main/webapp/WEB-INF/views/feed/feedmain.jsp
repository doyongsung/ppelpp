<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FEED MAIN</title>
<link rel="stylesheet" href="<c:url value='/css/feed/feedmain.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

	<!-- header -->
	<%@ include file="/WEB-INF/frame/default/header.jsp"%>
	
	<!-- 피드 올리기 모달창 -->
	<div class="modal_createfeed">
		<div class="modal_content_create">
			<section class="container_create">
				<%@ include file="/WEB-INF/views/feed/createfeed.jsp"%>
			</section>
		</div>
	</div>

	<!-- 메인 영역 -->
	<%@ include file="/WEB-INF/views/feed/feed.jsp"%>
	

	<!-- footer -->
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>

</body>
</html>