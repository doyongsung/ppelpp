        


// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의
function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function () {
    return '[id:' + this.userId + ' , pw: ' + this.pw + ' , name: ' + this.userName + ' ]'
};

//////////////////////////////////////////////////////////

// 회원의 정보를 저장하는 배열
var members = []; // new Array()

$(document).ready(function(){


    if(localStorage.getItem('members') == null){
        localStorage.setItem('members',JSON.stringify(members));
    }else{
        members = JSON.parse(localStorage.getItem('members')); 
        console.log(members);
          //테이블 세팅
           setList();
    }

    var getCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
    var getName = RegExp(/^[가-힣]+$/);
    
    var id = $('#userID');
    var pw = $('#pw');
    var repw = $('#repw');
    var name = $('#userName');
    
    $('#regForm').submit(function(){
  
  

        // 아이디 공백 확인
        if(id.val().trim().length < 1){
            $('#userID+div.msg').css('display','block').html("필수항목입니다.")
            return false;
        }

        // 아아디 유효성 검사
        if(!getCheck.test($('#userID').val())){
            alert("형식에 맞게 입력해주세요")
            $('#userID').focus();
            return false;
        }

        // 비밀번호 공백 확인
        if(pw.val().trim().length < 1){
            $('#pw+div.msg').css('display','block').html("필수항목입니다.")
            return false;
        }

        // 비밀번호 유효성 검사
        if(!getCheck.test($('#pw').val())){
            alert("패스워드 재입력바람")
            $('#pw').focus();
            return false;
        }

        // 비밀번호 확인 공백 확인
        if(repw.val().trim().length < 1){
            $('#pw+div.msg').css('display','block').html("필수항목입니다.")
            return false;
        }

        // 비밀번호와 비밀번호 확인이 같은지 확인
        if (pw.val().trim() != repw.val().trim()) {
           $('#repw+div.msg').css('display','block').html('비밀번호가 일치하지않습니다.');
           return false;
        }else{

        }

        //이름 공백 확인
        if (name.val().trim().length < 1) {
           $('#userName+div.msg').css('display','block').html('필수항목입니다.');
           return false;
        }

        //이름 유효성 검사
        if(!getName.test($('#userName').val())){
            alert("한글만을 입력해주세요")
            $('#userName').focus();
            return false;
        }
               // 배열에 사용자 정보를 추가
               members.push(new Member(id.val(), pw.val(), name.val()));

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('등록되었습니다.');
        console.log('회원 리스트', members);
        this.reset(); //form 초기화
        setList();

        return false;
        });

        $(id).focus(function(){
        $('#userID+div.msg').css('display','none').html('');
        });
        $(pw).focus(function(){
        $('#pw+div.msg').css('display','none').html('');
        });
        $(repw).focus(function(){
        $('#repw+div.msg').css('display','none').html('');
        repw.val('');
        });
        $(name).focus(function(){
        $('#userName+div.msg').css('display','none').html('');
        });


        });


        // 배열에 있는 요소를 -> table tr 행을 만들어서 출력
        function setList() {

            var list = $('#list');

        var tbody = '<tr>';
        tbody += '  <th>순번(index)</th>';
        tbody += '  <th>아이디</th>';
        tbody += '  <th>비밀번호</th>';
        tbody += '  <th>이름</th>';
        tbody += '  <th>관리</th>';
        tbody += '</tr>';

        if (members.length < 1) {

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';

        } else {

        for (var i = 0; i < members.length; i++) {
    
        tbody += '<tr>';
        tbody += '  <td>' + i + '</td>';
        tbody += '  <td>' + members[i].userId + '</td>';
        tbody += '  <td>' + members[i].pw + '</td>';
        tbody += '  <td>' + members[i].userName + '</td>';
        tbody += '  <td> <a href="javascript:editMember('+i+')">수정</a> |' +
            '<a href="javascript:deleteMember('+i+')">삭제</a></td>';
        tbody += '</tr>';
        }
    }
        $('#list').html(tbody);


}


        // 배열의 요소 삭제 함수
        function deleteMember(index) {
        if(confirm('삭제하시겠습니까?')){
            members.splice(index, 1);
            alert('삭제되었습니다.');
             // 저장
            localStorage.setItem('members', JSON.stringify(members));
            // 테이블 리스트를 갱신
            setList();
        };
        }

        // 배열의 요소 수정 함수
        function editMember(index){


        // 수정 폼 영역이 노출되어야 한다!
        $('#editFormArea').css('display','block');

        // editForm의 태그들의 value  값을 세팅
        $('#edit_id').val(members[index].userId);
        $('#edit_pw').val(members[index].pw);
        $('#edit_repw').val(members[index].pw);
        $('#edit_name').val(members[index].userName);
        $('#index').val(index);

        $('#editForm').submit(function(){

            //비밀번호와 비밀번호 확인이 같은지 체크
            if($('#edit_pw').val() != $('#edit_repw').val()){
                alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
                return false;
            };
            if(!getCheck.test($('#edit_pw').val())){
                    alert('비밀번호는 4글자 이상 12글자 미만으로 입력해주세요');
                    return false;
                };
   
            if(!confirm('수정하시겠습니까?')){
                return false;
            };


        members[$('#index').val()].pw = $('#edit_pw').val();
        members[$('#index').val()].username = $('#edit_name').val();

    
        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');

        // 테이블 세팅
        setList();

        editMemberClose();

        return false;

});

}

function editMemberClose(){
$('#editFormArea').css('display','none');
}


