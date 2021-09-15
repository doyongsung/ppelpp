<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/css/crew/crew-list.css'/>">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
let cList = [];
const searchType = '${searchType}';
const	keyword = '${keyword}';
</script>
<script src="<c:url value='/js/crew/list.js'/>"></script>
</head>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<body>
	<div class="section">

		<div class="article">
			<h1>MY CREW</h1>
			<div class="article-crew">
				<div>
					<a href="<c:url value='/crew/insert'/>"> <img
						src="<c:url value='/images/crew/new.JPG'/>"></a>
				</div>
				<a href="<c:url value='/crew/insert'/>" class="text-bold">나의 크루
					만들기</a>
			</div>
			<c:if test="${myCrewList ne null and not empty myCrewList}">
				<c:forEach items="${myCrewList}" var="crew">
					<div class="article-crew">
						<div>
							<a href='<c:url value="/crew/detail?crewIdx=${crew.crewIdx}"/>'>
								<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>">
							</a>
						</div>
						<p>${crew.crewName}</p>
					</div>
				</c:forEach>
			</c:if>

		</div>

		<div class="container">
			<div class="search-box">
				<div class="dropdown">
					<h1>CREW</h1>
					<button class="curved" id="nameList">이름순으로 보기</button>
					<button class="curved" id="newestList">최신순으로 보기</button>
					<button class="curved" id="oldList">오랜된 순으로 보기</button>
				</div>
				<form action="" name="frm" id="form">
					<div class="search-drop">
						<div class="searchType">
							<select name="searchType" id="selectSearch">
								<option value="name">크루 이름</option>
								<option value="nickName">닉네임</option>
								<option value="tag">해시태그</option>
							</select>
							<div class="boxSearch">
								<span class="icon">
									<i id="searchType" class="fa fa-search" aria-hidden="true"></i>
								</span>
								<input id="search" class="search" type="text" name="keyword" placeholder="Type to search">
							</div>
						</div>
					</div>
				</form>
			</div>
			
			<div id="cList">
			</div>
			<div id="paging-div">
				<nav aria-label="Page navigation example">
					<ul class="pagination" id="pagination">
					</ul>
				</nav>
			</div>
		
		</div> <!-- container -->
	</div>
   <input type="button" onClick="sendLinkCustom();" value="Custom"/>
    <input type="button" onClick="sendLinkDefault();" value="Default"/>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>

<script type="text/javascript">
    function sendLinkCustom() {
        Kakao.init("4c67ad1e22af5dce9aa8353dfcdb85bd");
        Kakao.Link.sendCustom({
            templateId: 61617
        });
    }
</script>

<script>
try {
  function sendLinkDefault() {
    Kakao.init('4c67ad1e22af5dce9aa8353dfcdb85bd')
    Kakao.Link.sendDefault({
      objectType: 'feed',
      content: {
        title: '딸기 치즈 케익',
        description: '#케익 #딸기 #삼평동 #카페 #분위기 #소개팅',
        imageUrl:
          'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
        link: {
          mobileWebUrl: 'https://developers.kakao.com',
          webUrl: 'https://developers.kakao.com',
        },
      },
      social: {
        likeCount: 286,
        commentCount: 45,
        sharedCount: 845,
      },
      buttons: [
        {
          title: '웹으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
        {
          title: '앱으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
      ],
    })
  }
; window.kakaoDemoCallback && window.kakaoDemoCallback() }
catch(e) { window.kakaoDemoException && window.kakaoDemoException(e) }
</script>
</body>
</html>