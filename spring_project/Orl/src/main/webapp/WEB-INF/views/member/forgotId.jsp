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
    <link rel="stylesheet" href="<c:url value='/css/member/forgotId.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<div id="all">
    <section class="forgot-id">
        <h1>FORGOT ID</h1>
        <form method="post">
            <div class="input-area">
                <input type="text" id="memberName" name="memberName" autocomplete="off" required>
                <label for="memberName">NAME</label>
            </div>

            <div class="input-area">
                <input type="text" id="memberEmail" name="memberEmail" autocomplete="off" required>
                <label for="memberEmail">E-MAIL</label>
            </div>

            <div class="btn-area">
                <input type="submit" value="아이디 찾기">
            </div>
        </form>

    </section>
    </div>
</body>
</html>