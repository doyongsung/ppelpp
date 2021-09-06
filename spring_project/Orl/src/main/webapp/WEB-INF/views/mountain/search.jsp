<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>검색결과보기</title>
  <link rel="stylesheet" href="<c:url value='/css/mountain/search.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">

</head>


<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>

<div id="container">
  <div id="contents">
    <div class="titleArea">
      <h2>SEARCH</h2>
    </div>
    <form id="frm">
      <div class="boxContainer">
        <table class="elementsContainer">
          <tr>
            <td>
              <input type="text" placeholder="검색하실 내용을 입력해주세요. " class="search" name="mysearch" required>
            </td>
            <td>
              <label for="button">
                <i id="submit" class="fas fa-search"></i>
              </label>
              <input type="submit" id="button" style="display:none">
            </td>
          </tr>
        </table>

      </div>
    </form>

    <c:if test="${not empty mountainList}">
      <h3 class="selectArea">해당 산의 검색결과</h3>
    </c:if>
    <div id="selectList">
      <c:forEach items="${mountainList}" var="list">
        <div class="item">
          <a href="${pageContext.request.contextPath}/mountain/mountainDetailInfo?mountainName=${list.mountainName}">
            <img class="img" src="https://www.forest.go.kr/images/data/down/mountain/${list.img}" alt="" width="200px" height="200px">
          </a>
          <span>#${list.mountainName}</span>
        </div>
      </c:forEach>
    </div>

    <c:if test="${not empty mountainList2}">
      <h3 class="selectArea">해당 지역의 검색결과</h3>
    </c:if>
    <div id="selectList">
      <c:forEach items="${mountainList2}" var="list">
        <div class="item">
          <a href="${pageContext.request.contextPath}/mountain/mountainDetailInfo?mountainName=${list.mountainName}">
            <img class="img" src="https://www.forest.go.kr/images/data/down/mountain/${list.img}" alt="" width="200px" height="200px">
          </a>
          <span>#${list.mountainName}</span>
        </div>
      </c:forEach>
    </div>


  </div>
</div>
<!--  </div>
-->


<%@ include file="/WEB-INF/frame/default/footer.jsp"%>


</body>
</html>