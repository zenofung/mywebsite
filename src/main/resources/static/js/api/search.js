$(function () {
    var left = $("#search_page");
    var win = $(window); //得到窗口对象
    var sc = $(document);//得到document文档对象
    win.scroll(function () {
        var t2 = document.documentElement.scrollHeight;
        var t1 = document.documentElement.scrollTop ;
        var b = t2-t1;
        navScroll(b);
    });
    function navScroll(bottom) {
        if (sc.scrollTop() >= 500) {
            left.addClass("left_nav_class");
            if (win.width < 768) {
                left.animate({display: 'none'}, 0)
            }
        } else {
            left.removeClass("left_nav_class");
        }
    }

    $("#loadMore").click(function () {
        var rows=10;
        var page=1;
        var keywords=$('meta[name="Keywords"]').attr("content");
        var param={'rows':rows,'page':page,'keyword':keywords};
        $.ajax({
            type:"post",
            url:"/searchNews",
            data:JSON.stringify(param),
            contentType: "application/json;charset=UTF-8",
            success: function(callback){
                page=callback.page;
                var list=callback.result;
                var num = callback.total;
                for(var i=0;i<list.length;i++){
                    var url = "/newsDetail?newsId=" + list[i].id;
                    $(".blog-main").append('     <article class="fade-in" style="background-color: #F1F1F1;width: 100%;height: 180px;cursor: pointer" onmouseenter="this.style.backgroundColor=\'#cee7de\'"\n' +
                        '                             onmouseleave="this.style.backgroundColor=\'#f1f1f1\'" onclick="window.location.href=\'' + url + '\'">\n' +
                        '                        <!--pc端-->\n' +
                        '                        <figure class="thumbnail visible-lg-block visible-md-block" style="">\n' +
                        '                            <a href="' + url + '">\n' +
                        '                                <img class="img-responsive lazy-img" style="display: block;"\n' +
                        '                                     src="' + list[i].pic + '" alt="' + list[i].newsTitle + '">\n' +
                        '                            </a>\n' +
                        '                        </figure>\n' +
                        '                        <div  class="visible-md-block visible-lg-block " >\n' +
                        '                            <span id="' + i + '" class="title-lg"">\n' +
                        list[i].newsTitle +
                        '                            </span>\n' +
                        '                        </div>\n' +
                        '                        <div class="entry-content visible-lg-block visible-md-block" >\n' +
                        '                            <div class="archive-content">\n' +
                        list[i].description +
                        '                            </div>\n' +
                        '                            <span class="entry-meta "  >\n' +
                        '                             <span class="views"  data-toggle="tooltip" data-placement="bottom" data-original-title="文章发表日期">\n' +
                        '                                 <i class="fa fa-calendar-o fa-fw"></i>' +
                        list[i].updateDatetime.split("T")[0]+
                        '                             </span>\n' +
                        '                            <span class="date"  data-toggle="tooltip" data-placement="bottom" data-original-title="文章阅读次数">\n' +
                        '                                 <i class="fa fa-eye fa-fw"></i>浏览(' + list[i].visitNum + ')<i class="fas fa-stroopwafel"></i></span>\n' +
                        '                        </span>\n' +
                        '                        </div>\n' +
                        '                        <!--移动端-->\n' +
                        '                        <div class="visible-xs-block visible-sm-block col-xs-4" style="height: 100%;padding: 0px">\n' +
                        '                            <img style="height: 100%;width: 160%" src="' + list[i].pic + '" alt="' + list[i].newsTitle + '">\n' +
                        '                        </div>\n' +
                        '                        <div class="visible-xs-block visible-sm-block col-xs-8" style="height: 100%;background-color: white;">\n' +
                        '                            <div >\n' +
                        '                                <span class="title-xs">\n' +
                        list[i].newsTitle +
                        '                                </span>\n' +
                        '                            </div>\n' +
                        '                            <div class="content-xs" style="height: 60px" >\n' +
                        list[i].description +
                        '                            </div>\n' +
                        '                            <div style="color: #5c5c5c;width: 95%">\n' +
                        '                                <span class="views"  data-toggle="tooltip" data-placement="bottom" data-original-title="文章发表日期">\n' +
                        list[i].updateDatetime.split("T")[0]+
                        '                                </span>\n' +
                        '                                <span style="float: right;">' +
                        list[i].author +
                        '                                </span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </article>');
                }
                if(num<rows){
                    $("#loadMore").remove();
                }
                var t2 = document.body.scrollHeight;
                var t1 = document.documentElement.scrollTop || document.body.scrollTop;
                var b = t2-t1;
                navScroll(b);

            }

        })
    })
});

