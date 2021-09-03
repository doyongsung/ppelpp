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
$(document).ready(function(){
	
	var cList=[];
	
	$.ajax({
		url:'<c:url value="/crew/crewName"/>',
		type:'GET',
		data:{crewName:'${crewName}'},
		dataType : 'json',
		success:function(data){
			cList = data;
			crewList(cList);
		}
	})
	
	$('#nameList').click(function(){
		console.log("이름순으로 정렬");
	  console.log(cList);
	  cList.sort(function(a,b){
		return a.crewName<b.crewName?-1:a.crewName>b.crewName?1:0;
	})
	crewList(cList);
	})
})	


function crewList(cList){
		var ccList=[];
		ccList=cList;
		console.log("리스트 함수 호출");
		console.log(ccList);
	
				var html='<div id="row" class="row">';
				
				$.each(ccList,function(index,item){
					html+='<div class="col-md-4">';
					html+='<div class="card shadow">';
					html+='<div class="inner">';
					html+='<div>';
					html+='<a href="<c:url value="/crew/detail/'+item.crewIdx+'"/>">';
					html+='<img src="<c:url value="/images/crew/'+item.crewPhoto+'"/>"  class="card-img-top" alt="card image cap">';
          html+='<div class="card-body text-left">';
          html+='<h4 class="card-title">크루 이름: '+item.crewName+' </h4>';
          html+='<p class="card-text">크루장: '+item.memberNickName+'</p>';
          html+='<p class="card-text">크루소개 : '+item.crewDiscription+'</p>';
          html+='<a href="#" class="btn btn-success">GO</a>';
          html+='</div>';
          html+='</a>';
					html+='</div>';
					html+='</div>';
					html+='</div>';
					html+='</div>';
					
					$('#cList').html(html);
				})
	}

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
           <button class="curved" id="nameList">이름순으로 보기</button>
            </div>

						<div id="cList">
            <div class="row">
        
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