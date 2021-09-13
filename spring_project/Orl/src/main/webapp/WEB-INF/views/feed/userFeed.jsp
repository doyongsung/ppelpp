<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER FEED</title>
 <!-- 스와이퍼 css -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


    <!-- 제이쿼리 다음에 스와이퍼, 스와이퍼js min버전 -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- bootstrap js -->
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/feed/userFeed.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/feed/follow.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/feed/createFeed.css'/>">
	
	<style>
		.display_none{
			display:none;
		}
	</style>
	

</head>
<body>
	<!-- 헤더영역 -->
	<%@ include file="/WEB-INF/frame/default/header.jsp"%>


	 <!-- 메인 피드 영역 -->
    <div class="container1">

        <!-- 프로필 영역 -->
        <section class="bio">
            <!-- 사진 영역 -->
            <div class="profile-photo">
                <img src="<c:url value="/images/feed/feeds/defaultPhoto.jpg"/>" alt="profile-photo">
            </div>

            <!-- 사용자 정보 영역: username, follow-infos, user-post,buttons -->
            <div class="profile-info">

                <!-- 사용자 id -->
                <div class="username">
                    <a href="#">${member.memberNickname}</a>
                </div>


                <ul class="follow-infos">
                    <li>게시물 ${feedCount}</li>
                    
                    <li class="follows" id="follower">
                    	<a href="#" >팔로워 <span id="followerCount"> ${followerCount}</span></a>
                    </li>
                    
                    <li class="follows" id="following">
                    	<a href="#">팔로잉 ${followingCount}</a>
                    </li>
                </ul>

                <!-- 버튼 영역 팔로우하기, 팔로우 끊기, 내정보 수정하기, 피드 올리기  -->
                <div class="buttons" >
	                <c:choose>
	                	<c:when test="${sessionScope.member.memberIdx ne member.memberIdx}">
	            			<!-- <div><a class="buttons-area" href="#">팔로우하기</a></div> -->
	            			<!-- 09.01 기존 a태그에서 서버 통신 위해 button으로 바꿈  -->
	            			<!-- <div id="followButton"><input type="button" class="buttons-area" value="팔로우하기"></div> -->
	                		<div id="follow-button-div">
	                		<input type="button" id="follow-button" class="${followRelation==0? 'buttons-area-yellow':'buttons-area-gray'}" value="${followRelation==0? '팔로우 시작하기': '팔로우 그만하기'}">
	                		</div>
	                		
	                	</c:when>
						<c:otherwise>
		                    <div><a class="buttons-area-yellow" href="<c:url value="/member/mypage"/>">내 정보 수정</a></div>
		                    <div><a class="buttons-area-yellow" href="/orl/feed/createFeed">피드 올리기</a></div>  						
						</c:otherwise>
	                </c:choose>
            	</div>
            	
            </div>


        </section>
        <!--프로필 영역 끝  -->
        
        <!-- 팔로우 시작하기, 팔로우 그만하기 버튼 js -->
        <script>
        	// 비동기 통신으로 팔로우 시작하기, 팔로우 그만하기 버튼을 눌렀을 때 팔로우 그민하기와 팔로우 시작하기 버튼으로 바꿔주기
        	
        	$('#follow-button-div').click(function(){
        		//클릭하면 비동기 통신 시작
        		
        		var followStatus = $('#follow-button').val(); // 팔로우 시작하기 혹은 그만하기 인지 확인
        		console.log(followStatus);
        		
        		if(followStatus == '팔로우 그만하기'){
        			//팔로우 그만하기
        			//followStatus = -1
        			$.ajax({
            			url:'<c:url value="/feed/followButtonClick"/>',
            			type:'POST',
            			data:{
            				followStatus : '-1',
            				memberIdx : '${member.memberIdx}'
            			},
            			success: function(data){
            				//data == 1 또는 0
            				if(data==1){
            					// 결과 데이터 1 : 리턴값 1 == 팔로우 그만하기 성공
            					// 1) 팔로우 그만하기 성공 ->글자 시작하기로 바꾸기
            					 $('#follow-button').val('팔로우 시작하기');
            					
            					// 2) 배경색 노란색으로 바꿔주기 
            					 $('#follow-button').css('background','#fdef7b');
            					
            					// 3) 팔로워 수 갱신 시키기 -> 남 피드 팔로워 수 -1시키기
            					
            					//int로 변환해줘야 더하면 값이 int
            					var followerCount = parseInt($('#followerCount').text());
             					var newFollowerCount = followerCount -1;
             					
             					// 캐스팅하고 값을 바꿔주기ㄴ
             					$('#followerCount').text(newFollowerCount);
             					console.log(newFollowerCount);
            					
            					
            				}else{
            					//팔로우 그만하기 실패
            				}
            			}
            			
            		});  
        			
        			
        		}else{
        			//팔로우 시작하기: followStatus ==1
        			
        			$.ajax({
        				url:'<c:url value="/feed/followButtonClick"/>',
            			type:'POST',
            			data:{
            				followStatus :'1',
            				memberIdx : '${member.memberIdx}'
            			},
            			success:function(data){
            				if(data ==1){
            					// 결과 데이터 1 : 리턴값 1 == 팔로우 시작하기 성공
            					
            					// 1) 팔로우 시작하기 성공 -> 글자 그만하기로 바꾸기
            					$('#follow-button').val('팔로우 그만하기');
            					
            					// 2) 배경색 회색으로 바꾸기
            					$('#follow-button').css('background','#f8f8f8');
            					
            					// 3) 팔로워 수 갱신 시키기 ->남 피드 팔로워 수 +1시키기
            					
            					// int로 바꾸기 (text로 받으면 type이 String->String +1 =String)
            					var followerCount = parseInt($('#followerCount').text());
            					var newFollowerCount = followerCount +1;
            					
            					$('#followerCount').text(newFollowerCount);
            					console.log(newFollowerCount);
            					
            				}
            			}
        				
        			});
        		}
        		
        	});
        	
        </script>
	<!-- 팔로우 시작하기, 팔로우 그만하기 버튼 js 끝-->
        

		<!-- 내크루 가기 영역  swiper 사용 -->
		<!-- href : crewIdx로 해서 크루 상세보기로 넘어가야한다. -->
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
             
              	<c:forEach var ="myCrewList" items="${myCrewList}">
	              	 <div class="swiper-slide">
	              		 <a href="<c:url value="/crew/detail/${myCrewList.crewIdx}&1"/>" class="crew">
		              		<img src="${myCrewList.crewPhoto}">
		              		<div>${myCrewList.crewName}</div>
	              		</a>
	              	</div>

              	</c:forEach>
              	
              <div class="swiper-slide">
                <a href="#" class="crew">
                    <img src="<c:url value="/images/feed/feeds/more.png"/>" alt="">
                    <div>MORE</div>
                </a>
              </div> 
              	

              	<div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름크루크루크루크루크루</div>
                </a>
              </div>
              
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크크크루루루!</div>
                </a>
              </div>
              
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름10글자까지</div>
                </a>
              </div>
              
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>넘어가면잘린다..</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>clickclick</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>
              <div class="swiper-slide">
                <a href="#" class="crew">
                  <img
                    src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"
                    alt=""/>
                  <div>크루이름</div>
                </a>
              </div>

			
            </div><!-- swiper-wrapper 끝 -->
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
          </div> <!-- 내크루 가기 영역 끝 -->
      
          <!-- Swiper JS -->
          <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
      
          <!-- Initialize Swiper -->
          <script>
            var swiper = new Swiper(".mySwiper", {
              slidesPerView: 6,
              spaceBetween: -40,
              slidesPerGroup: 6,
              loop: true,
              loopFillGroupWithBlank: true,
              pagination: {
                el: ".swiper-pagination",
                clickable: true
              },
              navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev"
              }
            });
          </script>
         <!-- 내 크루 영역 끝 --> 
          

        <!-- 갤러리 네비게이션 영역 : 피드보기랑 좋아요 보기 -->
        <div class="gallery-nav">
        	<!-- 기본정렬 -->
            <div class="feed-icon" id="default-sort-Click"><input type="image" src="<c:url value="/images/feed/feeds/feedicon.png"/>"></div>
        	<!-- 좋아요 정렬 -->
        	<div class="heart-icon" id="like-sort-Click" ><input type="image" src="<c:url value="/images/feed/feeds/redheart.png"/>"></div>
        </div>
        <!--갤러리 네비게이션 영역 끝 -->

        <!-- 갤러리영역 : 기본정렬 -->
	    <section class="gallery" id="default-sort-gallery">
        	
        		<c:forEach var ="feedGallery" items="${feedGallery}">
	        		<a href="#" class="item">
	        			<img src="feedGallery.boardPhoto" alt="기본">
	        		</a>
        		</c:forEach>
        </section> 
        
      
        <!-- 사진 피드 영역: 좋아요 영역 display_none으로 안보이는 상태-->
        <section class="gallery display_none" id="like-sort-gallery">
        	<c:forEach var="feedLikeGallery" items="${feedLikeGallery}">
	        	<a href="#" class="item">
	        		<img src="feedLikeGallery.boardPhoto" alt="좋아요"> 
	        	</a>
        	</c:forEach>
        </section>
        <!--갤러리 영역 끝 --> 
        
        <!-- 좋아요 갤러리 정렬  js-->
	    <script>
        
   		// 좋아요 아이콘 클릭하면 좋아요 정렬로 보여주기
	    	$('#like-sort-Click').click(function(){
	       		// 좋아요 정렬 : display_none 없애기
	       		// 기본 정렬: display_none 설정
		       	$('#default-sort-gallery').addClass('display_none');
		       	$('#like-sort-gallery').removeClass('display_none');
	       	});
	        
	        
	     // 다시 기본 정렬 클릭하면 기본정렬로 보여주기
	        $('#default-sort-Click').click(function(){
	        	// 좋아요 정렬 :display_none 설정
	        	// 기본 정렬 : 보이도록 설정
	        	$('#like-sort-gallery').addClass('display_none');
	        	$('#default-sort-gallery').removeClass('display_none');
	        }); 
        
        </script>
 <!-- 
            <a href="#" class="item">
              <img src="https://images.pexels.com/photos/2829336/pexels-photo-2829336.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#"class="item">
              <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/2829336/pexels-photo-2829336.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/2739505/pexels-photo-2739505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/6051221/pexels-photo-6051221.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/4652275/pexels-photo-4652275.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="">
            </a>
            <a href="#" class="item">
                <img src="https://images.pexels.com/photos/3598706/pexels-photo-3598706.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
            </a> -->
		
		<!-- 페이징 영역 -->
       <!--  <nav aria-label="Page navigation example ">
            <ul class="pagination">
              <li class="page-item"><a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                  </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">4</a></li>
              <li class="page-item"><a class="page-link" href="#">5</a></li>
              <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
    	</nav> -->
    	<!-- 페이징 영역 끝 -->
       

    </div>
<!-- 메인 피드 영역  끝-->


<!-- footer영역 -->
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
<!-- footer 영역 끝 -->



	<!--팔로워 리스트 영역 -->
	 <div class="container-follow display_none" id="container-follower">

        <div class="title">
            <div>팔로워</div>
            <button><img src="<c:url value="/images/feed/feeds/formdelete.png"/>" class="form-close"></button>
        </div>

        <div class="follower-members" id="follower-members">
            <div class="member">
             <!-- 비동기 통신으로 추가되는 영역 --> 
                <img src="<c:url value="/images/feed/feeds/defaultPhoto.jpg"/>">
                <a href="#">사용자아이디</a>
                <input type="submit" value="팔로우하기">
                
            </div>
        </div>
    </div>
    <!-- 팔로워 리스트 영역 끝  -->
	
	<!-- 팔로워 눌렀을 때  리스트 보여주기 JS-->
	<script>
	$('#follower').click(function(){
		//팔로워 보여주기
		$('#container-follower').removeClass('display_none');
		
		//팔로워 명단 초기화 시키기
		$('#follower-members').html('');
		
		//비동기 통신
		$.ajax({
			url:'<c:url value="/feed/followerList/${member.memberIdx}"/>',
			type:'POST',
			success: function(data){
				console.log(data); 
			
 			$.each(data,function(index,item){
					console.log(index,item);
					
					var html ='<div class="member">';
					html += '	<img src="'+item.memberProfile+'"/>';
					html += '	<a href="<c:url value="/feed/userFeed/'+item.memberIdx+'"/>">'+item.memberNickname+'</a>';
					html += '	<input type="submit" value="팔로우 시작하기">';
					html += '</div>';
					
					//div 추가해주기
					$('#follower-members').append(html);
				});  
			}
		});
		
		
	});
	
	// 닫기 버튼 눌렀을 때 다시 팔로워 숨기기
	$('.form-close').click(function(){
		$('#container-follower').addClass('display_none');
		
	});
	/* 팔로우 하기 팔로우 끊기 비동기 통신 여기서 처리!! */
	
	
	</script>
	<!--팔로워 리스트  영역 js 끝  -->
	
	<!--팔로잉  리스트 영역  -->
	<div class="container-follow display_none" id="container-following">

        <div class="title">
            <div>팔로잉</div>
            <button><img src="<c:url value="/images/feed/feeds/formdelete.png"/>" class="form-close"></button>
        </div>

        <div class="follower-members" id="following-members">
			<!-- 비동기 통신으로 추가되는 영역 -->            
        </div>
    </div>
    
    <!-- 팔로잉 리스트 JS -->
	<script>
	$('#following').click(function(){
		$('#container-following').removeClass('display_none');
		
		//명단 초기화 해준다음에 추가!
		$('#following-members').html('');
		
		//팔로잉 버튼 눌렀을 때 명단 가져오기 ->비동기 통신으로
		$.ajax({
			/* url:'<c:url value="/feed/followingList"/>', */
			/* 09.01 수정 */
			url:'<c:url value="/feed/followingList/${member.memberIdx}"/>',
			type:'GET',
			success: function(data){
				console.log(data); 
			
 			$.each(data,function(index,item){
					console.log(index,item);
					
					var html ='<div class="member">';
					html += '	<img src="'+item.memberProfile+'"/>';
					html += '	<a href="<c:url value="/feed/userFeed/'+item.memberIdx2+'"/>">'+item.memberNickname+'</a>';
					html += '	<input type="submit" id="follow-button-in-list" value="팔로우 그만하기">';
					html += '</div>';
					
					//div 추가해주기
					$('#following-members').append(html);
				});  
			}
		});
		
	});
	
	// 닫기 버튼 눌렀을 때 
	$('.form-close').click(function(){
		$('#container-following').addClass('display_none');
		
	});
	
	// 비동기 통신으로 팔로잉 리스트 속 버튼을 클릭했을 때
	$('#follow-button-in-list').click(function(){
		
		var followStatus = $('#follow-button').val(); // 팔로우 시작하기 혹은 그만하기 인지 확인
		console.log(followStatus);
		
		if(followStatus == '팔로우 그만하기'){
			//팔로우 그만하기
			//followStatus = -1
			$.ajax({
    			url:'<c:url value="/feed/followButtonClick"/>',
    			type:'POST',
    			data:{
    				followStatus : '-1',
    				memberIdx : '${member.memberIdx}'
    			},
    			success: function(data){
    				//data == 1 또는 0
    				if(data==1){
    					// 결과 데이터 1 : 리턴값 1 == 팔로우 그만하기 성공
    					// 1) 팔로우 그만하기 성공 ->글자 시작하기로 바꾸기
    					 $('#follow-button').val('팔로우 시작하기');
    					
    					// 2) 배경색 노란색으로 바꿔주기 
    					 $('#follow-button').css('background','#fdef7b');
    					
    					// 3) 팔로워 수 갱신 시키기 -> 남 피드 팔로워 수 -1시키기
    					
    					//int로 변환해줘야 더하면 값이 int
    					var followerCount = parseInt($('#followerCount').text());
     					var newFollowerCount = followerCount -1;
     					
     					// 캐스팅하고 값을 바꿔주기ㄴ
     					$('#followerCount').text(newFollowerCount);
     					console.log(newFollowerCount);
    					
    					
    				}else{
    					//팔로우 그만하기 실패
    				}
    			}
		
		
		
		
	});
	
	
	</script>
	
	
	
</body>
</html>