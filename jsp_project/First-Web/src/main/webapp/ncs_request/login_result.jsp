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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    </style>
    <script>
    </script>
</head>
<body>
<h1> 로그인 정보</h1>
    <table border= "1">
        <tr>
            <td colspan="2">
                회원정보
            </td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><%= userName %></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><%= userPW %></td>
        </tr>
    </table>

</body>
</html>