<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-detail.css'/>">
</head>
<body>
	<div class="section">
		<section>
			<div class="box">
				<div class="card">
				
					<img src="<c:url value='/images/hiking2.jpg'/>" class="card-img-top" alt="...">
						
					<div class="card-body">
						<div class="crew_name_section">
						
							<h3 class="card-title">${crew.crewName}</h3>
							
							<c:if test="${member.memberIdx eq crew.memberIdx}">
							<a href='<c:url value="/crew/edit"/>'
								class="btn btn-sm color_blue text_bold">크루 관리</a>
							</c:if>
							
						</div>
						
						<p class="card-text">${crew.crewDiscription}</p>
						<p class="crew_hashtag">${crew.crewTag}</p>
						
						<div class="crew_information">
							<span class="crew_captain">
								<p class="text_bold">${crew.memberNickName}</p> 
								<img id="profile" src="<c:url value='/images/default.jpg'/>">
							</span>
							<span class="crew_number">
								<p class="text_bold">크루원</p>
								<p>${crew.crewMemberNum}</p>
							</span>
							<span class="crew_comment_number">
								<p class="text_bold">댓글</p>
								<p>${crew.crewCommentNum}</p>
							</span>
						</div>
						
						<c:if test="${crew.isReg ne true}">
						<div class="join_section">
               <a href="#" class="btn btn-sm btn-light">가입하기</a>
            </div>
            </c:if>
						
					</div>
				</div>
				
				<div class="comment_section">
					<div class="comment_table">
						<div>
							<table>
							
								<c:if test="${commentList ne null and not empty commentList}">
									<c:forEach items="${commentList}" var="comment">
										<tr>
											<td><img id="profile" src="<c:url value='/images/default.jpg'/>"></td>
											<td>
												<p id="nickname">${comment.memberNickName}</p>
												<p class="content">${crewComment}</p>
												<p class="date">${crewCommentDate}</p>
											</td>
									</tr>
									</c:forEach>
								</c:if>
								
							</table>
						</div>
					</div>
					
					<div class="input_section">
						<div>
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">&lt</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">4</a></li>
								<li class="page-item"><a class="page-link" href="#">5</a></li>
								<li class="page-item"><a class="page-link" href="#">&gt</a></li>
							</ul>
						</div>
						
						<div class="input_control">
							<div>
								<input type="text" class="form-control">
							</div>
							<div>
								<input type="submit" value="게시"
									class="btn1 btn-light form-control">
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>