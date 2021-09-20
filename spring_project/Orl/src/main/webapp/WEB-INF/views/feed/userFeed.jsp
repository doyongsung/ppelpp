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
   <link rel="stylesheet" href="<c:url value='/css/feed/feedmain.css'/>">
   
   <style>
      .display_none{
         display:none;
      }
   </style>
   

</head>
<body>
   <!-- 헤더영역 -->
   <%@ include file="/WEB-INF/frame/default/header.jsp"%>
   
   
   <!-- modal_createfeed 우리언니 0908 추가  -->
   <div class="modal_createfeed">
      <div class="modal_content_create">
         <section class="container_create">
            <%@ include file="/WEB-INF/views/feed/createfeed.jsp"%>
         </section>
      </div>
   </div>


    <!-- 메인 피드 영역  시작-->
    <div class="container1">

        <!-- 프로필 영역 -->
        <section class="bio">
            <!-- 사진 영역 -->
            <a href="<c:url value="/feed/userfeed/${member.memberIdx}"/>">
               <div class="profile-photo">
                   <img src="<c:url value="/images/member/profile/${member.memberProfile}"/>" alt="profile-photo">
               </div>
            </a>

            <!-- 사용자 정보 영역: username, follow-infos, user-post,buttons -->
            <div class="profile-info">

                <!-- 사용자 id -->
                <div class="username">
                    <a href="<c:url value="/feed/userfeed/${member.memberIdx}"/>">${member.memberNickname}</a>
                </div>


                <ul class="follow-infos">
                    <li>게시물 ${feedCount}</li>
                    
                    <li class="follows" id="follower">
                       <a>팔로워 <span id="followerCount"> ${followerCount}</span></a>
                    </li>
                    
                    <li class="follows" id="following">
                       <a>팔로잉 <span id="followingCount">${followingCount}</span></a>
                    </li>
                </ul>

                <!-- 버튼 영역 팔로우하기, 팔로우 끊기, 내정보 수정하기, 피드 올리기  -->
                <div class="buttons" >
                   <c:choose>
                      <c:when test="${sessionScope.memberVo.memberIdx ne member.memberIdx}">
                         <div id="follow-button-div">
                            <input type="button" id="follow-button" class="${followRelation==0? 'buttons-area-yellow':'buttons-area-gray'}" value="${followRelation==0? '팔로우 시작하기': '팔로우 그만하기'}">
                         </div>
                      </c:when>

                  <c:otherwise>
                          <div><a class="buttons-area-yellow" href="<c:url value="/member/mypage"/>">내 정보 수정</a></div>
                          <div><a class="buttons-area-yellow modalbtn_createfeed">피드 올리기</a></div>               
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
      <!-- 크루 사진 경로 맞춰야함 -->
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
             
                <!--  내가 가입한 크루 리스트-->
                 <c:forEach var ="myCrewList" items="${myCrewList}">
                     <div class="swiper-slide">
                        <a href="<c:url value="/crew/detail?crewIdx=${myCrewList.crewIdx}"/>" class="crew">
                          <img src="<c:url value="/images/crew/${myCrewList.crewPhoto}"/>">
                          <div>${myCrewList.crewName}</div>
                       </a>
                    </div>
                 </c:forEach>
                 <!--  내가 가입한 크루 리스트 끝-->
              
              <!-- 크루 더 보기 -->
              <div class="swiper-slide">
                <a href="<c:url value="/crew/list"/>" class="crew">
                    <img src="<c:url value="/images/feed/feeds/more.png"/>" alt="">
                    <div>MORE</div>
                </a>
              </div> 
              <!-- 크루 더 보기 끝 -->   

            </div>
            <!-- swiper-wrapper 끝 -->
            
            
            <!-- 옆으로 가기 버튼 영역 시작  -->
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
            <!-- 버튼 영역 끝 -->
           
          </div> 
          <!-- 크루 가기 영역(swiper mySwiper) 끝 -->
      
      
          <!-- 크루가기Swiper JS -->
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
         <!--크루 영역 JS 끝 --> 
          

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
                 <a class="item">
                     <img onclick="location.href='${pageContext.request.contextPath}/feed/feedview/${member.memberIdx}&${feedGallery.boardIdx}'" src="<c:url value="/images/feed/feedw/uploadfile/${feedGallery.boardPhoto}"/>" alt="기본">
                 </a>
              </c:forEach>
          </section> 
      
        <!-- 갤러리 영역: 좋아요 영역 display_none으로 안보이는 상태-->
        <section class="gallery display_none" id="like-sort-gallery">
             <c:forEach var="feedLikeGallery" items="${feedLikeGallery}">
              <a class="item" >
                 <img onclick="location.href='${pageContext.request.contextPath}/feed/feedview/${feedLikeGallery.memberIdx}&${feedLikeGallery.boardIdx}'"  src="<c:url value="/images/feed/feedw/uploadfile/${feedLikeGallery.boardPhoto}"/>"alt="좋아요"> 
              </a>
             </c:forEach>
        </section>
        
        <!-- 갤러리 정렬  JS 시작-->
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
        <!-- 갤러리 정렬  JS 끝-->

    </div>
<!-- 메인 피드 영역  끝-->


<!-- footer영역 -->
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
<!-- footer 영역 끝 -->

<!-- 비동기 통신으로 보여지는 영역 시작 -->

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
   
   <!-- 팔로워 리스트 비동기통신 영역 시작-->
   <script>
   $('#follower').click(function(){
      //팔로워 보여주기
      $('#container-follower').removeClass('display_none');
      
      //팔로워 명단 초기화 시키기
      $('#follower-members').html('');
      
      //비동기 통신
      $.ajax({
         url:'<c:url value="/feed/followerList"/>',
         type:'POST',
         data:{
            memberIdx:'${member.memberIdx}'
         },
         success: function(data){
            
            console.log(data); 
         
          $.each(data,function(index,item){
               console.log(index,item);
               
               var html ='<div class="member">';
               html += '   <a href="<c:url value="/feed/userfeed/'+item.memberIdx+'"/>">';
               html += '      <img src="<c:url value="/images/member/profile/'+item.memberProfile+'"/>"/>';
               html += '   </a>';
               html += '   <a class="nickname-area" href="<c:url value="/feed/userfeed/'+item.memberIdx+'"/>">'+item.memberNickname+'</a>';
               /* html += '   <input type="submit" class="button-yellow-inList" value="팔로우 시작하기">'; */
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
    <!--팔로잉  리스트 영역  끝-->
    
    <!-- 팔로잉 리스트 영역 비동기 통신 영역 시작 -->
   <!-- 내피드에서 팔로잉 리스트에서 버튼, 남피드 팔로잉 리스트에서는 버튼 안보이게  -->
   <script>
   $('#following').click(function(){
      $('#container-following').removeClass('display_none');
      
      // 팔로잉 글자를 클릭하면 리스트가 나온다
      // 내 피드 이면 팔로잉 리스트 + 팔로우 시작하기 or 그만하기 버튼 
      // 남 피드 이면 팔로잉 리스트만 존재
      
      if(${sessionScope.memberVo.memberIdx ne member.memberIdx}){
         // 세션에 있는 memberIdx    !=  model에 저장된 memberIdx
         
         console.log("남 피드 입니다.")
         
         // 남 피드에서는 아예 팔로잉 리스트에 버튼 보이지 않도록 처리
         
         $('#following-members').html('');
         
         //팔로잉 버튼 눌렀을 때 명단 가져오기 ->비동기 통신으로
         $.ajax({
            url:'<c:url value="/feed/followingList"/>',
            type:'POST',
            data:{
               memberIdx:'${member.memberIdx}'
            },
            success: function(data){
               console.log(data); 
            
             $.each(data,function(index,item){
                  console.log(index,item);
                  
                  var html ='<div class="member">';
                  html += '   <a href="<c:url value="/feed/userfeed/'+item.memberIdx2+'"/>">';
                  html += '      <img src="<c:url value="/images/member/profile/'+item.memberProfile+'"/>"/>';
                  html += '   </a>';
                  html += '   <a class="nickname-area" href="<c:url value="/feed/userfeed/'+item.memberIdx2+'"/>">'+item.memberNickname+'</a>';
                  html += '</div>';
                  
                  //div에 추가해주기
                  $('#following-members').append(html);
               });  
            }
         });/* ajax끝 */
      
      }else{
         console.log("내 피드 입니다.")
         // 내 피드에서는 팔로잉 리스트에 버튼 보이도록
         // 즉각적으로 팔로우 시작하고 팔로우 끊을 수 있다. 
         
         // 명단 초기화 
         $('#following-members').html('');
         
         // 팔로잉 버튼 눌렀을 때 명단 가져오기 ->비동기 통신으로
         // post방식으로 바꿈
         $.ajax({
            url:'<c:url value="/feed/followingList"/>',
            type:'POST',
            data:{
               memberIdx:'${member.memberIdx}'
            },
            success: function(data){
               console.log(data); 
               
             $.each(data,function(index,item){
                  console.log(index,item);
                  
                  var html ='<div class="member">';
                  html += '   <a href="<c:url value="/feed/userfeed/'+item.memberIdx2+'"/>">';
                  html += '      <img src="<c:url value="/images/member/profile/'+item.memberProfile+'"/>"/>';
                  html += '   </a>';
                  html += '   <a class="nickname-area" href="<c:url value="/feed/userfeed/'+item.memberIdx2+'"/>">'+item.memberNickname+'</a>';
                  html += '   <input type="hidden" value="'+item.memberIdx2+'">';
                  html += '   <input type="button" class="button-gray-inList" value="팔로우 그만하기">';
                  html += '</div>';
                  
                  //div에 추가하기
                  $('#following-members').append(html);
               });  
            }
         });/* ajax 끝 */
         
      }/* else 끝 */
      
      
      
   });/*click 이벤트 끝  */
   
   // 닫기 버튼 눌렀을 때 
   $('.form-close').click(function(){
      $('#container-following').addClass('display_none');
      
   });/* 닫기끝 */
   
   
   // 내 팔로잉 리스트 안쪽에 버튼에서 
   // 팔로우 그만하기 버튼  눌렀을 때 처리하기
   // 클릭이벤트를 껍데기에 만들어야 한다!! 비동기 통신전에 button의 id값 모른다!
   $('#following-members').on('click','input[type=button]',function(){
      
      //비동기 통신으로 팔로우 그만하기와 시작하기하기!!
      
      //보내야 하는 데이터 : 리스트 옆쪽의 memberIdx
      //그리고 followStatus
      
      console.log("클릭");
      
      // 팔로우 시작하기 혹은 그만하기 인지 확인
      
      /* var followStatus = $('input[type=button]').val();   */
      /* ---> 오류 원인!! input[type=button]은 전체 버튼 배열이기 때문에 가장 첫번째의 val를 가져온다 */
      /* 즉 아래에 계속 첫번째 버튼 상태만 출력되는 오류가 발생 */
      var followStatus =$(this).val();
      console.log(followStatus);
      
      
      //클릭한 submit 이 있는 div인 member안쪽의  memberIdx2 $('선택자', 범위한정)
      var memberIdx2 =$('input[type=hidden]', $(this).parent()).val(); 
      console.log(memberIdx2); //memberIdx2 확인
      
      var btn = $(this);
      
       if(followStatus == '팔로우 그만하기'){ 
         
         //비동기 통신 시작
         
          $.ajax({
            url:'<c:url value="/feed/followButtonClick"/>',
             type:'POST',
             data:{
                followStatus : '-1',
                memberIdx : memberIdx2
             },
             
             success:function(data){
                
                console.log(data);
                 
                 if(data==1){
                    //그만하기 성공
                    //1)버튼 색을 바꿔준다
                    //2)버튼 글자를 팔로우 시작하기로 바꿔준다. 
                    //3)팔로잉 수를 바꿔준다.
                    
                   btn.val('팔로우 시작하기');
                    btn.css('background','#fdef7b'); 
                    //console.log(btn.val());
                    
                    var followingCount = parseInt($('#followingCount').text());
                   var newFollowingCount = followingCount -1;
                   
                   $('#followingCount').text(newFollowingCount);
                   /* console.log(newFollowingCount); */
                    
                 }
                
             }/* success 닫기 */
               
         });/* if 안쪽 비동기 통신 끝 */
         
         /* if 끝 */
         
      }else{
         //followStatus =='팔로우 시작하기'
      //비동기 통신 시작
       $.ajax({
         url:'<c:url value="/feed/followButtonClick"/>',
            type:'POST',
            data:{
               followStatus : '1',
               memberIdx : memberIdx2
            },
            
            success:function(data){
               
               console.log(data);
                
             if(data==1){
                // 시작하기 성공
                   
                //1)버튼 색을 바꿔준다
                //2)버튼 글자를 팔로우 시작하기로 바꿔준다. 
                //3)팔로잉 수를 바꿔준다.
                   
               btn.val('팔로우 그만하기');
                btn.css('background','#EFEFEF'); 
                //console.log(btn.val());
                   
                var followingCount = parseInt($('#followingCount').text());
                  var newFollowingCount = followingCount +1;
                  
                  $('#followingCount').text(newFollowingCount);
                  /* console.log(newFollowingCount); */
                   
                }
               
               }/* success 닫기 */
               
         });/* if 안쪽 비동기 통신 끝 */
         
      } 
         
      /*else 끝 */
      
   });/* click 끝 -- 팔로잉 리스트 안쪽 팔로우 시작하기 팔로우 그만하기 */
   
   
   </script>
   
   

</body>
</html>