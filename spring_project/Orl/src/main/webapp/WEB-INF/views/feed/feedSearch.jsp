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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/feed/search.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
</head>


<body>
     <%@ include file="/WEB-INF/frame/default/header.jsp"%>

    <div id="container">
        <div id="contents">
            <div class="titleArea">
                <h2>SEARCH</h2>
            </div>
            
         <form id="frm" action="<c:url value="/feed/feedSearch"/>" method="post">
            <div class="boxContainer">
                <table class="elementsContainer">
                    <tr>
                        <td>
                            <input type="text" placeholder="검색하실 내용을 입력해주세요. " class="search" name="mySearch" required>
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
                
                <!--  닉네임 검색결과 --> 
               <c:if test="${not empty searchByNickname}">            
                <h3 class="selectArea">닉네임 검색 결과</h3>
                </c:if>
                
                
                <div id="selectList">
                    <c:forEach items="${searchByNickname}" var="list">
                        <div class="item">
                        <!--프로필 사진  -->
                           <a href="<c:url value="/feed/userFeed/${list.memberIdx}"/>">
                               <img class="ProfileImg" src="<c:url value="/images/member/profile/${list.memberProfile}"/>" alt="" width="160px" height="160px"  style="border-radius:50%">
                           </a>
                           
                           <!-- 닉네임 -->
                           <a href="<c:url value="/feed/userFeed/${list.memberIdx}"/>">
                           <span>${list.memberNickname}</span>
                           </a>
                         </div>
                    </c:forEach>
                 </div>
                <!--  닉네임 검색결과 끝 --> 
            
            
                 <!-- 해시태그 검색 -->
                <c:if test="${not empty searchByHashtag}">
                  <h3 class="selectArea">해시태그 검색결과</h3>
                </c:if>
          
          
                <div id="selectList">
                   <c:forEach items="${searchByHashtag}" var="list">
                         <div class="item">
                            <!-- 사진 -->
                             <a href="<c:url value="/feed/feedview/${list.memberIdx}&${list.boardIdx}"/>">
                                <img class="img" src="<c:url value="/images/feed/feedw/uploadfile/${list.boardPhoto}"/>" alt="" width="288px" height="288px">
                             </a>
                              <!--닉네임  -->
                             <a href="<c:url value="/feed/userFeed/${list.memberIdx}"/>">
                                   <span>${list.memberNickname}</span>
                             </a>
                         </div>
                   </c:forEach>
                </div>
            
            
            </div> <!--contents 끝  -->
        </div> <!-- container 끝 -->
   <!--  </div> -->


      <%@ include file="/WEB-INF/frame/default/footer.jsp"%>


</body>
</html>