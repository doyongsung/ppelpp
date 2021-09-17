<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FEED EDIT</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/feed/feededit.css'/>">
</head>
<body>

<!-- header -->
<%@ include file="/WEB-INF/frame/default/header.jsp"%>

	<!-- 전체 영역 시작 -->
	<div class="background">
	
	    <!-- 뒤로 가기 (피드 메인) -->
	    <div class="pageBack">
	        <button id="pageBack">
	            <img alt="pageBack" src="<c:url value="/images/feed/feedw/feedButton.png"/>">
	        </button>
	    </div>
	    <!-- 뒤로 가기 끝 -->
	
		<!-- 피드 수정 영역 시작 -->
	    <section class="container_edit">
	
	        <!-- 왼쪽 사진 영역 시작 -->
	        <section class="e_leftbox">
	
	            <!-- 피드 사진 -->
	            <img src="<c:url value="/images/feed/feedw/uploadfile/${selectFeedView.boardPhoto}"/>" alt="feed-img">
	
	            <!-- 태그 버튼 -->
	            <button>
	                <img src="<c:url value="/images/feed/feedw/icon-05.png"/>">
	            </button>
	
	        </section>
	        <!-- 왼쪽 사진 영역 끝 -->
	
	
	
	        <!-- 오른쪽 수정 영역 시작 -->
	        <section class="e_rightbox">
	
	            <!-- 게시자 프로필 영역 -->
	            <div class="e_profile">
	
	                <!-- 게시자 프로필 사진 -->
	                <div class="e_photo">
	                    <button onclick="location.href = '<c:url value="/feed/userFeed/${selectFeedView.memberIdx}"/>'">
	                        <img src="<c:url value="/images/member/profile/${member.memberProfile}"/>" alt="profile-img">
	                    </button>
	                </div>
	
	                <!-- 게시자 닉네임 -->
	                <a href="<c:url value="/feed/userFeed/${selectFeedView.memberIdx}"/>" class="e_nickname">${selectFeedView.memberNickname}</a>
	
	            </div>
	            <!-- 게시자 프로필 영역 끝 -->
	            
	            <!-- 수정 폼 시작 -->
	            <form method="post" enctype="multipart/form-data" id="feededitform">
	            	
	            	<!-- 게시글 영역 -->
		           	<div class="contentsbox">
						<p>게시글</p>
						<input type="text" value="${selectFeedView.boardDiscription}" name="boardDiscription" id="boardDiscription" autocomplete="off">
					</div>
					
					<!-- 해시태그 영역 -->
					<div class="hashtagbox">
						<p>해시태그</p>
						<input type="text" value="${selectFeedView.hashtag}" name="hashtag" id="hashtag" autocomplete="off">
					</div>
					
					<!-- 태그 영역 -->
					<div class="tagbox">
						<p>태그</p>
						<input type="text" value="${selectFeedView.tag}" name="tag" id="tag" autocomplete="off">
					</div>
						
					<!-- 게시 버튼 -->
					<div class="submit">
						<input type="submit" class="edit_submit" value="게시">
					</div>
					
				</form>
				<!-- 수정 폼 끝 -->
	
	        </section>
	        <!-- 오른쪽 수정 영역 끝 -->
	
	    </section>
	    <!-- 피드 수정 영역 끝 -->
	    
	</div>
	<!-- 전체 영역 끝 -->
	
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>



	<script>
	
		/* 수정 확인 */
		function edit_submit(){
			alert('수정되었습니다');
		}
		
	</script>
	
	
	
</body>
</html>