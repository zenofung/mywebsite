//heaher
var topmenu = $("#topmenu"); //得到导航对象
var mainmenu = $("#mainmenu"); //得到导航对象
var win = $(window); //得到窗口对象
var sc = $(document);//得到document文档对象。
bindScroll();
win.scroll(function () {
    console.log("宽度:", win.width() + "高度:", win.height());
    console.log(sc.scrollTop());
    bindScroll();
});

function bindScroll() {
    if (sc.scrollTop() >= 100) {
        if (!mainmenu.hasClass("transparent")) {
            topmenu.animate({opacity: '0'}, 0);
            mainmenu.addClass('transparent');
            if (win.width() > 768) {
                mainmenu.animate({top: '0', 'z-index': 1000}, 1);
            }
            if (win.width() < 1000) {
                var mobile_head = $("#mobile-head");
                if (mobile_head.hasClass("mobile-head")) {
                    mobile_head.removeClass("mobile-head");
                }
                mobile_head.addClass("mobile-head-top");
                $("#header-search").attr("src", "/static/images/mobile/icon/搜索（黑）.png");
                $("#header-menu").attr("src", "/static/images/icon/汉堡包黑.png")
            }
        }

    } else {
        topmenu.animate({opacity: '1'}, 0);
        mainmenu.removeClass('transparent');
        if (win.width() > 768) {
            mainmenu.animate({top: '30', 'z-index': 998}, 1);
        }
        if (win.width() < 1000) {
            var mobile_head_top = $("#mobile-head");
            if (mobile_head_top.hasClass("mobile-head-top")) {
                mobile_head_top.removeClass("mobile-head-top");
            }
            mobile_head_top.addClass("mobile-head");
            $("#header-search").attr("src", "/static/images/mobile/icon/搜索（白）.png");
            $("#header-menu").attr("src", "/static/images/icon/汉堡包白.png");
        }
    }
};
//_banner
$("#pre").hover(
    function () {
        $(this).attr("src", "/static/images/pc/icon/左翻页选中.png");
    },
    function () {
        $(this).attr("src", "/static/images/pc/icon/左翻页.png");
    }).click(function () {
    var all = $("#report > li");
    $("#report > li").each(function (el) {
        console.log(all.length);
        var element = $($("#report > li")[el]);
        if (element.hasClass("show")) {
            element.slideToggle("slow", "linear", function () {
                element.removeClass("show").addClass("hide");
                var pre;
                pre = $($("#report > li")[(el - 1) < 0 ? (all.length - 1) : (el - 1)]);
                console.log(pre);
                pre.removeClass("hide").addClass("show");
            });
        }
    })
});
$("#last").hover(
    function () {
        $(this).attr("src", "/static/images/pc/icon/右翻页选中.png");
    },
    function () {
        $(this).attr("src", "/static/images/pc/icon/右翻页.png");
    }).click(function () {
    var all = $("#report > li");
    $("#report > li").each(function (el) {
        console.log(all.length);
        var element = $($("#report > li")[el]);
        if (element.hasClass("show")) {
            element.slideToggle("slow", "linear", function () {
                element.removeClass("show").addClass("hide");
                var next;
                next = $($("#report > li")[(el + 1) > (all.length - 1) ? 0 : (el + 1)]);
                console.log(next);
                next.removeClass("hide").addClass("show");
            });
        }
    })
});
$(function () {
    // Slideshow 4
    $("#slider4").responsiveSlides({
        auto: true,
        pager: true,
        nav: true,
        speed: 500,
        namespace: "callbacks",
        before: function () {
            $('.events').append("<li>before event fired.</li>");
        },
        after: function () {
            $('.events').append("<li>after event fired.</li>");
        }
    });
});
$(function () {
    // Slideshow 4
    $("#slider5").responsiveSlides({
        auto: true,
        pager: true,
        nav: true,
        speed: 500,
        namespace: "callbacks",
        before: function () {
            $('.events').append("<li>before event fired.</li>");
        },
        after: function () {
            $('.events').append("<li>after event fired.</li>");
        }
    });
});
$(document).ready(function () {
    $().UItoTop({easingType: 'easeOutQuart'});
});
