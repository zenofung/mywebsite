/**
 * Project: company
 * Package: static.js
 * @date : 2019/1/16 1:20
 * @author : pengyangyan
 */

$(document).ready(function () {
    var topmenu = $("#topmenu"); //得到导航对象
    var mainmenu = $("#mainmenu"); //得到导航对象
    var win = $(window); //得到窗口对象
    var sc = $(document);//得到document文档对象。
    bindScroll();
    win.scroll(function () {
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
    $().UItoTop({easingType: 'easeOutQuart'});
});
