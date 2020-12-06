$(function () {
    $.ajax({
        type: "GET",
        dataType: "JSON",
        async:false,
        url:"/getIndexNews",
        success: function (data) {
            console.log(data)
            var news = document.getElementById("ajaxNews");
            var news1 = data.news1;
            var news2 = data.news2;
            var news2 = data.news3;
            $(news).append(' <div class="col-md-4 w3-agile-post-grids col-sm-12">\n' +
                '                <div style="border: 2px white dotted;margin-top: 9px;margin-bottom: 9px;">\n' +
                '                    <div class="w3-agile-post-img w3-agile-post-img1">\n' +
                '                        <div style="height: 3.0em;width: 100%;background-color: #50c9a0;line-height: 100%;padding: 8px">\n' +
                '                            <span style="color: white;float:left;font-size:1.3em; font-weight: 500;padding: 0.3em">${news1.newsClassName}</span>\n' +
                '                            <span style="color: white;float:right;font-size: 1.2em;padding: 0.3em;"><a href="/newsListPage?classId=${news1.id}">more+</a></span>\n' +
                '                        </div>\n' +
                '                        <a href="/newsListPage?classId=${news1.id}" style=\'background: url("${news1.pic}") no-repeat 0px 0px;background-size: cover;margin-left: 16px;margin-right:16px;\'></a>\n' +
                '                    </div>\n' +
                '                    <div style="background-color:#50c9a0;width: 100%;height: 22em;overflow:hidden">\n' +
                '                        <ul style="margin-left: -36px;" class="${news1.newsClassName}">\n' +
                '                            @for(new in @news1.getList()){\n' +
                '                            <li style="width: 95%;margin:auto auto;height: 3em;line-height: 2em;padding: 0;display: block;overflow: hidden">\n' +
                '                                <div>\n' +
                '                                    <div class="col-sm-2 col-xs-2" style="overflow: hidden;margin-top: 1em">\n' +
                '                                        <span style="display: inline-block;width: 25px;height: 25px;background-color: white;color: black;border-radius: 50%;text-align: center;font-weight: 600;">问</span>\n' +
                '                                    </div>\n' +
                '                                    <div class="col-sm-10 col-xs-10"style="margin-top: 1em"><a style="color: white;font-weight:600;text-decoration: none" href="/newsDetail?newsId=${new.id}">${new.newsTitle}</a></div>\n' +
                '                                </div>\n' +
                '                            </li>\n' +
                '                            <li style="width: 95%;margin:auto auto;height: 8em;line-height: 2em;padding: 0;display: block;border-bottom: 2px dotted white;overflow: hidden">\n' +
                '                                <div>\n' +
                '                                    <div class="col-sm-2 col-xs-2" style="text-overflow: ellipsis">\n' +
                '                                        <span style="display: inline-block;width: 25px;height: 25px;background-color: white;color: black;border-radius: 50%;text-align: center;font-weight: 600;">答</span>\n' +
                '                                    </div>\n' +
                '                                    <div class="col-sm-10 col-xs-10"><a style="color: white;text-decoration: none;font-size: 13px" href="/newsDetail?newsId=${new.id}">${new.description}</a></div>\n' +
                '                                </div>\n' +
                '                                <!--<a style="color: white;text-decoration: none" href="#">${new.newsTitle}</a>-->\n' +
                '                            </li>\n' +
                '                             @}\n' +
                '                        </ul>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="col-md-4 w3-agile-post-grids col-sm-12">\n' +
                '                <div style="border: 2px white dotted;margin-top: 9px;margin-bottom: 9px;">\n' +
                '                    <div class="w3-agile-post-img w3-agile-post-img1">\n' +
                '                        <div style="height: 3.0em;width: 100%;background-color: #50c9a0;line-height: 100%;padding: 8px">\n' +
                '                            <span style="color: white;float:left;font-size:1.3em; font-weight: 500;padding: 0.3em">${news2.newsClassName}</span>\n' +
                '                            <span style="color: white;float:right;font-size: 1.2em;padding: 0.3em;"><a href="/newsListPage?classId=${news2.id}">more+</a></span>\n' +
                '                        </div>\n' +
                '                        <a href="/newsListPage?classId=${news2.id}" style=\'background: url("${news2.pic}") no-repeat 0px 0px;background-size: cover;margin-left: 16px;margin-right:16px;\'></a>\n' +
                '                    </div>\n' +
                '                    <div style="background-color:#50c9a0;width: 100%;height: 22em;overflow:hidden">\n' +
                '                        <ul style="margin-left: -36px;" class="${news2.newsClassName}">\n' +
                '                            @for(new in @news2.getList()){\n' +
                '                            <li style="margin:auto auto;width: 95%;height: 3em;line-height: 2em;padding: 0;display: block;overflow: hidden;;border-bottom: 2px dotted white">\n' +
                '                                <div>\n' +
                '                                    <div class="col-sm-12" style="margin-top: 0.5em">\n' +
                '                                        <a style="color: white;font-weight:600;text-decoration: none" href="/newsDetail?newsId=${new.id}">${new.newsTitle}</a>\n' +
                '                                    </div>\n' +
                '                                </div>\n' +
                '                                <!--<a style="color: white;text-decoration: none" href="#">${new.newsTitle}</a>-->\n' +
                '                            </li>\n' +
                '                            @}\n' +
                '                        </ul>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="col-md-4 w3-agile-post-grids col-sm-12">\n' +
                '                <div style="border: 2px white dotted;margin-top: 9px;margin-bottom: 9px;">\n' +
                '                    <div class="w3-agile-post-img w3-agile-post-img1">\n' +
                '                        <div style="height: 3.0em;width: 100%;background-color: #50c9a0;line-height: 100%;padding: 8px">\n' +
                '                            <span style="color: white;float:left;font-size:1.3em; font-weight: 500;padding: 0.3em">${news3.newsClassName}</span>\n' +
                '                            <span style="color: white;float:right;font-size: 1.2em;padding: 0.3em;"><a href="/newsListPage?classId=${news3.id}">more+</a></span>\n' +
                '                        </div>\n' +
                '                        <a href="/newsListPage?classId=${news3.id}" style=\'background: url("${news3.pic}") no-repeat 0px 0px;background-size: cover;margin-left: 16px;margin-right:16px;\'></a>\n' +
                '                    </div>\n' +
                '                    <div style="background-color:#50c9a0;width: 100%;height: 22em;overflow:hidden">\n' +
                '                        <ul style="margin-left: -36px;" class="${news3.newsClassName}">\n' +
                '                            @for(new in @news3.getList()){\n' +
                '                            <li style="margin:auto auto;width: 95%;height: 3em;line-height: 2em;padding: 0;display: block;overflow: hidden;;border-bottom: 2px dotted white">\n' +
                '                                <div>\n' +
                '                                    <div class="col-sm-12" style="margin-top: 0.5em">\n' +
                '                                        <a style="color: white;font-weight:600;text-decoration: none" href="/newsDetail?newsId=${new.id}">${new.newsTitle}</a>\n' +
                '                                    </div>\n' +
                '                                </div>\n' +
                '                                <!--<a style="color: white;text-decoration: none" href="#">${new.newsTitle}</a>-->\n' +
                '                            </li>\n' +
                '                            @}\n' +
                '                        </ul>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '            <div class="clearfix"> </div>')
        }
    })
});