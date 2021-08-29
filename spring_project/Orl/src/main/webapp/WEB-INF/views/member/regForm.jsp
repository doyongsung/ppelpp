<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="<c:url value='/css/member/reg.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
</head>
<body>
	<div class="reg_box">
		<div class="box2">
			<div class="logo">
				<h1>
					<a href="<c:url value='/'/>">오를래</a>
				</h1>
				<p>새로운 회원들과 함께 산을 탐험해보세요!</p>
			</div>
			<div class="naver_login">
				<button class="naver_btn">네이버로 로그인</button>
			</div>
			<div class="etc">또는</div>
			<div class="sign_section">
				<form method="post">
					<div class="int-area">
					
						<input type="text" name="memberId" id="id" autocomplete="off" required>
						<label for="id">ID</label>
						
					</div>
					<div class="int-area">
					
						<input type="password" name="memberPw" id="pw" autocomplete="off" required>
						<label for="pw">PASSWORD</label>
							
					</div>
					<div class="int-area">
					
						<input type="password" name="memberPw2" id="pw2" autocomplete="off" required> 
						<label for="pw2">PASSWORD 확인</label>
							
					</div>
					<div class="int-area">
					
						<input type="text" name="memberName" id="name" autocomplete="off" required> 
						<label for="name">이름</label>
							
					</div>
					<div class="int-area">
					
						<input type="text" name="memberEmail" id="email" autocomplete="off"	required> 
						<label for="email">E-mail</label>
							
					</div>
					<div class="int-area">
					
						<input type="text" name="memberNickname" id="nickname" autocomplete="off" required> 
						<label for="nickname">닉네임</label>
							
					</div>
					<div class="birth">
						<div class="int-area table_cell">
						
							<input type="number" name="year" id="year" autocomplete="off"	required> 
							<label for="year">년(4자)</label>
								
						</div>
						<div class="int-area table_cell select_opt">
							<select id="month" name="month">
								<option value="1">1월</option>
								<option value="2">2월</option>
								<option value="3">3월</option>
								<option value="4">4월</option>
								<option value="5">5월</option>
								<option value="6">6월</option>
								<option value="7">7월</option>
								<option value="8">8월</option>
								<option value="9">9월</option>
								<option value="10">10월</option>
								<option value="11">11월</option>
								<option value="12">12월</option>
							</select>
						</div>
						<div class="int-area table_cell">
						
							<input type="number" name="date" id="date" autocomplete="off" required> 
							<label for="date">일</label>
								
						</div>
					</div>
					<div class="btn-area">
						<input type="submit" value="가입">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>