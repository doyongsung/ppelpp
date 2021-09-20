let sel_file;
let nickJ = /^[가-힣A-Za-z0-9]{4,12}$/;
let checkNick = true;

let memberNickName;

$(document).ready(function () {
    
    //로그인 한사람의 정보를 우선 가져옴
    $.ajax({
        url: url + '/crew/getMemberInfo',
        type: 'get',
        data: { memberIdx: memberIdx },
        success: function (data) {
            if (data != null) {
                memberNickName = data.memberNickName
            }
        }
    });

    // 비동기통신 스타일 속성
    $('#crewName').focusin(function () {
        $('#msg').addClass('display_none');
        $('#msg').removeClass('color_blue');
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
                url: url + '/crew/nameCheck',
                type: 'get',
                data: {
                    crewName: $(this).val()
                },
                success: function (data) {
                    // data : Y / N
                    if (data == 'Y') {
                        $('#msg').html('사용가능');
                        $('#msg').addClass('color_blue');
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
            /*  alert('아이디는 4자 이상 12자 이하여야하며 ,대문자/소문자/숫자만 사용할 수 있습니다.'); */
            $('#crewName_check').removeClass('display_none');
            $('#crewName_check').text('크루명을 다시 입력해주세요.');
            $('#crewName_check').css('color', '#f82a2aa3');
            checkNick = false;
        }

    });

    // 사진이 바뀌면 사진 이미지 preview처리 함수 실행
    $("#crewPhoto").on("change", handleImgFileSelect);

    //크루 소개글에서 키업 이벤트가 발생했을 시
    $('#crewintro').on('keyup', function () {
        $('#crewintro_cnt').html("(" + $(this).val().length + " / 150)");

        //글자 수를 0에 대입시켜서 바꿔보이게 150자이상작성하면 짤림
        if ($(this).val().length > 150) {
            //substring으로 문자열을 0부터150까지만 나오고 자름
            $(this).val($(this).val().substring(0, 150));
            $('#crewintro_cnt').html("(150 / 150)");
            alert("150자 이내로 작성해주세요")
        }
    });

    $('#submit').on('click', function () {

        // 개행문자 = textarea의 엔터를 br태그로 바꿔서 db에 보냄 
        $("#crewintro").val().replace(/(?:\r\n|\r|\n)/g, '<br />');


        let formData = new FormData();
        formData.append("crewName", $('#crewName').val());

        let photoFile = $('#crewPhoto');
        let file1;
        if (photoFile != null) {
            file1 = photoFile[0].files[0];
        }
        if (file1 != null) {
            formData.append("crewPhoto", file1);
        }

        formData.append("crewDiscription", $('#crewintro').val());

        var tags = document.getElementsByName('crewTag');
        let tagString;
        if(tags != null){
            tagString = $(tags[0]).val();
            for(var i = 1; i <tags.length ; i++){
                tagString += ',';
                tagString += ($(tags[i]).val());
            }
        }

        formData.append("crewTag", tagString);
        formData.append("memberIdx", memberIdx);
        formData.append("memberNickName", memberNickName);

        if (checkNick) {
            $.ajax({
                url: url + '/crew/createCrew',
                type: 'post',
                data: formData,
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                cache: false,
                success: function (data) {
                    if (data != null) {
                        alert('크루 생성이 완료되었습니다.');
                        window.location.href = url2 + '/crew/detail?crewIdx=' + data.crewIdx + '';
                    } else {
                        alert('유효한 정보를 입력해주세요.');
                        history.go(-1);
                    }
                }
            });
        } else {
            return false;
        }
    });

});//ready end


//img preview
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


$(document).ready(function () {

    //해시 태그 처리
    var tag = {};
    var counter = 0;

    // 입력한 값을 태그로 생성한다.
    function addTag(value) {
        tag[counter] = value;
        counter++; // del-btn 의 고유 id 가 된다.
    }

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
                    $("#tag-list").append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x" +
                        "</span><input type='hidden' name='crewTag' id='crewTag' value=" + tagValue + "></li>");

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

});//ready end