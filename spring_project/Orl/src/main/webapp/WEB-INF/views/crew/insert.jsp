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
    <script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
        
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>
    <div class="section">
        <div class="box">
            <div class="edit_section">
                <form method="post" enctype="multipart/form-data">
                    <table>
                        <tr>
                        <td>
                            <div class="create">
                                <h1>생성하기</h1>
                            </div>
                            </td>
                            <td>
                                <label for="crewname">크루명</label>
                            </td>
                            <td>
                                <input type="text" id="crewname" name="crewName" class="form-control"
                                    placeholder="원래 크루명이 자동으로 뜨도록 처리">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="crewname">크루 사진</label>
                            </td>
                            <td>
                                <img id="hiking" src="<c:url value='/images/crew/메인.jpg'/>">
                                <input type="file" id="crewphoto" name="crewPhoto" class="form-control form-control-lg">
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
                                <div class="form-group">
                                    <input type="hidden" value="" name="=crewTag" id="rdTag" />
                                </div>

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
    <script>
        function menuToggle() {
            const toggleMenu = document.querySelector('.menu');
            toggleMenu.classList.toggle('active')
        }
        $(document).ready(function () {
            var tag = {};
            var counter = 0;

            // 입력한 값을 태그로 생성한다.
            function addTag(value) {
                tag[counter] = value;
                counter++; // del-btn 의 고유 id 가 된다.
            }

            // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
            function marginTag() {
                return Object.values(tag).filter(function (word) {
                    return word !== "";
                });
            }

            // 서버에 제공
            $("#tag-form").on("submit", function (e) {
                var value = marginTag(); // return array
                $("#rdTag").val(value);

                $(this).submit();
            });

            $("#tag").on("keypress", function (e) {
                var self = $(this);

                //엔터나 스페이스바 눌렀을때 실행
                if (e.key === "Enter" || e.keyCode == 32) {

                    var tagValue = self.val(); // 값 가져오기

                    // 해시태그 값 없으면 실행X
                    if (tagValue !== "") {

                        // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                        var result = Object.values(tag).filter(function (word) {
                            return word === tagValue;
                        })

                        // 해시태그가 중복되었는지 확인
                        if (result.length == 0) {
                            $("#tag-list").append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x</span></li>");
                            addTag(tagValue);
                            self.val("");
                        } else {
                            alert("태그값이 중복됩니다.");
                        }
                    }
                    e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
                }
            });

            // 삭제 버튼 
            // 인덱스 검사 후 삭제
            $(document).on("click", ".del-btn", function (e) {
                var index = $(this).attr("idx");
                tag[index] = "";
                $(this).parent().remove();
            });
        })
    </script>
    
</body>
</html>