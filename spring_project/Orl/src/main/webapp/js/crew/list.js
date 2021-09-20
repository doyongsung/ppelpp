$(document).ready(function () {

    $('#newestList').addClass('clicked');

    getList(searchType, keyword, 1);

    $('#nameList').click(function () {
        console.log("이름순으로 정렬");
        cList.sort(function (a, b) {
            a = a.crewName;
            b = b.crewName;
            return a < b ? -1 : a > b ? 1 : 0;
        });
        crewList(cList);
    });

    $('#newestList').click(function() {
        console.log("최신순으로 정렬");
        cList.sort(function (a, b) {
            a = a.crewCreatedate;
            b = b.crewCreatedate;
            return a > b ? -1 : a < b ? 1 : 0;
        });
        crewList(cList);
    }
    );

    $('#oldList').click(function () {
        console.log("오래된순으로 정렬");
        cList.sort(function (a, b) {
            a = a.crewCreatedate;
            b = b.crewCreatedate;
            return a < b ? -1 : a > b ? 1 : 0;
        });
        crewList(cList);

        var select = $('.searchType select');
        select.change(function(){
            var select_name = $(this).children('option:selected').text();
            $(this).siblings("label").text(select_name);
        });
        
    });// ready end
    
    var curved = document.getElementsByClassName("curved");

    function handleClick(event) {
        console.log(event.target);
        // console.log(this);
        // 콘솔창을 보면 둘다 동일한 값이 나온다

        console.log(event.target.classList);

        if (event.target.classList[1] === "clicked") {
            event.target.classList.remove("clicked");
        } else {
            for (var i = 0; i < curved.length; i++) {
                curved[i].classList.remove("clicked");
            }
            event.target.classList.add("clicked");
        }
    }

    function init() {
        for (var i = 0; i < curved.length; i++) {
            curved[i].addEventListener("click", handleClick);
        }
    }
    init();

}); //document ready end.

//ajax restcontroller
function getList(parameter1, parameter2, parameter3) {
    if (parameter2 == '') {
        $.ajax({
            url: url+'/crew/searchList',
            type: 'get',
            data: {
                page: parameter3,
            },
            success: function (data) {
                cList = data.crewList;
                crewList(cList, data.pk);
            }
        });
    } else {
        $.ajax({
            url: url+'/crew/searchList',
            type: 'get',
            data: {
                searchType: parameter1,
                keyword: parameter2,
                page: parameter3,
            },
            success: function (data) {
                cList = data.crewList;
                crewList(cList, data.pk);
            }
        });
    }
}

//출력함수(list, pagemaker)
function crewList(parameter1, parameter2) {
    let list = parameter1;
    let html = '<div id="row" class="row">';
    $.each(list, function (index, item) {
        html += '<div class="col-md-4">';
        html += '<div class="card shadow">';
        html += '<div class="inner">';
        html += '<div>';
        html += '<a href="'+url2+'/crew/detail?crewIdx=' + item.crewIdx + '">';
        html += '<img src="'+url2+'/images/crew/' + item.crewPhoto + '" class="card-img-top" alt="card image cap">';
        html += '<div class="card-body text-left">';
        html += '<h4 class="card-title">크루 이름: ' + item.crewName + '</h4>';
        html += '<p class="card-text">크루장: ' + item.memberNickName + '</p>';
        if(item.crewTag != null) {
            let str = [];
            const crewTagArr = item.crewTag;
            str = crewTagArr.split(",");
            html += '<ul>';
            for(let idx = 0 ; idx < str.length ; idx++) {
                html += '<li class="tag-item">#'+str[idx]+'</li>';
            }
            html += '</ul>';
        }
        html += '<p class="card-text">크루소개 : ' + item.crewDiscription + '</p>';
        html += '</div>';
        html += '</a>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        $('#cList').html(html);
    });
    
    //
    if (parameter2 == null) {
        return;
    } else {
        let pageMaker = parameter2;
        var html2 = '';
        if (pageMaker.prev) {
            html2 += '<li class="page-item">';
            html2 += '<a class="page-link" href="javascript:getList(\'' + searchType + '\', \'' + keyword + '\', ' + (Number(pageMaker.startPage) - 1) + ')">prev</a>';
            html2 += '</li>';
        }
        for (var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
            html2 += '<li class="page-item">';
            html2 += '<a class="page-link" href="javascript:getList(\'' + searchType + '\', \'' + keyword + '\', ' + i + ')">' + i + '</a>';
            html2 += '</li>';
        }
        if (pageMaker.next) {
            html2 += '<li class="page-item">';
            html2 += '<a class="page-link" href="javascript:getList(\'' + searchType + '\', \'' + keyword + '\', ' + (Number(pageMaker.endPage) + 1) + ')">next</a>';
            html2 += '</li>';
        }
        $('#pagination').html(html2);
    }
}