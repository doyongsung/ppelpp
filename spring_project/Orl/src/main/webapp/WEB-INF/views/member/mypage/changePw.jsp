<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정중</title>
<c:if test="${result>0}">
   <script>
      alert('비밀변호가 변경되었습니다.');
      location.href = '<c:url value="/member/logout"/>';
   </script>
</c:if>
<c:if test="${result eq 0}">
   <script>
      alert('비밀번호를 잘못 입력하셨습니다. \n입력페이지로 다시 이동합니다.');
      window.history.go(-1);
   </script>
</c:if>
</head>
</html>