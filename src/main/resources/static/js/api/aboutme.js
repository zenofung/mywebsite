//公司规模
$("#leader").hover(
    function () {
        $("#leaderInfo").animate({"opacity": 1}, 200);
        $("#leaderPic").animate({"opacity": 0}, 200);
    }, function () {
        $("#leaderPic").animate({"opacity": 1}, 200);
        $("#leaderInfo").animate({"opacity": 0}, 200);
    });
$("#team").hover(
    function () {
        $("#teamInfo").animate({"opacity": 1}, 200);
        $("#teamPic").animate({"opacity": 0}, 200);
    }, function () {
        $("#teamPic").animate({"opacity": 1}, 200);
        $("#teamInfo").animate({"opacity": 0}, 200);
    });
$("#workTeam").hover(
    function () {
        $("#workTeamInfo").animate({"opacity": 1}, 200);
        $("#workTeamPic").animate({"opacity": 0}, 200);
    }, function () {
        $("#workTeamPic").animate({"opacity": 1}, 200);
        $("#workTeamInfo").animate({"opacity": 0}, 200);
    });
//专利证书
$("#prv").click(function () {
    var id = $("#show").attr("value");
    var param = {"id": id, "key": "1"};
    $.ajax({
        url: '/patentAjax',
        type: "post",
        data: JSON.stringify(param),
        contentType: "application/json;charset=UTF-8",
        dataType: 'JSON',
        success: function (callback) {
            $("#info").animate({"opacity": 0}, 100);
            setTimeout(function () {
                $("#title").text(callback.title);
                $("#patentName").text(callback.patentName);
                $("#patentCode").text(callback.patentCode);
                $("#applyDate").text(callback.applyDate);
                $("#patentee").text(callback.patentee);
            }, 100);
            $("#show").attr("value", callback.id);
            $("#info").animate({"opacity": 1}, 100);

            $("#showimg").animate({"opacity": 0}, 100);
            setTimeout(function () {
                $("#patentPic").attr({"src": callback.pic, "alt": callback.patentName});
                $("#modelimg").attr({"src": callback.pic, "alt": callback.patentName});
            }, 100);
            $("#showimg").animate({"opacity": 1}, 100);
        }
    })
});
$("#next").click(function () {
    var id = $("#show").attr("value");
    var param = {"id": id, "key": "0"};
    $.ajax({
        url: '/patentAjax',
        type: "post",
        data: JSON.stringify(param),
        contentType: "application/json;charset=UTF-8",
        dataType: 'JSON',
        success: function (callback) {
            $("#info").animate({"opacity": 0}, 100);
            setTimeout(function () {
                $("#title").text(callback.title);
                $("#patentName").text(callback.patentName);
                $("#patentCode").text(callback.patentCode);
                $("#applyDate").text(callback.applyDate);
                $("#patentee").text(callback.patentee);
            }, 100);
            $("#show").attr("value", callback.id);
            $("#info").animate({"opacity": 1}, 100);

            $("#showimg").animate({"opacity": 0}, 100);
            setTimeout(function () {
                $("#patentPic").attr({"src": callback.pic, "alt": callback.patentName});
                $("#modelimg").attr({"src": callback.pic, "alt": callback.patentName});
            }, 100);
            $("#showimg").animate({"opacity": 1}, 100);
        }
    })
});
//左侧滑动
var left = $("#left");
var win = $(window); //得到窗口对象
var sc = $(document);//得到document文档对象
win.scroll(function () {
    var t2 = document.documentElement.scrollHeight;
    var t1 = document.documentElement.scrollTop ;
    var b = t2-t1;
    console.log("距离底部距离："+ b);
    navScroll(b);
});

function navScroll(bottom) {
    if (sc.scrollTop() >= 500) {
        if (left.hasClass("left_absolute")) {
            left.removeClass("left_absolute");
        }
        if(bottom<1200){
            left.addClass("left_relative");
            left.removeClass("left_nav_class");
        }else{
            left.addClass("left_nav_class");
            left.removeClass("left_relative")
            if (win.width < 768) {
                left.animate({display: 'none'}, 0)
            }
        }
    } else {
        left.removeClass("left_relative");
        left.removeClass("left_nav_class");
        left.addClass("left_absolute")
    }
}

$('.jarallax').jarallax({
    speed: 0.5,
    imgWidth: 1366,
    imgHeight: 768
})
$(document).ready(function () {
    $().UItoTop({easingType: 'easeOutQuart'});
});
