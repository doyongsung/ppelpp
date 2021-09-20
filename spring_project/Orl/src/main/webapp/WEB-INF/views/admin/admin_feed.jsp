<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>크루 관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/admin/crew.css'/>">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/admin/header.jsp" %>


<div class="container">
  <h2>피드 관리</h2>
  <p> 찾을 내용을 입력해주세요!</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped table-hover">
    <thead>
      <tr>
        <th>IDX</th>
        <th>사진</th>
        <th>멤버닉네임</th>
        <th>멤버프로필</th>
        <th>설명</th>
        <th>해시태그</th>
        <th>관리</th>
      </tr>
    </thead>
    <tbody id="myTable">
    <c:forEach items="${feedList}" var="list">
      <tr>
        <td>${list.boardIdx}</td>
        <td><img src="<c:url value='/images/feed/feedw/uploadfile/${list.boardPhoto}'/>" width="100px" height="100px" ></td>
        <td style="max-width:100px">${list.memberNickname}</td>
        <td><img src="<c:url value='/images/member/${list.memberProfile}'/>" style="width:80px; height:80px;border-radius: 50%;"></td>
        <td style="max-width:400px">${list.boardDiscription}</td>
        <td style="max-width:300px">${list.hashtag}</td>
        <td>
             <a id = "deleteId" href="<c:url value='/admin/feed/delete?boardIdx=${list.boardIdx}'/>" onclick="if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a>
        </td>

      </tr>
      </c:forEach>
    
    </tbody>
  </table>
  
  
  
  
</div>





<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>
</html>
