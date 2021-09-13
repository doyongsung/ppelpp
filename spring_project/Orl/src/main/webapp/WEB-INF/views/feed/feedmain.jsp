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

	<!-- modal_feedview -->
	<div class="modal_feedview">
		<div class="modal_content">
			<section class="container">
				<%@ include file="/WEB-INF/views/feed/feedview.jsp"%>
			</section>
		</div>
	</div>
	
	<!-- modal_createfeed -->
	<div class="modal_createfeed">
		<div class="modal_content">
			<section class="container">
				<%@ include file="/WEB-INF/views/feed/createfeed.jsp"%>
			</section>
		</div>
	</div>

	<!-- feed main -->
	<%@ include file="/WEB-INF/views/feed/feed.jsp"%>
	

	<!-- footer -->
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>



	<script>
	
		
		
	</script>

</body>
</html>