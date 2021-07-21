<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    List<Member> list = (List<Member>) request.getAttribute("result");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 
    td{
    text-align: center;
    padding: 5px 10px;
    }
    
    button{
    margin: 5px 0;
    }
</style>
<script>
</script>
</head>
<body>

<h1>멤버 리스트</h1>
<hr>

<button onclick="location.href='member_regForm.jsp';">멤버 정보 등록</button>

<table border ="1">

	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>가입 날짜</th>
		<th>관리</th>
	</tr>
	
	<%
	   if(list != null){
		   for(int i=0; i<list.size(); i++){
			   %>
			   <tr>
			   <td><%= list.get(i).getMemberId() %></td>
			   <td><%= list.get(i).getMemberPw() %></td>
			   <td><%= list.get(i).getMemberName() %></td>
			   <td><%= list.get(i).getRegdate() %></td>
			   <td>
			   <a href="#">수정</a>
			   <a href="#">삭제</a>
			   </td>
			   </tr>
			   <%
		   }
	   }
	
	%>
</table>

<script>
 
</script>
</body>
</html>