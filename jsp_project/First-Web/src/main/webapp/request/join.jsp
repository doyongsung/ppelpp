<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String pww = request.getParameter("pww");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    String userName = request.getParameter("username");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String userPhone = request.getParameter("userPhone");
    String sign = request.getParameter("sign");
    
    
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="request_css/naver_join.css">
    <title>네이버 회원가입</title>
</head>
<body>
    <div id="main-wrap">
<header>
    <div class="logo text-align">
        <a href="https://www.naver.com/" target="_blank" title="네이버 홈페이지">
        <img src="../images/NAVER_LOGO.png" class="image"></a>
    </div>
</header>
<form action="join_result.jsp" method="get">
<section>
    <article>
            <div class="sign up-id">
            <p>아이디</p>
            <input id ="userID"class="input-size"type="text" placeholder="@naver.com" name="id">
        </div>
        <div class="sign-up-pw">
            <p>비밀번호</p>
            <input id ="userPW"class="input-size"type="text" name="pw">
           </div>
           <div class="sign-up-pw2">
            <p>비밀번호 재확인</p>
            <input id="userRePw" class="input-size "type="text" name="pww">
         </div>
         <div class="sign up-name">
            <p>이름</p>
            <input id="userName" class="input-size"type="text" name="username">
           </div>
            <div class="sign up-bd">
                <p>생년월일</p>
                <input id="year" class="input-size3"type="text" placeholder="년(4자)" name="year">
            <select id="month" class ="button-size3" name="month" id="">
                <option value="월">월</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            <input id="day" class ="input-size3" type="text" placeholder="일" name="day">
           </div>
           <div class ="sign up-gender">
            <p>성별</p>
            <select id="gender" class="button-size"name="gender" id="">
                <option value="성별">성별</option>
                <option value="남자">남자</option>
                <option value="여자">여자</option>
                <option value="선택안함">선택안함</option>
            </select>
            </div>
            <div class="email">
            <p>본인 확인 이메일<span class="span">(선택)</span></p>
            <input id="userEmail" class="input-size"type="text" placeholder="선택입력" name="email">
            </div>
            <div class="phone">        
            <p>휴대전화</p>
            <select class="button-size"name="phone" id="phone">
                <option value="부천 +82">부천 +82</option>
                <option value="서울 +42">서울 +42</option>
                <option value="인천 +57">인천 +57</option>
                <option value="부산 +12">부산 +12</option>
                         
            <input id="userPhone" class="input-size2"type="text" placeholder="전화번호 입력" name="userPhone"/>
            <button class="button button-size2">인증번호 받기</button>                     
            <input id="sign" class="input-size input-back"type="text" placeholder="인증번호 입력하세요" name="sign">
            <input type="submit" class="button3 button-size" value="가입하기"/>
        </div>
    </article>
</section>
</form>
</div>    
</body>
</html>