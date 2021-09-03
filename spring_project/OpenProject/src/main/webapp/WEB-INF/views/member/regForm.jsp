<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

<style>
.display_none {
	display: none;
}

.color_blue {
	color: blue;
}

.color_red {
	color: red;
}

#loadingimg {
	height: 20px;
}
</style>

</head>
<body>

	<%--@ include file="/WEB-INF/views/frame/header.jsp"--%>
	<%--@ include file="/WEB-INF/views/frame/nav.jsp"--%>
<%@ include file="/WEB-INF/views/frame/bootstrap_header.jsp"%>


	<main role="main" class="container-fluid">
		
		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h2>회원가입</h2>
		<hr>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디 <span class="text-danger">*</span></td>
					<td><input type="text" name="memberRegRequest.memberid" id="memberid" class="form-control m-2">
						<span id="msg" class="display_none"></span> <img id="loadingimg"
						class="display_none" alt="loading"
						src="<c:url value="/images/loading.gif"/>"></td>
				</tr>
				<tr>
					<td>비밀번호 <span class="text-danger">*</span></td>
					<td><input type="password" name="memberRegRequest.password" id="password" class="form-control m-2"></td>
				</tr>
				<tr>
					<td>이름 <span class="text-danger">*</span></td>
					<td><input type="text" name="memberRegRequest.membername" id="membername" class="form-control m-2"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="memberRegRequest.photo" id="photo" class=" m-2"></td>
				</tr>
				
				
				<tr>
					<td>주소</td>
					<td>
						<input type="text" id="sample2_postcode" name="memberRequestAddress.zipcode" placeholder="우편번호" class="form-control m-2   ">
					</td>
					<td class="pl-2">
						<input type="button" class="form-control m-2  btn btn-dark  " onclick="sample2_execDaumPostcode()" value="우편번호 찾기">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="text" id="sample2_roadAddress" name="memberRequestAddress.address1" placeholder="도로명주소" class="form-control m-2   ">
						<span id="guide" style="color:#999;display:none"></span>
						<input type="text" id="sample2_detailAddress" name="memberRequestAddress.address2" placeholder="상세주소" class="form-control m-2   ">
						
						<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch; width: 300px;">
							<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
						</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample2_extraAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("sample2_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample2_postcode').value = data.zonecode;
                document.getElementById("sample2_roadAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample2_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
        var width = 300; //우편번호서비스가 들어갈 element의 width
        var height = 400; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 5; //샘플에서 사용하는 border의 두께

        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
						</div>
					</td>
					
				</tr>
				
				
				
				
			
				
				
				
				<tr>
					<td></td>
					<td>
						<input type="submit"  class="form-control m-2 btn btn-primary"> <input type="reset" class="form-control m-2 btn btn-info">
					</td>
				</tr>
			</table>
		</form>

			<div>
			ajax로 회원 가입 <input type="button" value="회원가입" id="btnReg1" class=" m-2 btn btn-primary">
			</div>
			<div>
			ajax로 Json 전송 회원 가입 <input type="button" value="회원가입" id="btnReg2" class=" m-2 btn btn-primary">
			</div>
		</div>

	</main>



<%@ include file="/WEB-INF/views/frame/footer.jsp" %> 



<script>
	$(document).ready(function() {

		$('#memberid').focusin(function() {
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');

			$(this).val('');
		});

		$('#memberid').focusout(function() {
			// ajax 비동기 통신 > id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다 -> 화면에 메시지 출력

			$.ajax({
				url : '<c:url value="/member/idCheck"/>',
				type : 'post',
				data : {
					mid : $(this).val()
				},
				beforeSend : function() {
					$('#loadingimg').removeClass('display_none');
				},
				success : function(data) {
					// data : Y / N
					if (data == 'Y') {
						$('#msg').html('사용가능');
						$('#msg').addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('사용 불가능');
						$('#msg').addClass('color_red');
						$('#msg').removeClass('display_none');
					}
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

	});
</script>




	<script>
		$(document).ready(function() {

			$('#btnReg1').click(function() {

				var photoFile = $('#photo');

				var file1 = photoFile[0].files[0];

				//console.log(file1);

				var formData = new FormData();
				formData.append("memberid", $('#memberid').val());
				formData.append("password", $('#password').val());
				formData.append("membername", $('#membername').val());
				formData.append("photo", file1);

				console.log(formData);

				$.ajax({
					url : '/op/members/reg1',
					type : 'post',
					data : formData,
					enctype : 'multipart/form-data',
					processData : false,
					contentType : false,
					cache : false,
					success : function(data) {
						console.log(data);
						if(data==1){
							alert('회원가입이 되었습니다.');
						}
					}
				});

			});
			
			

			$('#btnReg2').click(function() {


				var userid = $('#memberid').val();
				var pw = $('#password').val();
				var username = $('#membername').val();

				var member = {
						memberid: userid,
						password: pw,
						membername: username
				}
				
				console.log(JSON.stringify(member));
				
				$.ajax({
					url : '/op/members/reg2',
					type : 'post',
					data : JSON.stringify(member),
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {
						console.log(data);
						if(data==1){
							alert('회원가입이 되었습니다.');
						}
					}
				});

			});

		});
	</script>










</body>
</html>