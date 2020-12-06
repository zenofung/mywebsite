/**
 * Project: company
 * Package: static.js
 * @date : 2019/1/5 11:53
 * @author : pengyangyan
 */

function isInSight($img) {
    //获取浏览器高度
    var windowHeight = $(window).height();
    //获取窗户滚动条高度
    var windowScrollTop = $(window).scrollTop();
    var imgOffsettop = $img.offset().top;
    var imgHeight = $img.outerHeight(true);
    if (windowHeight + windowScrollTop > imgOffsettop && imgOffsettop + imgHeight > windowScrollTop) {
        return true
    }
    return false;
}
