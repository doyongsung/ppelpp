<%@ page import="com.bitcamp.orl.mountain.domain.MountainLocInfo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지역별산</title>
    <link rel="stylesheet" href="<c:url value='/css/mountain/local.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">


    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

    <!--카카오 지도 스크립트 -->

    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5188ac15584cefe54aea3746f43ba94"></script>
    <script>
        $(document).ready(function () {

            var mlist = [];

            $.ajax({
                url: '<c:url value="/mountain/height"/>',
                type: 'GET',
                data: {loc: '${loc}'},
                success: function (data) {
                    mlist = data;
                    mountainList(mlist);
                    map(mlist);
                }

            })


            $('#heightlist').click(function () {


                mlist.sort(function (left, right) {
                    return right.height - left.height;
                })

                console.log("높이순으로정렬");
                console.log(mlist);
                mountainList(mlist);
            })


            $('#namelist').click(function () {
                console.log(" 이름순으로정렬");
                console.log(mlist);
                mlist.sort(function (a, b) {
                    return a.mountainName < b.mountainName ? -1 : a.mountainName > b.mountainName ? 1 : 0;
                })
                mountainList(mlist);
            })

            function map(mlist) {
                var container = document.getElementById('map');
                let x = mlist[0].longitude;
                let y = mlist[0].latitude;
                var options = {
                    center: new kakao.maps.LatLng(x, y),
                    level: 12
                };
                var map = new kakao.maps.Map(container, options);

                var positions = [];
                for (const x of mlist) {
                    positions.push({
                        title: x.mountainName,
                        lating: new kakao.maps.LatLng(x.longitude, x.latitude),
                        content: {
                            img: x.img,
                            mountainName: x.mountainName,
                            mountainAddress: x.mountainAddress,
                            height: x.height
                        }
                    });
                }
                // 마커를 표시할 위치와 title 객체 배열입니다


                // 마커 이미지의 이미지 주소입니다
                var imageSrc = "${pageContext.request.contextPath}/images/mountain/m2.png";

                for (var i = 0; i < positions.length; i++) {

                    // 마커 이미지의 이미지 크기 입니다
                    var imageSize = new kakao.maps.Size(30, 30);

                    // 마커 이미지를 생성합니다
                    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                    for (var i = 0; i < positions.length; i++) {
                        // 마커를 생성합니다
                        var marker = new kakao.maps.Marker({
                            map: map, // 마커를 표시할 지도
                            position: positions[i].lating, // 마커를 표시할 위치
                            image: markerImage, // 마커 이미지
                        });

                        // 마커에 표시할 인포윈도우를 생성합니다
                        var infowindow = new kakao.maps.InfoWindow({
                            content:  // 인포윈도우에 표시할 내용
                                '<div class="listings_item">' +
                                '<div class="listings_image">' +
                                '<img style="margin-left: 6px" src="https://www.forest.go.kr/images/data/down/mountain/' + positions[i].content.img + '" alt="">' +
                                '</div>' +
                                '<div class="listings_content">' +
                                '<div class="listings_title">' +
                                '<div class="listings_text">' +
                                '<h2>#' + positions[i].content.mountainName + '</h2>' +
                                '</div>' +
                                '</div>' +
                                '<div class="listings_description">' +
                                '<span >' + positions[i].content.mountainAddress + '(높이 : ' + positions[i].content.height + 'm)</span>' +
                                '</div>' +
                                '</div>' +
                                '</div>' +
                                '</div>'
                        });

                        var mName = positions[i].title;
                        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                        // 이벤트 리스너로는 클로저를 만들어 등록합니다
                        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                        kakao.maps.event.addListener(marker, 'click', link(mName));
                    }

//
                    function link(name) {
                        return function () {
                            location.href = '${pageContext.request.contextPath}/mountain/mountainDetailInfo?mountainName=' + name;
                        };
                    }

                    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
                    function makeOverListener(map, marker, infowindow) {
                        return function () {
                            infowindow.open(map, marker);
                        };
                    }

                    // 인포윈도우를 닫는 클로저를 만드는 함수입니다
                    function makeOutListener(infowindow) {
                        return function () {
                            infowindow.close();
                        };
                    }
                }
            }

        });

        function mountainList(mlist) {
            var mmlist = [];
            mmlist = mlist;
            console.log("리스트 함수 호출");
            console.log(mmlist);
            var html = '<div id="listings" class="listings">';
            $.each(mmlist, function (index, item) {
                html += ' <div class="listings_item">';
                html += ' <div class="listings_image">';
                html += '<a href="${pageContext.request.contextPath}/mountain/mountainDetailInfo?mountainName=' + item.mountainName + '">';
                html += ' <img src="https://www.forest.go.kr/images/data/down/mountain/' + item.img + '" alt="">';
                html += '</a>';
                html += '</div>';
                html += ' <div class="listings_content">';
                html += ' <div class="listings_title">';
                html += ' <div class="listings_text">';
                html += '  <span class="greyText">${loc} 산 전체</span>';
                html += '<a href="${pageContext.request.contextPath}/mountain/mountainDetailInfo?mountainName=' + item.mountainName + '">';
                html += ' <h2>#' + item.mountainName + '</h2>';
                html += '</a>';
                html += '</div>';
                html += '</div>';
                html += '<div class="listings_description">';
                html += '   <span >' + item.mountainAddress + '(높이 : ' + item.height + 'm)</span>';
                html += ' <span class="greyText">' + item.mountainInfo + '</span>';
                html += '  </div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';

                $('#mlist').html(html);
            })
        }

        let weatherIcon = {
            '01': 'fas fa-sun',
            '02': 'fas fa-cloud-sun',
            '03': 'fas fa-cloud',
            '04': 'fas fa-cloud-meatball',
            '09': 'fas fa-cloud-sun-rain',
            '10': 'fas fa-cloud-showers-heavy',
            '11': 'fas fa-poo-storm',
            '13': 'far fa-snowflake',
            '50': 'fas fa-smog'
        };

        $.ajax({
            url: 'http://api.openweathermap.org/data/2.5/weather',
            dataType: 'json',
            data: {
                q: '${locEn}',
                APPID: 'c8a1de8202921d5b6652ab1b33d9918c',
                units: 'metric'
            },
            type: 'GET',
            success: function (data) {
                var $Icon = (data.weather[0].icon).substr(0, 2);
                var $Temp = Math.floor(data.main.temp) + 'º';
                var $city = data.name;
                $('.CurrIcon').append('<i class="' + weatherIcon[$Icon] + '"></i>');
                $('.CurrTemp').prepend($Temp);
                $('.City').append($city);
            }
        })


    </script>


</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>

<!--중간 부분 전부-->
<div class="main">
    <!--왼쪽 컨텐츠-->
    <div class="main_content">
        <span>${countLoc}개의 산</span>
        <div class="nameAndWeather">
            <div class="locName">
                <h1>${loc}</h1>
            </div>
            <div class="weather">
                <div class="CurrIcon"></div>
                <div class="weatherInfo">
                    <div class="CurrTemp"></div>
                    <div class="City"></div>
                </div>
            </div>
        </div>
        <div class="search">
            <div class="iconsearch"></div>
            <form action="${pageContext.request.contextPath}/mountain/search">
                <div class="input">
                    <input type="text" placeholder="산 이름을 검색하세요" id="mysearch" name="mysearch" required>
                </div>
            </form>
            <span id='clearIcon' class="clear" style="display:none;"
                  onclick="document.getElementById('mysearch').value=''"></span>
        </div>

        <script>
            const iconsearch = document.querySelector('.iconsearch');
            const search = document.querySelector('.search');
            const clearIcon = document.getElementById("clearIcon");
            iconsearch.onclick = function () {
                search.classList.toggle('active')
                if (clearIcon.style.display == 'none') {
                    clearIcon.style.display = 'block';
                } else {
                    clearIcon.style.display = 'none';
                }
            }
        </script>


        <div class="main_filters">
            <button class="outlined curved" id="namelist" type="submit" value="namelist">이름순으로 보기</button>
            <button class="outlined curved" id="heightlist" type="submit" value="heightlist">높이순으로 보기</button>
            <!--  <button class="outlined curved">인기순으로 보기</button> -->
        </div>


        <div class="main_scarcity">
            <img src="" alt="">
            <span>
                    <span>
                        산 이름을 입력하시면 해당 산에 대한 정보를 확인할 수 있습니다.
                    </span>
                검색하기 전에 지도로 주변 산들을  둘러보세요.
                </span>
        </div>

        <div id="mlist">


        </div>
    </div>

    <script type="text/javascript">

    </script>


    <!--오른쪽 지도-->
    <div class="main_map">
        <div class="main_kakaoMap">
            <div class="map" id='map'></div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/frame/default/footer.jsp" %>


</body>


</html>