<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크루 생성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/css/crew/insert.css'/>">
<script defer src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
<script defer src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script defer type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" charset="utf-8"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script defer src="<c:url value='/js/crew/insert.js'/>"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>
	<div class="section">
		<div class="box">
    	<div class="edit_section">
           	<div class="create">
            	<h1>크루 생성</h1>
            </div>
        <form method="post" enctype="multipart/form-data" id="tag-form">
        	 <table>
            <tr>
            	<td>
              	<label for="crewName">크루명</label>
              </td>
              <td>
               	<input type="text" id="crewName" name="crewName" class="form-control" required="required">
              	<div id="msg" class="display_none"></div>
              	<font id="crewName_check" size="2"></font>
              </td>
            </tr>
          	<tr>
          		<td>
		            <label for="crewPhoto">크루 사진</label>
		         	</td>
		          <td>
		          	<img src="<c:url value="/images/crew/5050.png"/>" id="img" class="hiking" title="클릭하시면 원본크기로 보실 수 있습니다." style="cursor: pointer;" onclick="doImgPop(this.src)"/>
		            <input type="file" id="crewPhoto" name="crewPhoto" class="form-control form-control-lg" required="required">
		         	</td>
		        </tr>
		        <tr>
		        	<td>
		          	<label for="crewDiscription">크루 소개글</label>
		          </td>
		         	<td>
		          	<textarea id="crewintro" name="crewDiscription" class="form-control" placeholder="새로운 크루 소개글을 입력해주세요!" required="required"></textarea>
		          	<div id="crewintro_cnt">(0 / 150)</div>
		          </td>
		        </tr>
		        <tr>
		        	<td>
		          	<div class="tr_hashTag_area">
		            	<p><strong>해시태그</strong></p>
		            </div>
		          </td>
		        	<td>
			        	<ul id="tag-list"></ul>
			          <div class="form-group">
			          	<input type="text" id="tag" size="7" placeholder="#" style="width: 300px;" />
			          </div>
		          </td>
		        </tr>
		        <tr>
		        <td>
		        </td>
           		<td id="submit" >
              	<input type="submit" value="생성" class="form-control btn-secondary">
            	</td>
           	</tr>
          </table>
       </form>
     </div>
   </div>
 </div>
<%@ include file="/WEB-INF/frame/default/footer.jsp" %>
<script>
    $('#crewintro').on('keyup', function() {
        $('#crewintro_cnt').html("("+$(this).val().length+" / 150)");
 
        //글자 수를 0에 대입시켜서 바꿔보이게 150자이상작성하면 짤림
        if($(this).val().length > 150) {  
        	//substring으로 문자열을 0부터150까지만 나오고 자름
            $(this).val($(this).val().substring(0, 150));
            $('#crewintro_cnt').html("(150 / 150)");
            alert("150자 이내로 작성해주세요")
        }
    });

// 개행문자 = textarea의 엔터를 br태그로 바꿔서 db에 보냄 
$("form").submit(function() {
	var html = $("#crewintro").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
	
});


</script>
</body>
</html>