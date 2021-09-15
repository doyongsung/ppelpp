<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/member/mypagePw.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<div id="all">
    <section class="forgot-pw">
        <h1>Change Password</h1>
        <form method="post" onsubmit="return form_submit(this.form)">
            <div class="input-area">
               <input type="password" id="pw" name="pw"
                        class="form-control" required>
               <label for="pw">이전 비밀번호</label>
            </div>

            <div class="input-area">
                <input type="password" id="newpw" name="newpw"
                        class="form-control" required>
                <label for="newpw">새 비밀번호</label>
                <span id="msgchk2"></span>
            </div>

            
            <div class="input-area">
                  <input type="password" id="newpw2" name="newpw2"
                        class="form-control" required>
               <label for="newpw2">새 비밀번호 확인</label>
               <span id="msgchk3"></span>
            </div>

            <div class="btn-area">
                <input type="submit" value="비밀번호 변경"
                        class="form-control btn-secondary">
            </div>
               <div class="caption">
               <a href="<c:url value="/member/forgotPw"/>">
                           <p class="pw_link">비밀번호를 잊으셨나요?
            </div>
        </form>

    </section>
    </div>
    <script>
    var pwJ = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

    var checkPw = true;
    var checkRePw = true;


    function form_submit(form) {
        if (checkPw && checkRePw){
            form.submit();
        }else{
            return false;
        }
    }

    $(document).ready(function () {
        // 2.비밀번호 유효성 체크

      $('#newpw').focusin(function () {
         $('#msgchk2').addClass('display_none');
         $(this).val('');
      });


        $("#newpw").blur(function () {
            if (pwJ.test($(this).val())) {
                console.log(pwJ.test($(this).val()));
                $("#msgchk2").text('');
                checkPw = true;
            } else {
                /*    alert('비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.'); */
            $('#msgchk2').removeClass('display_none');
            $('#msgchk2').text('숫자/대소문자/특수문자 모두 포함한 8자리 이상');
                $('#msgchk2').css('color', '#f82a2aa3');
                checkPw = false;
            }
        });

        // 3. 비밀번호 확인 체크
        $('#newpw').keyup(function () {
            $('#chkNotice').html('');
        });

        $('#newpw2').keyup(function () {

            if ($('#newpw').val() != $('#newpw2').val()) {
                $('#msgchk3').html('비밀번호가 일치하지 않습니다.');
                $('#msgchk3').css('color', '#f82a2aa3');
                checkRePw = false;
            } else {
                $('#msgchk3').html('비밀번호가 일치합니다.');
                $('#msgchk3').css('color', '#199894b3');
                checkRePw = true;
            }

        });
    });
    </script>
</body>
</html>