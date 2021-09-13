<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="<c:url value='/css/member/reg.css'/>">
<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">

</head>
<body>
	<div class="reg_box">
		<div class="box2">
			<div class="logo">
				<h1>
					<a href="<c:url value='/'/>">오를래</a>
				</h1>
				<p>새로운 회원들과 함께 산을 탐험해보세요!</p>
			</div>
			<div class="naver_login">
				<button class="naver_btn">네이버로 로그인</button>
			</div>
			<div class="etc">또는</div>
			<div class="sign_section">
				<form method="post">
					<div class="int-area">
					
						<input type="text" name="memberId" id="id" autocomplete="off" required>
						<label for="id">ID</label>
							<font id="id_check" size="2"></font>
						
					</div>
					<div class="int-area">
					
						<input type="password" name="memberPw" id="pw" autocomplete="off" required>
						<label for="pw">PASSWORD</label>
								<font id="pw_check" size="2"></font>
							
							
					</div>
					<div class="int-area">
					
						<input type="password" name="memberPw2" id="pw2" autocomplete="off" required> 
						<label for="pw2">PASSWORD 확인</label>
						<font id="chkNotice" size="2"></font>
					</div>
					<div class="int-area">
					
						<input type="text" name="memberName" id="name" autocomplete="off" required> 
						<label for="name">이름</label>
							<font id="name_check" size="2"></font>
							
					</div>
					<div class="int-area">
					
						<input type="text" name="memberEmail" id="email" autocomplete="off"	required> 
						<label for="email">E-mail</label>
								<font id="email_check" size="2"></font>
						
							
					</div>
					<div class="int-area">
					
						<input type="text" name="memberNickname" id="nickname" autocomplete="off" required> 
						<label for="nickname">닉네임</label>
								<font id="nickname_check" size="2"></font>
							
					</div>
					<div class="birth">
						<div class="int-area table_cell">
						
							<input type="number" name="year" id="year" autocomplete="off"	required> 
							<label for="year">년(4자)</label>
								
						</div>
						<div class="int-area table_cell select_opt">
							<select id="month" name="month">
								<option value="1">1월</option>
								<option value="2">2월</option>
								<option value="3">3월</option>
								<option value="4">4월</option>
								<option value="5">5월</option>
								<option value="6">6월</option>
								<option value="7">7월</option>
								<option value="8">8월</option>
								<option value="9">9월</option>
								<option value="10">10월</option>
								<option value="11">11월</option>
								<option value="12">12월</option>
							</select>
						</div>
						<div class="int-area table_cell">
						
							<input type="number" name="date" id="date" autocomplete="off" required> 
							<label for="date">일</label>
								
						</div>
					</div>
					<div class="btn-area">
						<input type="submit" value="가입">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
		
		//모든 공백 체크 정규식
		var empJ = /\s/g;
		//아이디 
		var idJ = /^[[A-Za-z0-9]{4,12}$/;
		// 비밀번호 
		var pwJ =  /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		// 이름 
		var nameJ = /^[가-힣]{2,6}$/;
		// 닉네임
		var ninkJ = /^[가-힣][A-Za-z0-9]{4,12}$/;
		// 이메일 검사 
		var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		$(document).ready(function(){
   
			 //아이디 유효성 체크
		$("#id").blur(function() {
			if (idJ.test($(this).val())) {
					console.log(idJ.test($(this).val()));	
					$("#id_check").text('');
			} else {
			/* 	alert('아이디는 4자 이상 12자 이하여야하며 ,대문자/소문자/숫자만 사용할 수 있습니다.'); */
				$('#id_check').text('아이디를 다시 입력해주세요');
				$('#id_check').css('color', '#f82a2aa3'); 
			}
		});
		 //비밀번호 유효성 체크
		$("#pw").blur(function() {
			if (pwJ.test($(this).val())) {
					console.log(pwJ.test($(this).val()));	
					$("#pw_check").text('');
			} else {
			/* 	alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.'); */
		   $('#pw_check').text('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
				$('#pw_check').css('color', '#f82a2aa3'); 
			}
		});
		 
		 //비밀번호 확인 체크
 $('#pw').keyup(function(){
      $('#chkNotice').html('');
    });

    $('#pw2').keyup(function(){

        if($('#pw').val() != $('#pw2').val()){
          $('#chkNotice').html('비밀번호가 일치하지 않습니다.<br><br>');
          $('#chkNotice').attr('color', '#f82a2aa3');
        } else{
          $('#chkNotice').html('비밀번호가 일치합니다<br><br>');
          $('#chkNotice').attr('color', '#199894b3');
        }

    });
		 //이름 유효성 체크
		$("#name").blur(function() {
			if (nameJ.test($(this).val())) {
					console.log(nameJ.test($(this).val()));	
					$("#name_check").text('');
			} else {
				/* alert('이름은 2자 이상 6자 이하여야 하며, 한글만을 사용해야 합니다.'); */
			 $('#name_check').text('이름을 다시 입력해주세요');
				$('#name_check').css('color', '#f82a2aa3'); 
			}
		});
		 //이메일 유효성 체크
		$("#email").blur(function() {
			if (mailJ.test($(this).val())) {
					console.log(mailJ.test($(this).val()));	
					$("#email_check").text('');
			} else {
			/* 	alert('이메일을 다시 입력해주세요'); */
	 	$('#email_check').text('이메일을 다시 입력해주세요');
				$('#email_check').css('color', '#f82a2aa3');
			}
		});
		 //닉네임 유효성 체크
		$("#nickname").blur(function() {
			if (ninkJ.test($(this).val())) {
					console.log(ninkJ.test($(this).val()));	
					$("#nickname_check").text('');
			} else {
				/* alert('이름은 4자 이상 12자 이하여야 하며, 한글/소문자/대문자만을 사용해야 합니다.'); */
			$('#nickname_check').text('닉네임을 다시 입력해주세요');
				$('#nickname_check').css('color', '#f82a2aa3'); 
			}
		});
		});
		 
	</script>
</body>
</html>