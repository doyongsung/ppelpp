<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" href="<c:url value='/css/member/login.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous"></script>
</head>
<body>

	<section class="login-form">
	
		<h1>
			<a href="<c:url value='/'/>">오를래</a>
		</h1>
		
		<form action="<c:url value='/member/login'/>" method="post">
		
			<div class="int-area">
				<input type="text" name="memberId" id="id" value="${cookie.reid.value}" autocomplete="off" required>
				<label for="id">ID</label>
				<input type="hidden" name="redirectUri" value="${param.referer}">
			</div>
			
			<div class="int-area">
				<input type="password" name="memberPw" id="pw" autocomplete="off" required>
				<label for="pw">PASSWORD</label>
			</div>
			
			<div class="remember-id">
				<input type="checkbox" name="reid" value="on" ${cookie.reid.value ne null ? 'checked':''}>
				<div>아이디 기억하기</div>
			</div>

			<div class="btn-area">
				<input id="btn" type="submit" value="LOGIN">
			</div>
			
		</form>
		
		<div class="caption">
			<a href="#">아이디 찾기 &nbsp|&nbsp</a> <a href="#">비밀번호 찾기</a>
		</div>
		<!-- 네이버로 로그인 영역
		<form class="naver-login">
			<input type="submit" value="네이버 로그인">
		</form> -->
		<!-- 회원가입 -->
		<form class="join-us">
			 <input type="button" value="JOIN US" onclick="location.href='<c:url value='/member/reg'/>'">
		</form>
	</section>
	<Script>
		let id = $('#id');
		let pw = $('#pw');
		let btn = $('#btn');
		$(btn).on('click', function() {
			if ($(id).val() == "") {
				$(id).next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');
				}, 1500);
			} else if ($(pw).val() == "") {
				$(pw).next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');
				}, 1500);
			}
		});
	</Script>
</body>
</html>
