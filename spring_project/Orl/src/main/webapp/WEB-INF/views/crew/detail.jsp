<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루 상세</title>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-detail.css'/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
const crewTag = '${crew.crewTag}';
const crewIdx = '${crew.crewIdx}';
const memberIdx = '${sessionScope.memberVo.memberIdx}';
const currentPageNum = parseInt('${cri.currentPageNum}');

/*부트서버*/
const url = 'http://localhost:8081';
/*뷰 서버*/	
const url2 = '${pageContext.request.contextPath}';
</script>
<script src="<c:url value='/js/crew/detail.js'/>"></script>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
<c:if test="${updateResult eq 1}">
<script>
	alert('수정되었습니다.')
</script>
</c:if>
	<div class="section">
		<section>
			<div class="box">
				<div class="card">
					<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>" class="card-img-top" alt="..." id="cardImg">
						
					<div class="card-body">
					
						<div class="crew_name_section">
							<h3 class="card-title">${crew.crewName}</h3>
							<c:if test="${memberVo.memberIdx eq crew.memberIdx}">
							<a href='<c:url value="/crew/edit/${crew.crewIdx}"/>'
								class="btn btn-sm color_blue text_bold">크루 관리</a>
							</c:if>
						</div>
						
						<pre class="card-text">${crew.crewDiscription}</pre>
						<ul class="crew_hashtag" id="crewHashTag"></ul>
						
						<div class="crew_information">
							<span class="crew_captain">
								<c:if test="${memberVo ne null}">
									<a href="<c:url value='/feed/userfeed/${crew.memberIdx}'/>">
								</c:if>
									<p class="text_bold">${crew.memberNickName}</p> 
								<img id="profile" src="<c:url value='/images/member/profile/${crew.memberProfile}'/>">
								<c:if test="${memberVo ne null}">
									</a>
								</c:if>
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
							<div class="join_section" id="joinToCrew">
	              <button class="btn btn-light">가입하기</button>
	            </div>
            </c:if>
            <c:if test="${crew.isReg eq true and sessionScope.memberVo.memberIdx ne crew.memberIdx}">
            	<div class="join_section" id="outFromCrew">
            		<button class="btn btn-light">탈퇴하기</button>
            	</div>
            </c:if>
					</div>
				</div>
				
				<div class="comment_section">
					<div class="comment_table">
						<table id="commentList">
							
						</table>
					</div>
					
					<div class="input_section">
						<div>
							<ul class="pagination" id="paging">
							</ul>
						</div>
						
						<c:if test="${crew.isReg ne true}">
							<div class="input_control">
								<div>
									<input type="text" class="form-control" readonly="readonly">
								</div>
								<div>
									<input type="submit" value="게시" class="btn1 btn-light form-control" readonly="readonly">
								</div>
							</div>
						</c:if>
						<c:if test="${crew.isReg eq true}">
							<form method="post">
								<div class="input_control">
									<div>
										<input type="text" name="crewComment" class="form-control" id="crewComment">
										<input type="hidden" value="${crew.crewIdx}" id="crewIdx">
									</div>
									<div>
										<input type="submit" value="게시" class="btn1 btn-light form-control" id="submit">
									</div>
								</div>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>