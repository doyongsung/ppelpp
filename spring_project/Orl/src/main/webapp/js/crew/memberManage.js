$(document).ready(function () {

    getCrewMemberList();

    $('#crewMemberList').on('click', 'button', function () {
        $.ajax({
            url: url+'/crew/deleteCrewMemberFromList',
            type: 'get',
            data: {
                memberIdx: $('input', $(this).parent()).val(),
                crewIdx: crewIdx
            },
            success: function (data) {
                if (data == 0) {
                    alert('추방에 실패했습니다.');
                } else if (data == 1) {
                    alert('해당 멤버를 추방했습니다.');
                }
                getCrewMemberList();
            }
        });
    });

});

function getCrewMemberList() {
    $.ajax({
        url: url+'/crew/getCrewMemberList',
        type: 'GET',
        data: {
            crewIdx: crewIdx
        },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        success: function (data) {
            var html = '';
            $.each(data, function (index, item) {
                html += '<tr>';
                html += '<td>' + Number(index + 1) + '</td>';
                html += '<td><img id="profile" src="'+url2+'/images/default.jpg"></td>';
                html += '<td id="nickname">' + item.memberNickName + '</td>';
                html += '<td class="date">' + item.crewRegdate + '</td>';
                if (item.memberIdx != sessionMemberIdx) {
                    html += '<td><button class="deleteBtn" id="button">추방</button>';
                    html += '<input type="hidden" id="memberIdx" value="' + item.memberIdx + '"></td>';
                } else {
                    html += '<td>크루장</td>'
                }
                html += '</tr>';
            });
            $('#crewMemberList').html(html);
        }
    });
}