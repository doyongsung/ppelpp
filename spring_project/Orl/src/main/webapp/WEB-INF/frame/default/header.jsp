<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/default/header.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<script defer src="https://kit.fontawesome.com/cccee664d4.js"
	crossorigin="anonymous"></script>
	<style>
.action .icon {
	padding:0;
	}
</style>
<script>
	function menuToggle() {
		const toggleMenu = document.querySelector('.menu');
		toggleMenu.classList.toggle('active')
	}
</script>
<div class="action">
	<div id="home" class="big-bg">
		<div class="header wrapper">
			<div class="logo">
				<span class="oly"><i class="fas fa-seedling"></i></span>
				<h1>
					<a href="<c:url value='/main/main'/>">오를래</a>
				</h1>
			</div>
			<div class="nav">
				<ul>
					<li><a href="<c:url value='/main/main'/>">MAIN</a></li>
					<li><a href="<c:url value='/mountain/mountainAllInfo'/>">HIKING</a></li>
					<li><a href="<c:url value='/crew/list'/>">CREW</a></li>
					<li><a href="<c:url value='/'/>">COMMUNITY</a></li>
					<li><div class="icon" onclick="menuToggle();">
							<a href="#"><i class="far fa-user"></i></a>
						</div></li>
				</ul>
			</div>
			<div class="menu">
				<ul>
					<c:if test="${sessionScope.member eq null}">
						<li><a href="<c:url value='/member/login'/>">로그인</a></li>
						<li><a href="<c:url value='/member/reg'/>">회원가입</a></li>
					</c:if>
					<c:if test="${sessionScope.member ne null}">
						<li><a href="<c:url value='/crew/list'/>">내 크루</a></li>
						<li><a href="#">내 피드</a></li>
						<li><a href="<c:url value='/member/mypage'/>">마이페이지</a></li>
						<li><a href="<c:url value='/member/logout'/>">로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
