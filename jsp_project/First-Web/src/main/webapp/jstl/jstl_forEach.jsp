<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

 	span {
 	color: red;
 	}
</style>
</head>
<body>
  	
  	
  	<!-- ${members}  -->
  	
  	<h1>회원 리스트</h1>
  	
  	<table border="1">
  		<tr>
  			<th>아이디</th>
  			<th>비밀번호</th>
  			<th>이름</th>
  			<th>index</th>
  			<th>count</th>
  		</tr>
  		                                        <!--count,index가 필요하면 varStatus사용 -->
  	<c:forEach items="${members}" var ="member1" varStatus="stat">
  		<tr>
  			<td>${member1.id}</td>
  			<td>${member1.pw}</td>
  			<td>
  			 <c:out value="${member1.name}"  escapeXml="false">
  			 <span>등록된 정보가 없습니다.</span>
  			 </c:out>
  			</td>
  			<td>${stat.index}</td>
  			<td>${stat.count}</td>
  		</tr>
  	</c:forEach>
  	</table>
  	
  	<hr>
  	
  	<h1>숫자 5번 반복</h1>
  	<c:forEach var="number" begin="1" end="5" step="1">
  	 <h3> ${number} </h3>	
  	</c:forEach>
  	
  	<hr>
  	                                         <!-- ,- 단위로 줄 바뀜 -->
  	<c:forTokens items="손흥민, 010-0000-9999, 런던" delims=",-" var="str" varStatus="stat">
  	<%--  ${str}  <br>--%>
  	<c:if test="${stat.index == 1}">
  	   <input type="text" value="${str}">
  	    
  	</c:if>
  	</c:forTokens>
</body>
</html>
