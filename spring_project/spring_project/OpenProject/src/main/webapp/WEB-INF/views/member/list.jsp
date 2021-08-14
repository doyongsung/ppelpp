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
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>



	<div id="content">
		<h2>회원 리스트</h2>
		<hr>
			<form>
				검색타입
				<select name="searchType">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="both">아이디+이름</option>
				</select>
				검색 키워드<input type="text" name="keyword">
				<input type="submit" value="검색" >
			</form>
		<hr>

		<table class="border">
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
					<a class="border" href="edit?idx=${member.idx}">수정</a> 
					<a class="border" href="delete?idx=${member.idx}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>


	</div>












</body>
</html>