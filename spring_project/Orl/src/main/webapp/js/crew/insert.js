
var sel_file;
var nickJ = /^[가-힣A-Za-z0-9]{4,12}$/;
var checkNick = true;

function form_submit(form) {
    if (checkNick){
        form.submit();
    }else{
        return false;
    }
}
$(document).ready(function () {
    // 비동기통신 스타일 속성
    $('#crewName').focusin(function () {
        $('#msg').addClass('display_none');
        $('#msg').removeClass('color_yellow');
        $('#msg').removeClass('color_red');
        $(this).val('');
    });
    //1. 아이디 유효성 체크
    $("#crewName").blur(function () {
        if (nickJ.test($(this).val())) {
            console.log(nickJ.test($(this).val()));
            $("#crewName_check").text('');
            // 유효성 체크 되면 비동기통신으로  id 중복 체크
            $.ajax({
                url: 'http://localhost:8080/orl/crew/nameCheck',
                type: 'get',
                data: {
                    crewName : $(this).val()
                },
                beforeSend: function () {
                    $('#loadingimg').removeClass('display_none');
                },
                success: function (data) {
                    // data : Y / N
                    if (data == 'Y') {
                        $('#msg').html('사용가능');
                        $('#msg').addClass('color_yellow');
                        $('#msg').removeClass('display_none');
                        checkNick = true;
                    } else {
                        $('#msg').html('사용 불가능');
                        $('#msg').addClass('color_red');
                        $('#msg').removeClass('display_none');
                        checkNick = false;
                    }
                },
                error: function (request, status, error) {
                    alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
                    console.log(request);
                    console.log(status);
                    console.log(error);
                },
                complete: function () {
                    $('#loadingimg').addClass('display_none');
                }   
            });
            } else {
                /*    alert('아이디는 4자 이상 12자 이하여야하며 ,대문자/소문자/숫자만 사용할 수 있습니다.'); */
                $('#crewName_check').removeClass('display_none');
                $('#crewName_check').text('닉네임을 다시 입력해주세요.');
                $('#crewName_check').css('color', '#f82a2aa3');
                checkNick = false;
            }
        });
        

    
    $("#crewPhoto").on("change", handleImgFileSelect);

 
});

function handleImgFileSelect(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    filesArr.forEach(function (f) {
        if (!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function (e) {
            $("#img").attr("src", e.target.result);
        }
        reader.readAsDataURL(f);
    });
}

// 이미지 클릭시 원본 크기로 팝업 보기
function doImgPop(img) {
    img1 = new Image();
    img1.src = (img);
    imgControll(img);
}

function imgControll(img) {
    if ((img1.width != 0) && (img1.height != 0)) {
        viewImage(img);
    }
    else {
        controller = "imgControll('" + img + "')";
        intervalID = setTimeout(controller, 20);
    }
}

function viewImage(img) {
    W = img1.width;
    H = img1.height;
    O = "width=" + W + ",height=" + H + ",scrollbars=yes";
    imgWin = window.open("", "", O);
    imgWin.document.write("<html><head><title>:*:*:*: 이미지상세보기 :*:*:*:</title></head>");
    imgWin.document.write("<body topmargin=0 leftmargin=0>");
    imgWin.document.write("<img src=" + img + " onclick='self.close()' style='cursor:pointer;' title ='클릭하시면 창이 닫힙니다.'>");
    imgWin.document.close();
}

///////////////////////

$(document).ready(function () {

    var tag = {};
    var counter = 0;

    // 입력한 값을 태그로 생성한다.
    function addTag(value) {
        tag[counter] = value;
        counter++; // del-btn 의 고유 id 가 된다.
    }

    // 서버에 제공
    $("#tag-form").on("submit", function (e) {
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
                    $("#tag-list").append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x"+
                    "</span><input type='hidden' name='crewTag' id='rdTag' value="+tagValue+"></li>");
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