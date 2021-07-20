<%@page import="domain.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Dept> list = (List<Dept>) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}
	
	button {
		margin: 5px 15px;
	}
</style>
<script>
</script>
</head>
<body>
	
	<h1>부서 리스트</h1>
	<hr>
	
	<button>부서정보 등록</button>
	
	<table border=1>
		<tr>
			<th>부서번호</th>			
			<th>부서이름</th>
			<th>위치</th>
			<th>관리</th>
		</tr>
		
	<%
		if(list != null){
			for(int i=0; i<list.size(); i++){
				%>
		<tr>
			<td><%= list.get(i).getDeptno() %></td>			
			<td><%= list.get(i).getDname() %></td>
			<td><%= list.get(i).getLoc() %></td>
			<td><a href="dept_deitForm.jsp?deptno=<%= list.get(i).getDeptno() %>">수정</a> <a href="#">삭제</a></td>
		</tr>
				<%
			}
		}
	%>
		
		
	</table>

	<%--
		out.println(list);
	--%>










</body>
</html>