<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="<c:url value='/css/crew/list.css'/>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<style>
.justify-content-center {
    justify-content: flex-start;
}
</style>
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
<body>

<%@ include file="/WEB-INF/frame/default/header.jsp" %>
    <div class="section">
        <div class="article">
         	<h1>MY CREW</h1>

		 	<c:if test="${myCrewList ne null and not empty myCrewList}">
		  	<c:forEach items="${myCrewList}" var="crew">
						<div class="article-crew">
				  	<div>
							<a href='<c:url value="/crew/detail/${crew.crewIdx}"/>'>
							<img src="<c:url value="/images/hiking2"/>"></a>
						</div>
						<p>${crew.crewName}</p>
					</div>
				</c:forEach>
			</c:if>
        </div>
        <div class="container">
            <div class="search-box">
            <form>
                <h1>POPULAR CREW</h1>
                <select name="searchType">
                <option value="name">크루 이름</option>
                <option value="nickName">닉네임</option>
                <option value="tag">해시태그</option>
                </select>
                <input class="search" type="text" name="keyword" placeholder="Type to search">
                <input type="submit" value="검색">
                <a class="search-btn" onclick="menuToggle();" href="#">	
                    <i class="fa fa-search" aria-hidden="true"></i>
                </a>
            </form>
            </div>
            <div class="dropdown">
                <ul class="select">
                    <li><a href="#">최신 순</a></li>
                    <li><a href="#">이름 순</a></li>
                    <li><a href="#">오래된 순</a></li>
                </ul>
            </div>
            
            <div class="row">
            <c:forEach items="${crewList}" var="crew">
                <div class="col-md-4">
                    <div class="card shadow" style="width: 25rem; height: 35rem;">
                        <div class="inner">
                            <div>
                            <a href="<c:url value='/crew/detail/${crew.crewIdx}'/>">
                            <img src="<c:url value='/images/crew/${crew.crewPhoto}'/>" 
                            class="card-img-top" alt="card image cap"></a>
                           </div>
                        </div>
                        <div class="card-body text-left">
                            <h4 class="card-title">크루 이름: ${crew.crewName}</h4>
                            <p class="card-text">크루장: ${crew.memberNickName}</p>
                            <p class="card-text">크루소개 : ${crew.crewDiscription}</p>
                            <a href="#" class="btn btn-success">GO</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
        <div class="page">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                 <!--    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li> -->
                    
                      <c:if test="${pageMaker.prev}">
		      <li class="page-item" id="page"><a class="page-link" href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		      <li class="page-item" id="page"><a class="page-link" href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		      <li class="page-item" id="page"><a class="page-link" href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
		    </c:if> 
                </ul>
            </nav>
            <div class="crew-insert">
                <a href="<c:url value='/crew/insert'/>">크루 생성하기</a>
            </div>
        </div>
    </div>
    
   <%@ include file="/WEB-INF/frame/default/footer.jsp" %>
    <script>
        function menuToggle() {
            const toggleMenu = document.querySelector('.menu');
            toggleMenu.classList.toggle('active')
        }
    </script>
</body>
</html>