<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/css/crew/crew-list.css'/>">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	let cList = [];
	const searchType = '${searchType}';
	const keyword = '${keyword}';
	/*부트서버*/
	const url = 'http://localhost:8081';
	/*뷰 서버*/	
	const url2 = '${pageContext.request.contextPath}';
</script>
<script src="<c:url value='/js/crew/list.js'/>"></script>
</head>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<body>
	<div class="section">

		<div class="article">
			<h1>MY CREW</h1>
			<div class="article-crew">
				<div>
					<a href="<c:url value='/crew/insert'/>">
					<img src="<c:url value='/images/crew/new.JPG'/>">
					</a>
				</div>
				<a href="<c:url value='/crew/insert'/>" class="text-bold">나의 크루
					만들기</a>
			</div>
			<c:if test="${myCrewList ne null and not empty myCrewList}">
				<c:forEach items="${myCrewList}" var="crew">
					<div class="article-crew">
						<div>
							<a href='<c:url value="/crew/detail?crewIdx=${crew.crewIdx}"/>'>
								<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>">
							</a>
						</div>
						<p>${crew.crewName}</p>
					</div>
				</c:forEach>
			</c:if>

		</div>

		<div class="container">
			<div class="search-box">
				<div class="dropdown">
					<h1>CREW</h1>
					<div class="dropdown-button">
						<button class="curved" id="newestList">최신순 보기</button>
						<button class="curved" id="nameList">이름순 보기</button>
						<button class="curved" id="oldList">오래된 순 보기</button>
					</div>
				</div>
				<form action="" name="frm" id="form">
					<div class="search-drop">
						<div class="searchType">
							<label for="selectbox">크루이름</label> <select name="searchType"
								id="selectSearch" title="검색">
								<option value="name" selected="selected">크루 이름</option>
								<option value="nickName">닉네임</option>
								<option value="tag">해시태그</option>
							</select>
						</div>
						<div class="boxSearch">
							<span class="icon"> <label for="button"> <i
									id="searchType" class="fas fa-search" aria-hidden="true"></i>
							</label> <input type="submit" id="button" style="display: none">
							</span> <input autocomplete="off" id="search" class="search" type="text"
								name="keyword" placeholder="Type to search">
						</div>

					</div>
				</form>
			</div>

			<div id="cList"></div>
			<div class="paging-div">
				<nav aria-label="Page navigation example">
					<ul class="pagination" id="pagination">
					</ul>
				</nav>
			</div>
		</div>
		<!-- container -->
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>