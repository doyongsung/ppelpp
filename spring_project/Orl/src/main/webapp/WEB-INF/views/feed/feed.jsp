<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FEED</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<link rel="stylesheet" href="<c:url value='/css/feed/feedmain.css'/>">
	<style>
		.display_none{
			display:none;
		}
	</style>

</head>
<body>

	<div>
		<div class="feedmain">
		
			<!-- <!— top blank START —> -->
			<div class="top">
				<div></div>
				<div class="h1box">
					<div>
						<h1>FEED</h1>
					</div>
				</div>
				<div></div>
			</div>
			<!-- <!— top blank END —> -->
			
			
			<div class="main">
				<div class="leftbox"></div>
				<div class="mainbox">

					<!-- 산 아이콘 -->
					<div class="mountain">
						<img src="<c:url value="/images/feed/feedw/mountain.png"/>">
					</div>

					<!-- 네비 영역 시작 -->
					<div class="feednav">
						<!-- 피드 키워드 영역 최신/ 인기 -->
						<div class="keyword">
							<!-- 기본 정렬 (최신순) -->
							<a id="currentFeedClick">최신</a>
							<!-- 선택 정렬 (인기순) -->
							<a id="likeFeedClick">인기</a>
						</div>
						<!-- 피드 키워드 영역  끝-->
						

						<!--피드 올리기 영역 0915 추가  -->
						<!-- feed create button (Login status) -->
						<c:if test="${sessionScope.memberVo ne null}">
							<div class="div_createfeed">
								<div>
									<button class="modalbtn_createfeed">피드 올리기</button>
								</div>
							</div>
						</c:if>	
						<!--피드 올리기 영역 끝 -->					

						<!-- 피드 검색 후 jsp넘기기위해 form 추가 -->
						<form action="<c:url value="/feed/feedSearch"/>" method="post">
							<div class="search">
								<input type="text" placeholder="search" name="mySearch">
								<button type="submit">
									<img src="<c:url value="/images/feed/feedw/search.png"/>"
										alt="search">
								</button>
							</div>
						</form>
						<!-- 피드 검색 영역 -->

					</div>
					<!-- 네비 영역 끝 -->
					
					<!-- 피드 최신순 정렬 영역  -->
					<div id="fBox" class="feedbox">
						<!-- 비동기 통신으로 추가되는 부분 -->
					</div>
					<!-- 피드 최신순 정렬 영역 끝 -->
					

					<!-- 피드 영역  좋아요 정렬 시작 -->
					<div class="feedbox display_none" id="likeFeedGallery">

						<c:forEach var="feedOrderByLike" items="${feedOrderByLike}">

							<div class="feed">
								<div class="feedsize">
									<button class="modalbtn_feedview" type="button" 
									onclick="feedLoginCheck(${feedOrderByLike.memberIdx}, ${feedOrderByLike.boardIdx})">
										<img
											src="<c:url value="/images/feed/feedw/uploadfile/${feedOrderByLike.boardPhoto}"/>"
											class="feedimg" alt="feedimg">
									</button>
								</div>
								<div class="feedinfo">
									<div class="nickname">
										<a onclick="feedNicknameCheck(${feedOrderByLike.memberIdx})" href="#" class="nickname2">${feedOrderByLike.memberNickname}</a>
									</div>
									<div>
										<button>
											<img src="<c:url value="/images/feed/feedw/nolike.png"/>"
												class="nolikeimg">
										</button>
									</div>
								</div>
							</div>

						</c:forEach>

					</div>
					<!-- 피드 영역 좋아요 순 정렬 영역 끝 -->


				</div>
				<div class="rightbox"></div>
			</div>
			<div class="bottom"></div>
		</div>
	</div>
	
	<script>
		// 인기를 클릭하면 좋아요 많은 수 정렬로 보여주기
		$('#likeFeedClick').click(function(){
			$('#likeFeedGallery').removeClass('display_none');
			$('#fBox').addClass('display_none');
			
		});	
		
		// 다시 기본정렬 클릭  --> 비동기통신으로 가져오는 메서드 추가해야
		$('#currentFeedClick').click(function(){
			$('#fBox').removeClass('display_none');
			$('#likeFeedGallery').addClass('display_none');
			
		});
	</script>
	
	
	<!-- 우리 언니 추가 ajax -->
	<script>
	/* NEW feed list */
	function showNewFeed(list){
		
		var html = '';
		console.log('show new feed');
		
		$.each(list, function(index, item){
			
			html += '<div class="feed">';
			html += '	<div class="feedsize">';
			html += '		<button class="modalbtn_feedview" type="button" onclick="feedLoginCheck('+item.memberIdx+', '+item.boardIdx+')">';
			html += '			<img src="<c:url value="/images/feed/feedw/uploadfile/'+item.boardPhoto+'"/>" class="feedimg" alt="feedimg">';
			html += '		</button>';
			html += '	</div>';
			html += '	<div class="feedinfo">';
			html += '		<div class="nickname">';
			html += '			<a onclick="feedNicknameCheck('+item.memberIdx+')" class="nickname2">'+item.memberNickname+'</a>';
			html += '		</div>';
			html += '		<div>';
			html += '			<button><img src="<c:url value="/images/feed/feedw/nolike.png"/>" class="nolikeimg"></button>';
			html += '		</div>';
			html += '	</div>';
			html += '</div>';
		
		})
		
		$('#fBox').html(html);
		
		
	}
	
	
	$(document).ready(function(){
		
		/* NEW feed list ajax */
		$.ajax({
			url: '<c:url value="/feed/feedmain/selectNewFeed"/>',
			type: 'get',
			success: function(data){
				
				console.log(data);
				var memberIdx = '${sessionScope.memberVo.memberIdx}';
				showNewFeed(data);
			}
		});
		/* NEW feed list ajax END */
		
	});


	/* NEW feed list END */
					
								
		/* feedview login check */
		function feedLoginCheck(memberIdx, boardIdx){
									
			var myIdx = '${sessionScope.memberVo.memberIdx}';
			var memberIdx = memberIdx;
			var boardIdx = boardIdx;
									
			if(!myIdx) {
				alert('로그인 후 이용 가능합니다');
				location.href='<c:url value="/member/login"/>';
			} else {
				location.href='<c:url value="/feed/feedview/'+memberIdx+'&'+boardIdx+'"/>';
			}
									
		};

		/* creator nickname check */
		function feedNicknameCheck(memberIdx){
									
			/* login check */
			var myIdx = '${sessionScope.memberVo.memberIdx}';
			var memberIdx = memberIdx;
									
			if(!myIdx) {
				alert('로그인 후 이용 가능합니다');
				location.href='<c:url value="/member/login"/>';
			} else {
				ocation.href='<c:url value="/feed/userFeed/'+memberIdx+'"/>';
			}
									
		}
	
	
	</script>

</body>
</html>