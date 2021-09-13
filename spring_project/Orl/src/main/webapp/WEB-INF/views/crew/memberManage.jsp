<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크루 관리</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function(){
		
		getCrewMemberList();
		
		$('#crewMemberList').on('click', 'button', function(){
			$.ajax({
				url: 'http://localhost:8080/orl/crew/deleteCrewMemberFromList',
				type: 'get',
				data: {
					memberIdx : $('input', $(this).parent()).val(),
					crewIdx : '${crew.crewIdx}'	
				},
				success : function(data){
					if(data==0){
						alert('추방에 실패했습니다.');
					} else if(data==1){
						alert('해당 멤버를 추방했습니다.');
					}
					getCrewMemberList();
				}
			});	
		});
		
	});
	
	function getCrewMemberList(){
		$.ajax({
			url: 'http://localhost:8080/orl/crew/getCrewMemberList',
			type: 'GET',
			data: {crewIdx: '${crew.crewIdx}'},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
			success: function(data){
				var html = '';
				$.each(data, function(index, item){
					html += '<tr>';
					html += '<td>'+Number(index+1)+'</td>';
					html += '<td><img id="profile" src="<c:url value="/images/default.jpg"/>"></td>';
					html += '<td id="nickname">'+item.memberNickName+'</td>';
					html += '<td class="date">'+item.crewRegdate+'</td>';
					if(item.memberIdx != '${sessionScope.member.memberIdx}'){
						html += '<td><button class="btn" id="button">추방</button>';
						html += '<input type="hidden" id="memberIdx" value="'+item.memberIdx+'"></td>';
					} else {
						html += '<td><input type="button" class="btn" value="나"></td>'
					}
					html += '</tr>';
				});
				$('#crewMemberList').html(html);
			}
		});
	}
</script>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
<c:if test="${chk ne null && chk eq false}">
	<script>
		alert('해당 페이지에 접근 할 권한이 없습니다.');
		location.href="<c:url value='/'/>";
	</script>
</c:if>
	<div class="section">
		<div class="box">
			<%@ include file="/WEB-INF/frame/crew/crew-manage-nav.jsp"%>
			<div class="edit_section">
				<label for="crewname">크루명</label>
					<table id="crewMemberList" class="table table-hover">
					</table>
			</div>
		</div>
	</div>
</body>
</body>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</html>