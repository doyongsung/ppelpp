<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/default/header.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<script defer src="https://kit.fontawesome.com/cccee664d4.js"
	crossorigin="anonymous"></script>
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
					<a href="<c:url value='/'/>">오를래</a>
				</h1>
			</div>
			<div class="nav">
				<ul>
					<li><a href="<c:url value='/'/>">MAIN</a></li>
					<li><a href="<c:url value='/mountain/mountainAllInfo/'/>">MOUNTAIN</a></li>
					<li><a href="<c:url value='/crew/list'/>">CREW</a></li>
					<li><a href="<c:url value='/feed/feedmain'/>">FEED</a></li>
					<li><div class="icon" onclick="menuToggle();">
						    <c:if test="${sessionScope.memberVo eq null}">
                                <i class="far fa-user"></i>
                            </c:if>
                            <c:if test="${sessionScope.memberVo ne null }">
                                <i class="fas fa-user"></i>
                            </c:if>
						</div></li>
				</ul>
			</div>
			<div class="menu">
				<ul>
					<c:if test="${sessionScope.memberVo eq null}">
						<li><a href="<c:url value='/member/login'/>">로그인</a></li>
						<li><a href="<c:url value='/member/reg'/>">회원가입</a></li>
					</c:if>
					<c:if test="${sessionScope.memberVo ne null }">
						<li><a href="<c:url value='/crew/list'/>">내 크루</a></li>
						<li><a href="<c:url value='/feed/userfeed/${sessionScope.memberVo.memberIdx}'/>">내 피드</a></li>
						<li><a href="<c:url value='/member/mypage'/>">마이페이지</a></li>
						<li><a href="<c:url value='/member/logout'/>">로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
