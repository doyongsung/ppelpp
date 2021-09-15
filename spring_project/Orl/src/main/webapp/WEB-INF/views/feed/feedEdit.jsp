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

<!-- background START -->
<div class="background">

    <!-- page back -->
    <div class="pageBack">
        <button id="pageBack">
            <img alt="pageBack" src="<c:url value="/images/feed/feedw/feedButton.png"/>">
        </button>
    </div>

    <section class="container_edit">

        <!-- feed photo START -->
        <section class="e_leftbox">

            <!-- feed photo -->
            <img src="<c:url value="/images/feed/feedw/uploadfile/${selectFeedView.boardPhoto}"/>" alt="feed-img">

            <!-- tag button -->
            <button>
                <img src="<c:url value="/images/feed/feedw/icon-05.png"/>">
            </button>

        </section>
        <!-- feed photo END -->



        <!-- right box START -->
        <section class="e_rightbox">

            <!-- profile START -->
            <div class="e_profile">

                <!-- feed creator profile photo -->
                <div class="e_photo">
                    <button onclick="location.href = '<c:url value="/feed/userFeed/${selectFeedView.memberIdx}"/>'">
                        <img src="<c:url value="/images/feed/feedw/defaultPhoto.jpg"/>" alt="profile-img">
                    </button>
                </div>

                <!-- feed creator nickname -->
                <a href="<c:url value="/feed/userFeed/${selectFeedView.memberIdx}"/>" class="e_nickname">${selectFeedView.memberNickname}</a>
                <!-- <button>팔로우</button> -->

            </div>
            <!-- profile END -->
            
            <!-- edit form -->
            <form method="post" enctype="multipart/form-data" id="feededitform">
	           	<div class="contentsbox">
					<p>게시글</p>
					<input type="text" value="${selectFeedView.boardDiscription}"
						name="boardDiscription" id="boardDiscription" autocomplete="off">
				</div>
	
				<div class="hashtagbox">
					<p>해시태그</p>
					<input type="text" value="${selectFeedView.hashtag}"
						name="hashtag" id="hashtag" autocomplete="off">
				</div>
	
				<div class="tagbox">
					<p>태그</p>
					<input type="text" value="${selectFeedView.tag}"
						name="tag" id="tag" autocomplete="off">
				</div>
					
				<!-- feed submit -->
				<div class="submit">
					<input type="submit" class="edit_submit" value="게시">
				</div>	
			</form>

        </section>
        <!-- right box END -->

    </section>
</div>
<!-- backgroung END -->



<!-- footer -->
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>



	<script>
	
		/* edit submit */
		function edit_submit(){
			alert('수정되었습니다');
			location.href='<c:url value="/feed/feedview/'+memberIdx+'&'+boardIdx+'"/>';
		}
		
	</script>
	
	
	
</body>
</html>