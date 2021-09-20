<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE FEED</title>
	<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/feed/createfeed.css'/>">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body>

	<!-- 피드 작성 폼 -->
	<form method="post" enctype="multipart/form-data" id="feedform">
		
		<!-- 모달창 시작 -->
		<section class="container_create">
		
			<!-- 모달창 종료 버튼 -->
			<button type="reset" class="c_close">
				<img src="<c:url value="/images/feed/feedw/close.png"/>">
			</button>

			<!-- 왼쪽 프리뷰 영역 -->
			<section class="c_leftbox" id="image_container">
				<img id="preview-img" src="<c:url value="/images/feed/feedw/noImage.png"/>">
			</section>

			<!-- 오른쪽 컨텐츠 영역 -->
			<section class="c_rightbox">
			
				<!-- 작성자 프로필 영역 -->
				<div class="c_profile">
				
					<!-- 작성자 프로필 -->
					<div class="c_photo">
						<button onclick="location.href = '<c:url value="/feed/userfeed/${sessionScope.memberVo.memberIdx}"/>'">	<!-- 수정(09.17.우리) -->
							<img src="<c:url value="/images/member/profile/${member.memberProfile}"/>" alt="profile-img">	<!-- 수정(09.17.우리) -->
						</button>
					</div>
					
					<!-- 작성자 닉네임 -->
					<a href="<c:url value="/feed/userFeed/${sessionScope.memberVo.memberIdx}"/>"
						class="c_nickname">${sessionScope.memberVo.memberNickname}
					</a>

					<!-- 파일 업로드 버튼 -->
					<div class="filebox">
						<label for="fileupload">사진선택</label>
						<input type="file" name="boardPhoto" id="fileupload" onchange="readURL(this);">
					</div>
					
				</div>
				<!-- 작성자 프로필 영역 끝 -->
				
				<!-- 입력 영역 -->
					<!-- 게시글 입력 -->
					<div class="contentsbox">
						<p>게시글</p>
						<textarea placeholder="게시글을 입력해주세요" name="boardDiscription" id="boardDiscription" autocomplete="off"></textarea>	<!-- 수정 (09.17.우리) -->
					</div>
					
					<!-- 해시태그 입력 -->
					<div class="hashtagbox">
						<p>해시태그</p>
						<input type="text" placeholder="#해시태그 입력" name="hashtag" id="hashtag" autocomplete="off">
					</div>
					
					<!-- 태그 입력 -->
					<div class="tagbox">
						<p>태그</p>
						<input type="text" placeholder="@닉네임 입력" name="tag" id="tag" autocomplete="off">
					</div>
					
					<!-- 피드 작성 버튼 -->
					<div class="submit">
						<input type="submit" class="feed_submit" value="게시">
					</div>
				<!-- 입력 영역 끝 -->
				
			</section>
			<!-- 오른쪽 컨텐츠 영역 끝 -->

		</section>
		<!-- 모달창 끝 -->
		
	</form>
	<!-- 피드 작성 폼 끝 -->





	<script>
	
		/* 모달창 on off */
		$(function() {
			
			/* on */
			$(".modalbtn_createfeed").click(function() {
				$(".modal_createfeed").fadeIn();
				$("html, body").addClass("not_scroll");
			});

			/* off */
			$(".c_close").click(function() {
				$(".modal_createfeed").fadeOut();
				$("html, body").removeClass("not_scroll");
			});
			
		});

		/* 선택 사진 프리뷰 처리 */
		function readURL(input) {
			
			/* Preview load */
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#preview-img').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
			
			/* Preview reset */
			$('.c_close').click(function(){
				$('#preview-img').attr('src', '<c:url value="/images/feed/feedw/noImage.png"/>');
			});
			
		};
		
		/* 파일 선택 여부 체크 */
		$('.feed_submit').click(function(memberIdx, memberIdx){
			
			var file = $('#fileupload').val();
			
			if(!file){
				alert('사진을 선택해주세요');
				return false;
			} alert('게시 되었습니다');
			
		});
		
		/* 게시글 입력창 줄바꿈 */
		$('#boardDiscription').click(function(){
			var html = $('#boardDiscription').val().replace(/(?:\r\n|\r|\n)/g, '<br />');
		});
		
	</script>

</body>

</html>