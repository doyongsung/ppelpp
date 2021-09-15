<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/member/forgotIdView.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<c:if test="${findId eq null}">
	<script>
		alert('아이디 찾기 실패');
		location.href='<c:url value="/index/"/>';
	</script>
</c:if>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
	<div id="all">
    <seciton class="show-id">
        <h1>FORGOT ID</h1>
        
        <!-- id 보여주는 영역 -->
        <div class="id-area">
            <div class="id-table">
                <h5>비밀번호를 찾으시려면 비밀번호 찾기를 이용해주세요.</h5>
            </div>

            <div class="id-table">
                아이디는 &nbsp <span>${findId}</span> &nbsp 입니다.
            </div>

        </div>

        <!--로그인하기, 비밀번호 찾기 영역 -->
        <div class="a-area">
            <a href="<c:url value='/member/forgotPw'/>" class="search-pw">비밀번호 찾기</a>
            <a href="<c:url value='/member/login'/>" class="login">LOGIN</a>
        </div>

    </seciton>
    </div>
</body>
</html>