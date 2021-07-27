<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Member member =(Member) request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>멤버 정보 수정</h1>
	<hr>
	
	<form action="editMember.jsp" method="post">
		<table>
			<tr>
		     	<td>idx</td>
		     	<td><input type="number" name="idx" value="<%= member.getIdx() %>" readonly></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberid" value="<%= member.getMemberid()%>" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" value="<%= member.getPassword()%>" required></td>
			</tr>
			<tr> 		
				<td>이름</td>
				<td><input type="text" name="membername" value="<%= member.getMembername()%>" required></td>
			</tr>
						<tr>
				<td></td>
				<td>
					<input type="submit" value="등록"> 
					<input type="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>