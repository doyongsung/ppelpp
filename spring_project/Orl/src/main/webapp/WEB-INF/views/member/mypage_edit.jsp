<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<%@ include file="/WEB-INF/frame/default/header.jsp"%>
	<div class="section">
		<div class="box">
			<%@ include file="/WEB-INF/frame/member/member-mypage-nav.jsp"%>
			<div class="edit_section">
				<form>
					<table>
						<tr>
							<td><img id="profile2"
								src="<c:url value='/images/default.jpg'/>"></td>
							<td>
								<p id="id" class="text_bold">idid1234</p> <a href="#">프로필 사진
									바꾸기</a>
							</td>
						</tr>
						<tr>
							<td><label for="name">이름</label></td>
							<td><input type="text" id="name" name="name"
								class="form-control"></td>
						</tr>
						<tr>
							<td><label for="nickname">닉네임</label></td>
							<td><input type="text" id="nickname" name="nickname"
								class="form-control"></td>
						</tr>
						<tr id="divide">
							<td></td>
							<td>
								<p>개인정보</p>
							</td>
						</tr>
						<tr>
							<td><label for="email">이메일</label></td>
							<td><input type="text" id="email" name="email"
								class="form-control"></td>
						</tr>
						<tr>
							<td><label for="birth">생년월일</label></td>
							<td>
								<div class="birth">
									<div class="table_cell">
										<input type="number" placeholder="년(4자)" class="form-control">
									</div>
									<div class="table_cell">
										<select class="form-control">
											<option value="1">1월</option>
											<option value="1">2월</option>
											<option value="1">3월</option>
											<option value="1">4월</option>
											<option value="1">5월</option>
											<option value="1">6월</option>
											<option value="1">7월</option>
											<option value="1">8월</option>
											<option value="1">9월</option>
											<option value="1">10월</option>
											<option value="1">11월</option>
											<option value="1">12월</option>
										</select>
									</div>
									<div class="table_cell">
										<input type="number" placeholder="일" class="form-control">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="변경하기"
								class="form-control btn-secondary"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>