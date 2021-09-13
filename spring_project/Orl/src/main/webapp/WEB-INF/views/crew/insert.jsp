<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크루 생성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/css/crew/insert.css'/>">
<script defer src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
<script defer src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script defer type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" charset="utf-8"></script>
<script defer src="<c:url value='/js/crew/insert.js'/>"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>
	<div class="section">
		<div class="box">
    	<div class="edit_section">
        <form method="post" enctype="multipart/form-data" id="tag-form">
        	 <table>
           	<div class="create">
            	<h1>생성하기</h1>
            </div>
            <tr>
            	<td>
              	<label for="crewName">크루명</label>
              </td>
              <td>
              	<input type="text" id="crewName" name="crewName" class="form-control" required="required">
              	<div id="msg" class="display_none"></div>
              	<font id="crewName_check" size="2"></font>
              </td>
            </tr>
          	<tr>
          		<td>
		            <label for="crewPhoto">크루 사진</label>
		         	</td>
		          <td>   
		          	<img src="<c:url value="/images/crew/default.jpg"/>" id="img" class="hiking" title="클릭하시면 원본크기로 보실 수 있습니다." style="cursor: pointer;" onclick="doImgPop(this.src)"/>
		            <input type="file" id="crewPhoto" name="crewPhoto" class="form-control form-control-lg" required="required">
		         	</td>
		        </tr>
		        <tr>
		        	<td>
		          	<label for="crewDiscription">크루 소개글</label>
		          </td>
		         	<td>
		          	<input type="text" id="crewintro" name="crewDiscription" class="form-control" placeholder="새로운 크루 소개글을 입력해주세요!" required="required">

		          </td>
		        </tr>
		        <tr>
		        	<td>
		          	<div class="tr_hashTag_area">
		            	<p><strong>해시태그</strong></p>
		            </div>
		          </td>
		        	<td>
			        	<ul id="tag-list"></ul>
			          <div class="form-group">
			          	<input type="text" id="tag" size="7" placeholder="#" style="width: 300px;" />
			          </div>
		          </td>
		        </tr>
		        <tr>
           		<td>
              	<input type="submit" value="생성" class="form-control btn-secondary">
            	</td>
           	</tr>
          </table>
       </form>
     </div>
   </div>
 </div>
<%@ include file="/WEB-INF/frame/default/footer.jsp" %>
<script src="//code.jquery.com/jquery.min.js"></script>
    <script>
    
    $(document).ready(function(){
    	
    var ninkJ = /^[가-힣A-Za-z0-9]{4,12}$/;
    
	 //닉네임 유효성 체크
	$("#crewName").blur(function() {
		if (ninkJ.test($(this).val())) {
				console.log(ninkJ.test($(this).val()));	
				$("#crewName_check").text('');
		} else {
		/* 	alert('이름은 4자 이상 12자 이하여야 하며, 한글/소문자/대문자만을 사용해야 합니다.'); */
    	$('#crewName_check').text('닉네임을 다시 입력해주세요');
			$('#crewName_check').css('color', '#f82a2aa3'); 
		}
	
	});
	});
	 
	$('#crewName').focusout(function() {
		// ajax 비동기 통신 > id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다 -> 화면에 메시지 출력
		$.ajax({
            url: '<c:url value="/crew/nameCheck"/>',
			type : 'get',
			data : {
				crewName : $(this).val()
			},
			beforeSend : function() {
				$('#loadingimg').removeClass('display_none');
			},
			success : function(data) {
				// data : Y / N
				if (data == 'Y') {
					$('#msg').html('사용 가능');
					$('#msg').addClass('color_blue');
					$('#msg').removeClass('display_none');
				} else {
					$('#msg').html('사용 불가능');
					$('#msg').addClass('color_red');
					$('#msg').removeClass('display_none');
				}
			console.log("처리 성공시 변경되는 내용")
			},
			error : function(request, status, error) {
				alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
				console.log(request);
				console.log(status);
				console.log(error);
			},
			complete : function() {
				$('#loadingimg').addClass('display_none');
			}
		});
	});
	
	  
    </script>
</body>
</html>