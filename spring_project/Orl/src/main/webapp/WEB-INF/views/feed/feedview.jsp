<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FEED VIEW</title>
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<link rel="stylesheet" href="<c:url value='/css/feed/feedview.css'/>">
</head>
<body>

	<section class="container">
		<button class="v_close">
			<img src="<c:url value="/images/feed/feedw/close.png"/>">
		</button>

		<section class="v_leftbox">
			<img
				src="<c:url value="/images/feed/feedw/uploadfile/${boardPhoto}"/>"
				alt="feed-img">
			<button>
				<img src="<c:url value="/images/feed/feedw/icon-05.png"/>">
			</button>
		</section>

		<section class="v_rightbox">
			<div class="v_profile">
				<div class="v_photo">
					<button>
						<img src="<c:url value="/images/feed/feedw/profile.jpg"/>"
							alt="profile-img">
					</button>
				</div>
				<a href="#" class="v_nickname">${member.memberNickname}</a>
				<button>팔로우</button>

				<div class="contents">
					<p>${content}</p>
					<div>
						<a class="hashtag">${hashtag}</a>
					</div>
				</div>
			</div>

			<section class="commentbox">
				<div>
					<div class="comments">
						<div class="cmt-profile">
							<button>
								<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
									alt="cmt-profile-img">
							</button>
						</div>
						<div class="comment">
							<p>
								<a href="#" class="v_nicknam">NICKNAME</a>파일이름:${boardPhoto.getName()}
							</p>
						</div>
					</div>
					<div class="comments">
						<div class="cmt-profile">
							<button>
								<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
									alt="cmt-profile-img">
							</button>
						</div>
						<div class="comment">
							<p>
								<a href="#" class="v_nicknam">NICKNAME</a>태그 : ${tag}
							</p>
						</div>
					</div>
					<div class="comments">
						<div class="cmt-profile">
							<button>
								<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
									alt="cmt-profile-img">
							</button>
						</div>
						<div class="comment">
							<p>
								<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다
								댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다 댓글입니다
							</p>
						</div>
					</div>
					<div class="comments">
						<div class="cmt-profile">
							<button>
								<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
									alt="cmt-profile-img">
							</button>
						</div>
						<div class="comment">
							<p>
								<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다
							</p>
						</div>
					</div>
					<div class="comments">
						<div class="cmt-profile">
							<button>
								<img src="<c:url value="/images/feed/feedw/cmt-profile.jpg"/>"
									alt="cmt-profile-img">
							</button>
						</div>
						<div class="comment">
							<p>
								<a href="#" class="v_nicknam">NICKNAME</a>댓글입니다 댓글입니다 댓글입니다
								댓글입니다 댓글입니다 댓글입니다
							</p>
						</div>
					</div>
				</div>
			</section>

			<section class="commentingbox">
				<div class="buttonline">
					<div>
						<button class="like">
							<img src="<c:url value="/images/feed/feedw/like-black.png"/>"
								class="nolike" alt="like-img">
							<!-- <img src="/images/like.png" class="like-red" alt="nolike-img"> -->
						</button>
						<button class="write">
							<img src="<c:url value="/images/feed/feedw/comment.png"/>"
								alt="comment-img">
						</button>
						<button class="share">
							<img src="<c:url value="/images/feed/feedw/share.png"/>"
								alt="share-img">
						</button>
					</div>
					<div class="likeline">
						<p>좋아요 1,000개</p>
					</div>
				</div>

				<div class="commentingline">
					<div class="textbox">
						<input type="text" placeholder="댓글달기">
					</div>
					<div class="submitbox">
						<input type="submit" value="게시">
					</div>
				</div>
			</section>

		</section>

	</section>



	<script>
		/* modal_feedview */
		$(function() {
			/* modal open */
			$(".modalbtn_feedview").click(function() {
				$(".modal_feedview").fadeIn();
				/* body - not scroll */
				$("html, body").addClass("not_scroll");
			});

			/* modal close */
			$(".v_close").click(function() {
				$(".modal_feedview").fadeOut();
				/* body - scroll */
				$("html, body").removeClass("not_scroll");
			});
		});
	</script>



</body>
</html>