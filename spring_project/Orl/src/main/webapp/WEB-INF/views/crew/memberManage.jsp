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
				<label for="crewname">크루명</label>
				<form>
					<table class="table table-hover">
						<tr>
							<td>idx</td>
							<td><img id="profile"
								src="<c:url value='/images/default.jpg'/>"></td>
							<td id="nickname">닉네임</td>
							<td class="date">21-08-18 03:23</td>
							<td><input type="submit" class="btn" value="추방"></td>
						</tr>
						<tr>
							<td>idx</td>
							<td><img id="profile"
								src="<c:url value='/images/default.jpg'/>"></td>
							<td id="nickname">닉네임</td>
							<td class="date">21-08-18 03:23</td>
							<td><input type="submit" class="btn" value="추방"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</body>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</html>