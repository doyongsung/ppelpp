//el 들어간 거는 js로 빼면 오류남 ? el표현된 것이 서버에서 돌아야하니까..
//어떻게 해결? el 표현으로 넘기지말고 html로 표현해서 넣으면 가능 - val() 이나 text() 사용하는 등..
//js src 하는 위에서 js 변수로 잡아도 되는데, idx를 노출해도 되면 이렇게 하면되고, 노출하면 안되는 정보일 경우 x

// 토글처리,, 클래스에 번호일일히 붙이지 않는 방법 -> on 으로 위에 태그로 잡아서 처리
// 부트 (el -> timeleaf)

$(document).ready(function(){

	commentList();

    //When click the 'body' tag toggle that menu(active-inactive).
    $('body').click(function(){
        var matches = document.querySelectorAll('.active');
        $('body').click(function(){
            for(var i = 0 ; i < matches.length ; i ++){
                matches[i].classList.toggle('active');
            }
        });
    });
    
    //Hash-Tag showing.
    if(crewTag == null){
        return;
    } else {
        var str = [];
        const crewTagArr = crewTag;
        str = crewTagArr.split(",");
        var html = "";
        for(var idx = 0 ; idx < str.length ; idx++){
            html += '<li class="tag-item">#'+str[idx]+'</li>';}
        $("#crewHashTag").html(html);
    }
    
    //Comment insert.
    $('#submit').click(function(){
        var formData = new FormData();
        formData.append("crewIdx", $('#crewIdx').val());
        formData.append("crewComment", $('#crewComment').val());
        $.ajax({
            url: 'http://localhost:8080/orl/crew/commentInsert',
            type: 'post',
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success : function(data){
                if(data==0){
                    alert('로그인 여부를 확인해주세요.');}
                commentList();
            }
        })
    });

 	//Joining the crew. 
     $('#joinToCrew').on('click', 'button', function(){
		if(memberIdx==''){
			window.location.href="http://localhost:8080/orl/member/login";
		} else {
			$.ajax({
				url: 'http://localhost:8080/orl/crew/joinToCrewMemberList',
				type: 'get',
				data: {
					memberIdx : memberIdx,
					crewIdx : crewIdx
				},
				success : function(data){
					if(data==0){
						alert('가입에 실패했습니다.');
					} else if(data==1){
						alert('크루에 가입하셨습니다.');
						window.location.href="http://localhost:8080/orl/crew/detail?crewIdx="+crewIdx+"";
					}
				}
			});	
		}
	});
		
	//Leaving the crew.
	$('#outFromCrew').on('click', 'button', function(){
		if(memberIdx==''){
			window.location.href="http://localhost:8080/orl/member/login";
		} else {
			$.ajax({
				url: 'http://localhost:8080/orl/crew/deleteCrewMemberFromList',
				type: 'get',
				data: {
					memberIdx : memberIdx,
					crewIdx : crewIdx
				},
				success : function(data){
					if(data==0){
						alert('탈퇴에 실패했습니다.');
					} else if(data==1){
						alert('해당 크루를 탈퇴했습니다.');
						window.location.href="http://localhost:8080/orl/crew/detail?crewIdx="+crewIdx+"";
					}
				}
			});
		}
	});   
    
});//document ready end.

//Comment toggle managing.
function commentToggle(parameter){
    const toggleMenu = document.querySelector('.commentMenu'+parameter+'');
    toggleMenu.classList.toggle('active');
    var html = '<li><a href="javascript:editComment('+parameter+')">수정</a></li>';
    html += '<li><a href="javascript:deleteComment('+parameter+')">삭제</a>';
    $('#commentMenu'+parameter+'').html(html);
}

//Comment edit.
function editComment(parameter){
    $.ajax({
        url: 'http://localhost:8080/orl/crew/getCommentInfo',
        type: 'GET',
        data: {crewCommentIdx : parameter},
        success: function(data){
            var html = '<td><img id="profile" src="http://localhost:8080/orl/images/default.jpg"></td>';
            html += '<td><p id="nickname">'+data.memberNickName+'</p>';
            html += '<input class="form-control" id="newCrewComment" type="text" value="'+data.crewComment+'"></td>';
            html += '<td><p><br></p><a href="javascript:commentList()" class="tag-item">취소</a>';
            html += '<a href="javascript:updateComment('+parameter+')" class="tag-item">등록</a></td>';
            $('#'+parameter+'').html(html);
        }
    });
}

//Comment update.
function updateComment(parameter){
    $.ajax({
        url: 'http://localhost:8080/orl/crew/commentUpdate',
        type: 'post',
        data: {
            crewComment: $('#newCrewComment').val(),
            crewCommentIdx: parameter
        },
        success : function(data){
            if(data==0){
                alert('로그인 여부를 확인해주세요.');
            }
            commentList();
        }
    });
}

//Comment delete.
function deleteComment(parameter){
    $.ajax({
        url: 'http://localhost:8080/orl/crew/commentDelete',
        type: 'GET',
        data: {crewCommentIdx : parameter},
        success: function(data){
            commentList();
        }
    });
}

//HTML output function.
function commentList(parameter){
	$.ajax({
		url: 'http://localhost:8080/orl/crew/getCommentInfoList',
		type: 'GET',
		data: {
			crewIdx: crewIdx,
			currentPageNum : parameter
		},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
		success: function(data){
				
			//Comment없으면 return
			if(data.infoList.length == 0) {
				var html = '<tr><td>아직 작성된 댓글이 없습니다.</td></tr>';
				$('#commentList').html(html);
				return;
			}
				
			var html = '';
			var html2 = '';
				
			// 있는 경우 Comment 정보 반복문으로 처리
			$.each(data.infoList, function(index, item){
				html += '<tr id="'+item.crewCommentIdx+'"><td><img id="profile" src="http://localhost:8080/orl/images/default.jpg"></td>';
				html +=	'<td><p id="nickname">'+item.memberNickName+'</p>';
				html += '<p class="content">'+item.crewComment+'</p>';
				html += '<p class="date">'+item.crewCommentDate+'</p></td>';
				html += '<td>';
			    if(memberIdx == item.memberIdx){
					html += '<div class="commentMenuBox">';
					html += '<div class="icon" onclick="commentToggle('+item.crewCommentIdx+');">';
					html += '<a href="#"><img id="commentMng" src="http://localhost:8080/orl/images/crew/icon.png"></a>';
					html +=	'<div id="cmid" class="commentMenu commentMenu'+item.crewCommentIdx+'"><ul id="commentMenu'+item.crewCommentIdx+'"></ul></div>';						html += '</div>';
					html += '</div>';
				}
				html += '</td></tr>';
				$('#commentList').html(html);
			});
			
			//Paging처리
			var prev = currentPageNum-1;
			if (prev==0){
				prev = 1;
			}
			var next = currentPageNum+1;
			if (next>data.totalPageNum){
				next = data.totalPageNum
			}
			html2 += '<li class="page-item">';
			html2 += '<a class="page-link" href="javascript:commentList('+prev+')">&lt</a></li>';
			for(var i=1 ; i <= data.totalPageNum; i++){
				html2 += '<li class="page-item">';
				html2 += '<a href="javascript:commentList('+i+')" class="page-link">'+i+'</a></li>';
			}
			html2 += '<li class="page-item">';
			html2 += '<a class="page-link" href="javascript:commentList('+next+')">&gt</a></li>';
			$('#paging').html(html2);
		}
	});                                                                                                                     
}