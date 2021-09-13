<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-member-mng.css'/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<div class="nav2">
	<ol>
		<li><a href="<c:url value='/crew/edit/${crew.crewIdx}'/>">크루 수정</a></li>
		<li><a href="<c:url value='/crew/memberManage/${crew.crewIdx}'/>">크루원 관리</a></li>
		<li><a href="<c:url value='/crew/remove/${crew.crewIdx}'/>">크루 삭제</a></li>
	</ol>
</div>