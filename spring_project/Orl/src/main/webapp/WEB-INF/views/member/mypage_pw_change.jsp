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
								<p id="id" class="text_bold">idid1234</p>
							</td>
						</tr>
						<tr>
							<td><label for="pw">이전 비밀번호</label></td>
							<td><input type="password" id="pw" name="pw"
								class="form-control"></td>
						</tr>
						<tr>
							<td><label for="newpw">새 비밀번호</label></td>
							<td><input type="password" id="newpw" name="newpw"
								class="form-control"></td>
						</tr>
						<tr>
							<td><label for="newpw2">새 비밀번호 확인</label></td>
							<td><input type="password" id="newpw2" name="newpw2"
								class="form-control"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="비밀번호 변경"
								class="form-control btn-secondary"></td>
						</tr>
						<tr>
							<td colspan="2"><a href="#">
									<p class="pw_link">비밀번호를 잊으셨나요?</p>
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>