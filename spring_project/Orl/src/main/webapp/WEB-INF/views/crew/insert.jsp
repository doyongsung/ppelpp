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
    <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
       <script src="<c:url value='/js/crew/insert.js'/>"></script>
        
        <style>
.display_none {
	display: none;
}

.color_blue {
	color: blue;
}

.color_red {
	color: red;
}

#loadingimg {
	height: 20px;
}
        </style>
</head>

<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>
    <div class="section">
        <div class="box">
            <div class="edit_section">
                <form method="post" enctype="multipart/form-data">
                    <table>
                    <div class="create">
                    <h1>생성하기</h1>
                    </div>
                        <tr>
                            <td>
                                <label for="crewname">크루명</label>
                    
                            </td>
                            <td>
                                <input type="text" id="crewName" name="crewName" class="form-control"
                                    placeholder="원래 크루명이 자동으로 뜨도록 처리">
                                    	<span id="msg" class="display_none"></span> <img id="loadingimg"
															class="display_none" alt="loading"
															src="<c:url value="/images/loading.gif"/>">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="crewname">크루 사진</label>
                            </td>
                            <td>   
                            <img src="<c:url value="/images/crew/default.jpg"/>" id="img" class="hiking" title="클릭하시면 원본크기로 보실 수 있습니다." style="cursor: pointer;" onclick="doImgPop(this.src)"/>
                                <input type="file" id="crewPhoto" name="crewPhoto" class="form-control form-control-lg">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="crewintro">크루 소개글</label>
                            </td>
                            <td>
                                <input type="text" id="crewintro" name="crewDiscription" class="form-control"
                                    placeholder="새로운 크루 소개글을 입력해주세요!">
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
                <input type="submit" value="생성" class="form-control btn-secondary">
            </td>
            </tr>
            </table>
            </form>
        </div>
        </div>
    </div>
       <%@ include file="/WEB-INF/frame/default/footer.jsp" %>

    
</body>
</html>