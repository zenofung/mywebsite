// itemInit();
// $(".box").hide();
// let flag = false;
// window.addEventListener("scroll", function () {
//     if (elementIsVisibleInViewport(document.querySelector(".box")) && !flag) {
//         $(".box").fadeIn(1000, function () {});
//         let box = document.querySelectorAll(".item");
//         for (let i = 0; i < box.length; i++) {
//             if (i % 2 == 0) {
//                 box[i].style.top = "0px";
//             } else {
//                 box[i].style.bottom = "0px";
//             }
//         }
//         flag=true;
//     }
// })
// function elementIsVisibleInViewport(el, partiallyVisible = false) {
//     const {
//         top,
//         left,
//         bottom,
//         right
//     } = el.getBoundingClientRect();
//     const {
//         innerHeight,
//         innerWidth
//     } = window;
//     return partiallyVisible ?
//         ((top > 0 && top < innerHeight) || (bottom > 0 && bottom < innerHeight)) &&
//         ((left > 0 && left < innerWidth) || (right > 0 && right < innerWidth)) :
//         top >= 0 && left >= 0 && bottom <= innerHeight && right <= innerWidth;
// }
//
// function itemInit() {
//     let box = document.querySelectorAll(".item");
//     for (let i = 0; i < box.length; i++) {
//         if (i % 2 == 0) {
//             box[i].style.top = "-70px";
//         } else {
//             box[i].style.bottom = "-70px";
//         }
//     }
// }