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
.nav{
padding-left: 50%;
}
.logo{
padding-top: 10px;
}
</style>
<script>


$(document).ready(function(){
	var cList=[];
/* 	
	 $.ajax({
		url:'<c:url value="/crew/."/>',
		type:'GET',
		data:{searchType:'${searchType}'},
		dataType : 'json',
		success:function(data){
			cList = data;
			crewList(cList);
		}
	}) */ 

		$.ajax({
			url:'<c:url value="/crew/searchList"/>',
			type:'GET',
			data:{"search":$("#search").val(),
				"selectSearch":$("#selectSearch").val()},
			dataType : 'json',
		success:function(data){
			console.log("실행되었습니다.	")
			cList = data;
			crewList(cList);
		}
		});
	
		
	
 	/* 	$.ajax({
		url:'<c:url value="/crew/crewName"/>',
		type:'GET',
		data:{crewName:'${crewName}'},
		dataType : 'json',
		success:function(data){
			cList = data;
			crewList(cList);
		}
	})   */
	
	$('#nameList').click(function(){
		console.log("이름순으로 정렬");
	  console.log(cList);
	  cList.sort(function(a,b){
		  a = a.crewName;
			b = b.crewName;
		return a < b ? - 1 : a > b ? 1 : 0;
	})
	
	crewList(cList);
	})

		$('#newestList').click(function(){
		console.log("최신순으로 정렬");
	  console.log(cList);
	  cList.sort(function(a,b){
		a = a.crewCreatedate;
		b = b.crewCreatedate;
		return a > b ? -1 : a < b ? 1 : 0;
	})
	crewList(cList);
	})
	
		$('#oldList').click(function(){
		console.log("오래된순으로 정렬");
	  console.log(cList);
	  cList.sort(function(a,b){
			a = a.crewCreatedate;
			b = b.crewCreatedate;
		  return a < b ? -1 : a > b ? 1 : 0;
	})
	crewList(cList);
	})
	
});

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
					html+='<a href="<c:url value="/crew/detail/'+item.crewIdx+'&1"/>">';
					html+='<img src="<c:url value="/images/crew/'+item.crewPhoto+'"/>"  class="card-img-top" alt="card image cap">';
          html+='<div class="card-body text-left">';
          html+='<h4 class="card-title">크루 이름: '+item.crewName+' </h4>';
          html+='<p class="card-text">크루장: '+item.memberNickName+'</p>';
          html+='<p class="card-text">크루소개 : '+item.crewDiscription+'</p>';
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
							<a href='<c:url value="/crew/detail/${crew.crewIdx}&1"/>'>
							<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>"></a>
						</div>
						<p>${crew.crewName}</p>
					</div>
					
				</c:forEach>
			</c:if>
        </div>
        <div class="container">
            <div class="search-box">
                    <div class="dropdown">
                        <h1>CREW</h1>
                        <button class="curved" id="nameList">이름순으로 보기</button>
                        <button class="curved" id="newestList">최신순으로 보기</button>
                        <button class="curved" id="oldList">오랜된 순으로 보기</button>
                    </div>
                    <div class="select-option">
                    <form action="" name="frm" id="form">
                      <div class="search-drop">
                              <select name="searchType" id="selectSearch" >
                              	  <option selected disabled>검색</option>
                                  <option value="name">크루 이름</option>
                                  <option value="nickName">닉네임</option>
                                  <option value="tag">해시태그</option>
                                </select>
                                <div class="boxSearch">
                                    <span class="icon"><i id="searchType"class="fa fa-search" aria-hidden="true"></i></span>
                                    <input id="search"class="search"  type="text" name="keyword" placeholder="Type to search">
                                </div>
                            </div>
                        </form>
                    </div>
                       
                    </div>



    	<div class="row">
						 <div id="cList"> </div>
 				 <%--  <c:forEach items="${list}" var="crew">
				<div class="col-md-4">
					<div class="card shadow">
					<div class="inner">
				  <div>
					<a href="<c:url value="/crew/detail/${crew.crewIdx}&1"/>">
					<img src="<c:url value="/images/crew/${crew.crewPhoto}"/>"  class="card-img-top" alt="card image cap">
					</a>
          <div class="card-body text-left">
          <h4 class="card-title">크루 이름: ${crew.crewName}</h4>
          <p class="card-text">크루장: ${member.memberNickname}</p>
          <p class="card-text">크루소개 : ${crew.crewName}</p>
          </div>
					</div>
					</div>
					</div>
					</div>
          </c:forEach>  --%>
			</div> 
		  
	</div>
 <div class="paging-div">
	<nav aria-label="Page navigation example">
	<ul class="pagination" id="pagination">
    <c:if test="${pageMaker.prev}">
        <li class="page-item">
            <a class="page-link" href="<c:url value="/crew/list/${pageMaker.makeQuery(pageMaker.startPage - 1)}"/>">prev</a>
        </li>  
    </c:if>
    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="index">
    <li class="page-item">
        <a class="page-link" href="<c:url value="/crew/list/${pageMaker.makeQuery(index)}"/>">${index}</a>
   </li>
    </c:forEach>
 
    <c:if test="${pageMaker.next}">
  
        <li class="page-item">
            <a class="page-link" href="<c:url value="/crew/list/${pageMaker.makeQuery(pageMaker.endPage + 1)}"/>">next</a>
        </li>
    </c:if>  
</ul>
</nav>
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