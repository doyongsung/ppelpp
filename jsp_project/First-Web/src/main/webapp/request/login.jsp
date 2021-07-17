<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String job = request.getParameter("job");
    String userName = request.getParameter("username");
    String userPW = request.getParameter("userpw");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, 
    maximum-scale-1.0, minimum-scale-1.0, user-scalable=no">
    <link rel="stylesheet" href="request_css/naver_login.css">
    <script src ="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
    <title>네이버 로그인</title>
    <style>
    </style>
</head>
<body>
    <div class="main"></div>
    <!--웹페이지 상단-->
    <header>
        <!--language select-->

    <form action="login_result.jsp" method="get">
        <div class="select-lang">
            <select class="selectbox" name="job">
                <option value="">한국어</option>
                <option value="">English</option>
                <option value="">中國語</option>
            </select>
        </div>
        <!--NAVER LOGO-->
        <div class="logo">
            <a href="https://www.naver.com/" target="_blank" title="네이버 홈페이지">
            <img src="../images/NAVER_LOGO.png" class="image"></a>
        </div>
    </header>

    <!--로그인 부분-->
    <section class ="login-wrap">
        <div class="login-id-wrap">
            <input placeholder="아이디" type="text" class="input-id" name="username"></div>
        <div class="login-pw-wrap">
            <input placeholder="비밀번호" type="password" class="input-pw" name="userpw"></div>
        <div class ="login-btn-wrap">
        <input type="submit"class="login-btn" value="로그인"/>
        </div>
        <div class="under-login">
            <span class="stay-check">
                <input type="checkbox" name="stay-btn" value ="stay" class="stay-checkbox">로그인 상태 유지
            </span>
                <span class="IP-check">IP 보안 ON
                </span>    
            </div>
        <div class="name">
           <p>더욱 간편한 로그인</p>
           <div class="second-login">
            <input type="text" value="QR코드 로그인">
            <input type="text" value="일회용 번호 로그인">
        </div>
        </div>
       
        <DIV class="nav">
            <div>       
            <a href="#">아이디 찾기</a>
            <span>l</span>
            <a href="#">비밀번호 찾기</a>
            <span>l</span>
            <a href="#">회원가입</a>
            <span>l</span>
        </DIV>
    </div>
    </section>
    </form>
  
</body>
</html>