<%@ page import="com.bitcamp.orl.mountain.domain.MountainLocInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mountain_Info</title>
    <link rel="stylesheet" href="<c:url value='/css/mountain/mountain_info.css'/>">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>
<div class="body_wrap">
    <div class="main_wrap_con">
        <div class="main_wrap_item main_wrap_item_1 main_wrap_item_1_top_con">
            <div class="main_wrap_item_1_top_item main_wrap_item_1_top_item_1">
                <img src="https://www.forest.go.kr/images/data/down/mountain/${mountainLocInfo.img}" width="600px"
                     height="500px">
            </div>
            <div class="main_wrap_item_1_top_item main_wrap_item_1_top_item_2 mountain_info_con">
                <div class="mountain_info_item_name">
                    <div class="mountain_info_item_2">
                        ${mountainLocInfo.mountainName}
                    </div>
                </div>
                <div class="mountain_info_item_detail">
                    <div class="mountain_info_item mountain_info_item_3">
                        높이 : ${mountainLocInfo.height}m
                    </div>
                    <div class="mountain_info_item mountain_info_item_4">
                        위치 : ${mountainLocInfo.mountainAddress}
                    </div>
                    <div class="mountain_info_item mountain_info_item_5">
                        정보 : ${mountainLocInfo.mountainInfo}
                    </div>
                    <div class="mountain_info_item mountain_info_item_6">
                        ${mountainLocInfo.mountainDetailInfo}
                    </div>
                    <div class="mountain_info_item mountain_info_item_7">
                        교통 : ${mountainLocInfo.transport}
                    </div>
                </div>
            </div>
        </div>
        <!-- 피드 사진 가져오기 -->
        <div class="main_wrap_item main_wrap_item_2 main_wrap_item_1_bottom_con">
            <div class="main_wrap_item_1_bottom_item main_wrap_item_1_bottom_item_1">
                #${mountainLocInfo.mountainName}
            </div>
            <div id="feedByMountain"
                 class="main_wrap_item_1_bottom_item main_wrap_item_1_bottom_item_2 feed_picture_con">
            </div>
        </div>
    </div>

    <script>
        function showFeedByMountainList(feedList) {
            var getFeedList = [];
            getFeedList = feedList;

            var html = '';
            $.each(getFeedList, function (index, item) {
                if (index < 7) {
                    html += '<div class="feed_picture_item feed_picture_item1">';
                    html += '<a href="<c:url value="/feed/feedview/'+item.memberIdx+'&'+item.boardIdx+'"/>">';
                    html += ' <img class="img" src="<c:url value="/images/feed/feedw/uploadfile/'+item.boardPhoto+'"/>" width="100%" height="100%">';
                    html += '</a>';
                    html += '</div>';
                }
            });
            html += '<form id="formLoc" action="${pageContext.request.contextPath}/feed/feedSearch" method="POST">';
            html += '<div class="feed_picture_item8">'
            html += '<img onclick="setParamLoc(this.title)" class="img" title="${mountainLocInfo.mountainName}" src="<c:url value="/images/mountain/rightSide.png"/>" width="30px">'
            html += '</div>';
            html += '<input name="mySearch" id="mySearch" type="hidden" value="">'
            html += '</form>';
            $('#feedByMountain').html(html);
        }


        function setParamLoc(loc){
            $("#mySearch").val(loc);
            console.log(loc);
            $("#formLoc").submit();
        }

        $(document).ready(function () {

            var feedList = [];


            // 시작할때 비동기 통신으로 지역별 산 리스트 받아와서 mList에 저장
            $.ajax({
                url: '<c:url value="/feed/feedmain/selectNewMountainFeed"/>',
                type: 'GET',
                data: {mName: '${mountainLocInfo.mountainName}'},
                success: function (data) {
                    feedList = data;
                    showFeedByMountainList(feedList);
                }

            })

        });
    </script>
    <!-- 지도-->
    <div id="map" class="map" style="width: 85%; height: 800px; margin: 0px auto ;">
        <%
            MountainLocInfo mountainLocInfo = (MountainLocInfo) request.getAttribute("mountainLocInfo");
        %>
        <script type="text/javascript"
                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5188ac15584cefe54aea3746f43ba94"></script>
        <script>
            var container = document.getElementById('map');
            var options = {
                center: new kakao.maps.LatLng(<%=mountainLocInfo.getLongitude()%>, <%=mountainLocInfo.getLatitude()%>),
                level: 6
            };

            var map = new kakao.maps.Map(container, options);

            // 마커가 표시될 위치입니다
            var markerPosition = new kakao.maps.LatLng(<%=mountainLocInfo.getLongitude()%>, <%=mountainLocInfo.getLatitude()%>);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);

            // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
            // marker.setMap(null);
        </script>
    </div>
</div>
<%@ include file="/WEB-INF/frame/default/footer.jsp" %>
</body>
</html>
