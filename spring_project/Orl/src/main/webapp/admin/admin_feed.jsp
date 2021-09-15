<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>크루 관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/admin/crew.css'/>">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/admin/header.jsp" %>


<div class="container">
  <h2>피드 관리</h2>
  <p> 찾을 내용을 입력해주세요. Type something in the input field to search the table for first names, last names or emails:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped table-hover">
    <thead>
      <tr>
        <th>IDX</th>
        <th>사진</th>
        <th>설명</th>
        <th>해시태그</th>
        <th>멤버닉네임</th>
        <th>멤버프로필</th>
        <th>관리</th>
      </tr>
    </thead>
    <tbody id="myTable">
    <c:forEach items="${feedList}" var="list">
      <tr>
        <td>${list.boardIdx}</td>
        <td><img src="<c:url value='/images/feed/${list.boardPhoto}'/>" style="width:100px" ></td>
        <td>${list.boardDiscription}</td>
        <td style="max-width:400px">${list.hashtag}</td>
        <td style="max-width:100px">${list.memberNickname}</td>
        <td><img src="<c:url value='/images/member/${list.memberProfile}'/>" style="width:100px"></td>
        <td><p class="text-center">${list.memberNickName}</p></td>
        <td>
             <a id = "deleteId" href="<c:url value='/admin/feed/delete?boardIdx=${list.boardIdx}'/>" onclick="if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a>
        </td>
           <td>
        	
<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">피드 미리보기</h4>
      </div>
      <div class="modal-body selectList">
                <div class="item">
	                 <img class="img" src="" alt="" width="80px" height="80px">
                    <span>#이름</span>
                </div>
                 <div class="item">
	                 <img class="img" src="" alt="" width="80px" height="80px">
                    <span>#이름</span>
                </div>
                 <div class="item">
	                 <img class="img" src="" alt="" width="80px" height="80px">
                    <span>#이름</span>
                </div>
      			 <div class="item">
	                 <img class="img" src="" alt="" width="80px" height="80px">
                    <span>#이름</span>
                </div>
      			 <div class="item">
	                 <img class="img" src="" alt="" width="80px" height="80px">
                    <span>#이름</span>
                </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" >save changes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
        
        
        </td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
  
  <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
  
  
  

 <!--페이징-->
        <!-- <div class="delete pull-right">
       		<input class="btn btn-default" type="submit" value="일괄삭제">
        </div> -->
        <div class="pres">
            <h4 class="hidden">현재 페이지</h4>
            <div><span>1</span> / 1 pages</div>
        </div>


      <div class="text-center">
      <nav aria-label="Page navigation example">
		  <ul class="pagination  justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li>
		  </ul>
	</nav>
     </div>   
</div>





<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>
</html>
