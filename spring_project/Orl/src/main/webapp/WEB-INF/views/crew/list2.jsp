<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-list.css'/>">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="section">
	
		<div class="article">
			<h1>MY CREW</h1>

			<c:if test="${myCrewList ne null and not empty myCrewList}">
				<c:forEach items="${myCrewList}" var="crew">
				
					<div class="article-crew">
						<div>
							<a href='<c:url value="/crew/detail/${crew.crewIdx}"/>'>
							<img src="<c:url value="/images/hiking2"/>"></a>
						</div>
						<p>${crew.crewName}</p>
					</div>
					
				</c:forEach>
			</c:if>

		</div>
		
		<div class="container">
		
			<div class="search-box">
				<h1>POPULAR CREW</h1>
				<form>
					<input class="search-txt" type="text" name="" placeholder="Type to search"> 
				</form>
				<a class="search-btn" onclick="menuToggle();" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
			</div>
			
			<div class="row justify-content-center">
			
				<c:if test="${crewListAll ne null and not empty crewListAll}">
					<c:forEach items="${crewListAll}" var="crew">
					
						<div class="col-md-4">
							<div class="card shadow" style="width: 25rem; height: 35rem;">
								<div class="inner">
									<div>
										<a href="<c:url value='/crew/detail/${crew.crewIdx}'/>"> 
										<img src="<c:url value='/images/hiking2.jpg'/>" class="card-img-top" alt="card image cap"></a>
									</div>
								</div>
								<div class="card-body text-left">
									<h4 class="card-title">크루 이름: ${crew.crewName}</h4>
									<p class="card-text">크루장: ${crew.memberNickName}</p>
									<p class="card-text">크루소개 : ${crew.crewDiscription}</p>
									<a href="#" class="btn btn-success">GO</a>
								</div>
							</div>
						</div>
					
					</c:forEach>
				</c:if>
			</div>
		</div>
		
		
		<div class="page">
			<nav aria-label="Page navigation example">
			
				<c:if test="${listView.totalPageNum>0}">
					<ul class="pagination">
					
						<c:forEach begin="1" end="${listView.totalPageNum}" var="num">
							<li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="<c:url value=''/>">1</a></li>
							<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
							</a></li>
						</c:forEach>
						
					</ul>
				</c:if>
				
			</nav>
		</div>
		
	</div>
	
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>