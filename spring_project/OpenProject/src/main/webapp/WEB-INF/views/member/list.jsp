<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>



</head>
<body class="bg-light">

	<%--@ include file="/WEB-INF/views/frame/header.jsp"--%>
	<%--@ include file="/WEB-INF/views/frame/nav.jsp"--%>
<%@ include file="/WEB-INF/views/frame/bootstrap_header.jsp"%>


	<main role="main" class="container">
		
		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h2>회원 리스트</h2>
		<hr>
			<form class="form-inline">
				<label class="mr-2">검색타입</label>
				<select name="searchType" class="form-control mr-2">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="both">아이디+이름</option>
				</select>
				
				<label class="mr-2">검색 키워드</label>
				
				<input type="text" class="form-control mr-2" name="keyword">
				<input type="submit" class="form-control btn btn-success mr-2" value="검색" >
			</form>
		<hr>

		<table class="table">
			<tr>
				<th>IDX</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>사진</th>
				<th>가입일</th>
				<th>관리</th>
			</tr>
			
			<c:forEach items="${memberList}" var="member" >
			<tr>
				<td>${member.idx}</td>
				<td>${member.memberid}</td>
				<td>${member.password}</td>
				<td>${member.membername}</td>
				<td>${member.memberphoto}</td>
				<td><fmt:formatDate value="${member.date}" type="both"/></td>
				<td>
					<a class="btn btn-primary" href="edit?idx=${member.idx}">수정</a> 
					<a class="btn btn-danger" href="delete?idx=${member.idx}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</div>

	</main>


	<%@ include file="/WEB-INF/views/frame/footer.jsp" %> 



</body>
</html>