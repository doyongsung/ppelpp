<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<script>
</script>
<body>

    <h1>멤버 정보 등록</h1>
    <hr>
    
    <fomr action="regMember.jsp" method ="post">
    <table>
    <tr>
    	<td>아이디</td>
    	<td><input type="text" name="memberId" required></td>
    </tr>
    <tr>
    	<td>비밀번호</td>
    	<td><input type="password" name="memberPw" required></td>
    </tr>
    <tr>
    	<td>이름</td>
    	<td><input type="text" name="memberName" required></td>
    </tr>
    <tr>
    	<td></td>
    	<td>
    	<input type="submit" value="등록">
    	<input type="reset">
    </td>
    </tr>
    </table>
    </fomr>
</body>
</html>