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
							<td><input type="text" id="crewname" name="crewname"
								class="form-control" placeholder="원래 크루명이 자동으로 뜨도록 처리">
							</td>
						</tr>
						<tr>
							<td><label for="crewname">크루 사진</label></td>
							<td><img id="hiking" src="hiking.jpg"> <input
								type="file" id="crewphoto" name="crewphoto"
								class="form-control form-control-lg"></td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td><label for="crewintro">크루 소개글</label></td>
							<td><input type="text" id="crewintro" name="crewintro"
								class="form-control" placeholder="새로운 크루 소개글을 입력해주세요!">
							</td>
						</tr>
						<tr>
							<td><label for="crewhash">크루 해시태그</label></td>
							<td><input type="text" id="crewhash" name="crewhash"
								class="form-control"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="수정"
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