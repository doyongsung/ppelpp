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
<link rel="stylesheet" href="<c:url value='/css/feed/feedview.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<!-- feed create form START -->
	<form method="post" enctype="multipart/form-data" id="feedform">
		
		<!-- modal START -->
		<section class="container_create">
		
			<!-- modal close button -->
			<button type="reset" class="c_close">
				<img src="<c:url value="/images/feed/feedw/close.png"/>">
			</button>

			<!-- feed photo preview -->
			<section class="c_leftbox" id="image_container">
				<img id="preview-img" src="<c:url value="/images/feed/feedw/noImage.png"/>">
			</section>

			<!-- feed form START -->
			<section class="c_rightbox">
			
				<!-- creator profile START -->
				<div class="c_profile">
					<div class="c_photo">
						<button onclick="location.href = '<c:url value="/feed/userFeed/${sessionScope.memberVo.memberIdx}"/>'">
							<img src="<c:url value="/images/feed/feedw/profile.jpg"/>"
								alt="profile-img">
						</button>
					</div>
					<a href="<c:url value="/feed/userFeed/${sessionScope.memberVo.memberIdx}"/>"
						class="c_nickname">${sessionScope.memberVo.memberNickname}</a>

					<!-- file upload -->
					<div class="filebox">
						<label for="fileupload">사진선택</label>
						<input type="file" name="boardPhoto" id="fileupload" onchange="readURL(this);">
					</div>
					<!-- file upload -->

				</div>
				<!-- creator profile END -->

				<!-- contents form START -->
				<div class="contentsbox">
					<p>게시글</p>
					<input type="text" placeholder="문구 입력" name="boardDiscription" id="boardDiscription" autocomplete="off">
				</div>

				<div class="hashtagbox">
					<p>해시태그</p>
					<input type="text" placeholder="#..." name="hashtag" id="hashtag" autocomplete="off">
				</div>

				<div class="tagbox">
					<p>태그</p>
					<input type="text" placeholder="@..." name="tag" id="tag" autocomplete="off">
				</div>
				
				<!-- feed submit -->
				<div class="submit">
					<input type="submit" class="feed_submit" value="게시">
				</div>
				<!-- contents form END -->

			</section>
			<!-- feed form END -->

		</section>
		<!-- modal END -->
		
	</form>
	<!-- feed create form END -->



	<script>
	
		/* modal_createfeed */
		$(function() {
			
			/* modal open */
			$(".modalbtn_createfeed").click(function() {
				$(".modal_createfeed").fadeIn();
				/* body - not scroll */
				$("html, body").addClass("not_scroll");
			});

			/* modal close */
			$(".c_close").click(function() {
				$(".modal_createfeed").fadeOut();
				/* body - scroll */
				$("html, body").removeClass("not_scroll");
			});
			
		});

		/* Image Preview */
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
		
		/* upload check */
		$('.feed_submit').click(function(){
			
			/* file check */
			var file = $('#fileupload').val();
			
			if(!file){
				alert('사진을 선택해주세요');
				return false;
			}
			
			/* upload check */
			alert('게시 되었습니다');
			
		});
		
	</script>

</body>

</html>







