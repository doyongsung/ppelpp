$(document).ready(function () {
    if(crewtag == null){
        return;
    } else {
        var str = [];
        const crewTag = crewtag;
        str = crewTag.split(",");
        for(var idx = 0 ; idx < str.length ; idx++){
            $("#tag-list").append("<li class='tag-item'>" + str[idx] + "<span class='del-btn' idx='" + idx + "'>x"+
                    "</span><input type='hidden' name='crewTag' id='rdTag' value="+ str[idx] +"></li>");
        }
    }
});