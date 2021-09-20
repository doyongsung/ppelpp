<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인-비디오</title>
<link rel="stylesheet" href="<c:url value='/css/main/main.css'/>">
<script src="https://kit.fontawesome.com/cccee664d4.js"
   crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet"
   href="<c:url value='/css/main/fullpage.min.css'/>">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
   integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
   crossorigin="anonymous"></script>
<script src="<c:url value='/js/main/fullpage.min.js'/>"></script>
<script src="<c:url value='/js/main/main.js'/>"></script>
</head>
<body>
   <main id="fullpage">
      <section class="section">
         <!--헤더 네비-->
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
                        <div class="icon" onclick="menuToggle();">
                           <c:if test="${sessionScope.memberVo eq null}">
                                      <i class="far fa-user"></i>
                                  </c:if>
                                  <c:if test="${sessionScope.memberVo ne null }">
                                      <i class="fas fa-user"></i>
                                  </c:if>
                        </div>
                     </ul>
                  </div>
                  <div class="menu">
                     <ul>
                        <c:if test="${sessionScope.memberVo eq null}">
                           <li><a href="<c:url value='/member/login'/>">로그인</a></li>
                           <li><a href="<c:url value='/member/reg'/>">회원가입</a></li>
                        </c:if>
                        <c:if test="${sessionScope.memberVo ne null}">
                           <li><a href="<c:url value='/crew/list'/>">내 크루</a></li>
                           <li><a
                              href="<c:url value='/feed/userfeed/${sessionScope.memberVo.memberIdx}'/>">내
                                 피드</a></li>
                           <li><a href="<c:url value='/member/mypage'/>">마이페이지</a></li>
                           <li><a href="<c:url value='/member/logout'/>">로그아웃</a></li>
                        </c:if>
                     </ul>
                  </div>
               </div>
               <div class="home_video">
                  <video loop autoplay="autoplay" muted="muted"
                     src="<c:url value="/video/hikingg.mov"/>"></video>
               </div>
               <div class="home-content wrapper">
                  <h2 class="page-title">
                     <!-- LET'S <br>CLIMB <br>TOGETHER -->
                     <img src="<c:url value='/images/crew/font.png'/>">
                  </h2>
                  <span class="main-button">
                     <a href="<c:url value='/mountain/mountainAllInfo/'/>">MOUNTAIN</a>
                  </span>
               </div>
            </div>
         </div>
      </section>

      <section class="section">

         <div id="home_2" class="big-bg">
            <div class="card">
               <a href="<c:url value='/crew/list'/>">
                  <img src="<c:url value='/images/crew/main5.png'/>" align="right">
               </a>
            </div>
            <div class="home_2_text">
               <!-- <h1>WANNA JOIN OUR CREWS?<br>WE ARE ALWAYS WITH YOU</h1> -->
               <h1>
                  혼자 오르지 않아도 괜찮아요.<br>당신과 함께할 크루를 찾아보세요!
               </h1>
               <p>WANNA JOIN OUR CREWS? WE ARE ALWAYS WITH YOU</p>
               <BUtton class="button1">
                  <a href="<c:url value='/crew/list'/>">CREW</a>
               </BUtton>
            </div>
         </div>
      </section>
      <section class="section">

         <div id="home_3" class="big-bg">
            <div class="card">
               <a href="<c:url value='/mountain/mountainAllInfo/'/>">
                  <img src="<c:url value='/images/crew/main3.jpg'/>">
               </a>
            </div>
            <div class="home_3_text">
               <h1>
                  오늘은 새로운 산 어때요?<br>한국의 아름다운 산을 찾아보세요
               </h1>
               <p></p>
               <BUtton class="button2">
                  <a href="<c:url value='/mountain/mountainAllInfo/'/>">MOUNTAIN</a>
               </BUtton>
            </div>
         </div>
      </section>
      <section class="section">
         <div id="last">
            <div id="home_4" class="big-bg">
               <div class="home_4_mini">
                  <div class="lastSection">
                     <div class="lastImg">
                        <a href="<c:url value='/feed/feedmain'/>"><img src="<c:url value='/images/crew/main1.jpg'/>"></a>
                        <div class="home_4_text">
                           <h1>당신의 하루를 공유해주세요</h1>
                           <p>HOW TO ENJOY YOUR HIKING TRIP?</p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <section class="section fp-auto-height">
         <%@ include file="/WEB-INF/frame/default/footer.jsp"%>
      </section>
   </main>
   <script>
      function menuToggle() {
         const toggleMenu = document.querySelector('.menu');
         toggleMenu.classList.toggle('active')
      }
   </script>
</body>
</html>