<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
	<div class="section">
		<div class="box">
			<%@ include file="/WEB-INF/frame/crew/crew-manage-nav.jsp"%>
			<div class="edit_section">
				<form>
					<table>
						<tr>
							<td><label for="crewname">크루명</label></td>
							<td>
								<p id="crewname" class="text_bold">idid1234</p>
							</td>
						</tr>
						<tr>
							<td><label for="confirm">확인</label></td>
							<td><input type="text" class="form-control remove_input"
								placeholder="삭제를 원하시면 크루명을 입력해주세요."></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="삭제"
								class="form-control btn-secondary"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</html>