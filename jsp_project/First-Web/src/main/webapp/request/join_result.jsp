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
    <link rel="stylesheet" href="request_css/login.css">
    <title>네이버 회원가입</title>
</head>
<body>
<h1>회원가입 정보</h1>
<table border="1">
    <tr>
        <td>아이디</td>
        <td><%= id %></td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><%= pw %></td>
    </tr>
    <tr>
        <td>비밀번호 확인</td>
        <td><%= pww %></td>
    </tr>
    <tr>
        <td>이름</td>
        <td><%= userName %></td>
    </tr>
    <tr>
        <td>생년월일</td>
        <td><%= year %>
        <%= month %>
       <%= day %>
       </td>
    </tr>
    <tr>
        <td>성별</td>
        <td><%= gender %></td>
    </tr>
    <tr>
        <td>이메일</td>
        <td><%= email %></td>
    </tr>
    <tr>
        <td>지역</td>
        <td><%= phone %></td>
    </tr>
    <tr>
        <td>휴대전화</td>
        <td><%= userPhone %></td>
    </tr>
    <tr>
        <td>인증번호</td>
        <td><%= sign %></td>
    </tr>
</table>
        
</body>
</html>