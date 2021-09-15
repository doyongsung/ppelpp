<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="<c:url value='/css/member/mypage.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script defer src="<c:url value='/js/member/insert.js'/>"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
   <div id="all">
      <section class="forgot-pw">
         <h1>MyPage</h1>
         <form method="post" enctype="multipart/form-data" onsubmit="return form_submit(this.form)">
            <div class="input-area" id="wrapImg">
               <img id="profile"
                  src="<c:url value='/images/member/profile/${member.memberProfile}'/>"
                  onclick="doImgPop(this.src)">
                  <span id="id">${member.memberNickname}</span>
                  <input type="file" id="memberPhoto" name="memberPhoto" style="display: none">
                  <label for="memberPhoto" class="changeProfile" style="color:#FDEF7B">프로필사진바꾸기</label> 
            </div>
            <div class="input-area">
               
               <input type="text" id="name"
                  name="memberName" autocomplete="off"
                  value="${member.memberName}" required>
                  <label for="name">이름</label> 
                    <span id="msgchk4"></span>
            </div>

            <div class="input-area">
               <input type="text" id="nickname" name="memberNickname"
                  class="form-control" autocomplete="off"
                  value="${member.memberNickname}" required> 
               <label for="nickname">닉네임</label>
                <span id="msg2" class="display_none"></span>
                    <img id="loadingimg2" class="display_none" alt="loading"
                         src="<c:url value="/images/default/loading.gif"/>">
                    <span id="msgchk6"></span>
            </div>


            <div class="input-area">
               <input type="text" id="email"
                  name="memberEmail" class="form-control" autocomplete="off"
                  value="${member.memberEmail}" required>
               <label for="email">이메일</label>
                <span id="msg3" class="display_none"></span>
                    <img id="loadingimg3" class="display_none" alt="loading"
                         src="<c:url value="/images/default/loading.gif"/>">
                    <span id="msgchk5"></span> 
            </div>

            <div class="input-area">
               <input type="text" id="memberBirth"
                  name="birth" class="form-control" autocomplete="off"
                  value="${member.memberBirth}" required>
               <label>생년월일</label> 
               <span id="msgchk7"></span> 
            </div>
            

         <div class="caption">
                <a href="<c:url value='/member/mypage/pwchange'/>">비밀번호 변경하기</a>
            </div>


            <div class="btn-area">
               <input type="submit" value="변경하기"   class="form-control btn-secondary"> 
            </div>
         </form>

      </section>
   </div>
   
   
   <script>

    //모든 공백 체크 정규식
    var empJ = /\s/g;
    // 이름
    var nameJ = /^[가-힣A-Za-z]{2,6}$/;
    // 닉네임
    var ninkJ = /^[가-힣A-Za-z0-9]{2,12}$/;
    // 이메일 검사
    var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 생년월일
    var birthJ = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;


   var checkName = true;
   var checkEmail = true;
   var checkNick = true;
   var checkBirth = true;


   function form_submit(form) {
      if (checkName && checkEmail && checkNick && birthJ){
         form.submit();
      }else{
         return false;
      }
   }


    $(document).ready(function () {

       //생년월일 체크
      $('#memberBirth').focusin(function () {
         $('#msgchk7').addClass('display_none');
      });


        $("#memberBirth").blur(function () {
            if (birthJ.test($(this).val())) {
                console.log(birthJ.test($(this).val()));
                $("#msgchk7").text('');
            checkBirth = true;
         } else {
                /*    alert('생년월일은 1996-03-04 형식으로 작성해야합니다'); */
            $('#msgchk7').removeClass('display_none');
            $('#msgchk7').text('생년월일은 1996-03-04 형식으로 작성해야합니다');
                $('#msgchk7').css('color', '#f82a2aa3');
            checkBirth = false;
         }
        });

       

        // 이름 체크
      $('#name').focusin(function () {
         $('#msgchk4').addClass('display_none');
      });

      $("#name").blur(function () {
         if (nameJ.test($(this).val())) {
            console.log(nameJ.test($(this).val()));
            $("#msgchk4").text('');
          checkName = true;
       } else {
            /* alert('이름은 2자 이상 6자 이하여야 하며, 한글만을 사용해야 합니다.'); */
            $('#msgchk4').removeClass('display_none');
            $('#msgchk4').text('2~6자 한글 또는 영어 사용가능.');
            $('#msgchk4').css('color', '#f82a2aa3');
          checkName = false;
       }
      });


      // email 체크
      $('#email').focusin(function () {
         $('#msgchk5').addClass('display_none');
         $('#msg3').addClass('display_none');
         $('#msg3').removeClass('color_yellow');
         $('#msg3').removeClass('color_red');
        /*  $(this).val(''); */
      });

      $("#email").blur(function () {
         if (mailJ.test($(this).val())) {
            console.log(mailJ.test($(this).val()));
            $("#msgchk5").text('');
               $.ajax({
                  url: '<c:url value="/member/emailCheck"/>',
                  type: 'get',
                  data: {
                     email: $(this).val()
                  },
                  beforeSend: function () {
                     $('#loadingimg3').removeClass('display_none');
                  },
                  success: function (data) {
                     // data : Y / N
                     if (data == 'Y') {
                        $('#msg3').html('사용가능');
                        $('#msg3').addClass('color_yellow');
                        $('#msg3').removeClass('display_none');
                   checkEmail = true;
                } else {
                        $('#msg3').html('사용 불가능');
                        $('#msg3').addClass('color_red');
                        $('#msg3').removeClass('display_none');
                   checkEmail = false;
                }
                  },
                  error: function (request, status, error) {
                     alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
                     console.log(request);
                     console.log(status);
                     console.log(error);
                  },
                  complete: function () {
                     $('#loadingimg3').addClass('display_none');
                  }
               });
         } else {
            /*    alert('이메일을 다시 입력해주세요'); */
            $('#msgchk5').removeClass('display_none');
            $('#msgchk5').text('이메일형식에 맞게 작성해주세요');
            $('#msgchk5').css('color', '#f82a2aa3');
          checkEmail = false;

       }
      });

      // 닉네임 체크

        $('#nickname').focusin(function () {
           $('#msgchk6').addClass('display_none');
           $('#msg2').addClass('display_none');
            $('#msg2').removeClass('color_yellow');
            $('#msg2').removeClass('color_red');
          /*   $(this).val(''); */
        });
      $("#nickname").blur(function () {
         if (ninkJ.test($(this).val())) {
            console.log(ninkJ.test($(this).val()));
            $("#msgchk6").text('');
               $.ajax({
                  url: '<c:url value="/member/nickNameCheck"/>',
                  type: 'get',
                  data: {
                     nickname: $(this).val()
                  },
                  beforeSend: function () {
                     $('#loadingimg2').removeClass('display_none');
                  },
                  success: function (data) {
                     // data : Y / N
                     if (data == 'Y') {
                        $('#msg2').html('사용가능');
                        $('#msg2').addClass('color_yellow');
                        $('#msg2').removeClass('display_none');
                   checkNick = true;
                } else {
                        $('#msg2').html('사용 불가능');
                        $('#msg2').addClass('color_red');
                        $('#msg2').removeClass('display_none');
                   checkNick = false;
                }
                  },
                  error: function (request, status, error) {
                     alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
                     console.log(request);
                     console.log(status);
                     console.log(error);
                  },
                  complete: function () {
                     $('#loadingimg2').addClass('display_none');
                  }
               });
         } else {
            /* alert('이름은 4자 이상 12자 이하여야 하며, 한글/소문자/대문자만을 사용해야 합니다.'); */
            $('#msgchk6').removeClass('display_none');
            $('#msgchk6').text('2~12자의 한글 또는 영어 사용가능.');
            $('#msgchk6').css('color', '#f82a2aa3');
          checkNick = false;
       }
      });


    });

</script>
</body>
</html>